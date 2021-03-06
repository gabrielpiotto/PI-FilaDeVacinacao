package Telas;

import Classe_Pessoa.Pessoa;
import Classe_Pessoa.PessoaDAO;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gabriel Piotto
 */
public class Tela_Principal extends javax.swing.JFrame {

    /**
     * Creates new form Tela_Principal
     */
    public Tela_Principal(String nivelAcesso, String usuario) {
        initComponents();
        readTabela();
        
        painelTabela.setVisible(false);
        
        lblNome.setText(usuario);
        
        lblNivelAcesso.setText(nivelAcesso);
        
        if (!nivelAcesso.equals("Administrador")) {
            painelAdm.setVisible(false);
        }

        readTabela();
    }

    public void readTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaFila.getModel();
        modelo.setNumRows(0);
        tabelaFila.setRowSorter(new TableRowSorter<TableModel> (modelo));
        PessoaDAO pDAO = new PessoaDAO();

        try {
            for (Pessoa p : pDAO.read()) {
                modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getEndereco(),
                    p.getIdade(),
                    p.getAreaSaude(),
                    p.getDataVacinacao(),
                    p.getNivelPrioridade(),
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Problemas tecnicos, tente mais tarde");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fundo = new javax.swing.JPanel();
        Base = new javax.swing.JPanel();
        painelAtendente = new javax.swing.JPanel();
        btnVacinar = new javax.swing.JButton();
        btnFila = new javax.swing.JButton();
        painelID = new javax.swing.JPanel();
        lblNivelAcesso = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        painelAdm = new javax.swing.JPanel();
        btnPessoa = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        painelLogout = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        painelTabela = new javax.swing.JScrollPane();
        tabelaFila = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vaccrow");

        Fundo.setBackground(new java.awt.Color(80, 178, 215));

        Base.setBackground(new java.awt.Color(255, 255, 255));

        btnVacinar.setText("Vacinar");
        btnVacinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVacinarActionPerformed(evt);
            }
        });

        btnFila.setText("Mostrar Fila");
        btnFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAtendenteLayout = new javax.swing.GroupLayout(painelAtendente);
        painelAtendente.setLayout(painelAtendenteLayout);
        painelAtendenteLayout.setHorizontalGroup(
            painelAtendenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAtendenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVacinar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAtendenteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFila, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelAtendenteLayout.setVerticalGroup(
            painelAtendenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAtendenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVacinar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFila, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblNivelAcesso.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNivelAcesso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNivelAcesso.setText("Nivel De Acesso");

        lblNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNome.setText("Nome");

        javax.swing.GroupLayout painelIDLayout = new javax.swing.GroupLayout(painelID);
        painelID.setLayout(painelIDLayout);
        painelIDLayout.setHorizontalGroup(
            painelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelIDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNivelAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelIDLayout.setVerticalGroup(
            painelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelIDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNivelAcesso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(lblNome)
                .addContainerGap())
        );

        btnPessoa.setText("Gerenciar Pessoas");
        btnPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPessoaActionPerformed(evt);
            }
        });

        btnUsuario.setText("Gerenciar Usuarios");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        btnRelatorio.setText("Relatorio");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAdmLayout = new javax.swing.GroupLayout(painelAdm);
        painelAdm.setLayout(painelAdmLayout);
        painelAdmLayout.setHorizontalGroup(
            painelAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAdmLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btnUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelAdmLayout.setVerticalGroup(
            painelAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAdmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLogoutLayout = new javax.swing.GroupLayout(painelLogout);
        painelLogout.setLayout(painelLogoutLayout);
        painelLogoutLayout.setHorizontalGroup(
            painelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLogoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelLogoutLayout.setVerticalGroup(
            painelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLogoutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabelaFila.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tabelaFila.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Endere??o", "Idade", "??rea Saude", "Data Vacina????o", "Nivel de Prioridade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        painelTabela.setViewportView(tabelaFila);

        javax.swing.GroupLayout BaseLayout = new javax.swing.GroupLayout(Base);
        Base.setLayout(BaseLayout);
        BaseLayout.setHorizontalGroup(
            BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(painelID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(painelLogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(painelAtendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(painelAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        BaseLayout.setVerticalGroup(
            BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelTabela)
                    .addGroup(BaseLayout.createSequentialGroup()
                        .addComponent(painelID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(painelLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout FundoLayout = new javax.swing.GroupLayout(Fundo);
        Fundo.setLayout(FundoLayout);
        FundoLayout.setHorizontalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        FundoLayout.setVerticalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilaActionPerformed
        
        // Visibilidade da fila:
        if (painelTabela.isVisible()) {
            painelTabela.setVisible(false);
            btnFila.setText("Mostrar Fila");
            readTabela();
        } else {
            painelTabela.setVisible(true);
            btnFila.setText("Ocultar Fila");
            readTabela();
        }
    }//GEN-LAST:event_btnFilaActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        new Tela_Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPessoaActionPerformed
        new Tela_GerenciarPessoa().setVisible(true);
    }//GEN-LAST:event_btnPessoaActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        new Tela_GerenciarUsuario().setVisible(true);
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        new Tela_Relatorio().setVisible(true);
    }//GEN-LAST:event_btnRelatorioActionPerformed

    private void btnVacinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVacinarActionPerformed
        int column = 0;
        int row = tabelaFila.getSelectedRow();
        Integer idPessoa = (Integer) tabelaFila.getModel().getValueAt(row, column);   
        try{
        
          new PessoaDAO().vacinarPessoa(idPessoa);
        }  catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Problemas tecnicos, tente mais tarde");
        }
        JOptionPane.showMessageDialog(this, "Pessoa Vacinada");
      readTabela();
    }//GEN-LAST:event_btnVacinarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Tela_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Base;
    private javax.swing.JPanel Fundo;
    private javax.swing.JButton btnFila;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPessoa;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton btnVacinar;
    private javax.swing.JLabel lblNivelAcesso;
    private javax.swing.JLabel lblNome;
    private javax.swing.JPanel painelAdm;
    private javax.swing.JPanel painelAtendente;
    private javax.swing.JPanel painelID;
    private javax.swing.JPanel painelLogout;
    private javax.swing.JScrollPane painelTabela;
    private javax.swing.JTable tabelaFila;
    // End of variables declaration//GEN-END:variables
}
