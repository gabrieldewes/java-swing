package agenda;

import static agenda.Controller.dao;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
public class App extends javax.swing.JFrame {
   
    public App() {
        initComponents();
        
        AttBtn.setEnabled(false);
        DelBtn.setEnabled(false);
        
        ResultSet rs = Controller.Todos();
        Tabela.setModel(DbUtils.resultSetToTableModel(rs)); 
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        btnAddView = new javax.swing.JButton();
        AttBtn = new javax.swing.JButton();
        DelBtn = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda");

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "idContato", "nome", "fone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabela);

        searchField.setText("Nome...");
        searchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchFieldMouseClicked(evt);
            }
        });
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        searchBtn.setText("Buscar");
        searchBtn.setToolTipText("");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        btnAddView.setText("Adicionar...");
        btnAddView.setToolTipText("");
        btnAddView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddViewActionPerformed(evt);
            }
        });

        AttBtn.setText("Alterar");
        AttBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttBtnActionPerformed(evt);
            }
        });

        DelBtn.setText("Excluir");
        DelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AttBtn)
                    .addComponent(DelBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddView, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBtn)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddView, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(AttBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DelBtn)
                        .addContainerGap(126, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMouseClicked
        AttBtn.setEnabled(true);
        DelBtn.setEnabled(true);
        
        //JOptionPane.showInputDialog( Tabela.getValueAt(Tabela.getSelectedRow(), 0) );
    }//GEN-LAST:event_TabelaMouseClicked

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMouseClicked
        searchField.setText("");
    }//GEN-LAST:event_searchFieldMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String nome = searchField.getText();
        //JOptionPane.showMessageDialog(null, nome );
        ResultSet rs;
        if (nome.contentEquals("")) 
            rs = Controller.Todos();
        else
            rs = Controller.Buscar(nome);
        Tabela.setModel(DbUtils.resultSetToTableModel(rs));
    }//GEN-LAST:event_searchBtnActionPerformed
/* BOTÃO SALVAR CONTATO */
    private void btnAddViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddViewActionPerformed
        JTextField nome = new JTextField();
        JTextField sobrenome = new JTextField();
        JTextField fone = new JTextField();
        JTextField fone2 = new JTextField();

        Object[] message = {
            "Nome:", nome,
            "Sobrenome:", sobrenome,
            "Fone:", fone,
            "Fone 2", fone2 
        };
        
        int option=1;
        while (option != JOptionPane.OK_CANCEL_OPTION) {
            option = JOptionPane.showConfirmDialog(null, message, "Novo contato", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                ArrayList<String> nomes = new ArrayList<>();
                ArrayList<String> fones = new ArrayList<>();

                if (!nome.getText().contentEquals("")) nomes.add(nome.getText());
                if (!sobrenome.getText().contentEquals("")) nomes.add(sobrenome.getText());
                if (!fone.getText().contentEquals("")) fones.add(fone.getText());
                if (!fone2.getText().contentEquals("")) fones.add(fone2.getText());
                
                if (Controller.Salvar(nomes,fones)) {   
                    option = JOptionPane.OK_CANCEL_OPTION;
                    ResultSet rs = dao.list();
                    Tabela.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } else System.out.println("Cancelar. ");
        }
    }//GEN-LAST:event_btnAddViewActionPerformed

    /* BOTÃO ATUALIZAR CONTATO */
    private void AttBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttBtnActionPerformed
        //JOptionPane.showInputDialog( Tabela.getValueAt(Tabela.getSelectedRow(), 0) );
        int id = (int) Tabela.getValueAt(Tabela.getSelectedRow(), 0);
        Model p_old = Controller.Pegar(id);
        //JOptionPane.showMessageDialog(null, " "+ p.getNome() +"");
        JTextField nome = new JTextField();
        JTextField sobrenome = new JTextField();
        JTextField fone = new JTextField();
        JTextField fone2 = new JTextField();
        
        nome.setText( p_old.getNome().get(0).toString() );
        
        if (p_old.getNome().size() == 2) 
            sobrenome.setText( p_old.getNome().get(1).toString() );
        if (p_old.getFone().size() == 2) {
            fone.setText( p_old.getFone().get(0).toString().substring (0, p_old.getFone().get(0).toString().length() - 1) );
            fone2.setText( p_old.getFone().get(1).toString() );
        } else fone.setText( p_old.getFone().get(0).toString() );

        Object[] message = {
            "Nome:", nome,
            "Sobrenome:", sobrenome,
            "Fone:", fone,
            "Fone 2", fone2 
        };
        int option = 1;
        while (option != JOptionPane.OK_CANCEL_OPTION) {
            option = JOptionPane.showConfirmDialog(null, message, "Novo contato", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                ArrayList<String> nomes = new ArrayList<>();
                ArrayList<String> fones = new ArrayList<>();

                if (!nome.getText().contentEquals("")) nomes.add(nome.getText());
                if (!sobrenome.getText().contentEquals("")) nomes.add(sobrenome.getText());
                if (!fone.getText().contentEquals("")) fones.add(fone.getText());
                if (!fone2.getText().contentEquals("")) fones.add(fone2.getText());
                
                if ( Controller.Alterar( p_old, nomes, fones ) ) {
                    option = JOptionPane.OK_CANCEL_OPTION;
                    ResultSet rs = Controller.Todos();
                    Tabela.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } else System.out.println("Cancelar. ");
        }
    }//GEN-LAST:event_AttBtnActionPerformed
/* BOTÃO APAGAR CONTATO */
    private void DelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelBtnActionPerformed
        //JOptionPane.showInputDialog( Tabela.getValueAt(Tabela.getSelectedRow(), 0) );
        int response = JOptionPane.showConfirmDialog(null, "Apagar "+ Tabela.getValueAt(Tabela.getSelectedRow(), 1) +"?", "Atenção",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) 
            System.out.println("Cancelar. ");
        else if (response == JOptionPane.YES_OPTION) {
            System.out.println("Confirmar. ");
            if ( Controller.Apagar( (int) Tabela.getValueAt(Tabela.getSelectedRow(), 0) ) ) {
                ResultSet rs = Controller.Todos();
                Tabela.setModel(DbUtils.resultSetToTableModel(rs));
            }
        } 
        
    }//GEN-LAST:event_DelBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AttBtn;
    private javax.swing.JButton DelBtn;
    private javax.swing.JTable Tabela;
    private javax.swing.JButton btnAddView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
