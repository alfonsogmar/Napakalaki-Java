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
public abstract class BadConsequence {
    protected String text;
    protected int levels;

    static final int MAXTREASURES=10;
    
    
    
    
    /*
    public BadConsequence
    
    public BadConsequence (String text, boolean death)
    {
        this.text   = text;
        this.death  = death;
        this.levels = Player.MAXLEVEL;
        this.nVisibleTreasures  = MAXTREASURES;
        this.nHiddenTreasures   = MAXTREASURES;
    }
 
    
    public BadConsequence (String text, int levels, ArrayList<TreasureKind> tVisible,
                           ArrayList<TreasureKind> tHidden)
    {
        this.text                       = text;
        this.levels                     = levels;
        this.death                      = false;
        this.specificVisibleTreasures   = tVisible;
        this.specificHiddenTreasures    = tHidden;
        this.nVisibleTreasures          = 0;
        this.nHiddenTreasures           = 0;
    }
    */
    public BadConsequence (String text, int levels)
    {
        this.text   = text;
        this.levels = levels;
    }
            
    
            
    
    public String getText()
    {
        return this.text;
    }
    
    public int getLevels()
    {
        return this.levels;
    }
    
    /*
    public boolean getDeath()
    {
        return this.death;
    }
    */

    
    @Override
    public abstract String toString();
    /*
    {
        String bcString = "Description =\t" + this.text + "\nLevels = "
                + Integer.toString(this.levels)+"\nNumber of Visible Treasures= "
                + Integer.toString(this.nVisibleTreasures)
                + "\nVisible Treasures:\n";
        
        for (TreasureKind vTreasure: specificVisibleTreasures)
        {
            bcString += (vTreasure.toString()+" ");
        }
        bcString += "\nNumber of Hidden Treasures = "
                + this.nHiddenTreasures
                + "\nInvisible Treasures:\n";
               
        for (TreasureKind hTreasure: specificHiddenTreasures)
        {
            bcString += (hTreasure.toString()+" ");
        }
        
        bcString += "\nKills: " + this.death;
                
        return bcString;
               
    }
    */
    public abstract boolean isEmpty();
    /*{
        return (nVisibleTreasures==0 && nHiddenTreasures==0 &&
                specificVisibleTreasures.isEmpty() &&
                specificHiddenTreasures.isEmpty());
    }*/
    
    public abstract void substractVisibleTreasure(Treasure T);
    /*{
        if ( !specificVisibleTreasures.remove(T.getType()) )
        {                           // Si estaba especificado el tipo de tesoro,
                                    // se elimina del ArrayList de específicos.
            if(nVisibleTreasures > 0)
                nVisibleTreasures--;// Si no estaba especificado el tipo, se
                                    // reduce el número de tesoros pendientes.
        }
    }*/
    
    public abstract void substractHiddenTreasure(Treasure T);
    /*{
        if ( !specificHiddenTreasures.remove(T.getType()) )
        {                           // Si estaba especificado el tipo de tesoro,
                                    // se elimina del ArrayList de específicos.
            if(nHiddenTreasures > 0)
                nHiddenTreasures--; // Si no estaba especificado el tipo, se
                                    // reduce el número de tesoros pendientes.
        }
    }*/
    
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,
                                                   ArrayList<Treasure> h);
    /*{

        
        BadConsequence newBadConsequence;   // Creamos un nuevo mal rollo
                                            // igual al actual
        if(this.death)
        {
            newBadConsequence = new BadConsequence(this.text,this.death);
            newBadConsequence.nVisibleTreasures = v.size();
            newBadConsequence.nHiddenTreasures = h.size();
            
        }
        
        else if (this.nVisibleTreasures>0 || this.nHiddenTreasures>0)
        {   // Si el mal rollo implica quitar número de tesoros
            newBadConsequence = new BadConsequence(this.text,this.levels,this.nVisibleTreasures,this.nHiddenTreasures);
            
            if(newBadConsequence.nVisibleTreasures > v.size())
                newBadConsequence.nVisibleTreasures = v.size();
            if(newBadConsequence.nHiddenTreasures > h.size())
                newBadConsequence.nHiddenTreasures = h.size();
            
        }
        
        else
        {   // Si el mal rollo implica quitar tesoros específicos
            newBadConsequence = new BadConsequence(text,levels,new ArrayList(this.specificVisibleTreasures),new ArrayList(this.specificHiddenTreasures));
            
            
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
                
                for (TreasureKind tk : newBadConsequence.specificVisibleTreasures)
                {
                    if (tk == tKind)
                        new_count++;
                }
                    
                if(count<new_count)
                {// Los tipos de tesoros que no estén en el arraylist, se eliminan
                 // del nuevo BadConsequence

                    newBadConsequence.specificVisibleTreasures.remove(tKind);
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
                
                for (TreasureKind tk : newBadConsequence.specificHiddenTreasures)
                {
                    if (tk == tKind)
                        new_count++;
                }
                    
                if(count<new_count)
                {// Los tipos de tesoros que no estén en el arraylist, se eliminan
                 // del nuevo BadConsequence

                    newBadConsequence.specificHiddenTreasures.remove(tKind);
                }
            }
        }
           
        return newBadConsequence;
    }*/
    
    
    
}
