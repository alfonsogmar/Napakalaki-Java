/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import NapakalakiGame.*;
/**
 *
 * @author alfonso
 */    

public class NapakalakiView extends javax.swing.JFrame {

    
    private Napakalaki napakalakiModel;
    
    
    
    public void setNapakalaki(Napakalaki n)
    {
        napakalakiModel = n;
        playerView1.setPlayer(n.getCurrentPlayer());
        playerView1.setNapakalaki(n);
        monsterView1.setMonster(n.getCurrentMonster());
        
        monsterView1.setVisible(false);
        combatButton.setEnabled(false);
        nextTurnButton.setEnabled(true);
        
        
        //Necesarios estos dos?
        repaint();
        revalidate();
    }
    
    
    public void refreshNapakalaki()
    {
        playerView1.setPlayer(napakalakiModel.getCurrentPlayer());
        playerView1.setNapakalaki(napakalakiModel);
        monsterView1.setMonster(napakalakiModel.getCurrentMonster());
        
        repaint();
        revalidate();
    }
    
    
    

    
    
    
    /**
     * Creates new form NewJFrame
     */
    public NapakalakiView() {
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

        meetMonsterButton = new javax.swing.JButton();
        combatButton = new javax.swing.JButton();
        nextTurnButton = new javax.swing.JButton();
        monsterView1 = new GUI.MonsterView();
        playerView1 = new GUI.PlayerView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Napakalaki");

        meetMonsterButton.setText("Mostrar monstruo");
        meetMonsterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetMonsterButtonActionPerformed(evt);
            }
        });

        combatButton.setText("Combatir");
        combatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatButtonActionPerformed(evt);
            }
        });

        nextTurnButton.setText("Siguiente turno");
        nextTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(meetMonsterButton)
                            .addComponent(combatButton)
                            .addComponent(nextTurnButton))
                        .addGap(18, 18, 18)
                        .addComponent(monsterView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(playerView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(meetMonsterButton)
                        .addGap(9, 9, 9)
                        .addComponent(combatButton)
                        .addGap(9, 9, 9)
                        .addComponent(nextTurnButton)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(monsterView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void meetMonsterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetMonsterButtonActionPerformed
        // TODO add your handling code here:
        monsterView1.setVisible(true);
        monsterView1.repaint();
        meetMonsterButton.setEnabled(false);
        combatButton.setEnabled(true);
        nextTurnButton.setEnabled(false);
        
        // Desactiva los botones del jugador
        playerView1.meetingMonster();
        
        
        this.repaint();
    }//GEN-LAST:event_meetMonsterButtonActionPerformed

    private void nextTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnButtonActionPerformed
        // TODO add your handling code here:
        if (!napakalakiModel.getCurrentPlayer().validState())
        {
            NotValidState notValid = new NotValidState(this,true);
            notValid.setMessage(napakalakiModel.getCurrentPlayer().getName());
        }
        
        else
        {
        
            napakalakiModel.nextTurn();
        
            playerView1.setPlayer(napakalakiModel.getCurrentPlayer());
            monsterView1.setMonster(napakalakiModel.getCurrentMonster());
        
            playerView1.repaint();
            monsterView1.repaint();
        
            // Se reactiva el botón de mostrar monstruo
            meetMonsterButton.setEnabled(true);
            // Monstruo no será visible hasta que se pulse
            // el botón correspondiente, 'meetMonsterButton'
            monsterView1.setVisible(false);
        
            // Se desactiva botón de combate, ya que hay que
            // mostrar primero al monstruo
            combatButton.setEnabled(false);
                
        }
    }//GEN-LAST:event_nextTurnButtonActionPerformed

    private void combatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatButtonActionPerformed
        // TODO add your handling code here:
        CombatResult result = napakalakiModel.developCombat();
        
        // Para cada resultado, crear ventana emergente que indique el 
        // resultado del combate 
        ResultMessage message = new ResultMessage(this,true);
        message.setMessage(result, napakalakiModel.getCurrentPlayer().getName());
        playerView1.setPlayer(napakalakiModel.getCurrentPlayer());
        
        combatButton.setEnabled(false);
        playerView1.playerCanSteal();
        playerView1.setPlayer(napakalakiModel.getCurrentPlayer());
        nextTurnButton.setEnabled(true);
        
    }//GEN-LAST:event_combatButtonActionPerformed

    
    public void showView() {
        this.setVisible(true);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combatButton;
    private javax.swing.JButton meetMonsterButton;
    private GUI.MonsterView monsterView1;
    private javax.swing.JButton nextTurnButton;
    private GUI.PlayerView playerView1;
    // End of variables declaration//GEN-END:variables
}
