/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import GUI.*;
import java.util.ArrayList;

/**
 *
 * @author alfonso
 */
public class MainNapakalaki {
    
    public static void main(String[] args) {
        Napakalaki game = Napakalaki.getInstance();
        
        NapakalakiView napakalakiView = new NapakalakiView();
        
        Dice.createInstance(napakalakiView);
        
        //napakalakiView.setNapakalaki(game);
        
        
        
        ArrayList<String> names = new ArrayList();
        
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView,true);
        
        names = namesCapture.getNames();
        
        game.initGame(names);
        
        // Prueba
        napakalakiView.setNapakalaki(game);
        
        napakalakiView.setVisible(true);
        
    }
    
}
