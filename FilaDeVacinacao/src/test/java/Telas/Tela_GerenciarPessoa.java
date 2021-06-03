package Telas;

import Classe_Pessoa.Pessoa;
import Classe_Pessoa.PessoaDAO;
import Classe_Usuario.Usuario;
import Classe_Usuario.UsuarioDAO;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gabriel Piotto
 */
public class Tela_GerenciarPessoa extends javax.swing.JFrame {

    /**
     * Creates new form Tela_CadastroPessoa
     */
    public Tela_GerenciarPessoa() {
        initComponents();
        readTabela();
    }

    public void readTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaPessoas.getModel();
        modelo.setNumRows(0);
        PessoaDAO pDAO = new PessoaDAO();

        try {
            for (Pessoa p : pDAO.read()) {
                modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getIdade(),
                    p.getEndereco(),
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

        fundo = new javax.swing.JPanel();
        painelTopo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        txtIdade = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPessoas = new javax.swing.JTable();
        txtSaude = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        txtNivelPrioridade = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciar Pessoas");
        setResizable(false);

        fundo.setBackground(new java.awt.Color(80, 178, 215));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 3, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(80, 178, 215));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerenciar Pessoas");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout painelTopoLayout = new javax.swing.GroupLayout(painelTopo);
        painelTopo.setLayout(painelTopoLayout);
        painelTopoLayout.setHorizontalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelTopoLayout.setVerticalGroup(
            painelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(80, 178, 215));

        txtNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(80, 178, 215))); // NOI18N

        txtIdade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIdade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Idade ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(80, 178, 215))); // NOI18N
        txtIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdadeActionPerformed(evt);
            }
        });

        txtEndereco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(80, 178, 215))); // NOI18N

        tabelaPessoas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tabelaPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaPessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPessoasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPessoas);

        txtSaude.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSaude.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Área da Saúde ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(80, 178, 215))); // NOI18N
        txtSaude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaudeActionPerformed(evt);
            }
        });

        txtData.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data de Vacinação ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(80, 178, 215))); // NOI18N

        btnCadastrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(80, 178, 215));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(80, 178, 215));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAtualizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(80, 178, 215));
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(80, 178, 215));
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtNivelPrioridade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNivelPrioridade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nivel de Prioridade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(80, 178, 215))); // NOI18N
        txtNivelPrioridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNivelPrioridadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdade)
                    .addComponent(txtEndereco)
                    .addComponent(txtSaude)
                    .addComponent(txtData)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNome)
                    .addComponent(txtNivelPrioridade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSaude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNivelPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout fundoLayout = new javax.swing.GroupLayout(fundo);
        fundo.setLayout(fundoLayout);
        fundoLayout.setHorizontalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelTopo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        fundoLayout.setVerticalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelTopo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaPessoasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPessoasMouseClicked
        if (tabelaPessoas.getSelectedRow() != -1) {
            txtNome.setText(tabelaPessoas.getValueAt(tabelaPessoas.getSelectedRow(), 1).toString());
            txtIdade.setText(tabelaPessoas.getValueAt(tabelaPessoas.getSelectedRow(), 2).toString());
            txtEndereco.setText(tabelaPessoas.getValueAt(tabelaPessoas.getSelectedRow(), 3).toString());
            txtSaude.setText(tabelaPessoas.getValueAt(tabelaPessoas.getSelectedRow(), 4).toString());
            txtData.setText(tabelaPessoas.getValueAt(tabelaPessoas.getSelectedRow(), 5).toString());
            txtNivelPrioridade.setText(tabelaPessoas.getValueAt(tabelaPessoas.getSelectedRow(), 6).toString());
        }
    }//GEN-LAST:event_tabelaPessoasMouseClicked

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // Traduzindo os botões do JOP:
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");

        try {
            // Recebendo os dados:
            String nome = txtNome.getText();
            String endereco = txtEndereco.getText();
            int idade = Integer.parseInt(txtIdade.getText());
            String areaSaude = txtSaude.getText();
            String dataVacinacao = txtData.getText();
            int nivelPrioridade = Integer.parseInt(txtNivelPrioridade.getText());
            

            // Não cadastrar ficha em branco:
            if (nome.length() == 0 || endereco.length() == 0 || txtIdade.getText().length() == 0 || areaSaude.length() == 0 ) {
                JOptionPane.showMessageDialog(this, "Preencha os campos corretamente.");
                return;
            }
            if (areaSaude.equals("Sim") || areaSaude.equals("Não")) {

            } else {
                JOptionPane.showMessageDialog(this, "Preencha o campo 'Área Saúde' corretamente");
            }
           
            Pessoa p = new Pessoa(nome, endereco, idade, areaSaude, nivelPrioridade);
            PessoaDAO pDAO = new PessoaDAO();

            // Confirmação de Cadastro:
            int escolha = JOptionPane.showConfirmDialog(this, "Deseja mesmo cadastrar " + txtNome.getText() + " ?");
            if (escolha == JOptionPane.YES_OPTION) {
                pDAO.cadastrarPessoa(p);

                // Limpar os campos e Atualizando tabela:
                txtNome.setText("");
                txtEndereco.setText("");
                txtIdade.setText("");
                txtSaude.setText("");
                txtData.setText("");
                txtNivelPrioridade.setText("");

                readTabela();
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Problemas tecnicos, tente mais tarde");
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // Traduzindo os botões do JOP:
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");

        // Confirmação de atualização:
        try {
            int escolha = JOptionPane.showConfirmDialog(this, "Deseja mesmo atualizar " + txtNome.getText() + " ?");
            if (escolha == JOptionPane.YES_OPTION) {
                if (tabelaPessoas.getSelectedRow() != -1) {
                    // Recebendo os dados:
                    int id = (int) tabelaPessoas.getValueAt(tabelaPessoas.getSelectedRow(), 0);
                    String nome = txtNome.getText();
                    String endereco = txtEndereco.getText();
                    int idade = Integer.parseInt(txtIdade.getText());
                    String areaSaude = txtSaude.getText();
                    String dataVacinacao = txtData.getText();
                    int nivelPrioridade = Integer.parseInt(txtNivelPrioridade.getText());

                    // Não cadastrar ficha em branco:
                    if (nome.length() == 0 || endereco.length() == 0 || txtIdade.getText().length() == 0 || areaSaude.length() == 0 || txtNivelPrioridade.getText().length() == 0 ) {
                        JOptionPane.showMessageDialog(this, "Preencha os campos corretamente.");
                        return;
                    }

                    if (areaSaude.equals("Sim") || areaSaude.equals("Não")) {

                    } else {
                        JOptionPane.showMessageDialog(this, "Preencha o campo 'Área Saúde' corretamente");
                        return;
                    }

                    Pessoa p = new Pessoa(id, nome, endereco, idade, areaSaude, dataVacinacao, nivelPrioridade);
                    PessoaDAO pDAO = new PessoaDAO();
                    pDAO.atualizarPessoa(p);

                    // Limpar os campos e Atualizando tabela:
                    txtNome.setText("");
                    txtEndereco.setText("");
                    txtIdade.setText("");
                    txtSaude.setText("");
                    txtData.setText("");
                    txtNivelPrioridade.setText("");

                    readTabela();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Problemas tecnicos, tente mais tarde");
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // Traduzindo os botões do JOP:
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");

        try {
            int escolha = JOptionPane.showConfirmDialog(this, "Deseja mesmo apagar o usuario " + txtNome.getText() + " ?");
            if (escolha == JOptionPane.YES_OPTION) {
                if (tabelaPessoas.getSelectedRow() != -1) {
                    Pessoa p = new Pessoa();
                    PessoaDAO pDAO = new PessoaDAO();

                    p.setId((int) tabelaPessoas.getValueAt(tabelaPessoas.getSelectedRow(), 0));

                    pDAO.apagarPessoa(p);

                    // Limpar os campos e Atualizando tabela:
                    txtNome.setText("");
                    txtEndereco.setText("");
                    txtIdade.setText("");
                    txtSaude.setText("");
                    txtData.setText("");
                    txtNivelPrioridade.setText("");

                    readTabela();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Problemas tecnicos, tente mais tarde");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtSaudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaudeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaudeActionPerformed

    private void txtNivelPrioridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNivelPrioridadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNivelPrioridadeActionPerformed

    private void txtIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdadeActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_GerenciarPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_GerenciarPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_GerenciarPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_GerenciarPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_GerenciarPessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel fundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelTopo;
    private javax.swing.JTable tabelaPessoas;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNivelPrioridade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSaude;
    // End of variables declaration//GEN-END:variables
}
