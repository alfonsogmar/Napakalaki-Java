/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author alfonsogm
 */
public class DeathBadConsequence extends NumericBadConsequence{
    
    
    private boolean death;
    
    public DeathBadConsequence(String text, boolean death)
    {
        super(text,0,BadConsequence.MAXTREASURES,BadConsequence.MAXTREASURES);
        this.death = death;
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,
                                                   ArrayList<Treasure> h)
    {
        BadConsequence newBadConsequence;
        
        
        newBadConsequence = new NumericBadConsequence(this.text,0,v.size(),h.size());
            
        
        // ((DeathBadConsequence)newBadConsequence).nVisibleTreasures = v.size();
        
        // ((DeathBadConsequence)newBadConsequence).nHiddenTreasures = h.size();
        
        return newBadConsequence;
    }
    
}
