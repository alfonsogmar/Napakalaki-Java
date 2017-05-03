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
public class SpecificBadConsequence extends BadConsequence {
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
                           ArrayList<TreasureKind> tHidden)
    {
        super(text,levels);
        specificHiddenTreasures     = tHidden;
        specificVisibleTreasures    = tVisible;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures()
    {
        return this.specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures()
    {
        return this.specificVisibleTreasures;
    }
    
    
    @Override
    public  boolean isEmpty()
    {
        return (this.specificVisibleTreasures.isEmpty() &&
                this.specificHiddenTreasures.isEmpty());
    }
    
    
    @Override
    public void substractVisibleTreasure(Treasure T)
    {
        this.specificVisibleTreasures.remove(T.getType());
    }
    
    @Override
    public void substractHiddenTreasure(Treasure T)
    {
        this.specificHiddenTreasures.remove(T.getType());
    }
    
    
    @Override
    public String toString()
    {
        String bcString = "Description =\t" + this.text + "\nLevels = "
                + Integer.toString(this.levels) + "\nVisible Treasures:\n";
        
        for (TreasureKind vTreasure: specificVisibleTreasures)
        {
            bcString += (vTreasure.toString()+" ");
        }
        bcString += "\nHidden Treasures:\n";
               
        for (TreasureKind hTreasure: specificHiddenTreasures)
        {
            bcString += (hTreasure.toString()+" ");
        }
        
        return bcString;
    }
    
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,
                                                   ArrayList<Treasure> h)
    {
        BadConsequence newBadConsequence;
        newBadConsequence = new SpecificBadConsequence(text,levels,new ArrayList(this.specificVisibleTreasures),new ArrayList(this.specificHiddenTreasures));
            
            
        ArrayList<TreasureKind> tv = new ArrayList(), th = new ArrayList();
            // Extraemos los tipos de tesoros de los parámetros en dos ArrayLists
        for (Treasure t:v)
            tv.add(t.getType());
        
        for (Treasure t:h)
            th.add(t.getType());
            
        int count,new_count;
            
        for (TreasureKind tKind : this.specificVisibleTreasures)
        {// Iteramos en el arraylist del BadConsequence actual, porque el del
         // nuevo va a ser modificado
            count = 0;
            new_count=0;
            for (TreasureKind tk :tv)
            {
                if (tk == tKind)
                    count++;
            }
                
                for (TreasureKind tk : ((SpecificBadConsequence)newBadConsequence).specificVisibleTreasures)
                {
                    if (tk == tKind)
                        new_count++;
                }
                    
                if(count<new_count)
                {// Los tipos de tesoros que no estén en el arraylist, se eliminan
                 // del nuevo BadConsequence

                    ((SpecificBadConsequence)newBadConsequence).specificVisibleTreasures.remove(tKind);
                }                
        }

            
        for (TreasureKind tKind : this.specificHiddenTreasures)
        {// Iteramos en el arraylist del BadConsequence actual, porque el del
         // nuevo va a ser modificado
            count = 0;
            new_count=0;
            for (TreasureKind tk :th)
            {
                if (tk == tKind)
                    count++;
            }
                
            for (TreasureKind tk : ((SpecificBadConsequence)newBadConsequence).specificHiddenTreasures)
            {
                if (tk == tKind)
                    new_count++;
            }
                    
            if(count<new_count)
            {// Los tipos de tesoros que no estén en el arraylist, se eliminan
             // del nuevo BadConsequence

                ((SpecificBadConsequence)newBadConsequence).specificHiddenTreasures.remove(tKind);
            }
        }
        
    return newBadConsequence;

    }
    
}
