/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author alfonsogmw
 */
public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence bc;
    private int levelChangeAgainstCultistPlayer = 0;
    
    public Monster(String name, int combatLevel,
                   BadConsequence bc, Prize prize)
    {
        this.name           = name;
        this.combatLevel    = combatLevel;
        this.prize          = prize;
        this.bc             = bc;
    }
    
    public Monster(String n, int l, BadConsequence badConsequence,
                   Prize p, int lc)
    {
        name        = n;
        combatLevel = l;
        bc          = badConsequence;
        prize       = p;
        
        levelChangeAgainstCultistPlayer = lc;
    }
    
    
    public int getCombatLevelAgainstCultist()
    {
        return (combatLevel + levelChangeAgainstCultistPlayer);
    }
    
    
    public String getName()
    {
        return this.name;
    }
    
    public int getCombatLevel()
    {
        return this.combatLevel;
    }
    
    public BadConsequence getBadConsequence()
    {
        return this.bc;
    }
    
    @Override
    public String toString()
    {
        return  this.name
                + "\nCombat level = "
                + Integer.toString(this.combatLevel)
                + "\nCultist modifier = "
                + Integer.toString(this.levelChangeAgainstCultistPlayer)
                + "\nPrize:\n\n"
                + this.prize.toString()
                + "\n\nBad Consequence:\n\n"
                + this.bc.toString();
                
    }
    
    public int gelLevelsGained()
    {
        return prize.getLevels();
    }
    
    public int getTreasuresGained()
    {
        return prize.getTreasures();
    }
}
