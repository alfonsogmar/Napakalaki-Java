/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import NapakalakiGame.Monster;
import NapakalakiGame.Prize;

/**
 *
 * @author alfonso
 */
public class MonsterView extends javax.swing.JPanel {

    
    private Monster monsterModel;
    
    
    /**
     * Creates new form MonsterView
     */
    public MonsterView() {
        initComponents();
    }
    
    
    public void setMonster(Monster m)
    {
        monsterModel = m;
        
        nameView.setText(m.getName());
        combatLevelView.setText("Nivel de combate: "+m.getCombatLevel());
        levelChangeAgainstCultistView.setText("Nivel contra sectarios: "+m.getCombatLevelAgainstCultist());
        Prize prize = new Prize(m.getTreasuresGained(),m.gelLevelsGained());
        
        prizeView1.setPrize(prize);
        badConsequenceView1.setBadConsequence(m.getBadConsequence());
        
        repaint();
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
        combatLevelView = new javax.swing.JTextField();
        prizeLabel = new javax.swing.JLabel();
        badConsequenceLabel = new javax.swing.JLabel();
        prizeView1 = new GUI.PrizeView();
        badConsequenceView1 = new GUI.BadConsequenceView();
        levelChangeAgainstCultistView = new javax.swing.JTextField();

        nameView.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        nameView.setText("Name");

        combatLevelView.setEditable(false);
        combatLevelView.setText("Nivel de combate:  ");
        combatLevelView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatLevelViewActionPerformed(evt);
            }
        });

        prizeLabel.setText("Buen rollo");

        badConsequenceLabel.setText("Mal rollo");

        levelChangeAgainstCultistView.setEditable(false);
        levelChangeAgainstCultistView.setText("Nivel contra sectarios:  ");
        levelChangeAgainstCultistView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelChangeAgainstCultistViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combatLevelView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(levelChangeAgainstCultistView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameView)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(prizeLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(prizeView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(badConsequenceLabel)
                    .addComponent(badConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameView)
                    .addComponent(badConsequenceLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(badConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(combatLevelView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(levelChangeAgainstCultistView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prizeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prizeView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void combatLevelViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatLevelViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combatLevelViewActionPerformed

    private void levelChangeAgainstCultistViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelChangeAgainstCultistViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_levelChangeAgainstCultistViewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel badConsequenceLabel;
    private GUI.BadConsequenceView badConsequenceView1;
    private javax.swing.JTextField combatLevelView;
    private javax.swing.JTextField levelChangeAgainstCultistView;
    private javax.swing.JLabel nameView;
    private javax.swing.JLabel prizeLabel;
    private GUI.PrizeView prizeView1;
    // End of variables declaration//GEN-END:variables
}