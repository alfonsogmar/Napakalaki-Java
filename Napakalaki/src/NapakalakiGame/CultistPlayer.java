/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.Random;

/**
 *
 * @author alfonso
 */
public class CultistPlayer extends Player
{
    private static int totalCultistPlayers = 0;
    
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c)
    {
        super(p);
        totalCultistPlayers++;
        myCultistCard = c;
    }
    
    @Override
    protected boolean shouldConvert()
    {
       return false; 
    }
    
    @Override
    protected int getCombatLevel()
    {
        return (super.getCombatLevel() + super.getCombatLevel()*70/100 +
                (myCultistCard.getGainedLevels()*totalCultistPlayers));
    }
    
    @Override
    protected int getOponentLevel(Monster m)
    {
       return m.getCombatLevelAgainstCultist();
    }
    
    
    @Override
    protected Treasure giveMeATreasure()
    {
        Random rand = new Random();
        int index = rand.nextInt(getVisibleTreasures().size());
        
        Treasure treasure = getVisibleTreasures().get(index);
        getVisibleTreasures().remove(index);    // ¿Correcto?
        
        return treasure;
    }
    
    @Override
    protected boolean canYouGiveMeATreasure()
    {
        return !getVisibleTreasures().isEmpty();
    }
    
    
    public static int getTotalCultistPlayers()
    {
        return totalCultistPlayers;
    }
    
    
    // Consultor para la GUI
    /*
    public int getGainedLevels()
    {
        return this.myCultistCard.getGainedLevels();
    }
    */
    
    @Override
    public String toString()
    {
        return super.toString() + "\nSectario\nBonificación por cada cultista:" + myCultistCard.getGainedLevels();
    }
}
