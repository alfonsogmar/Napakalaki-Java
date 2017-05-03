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
public class NumericBadConsequence extends BadConsequence {
    
    protected int nVisibleTreasures;
    protected int nHiddenTreasures;
    
    
    public NumericBadConsequence(String text, int levels,
                          int nVisibleTreasures,int nHiddenTreasures)
    {
        super(text,levels);
        this.nVisibleTreasures  = nVisibleTreasures;
        this.nHiddenTreasures   = nHiddenTreasures;
    }

    public int getNHiddenTreasures()
    {
        return this.nHiddenTreasures;
    }
    
    public int getNVisibleTreasures()
    {
        return this.nVisibleTreasures;
    }
    
    
    @Override
    public  boolean isEmpty()
    {
        return (nVisibleTreasures == 0 && nHiddenTreasures == 0);
    }
    
    
    @Override
    public void substractVisibleTreasure(Treasure T)
    {
        if(nVisibleTreasures > 0)
            nVisibleTreasures--;
    }
    
    
    
    @Override
    public void substractHiddenTreasure(Treasure T)
    {
        if(nHiddenTreasures > 0)
            nHiddenTreasures--;
    }
    
    
    @Override
    public String toString()
    {
        String bcString = "Description =\t" + this.text + "\nLevels = "
                + Integer.toString(this.levels)+"\nNumber of Visible Treasures= "
                + Integer.toString(this.nVisibleTreasures) 
                + "\nNumber of Hidden Treasures = "
                + this.nHiddenTreasures;
        
        return bcString;
    }
    
    
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,
                                                   ArrayList<Treasure> h)
    {
        BadConsequence newBadConsequence;
        
        
        newBadConsequence = new NumericBadConsequence(this.text,this.levels,this.nVisibleTreasures,this.nHiddenTreasures);
            
        if(((NumericBadConsequence)newBadConsequence).nVisibleTreasures > v.size())
            ((NumericBadConsequence)newBadConsequence).nVisibleTreasures = v.size();
        if(((NumericBadConsequence)newBadConsequence).nHiddenTreasures > h.size())
            ((NumericBadConsequence)newBadConsequence).nHiddenTreasures = h.size();
        
        return newBadConsequence;
    }
    
}
