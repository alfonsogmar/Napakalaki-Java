/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import java.util.ArrayList;
import java.util.Random;
import GUI.Dice;

/**
 *
 * @author alfonso
 */
public class Player {
    
    static final int MAXLEVEL = 10;
    
    private String name;
    private int level;
    private boolean dead        = true;
    private boolean canISteal   = true;
    private BadConsequence pendingBadConsequence;
    private Player enemy;
    
    private ArrayList<Treasure> visibleTreasures    = new ArrayList();
    private ArrayList<Treasure> hiddenTreasures     = new ArrayList();
    
    
    public Player(String name)
    {
        this.level  = 1;
        this.name   = name;
    }
    
    
    public Player(Player p)
    {
        this.name       = p.name;
        this.level      = p.level;
        this.dead       = p.dead;
        this.canISteal  = p.canISteal;
        this.enemy      = p.enemy;
        
        this.pendingBadConsequence  = p.pendingBadConsequence;
        this.visibleTreasures       = p.visibleTreasures;
        this.hiddenTreasures        = p.hiddenTreasures;

    }
    
    
    public String getName()
    {
        return name;
    }
    
    
    protected int getOponentLevel(Monster m)
    {
        return m.getCombatLevel();
    }
    

    protected boolean shouldConvert()
    {
        Dice dice = Dice.getInstance();
        int number = dice.nextNumber();
        boolean convert = false;
        
        if(number == 6)
        {
            convert = true;
        }
        
        return convert;
    }
    
    
    private void bringToLife()
    {
        dead = false;
    }
    
    protected int getCombatLevel()
    {
        int combat_level=level;
        
        for (Treasure t : visibleTreasures)
        {
            combat_level += t.getBonus();
        }
        
        return combat_level;
    }
    
    // public??
    public Player getEnemy()
    {
        return enemy;
    }
    
    
    private void incrementLevels(int l)
    {
        level += l;
    }
    
    private void decrementLevels(int l)
    {
        level -= l;
        if (level<1)
            level = 1;
    }
    
    private void setPendingBadConsequence(BadConsequence b)
    {
        pendingBadConsequence = b;
    }
    
    
    // Consultor añadido para la GUI
    public BadConsequence getPendingBadConsequence()
    {
        return this.pendingBadConsequence;
    }
    
    
    private void applyPrize(Monster m)
    {
        int nlevels = m.gelLevelsGained();
        this.incrementLevels(nlevels);
        
        int nTreasures = m.getTreasuresGained();
        if(nTreasures>0)
        {
            CardDealer dealer = CardDealer.getInstance();
            
            Treasure treasure;
            
            for (int i=1; i<= nTreasures; i++)
            {
                treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }
    }
    
    
    private void applyBadConsequence(Monster m)
    {
        BadConsequence badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();
        this.decrementLevels(nLevels);
        
        BadConsequence pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        this.setPendingBadConsequence(pendingBad);
    }
    
    
    private boolean canMakeTreasureVisible(Treasure t)
    {
        boolean canMakeVisible;
        
        if (t.getType() == TreasureKind.ONEHAND)
            // Si es un tesoro a una manos, hay que comprobar todos los tesoros
            // que se equipen en las manos
        {   
            canMakeVisible = ( howManyVisibleTreasures(t.getType())<2 &&
                               howManyVisibleTreasures(TreasureKind.BOTHHANDS)<1);
        }
        else if(t.getType() == TreasureKind.BOTHHANDS)
        {   // Si es un tesoro a dos manos, también hay que comprobar todos
            // los tesoros que se equipen en las manos
            canMakeVisible = ( howManyVisibleTreasures(t.getType())<1 &&
                               howManyVisibleTreasures(TreasureKind.ONEHAND)<1);
        }
        else
        {   // Para el resto de tipos de tesoros, de los que solo puede
            // tenerse uno equipado
            canMakeVisible = ( howManyVisibleTreasures(t.getType())<1);
        }
        
        return canMakeVisible;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind)
    {
        int nVisible=0;
        for (Treasure treasure : visibleTreasures)
        {
            if(treasure.getType()==tKind)
                nVisible++;
        }
        
        return nVisible;
    }
    
    private void dieIfNoTreasures()
    {
        if (visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
        {
            dead    = true;
            level   = 1;
        }
    }
    
    public boolean isDead()
    {
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures()
    {
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures()
    {
        return visibleTreasures;
    }
    
    
    
    public CombatResult combat(Monster m)
    {
        int myLevel         = this.getCombatLevel();
        int monsterLevel    = this.getOponentLevel(m);
        CombatResult result;
        
        if (!this.canISteal)
        {
            Dice dice = Dice.getInstance();
            int number = dice.nextNumber();
            
            if (number < 3)
            {
                int enemyLevel = enemy.getCombatLevel();
                monsterLevel += enemyLevel;
            }
        }
        
        if (myLevel > monsterLevel)
        {
            this.applyPrize(m);
            if (this.level >= MAXLEVEL)
            {
                result = CombatResult.WINGAME;
            }
            
            else
            {
                result = CombatResult.WIN;
            }
        }
        
        else
        {
            this.applyBadConsequence(m);
            
            if (this.shouldConvert())
                result = CombatResult.LOSEANDCONVERT;
            else
                result = CombatResult.LOSE;
        }
        return result;
    }
    
    
    
    public void makeTreasureVisible(Treasure t)
    {
        boolean canI = this.canMakeTreasureVisible(t);
        
        if (canI)
        {
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
        
    }
    
    
    
    public void discardVisibleTreasure(Treasure t)
    {
        this.visibleTreasures.remove(t);
        
        if ((this.pendingBadConsequence!=null) && (!this.pendingBadConsequence.isEmpty()))
        {
            this.pendingBadConsequence.substractVisibleTreasure(t);
        }
        
        this.dieIfNoTreasures();
    }
    
    
    
    public void discardHiddenTreasure(Treasure t)
    {
        this.hiddenTreasures.remove(t);
        
        if ((this.pendingBadConsequence!=null) && (!this.pendingBadConsequence.isEmpty()))
        {
            this.pendingBadConsequence.substractHiddenTreasure(t);
        }
        
        this.dieIfNoTreasures();
    }
    
    
    
    public boolean validState()
    {
        boolean ok = this.hiddenTreasures.size()<=4;
        
        if(this.pendingBadConsequence != null)
            ok = (this.hiddenTreasures.size()<=4 && this.pendingBadConsequence.isEmpty());
        
        return ok;
    }
    
    public void initTreasures()
    {
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        
        this.bringToLife();
        
        Treasure treasure = dealer.nextTreasure();
        this.hiddenTreasures.add(treasure);
        
        int number = dice.nextNumber();
        
        if (number > 1)
        {
           treasure = dealer.nextTreasure();
           this.hiddenTreasures.add(treasure);
        }
        
        if (number == 6)
        {
           treasure = dealer.nextTreasure();
           this.hiddenTreasures.add(treasure);
        }
        
        
    }
    
    public int getLevels()
    {
        return level;
    }
    

    
    
    public Treasure stealTreasure()
    {
        boolean canI = this.canISteal;
        boolean canYou;
        Treasure treasure=null;
        
        if (canI)
        {
            canYou = enemy.canYouGiveMeATreasure();
            
            if (canYou)
            {
                treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                this.haveStolen();
            }
        }
        
        return treasure;
    }
    
    
    
    public void setEnemy(Player enemy)
    {
        this.enemy = enemy;
    }
    
    
    protected Treasure giveMeATreasure()
    {
        Random rand = new Random();
        int index = rand.nextInt(hiddenTreasures.size());
        
        Treasure treasure = hiddenTreasures.get(index);
        hiddenTreasures.remove(index);
        
        return treasure;
    }
    
    
    public boolean canISteal()
    {
        return canISteal;
    }
    
    
    protected boolean canYouGiveMeATreasure()
    {
        return ( !hiddenTreasures.isEmpty() );
    }
    
    private void haveStolen()
    {
        canISteal=false;
    }
    
    public void discardAllTreasures()
    {
        ArrayList<Treasure> vTreasures = new ArrayList(this.visibleTreasures);
        ArrayList<Treasure> hTreasures = new ArrayList(this.hiddenTreasures);
        
        for (Treasure treasure : vTreasures)
        {
            this.discardVisibleTreasure(treasure);
        }
        
        for (Treasure treasure : hTreasures)
        {
            this.discardHiddenTreasure(treasure);
        }
    }
    
    // Consultor para la GUI
    //public abstract int getGainedLevels();
    
    @Override
    public String toString()
    {
        String out = name + "\nNivel: " + this.level + "\nNivel de combate: " + this.getCombatLevel() + "\nEnemigo: " + this.enemy.name;
        if (this.dead)
            out += "\nMuerto";
        else
            out += "\nVivo";
            
        return out;
    }
    
}
