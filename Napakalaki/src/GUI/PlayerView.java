/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import NapakalakiGame.Player;
import NapakalakiGame.CultistPlayer;
import NapakalakiGame.Treasure;
import NapakalakiGame.Napakalaki;
import java.awt.Component;
import java.util.ArrayList;
/**
 *
 * @author alfonso
 */
public class PlayerView extends javax.swing.JPanel {

    private Player playerModel;
    private Napakalaki napakalakiModel;
    
    
    public void setNapakalaki(Napakalaki n)
    {
        napakalakiModel = n;
    }
    
    
    // Asigna/actualiza el jugador representado en la vista
    public void setPlayer(Player p)
    {
        playerModel = p;
        nameView .setText(p.getName());
        levelView.setText("Nivel: "+p.getLevels());
        
        
        if (p.getEnemy() != null)
            enemyNameView.setText("Enemigo: "+p.getEnemy().getName());
        
        if (p.isDead())
            deathView.setText("Muerto");
        else
            deathView.setText("Vivo");
        
        fillTreasurePanel (visibleTreasures, playerModel.getVisibleTreasures());
        fillTreasurePanel (hiddenTreasures, playerModel.getHiddenTreasures());
        
        if (p.getClass().getName().equals("NapakalakiGame.CultistPlayer"))
        {
            cultistLabel.setText("Cultista");
        }
        else
        {
            cultistLabel.setText("Normal");
        }
            
        cultistPlayersView.setText("Numero total de cultistas: "+CultistPlayer.getTotalCultistPlayers());
        

        if(playerModel.getVisibleTreasures().isEmpty() && playerModel.getHiddenTreasures().isEmpty())
        {
            discardAllTreasuresButton.setEnabled(false);
            discardHiddenTreasureButton.setEnabled(false);
            discardVisibleTreasureButton.setEnabled(false);
            makeVisibleButton.setEnabled(false);
        }
        else
        {
            discardAllTreasuresButton.setEnabled(true);
        
            if(playerModel.getVisibleTreasures().isEmpty())
            {
                discardVisibleTreasureButton.setEnabled(false); 
            }
            else
            {
                discardVisibleTreasureButton.setEnabled(true);
            }
        
            if(playerModel.getHiddenTreasures().isEmpty())
            {
                discardHiddenTreasureButton.setEnabled(false);
                makeVisibleButton.setEnabled(false);
            }
            else
            {
                discardHiddenTreasureButton.setEnabled(true);
                makeVisibleButton.setEnabled(true);
            }
                
        }
        
        
        
        stealTreasureButton.setEnabled(false);
 

        if (playerModel.getPendingBadConsequence() != null)
            this.pendingBadConsequenceView1.setPendingBadConsequence(playerModel.getPendingBadConsequence());
        
        repaint();
        revalidate();
    }
    
    
    // Método añadido para que napakalakiView pueda indicar que se habilita
    // el botón de robar tesoro DESPUÉS de un combate
    public void playerCanSteal()
    {
        if (playerModel.canISteal())
            stealTreasureButton.setEnabled(true);
        else
            stealTreasureButton.setEnabled(false);
    }
    
    
    private void fillTreasurePanel (javax.swing.JPanel aPanel, ArrayList<Treasure> aList)
    {
        // Se elimina la información antigua
        aPanel.removeAll();
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
        //al panel
        for (Treasure t : aList) {
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure (t);
            aTreasureView.setVisible (true);
            aPanel.add (aTreasureView);
        }
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
    }
    
    
    private ArrayList<Treasure> getSelectedTreasures(javax.swing.JPanel aPanel)
    {
        // Se recorren los tesoros que contiene el panel,
        // almacenando en un vector aquellos que están seleccionados.
        // Finalmente se devuelve dicho vector.

        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            if ( tv.isSelected() )
                output.add ( tv.getTreasure() );
        }
    return output;
    }
    
    
    // Método para desactivar todos los botones una vez se ha mostrado al monstruo
    public void meetingMonster()
    {
        discardAllTreasuresButton.setEnabled(false);
        discardHiddenTreasureButton.setEnabled(false);
        discardVisibleTreasureButton.setEnabled(false);
        makeVisibleButton.setEnabled(false);
        stealTreasureButton.setEnabled(false);
    }
    
    
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameView = new javax.swing.JLabel();
        levelView = new javax.swing.JTextField();
        enemyNameView = new javax.swing.JTextField();
        deathView = new javax.swing.JTextField();
        visibleTreasures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();
        stealTreasureButton = new javax.swing.JButton();
        discardVisibleTreasureButton = new javax.swing.JButton();
        discardHiddenTreasureButton = new javax.swing.JButton();
        discardAllTreasuresButton = new javax.swing.JButton();
        cultistPlayersView = new javax.swing.JTextField();
        cultistLabel = new javax.swing.JLabel();
        visibleTreasuresLabel = new javax.swing.JLabel();
        hiddenTreasuresLabel = new javax.swing.JLabel();
        pendingBadConsequenceView1 = new GUI.PendingBadConsequenceView();
        makeVisibleButton = new javax.swing.JButton();

        nameView.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        nameView.setText("Name");

        levelView.setEditable(false);
        levelView.setText("jTextField1");
        levelView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelViewActionPerformed(evt);
            }
        });

        enemyNameView.setEditable(false);
        enemyNameView.setText("Sin enemigo");

        deathView.setEditable(false);
        deathView.setText("jTextField4");

        visibleTreasures.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        stealTreasureButton.setText("Robar tesoro");
        stealTreasureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stealTreasureButtonActionPerformed(evt);
            }
        });

        discardVisibleTreasureButton.setText("Descartar tesoro visible");
        discardVisibleTreasureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardVisibleTreasureButtonActionPerformed(evt);
            }
        });

        discardHiddenTreasureButton.setText("Descartar tesoro oculto");
        discardHiddenTreasureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardHiddenTreasureButtonActionPerformed(evt);
            }
        });

        discardAllTreasuresButton.setText("Descartar todos los tesoros");
        discardAllTreasuresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardAllTreasuresButtonActionPerformed(evt);
            }
        });

        cultistPlayersView.setEditable(false);
        cultistPlayersView.setText("Numero total de cultistas");
        cultistPlayersView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cultistPlayersViewActionPerformed(evt);
            }
        });

        cultistLabel.setText("Sectario");

        visibleTreasuresLabel.setText("Tesoros visibles");

        hiddenTreasuresLabel.setText("Tesoros ocultos");

        makeVisibleButton.setText("Equipar tesoro/s");
        makeVisibleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameView)
                    .addComponent(levelView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enemyNameView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deathView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(visibleTreasuresLabel)
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hiddenTreasuresLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cultistLabel)
                    .addComponent(stealTreasureButton)
                    .addComponent(cultistPlayersView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(discardVisibleTreasureButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(discardHiddenTreasureButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(discardAllTreasuresButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(makeVisibleButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pendingBadConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(levelView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(enemyNameView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deathView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(visibleTreasuresLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hiddenTreasuresLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pendingBadConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cultistLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cultistPlayersView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stealTreasureButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(discardHiddenTreasureButton)
                                    .addComponent(discardVisibleTreasureButton, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(discardAllTreasuresButton)
                                    .addComponent(makeVisibleButton))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void levelViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_levelViewActionPerformed

    private void discardVisibleTreasureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardVisibleTreasureButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<Treasure> selVisible = getSelectedTreasures (visibleTreasures);
        for (Treasure selectedTreasure : selVisible)
            playerModel.discardVisibleTreasure(selectedTreasure);
        
        setPlayer (napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_discardVisibleTreasureButtonActionPerformed

    private void cultistPlayersViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cultistPlayersViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cultistPlayersViewActionPerformed

    private void makeVisibleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<Treasure> selHidden = getSelectedTreasures (hiddenTreasures);
        napakalakiModel.makeTreasuresVisible (selHidden);
        setPlayer (napakalakiModel.getCurrentPlayer());
        
    }//GEN-LAST:event_makeVisibleButtonActionPerformed

    private void stealTreasureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stealTreasureButtonActionPerformed
        playerModel.stealTreasure();
        playerCanSteal();
        setPlayer(napakalakiModel.getCurrentPlayer());
        //hiddenTreasures.repaint();
    }//GEN-LAST:event_stealTreasureButtonActionPerformed

    private void discardHiddenTreasureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardHiddenTreasureButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<Treasure> selHidden = getSelectedTreasures (hiddenTreasures);
        for (Treasure selectedTreasure : selHidden)
            playerModel.discardHiddenTreasure(selectedTreasure);
        
        setPlayer (napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_discardHiddenTreasureButtonActionPerformed

    private void discardAllTreasuresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardAllTreasuresButtonActionPerformed
        // TODO add your handling code here:
        playerModel.discardAllTreasures();
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_discardAllTreasuresButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cultistLabel;
    private javax.swing.JTextField cultistPlayersView;
    private javax.swing.JTextField deathView;
    private javax.swing.JButton discardAllTreasuresButton;
    private javax.swing.JButton discardHiddenTreasureButton;
    private javax.swing.JButton discardVisibleTreasureButton;
    private javax.swing.JTextField enemyNameView;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JLabel hiddenTreasuresLabel;
    private javax.swing.JTextField levelView;
    private javax.swing.JButton makeVisibleButton;
    private javax.swing.JLabel nameView;
    private GUI.PendingBadConsequenceView pendingBadConsequenceView1;
    private javax.swing.JButton stealTreasureButton;
    private javax.swing.JPanel visibleTreasures;
    private javax.swing.JLabel visibleTreasuresLabel;
    // End of variables declaration//GEN-END:variables
}
