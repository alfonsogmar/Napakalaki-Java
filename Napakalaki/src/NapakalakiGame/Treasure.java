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
public class Treasure {
    
    private String name="";
    private int bonus=0;
    private TreasureKind type;
    
    public Treasure(String n, int bonus, TreasureKind t)
    {
        this.name    = n;
        this.bonus   = bonus;
        this.type    = t;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getBonus()
    {
        return this.bonus;
    }
    
    public TreasureKind getType()
    {
        return this.type;
    }
    
    public String toString()
    {
        String out = this.name + "\nBonus: " + this.bonus + "\nTipo:" + this.type.toString();
        return out;
    }
     
    
}
