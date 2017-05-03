/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame
;

/**
 *
 * @author alfonsogmw
 */
public enum TreasureKind {
    ARMOR, ONEHAND, BOTHHANDS, HELMET, SHOES;
    
    @Override
    public String toString()
    {
        String kind="";
        
        if(this==ARMOR)
        {
            kind = "Armadura";
        }
 
        else if(this==ONEHAND) 
        {
            kind = "Una mano";
        }
        else if(this==BOTHHANDS)
        {
            kind = "Dos manos";
        }
        else if(this==HELMET)
        {
            kind = "Casco";
        }
        else
        {
            kind = "Calzado";
        }
            
        return kind;
    }
}
