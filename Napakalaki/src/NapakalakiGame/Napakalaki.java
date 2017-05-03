/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author alfonso
 */
public class Napakalaki {
    private static Napakalaki instance = null;
    
    private Monster currentMonster;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer =  CardDealer.getInstance();
    
    private Napakalaki(){}
    
    private void initPlayers(ArrayList<String> names)
    {
        players = new ArrayList();
        
        for (String name : names)
                players.add(new Player(name));
                
    }
    
    
    private Player nextPlayer()
    {
        int index;   
        
        if (currentPlayer==null)
        {   // Si el jugador actual no está inicializado, entonces es la primera jugada
            Random random=new Random();
            index = random.nextInt(players.size());
        }
        else
        {
            index = players.indexOf(currentPlayer);
            // Incrementames el índice en módulo 'players.size()', para que
            // valga 0 si antes valía 'players.size()-1'
            index = (index + 1) % players.size();
        }
        
        currentPlayer = players.get(index);
        return players.get(index);
    }
    
    
    private boolean nextTurnAllowed()
    {
        boolean allowed;
        if (currentPlayer==null)
        {
            allowed = true;
        }
        else
        {
            allowed = this.currentPlayer.validState();
        }
        
        return allowed;
    }
    
    private void setEnemies()
    {
        Random random=new Random();
        Player enemy;
        int positions = random.nextInt(this.players.size()-1)+1;
        // A cada jugador le corresponde como enemigo el jugador
        // situado a <positions> posiciones de la suya
        
        for(int i=0; i<players.size(); i++)
        {
            enemy = players.get( (i+positions) % players.size() );
            players.get(i).setEnemy(enemy);
        }
    }
    
    public static Napakalaki getInstance()
    {
        if(instance == null)
            instance = new Napakalaki();
        return instance;
    }
    
    
    // Añadido para pruebas en la GUI
    public void makeCultist()
    {
        Cultist cultist = dealer.nextCultist();
        CultistPlayer cp = new CultistPlayer(this.currentPlayer,cultist);
        for (Player player : players)
        {
            if (player.getEnemy() == currentPlayer)
               player.setEnemy(cp);
            else if (player == currentPlayer)
                player = cp;
                   
        }
        currentPlayer = cp;
    }
        
    
    public CombatResult developCombat()
    {
        CombatResult result = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        
        if (result == CombatResult.LOSEANDCONVERT)
        {
           Cultist cultist = dealer.nextCultist();
           CultistPlayer cp = new CultistPlayer(this.currentPlayer,cultist);
           for (Player player : players)
           {
               if (player.getEnemy() == currentPlayer)
                   player.setEnemy(cp);
               else if (player == currentPlayer)
                   player = cp;
                   
           }
           currentPlayer = cp;
        }
        
        return result;
    }
    
    
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures)
    {
        
        for (Treasure treasure : treasures)
        {
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures)
    {
        
        for (Treasure treasure : treasures)
        {
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
        
    }
    
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures)
    {

        for (Treasure t : treasures)
        {
            currentPlayer.makeTreasureVisible(t);
        }
    }
    
    
    public void initGame(ArrayList<String> players)
    {
        initPlayers(players);
        setEnemies();
        dealer.initCards();
        nextTurn();
        
        
    }
    
    
    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }
    
    public Monster getCurrentMonster()
    {
        return currentMonster;
    }
    
    public boolean nextTurn()
    {
        boolean stateOK = nextTurnAllowed();
        
        if (stateOK)
        {
            currentMonster = dealer.nextMonster();
            currentPlayer = this.nextPlayer();
            boolean dead = currentPlayer.isDead();
            
            if (dead)
            {
                currentPlayer.initTreasures();
            }
        }
         
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result)
    {
        return (result==CombatResult.WINGAME);
    }
}
