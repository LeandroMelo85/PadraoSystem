/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DAO.CadastroDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro Melo
 */
public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
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

        jMenuItem2 = new javax.swing.JMenuItem();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/fundo.png"));
        Image image = icon.getImage();
        jDesktopPane = new javax.swing.JDesktopPane() {
            public void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(),this);
            }
        };
        painel_rodape = new javax.swing.JPanel();
        label_data = new javax.swing.JLabel();
        label_hora = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        campo_versao = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_menu = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jM_NovoComputador = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        cbSelecionaLocal = new javax.swing.JCheckBoxMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmi_sair = new javax.swing.JMenuItem();
        jm_consulta = new javax.swing.JMenu();
        jmi_clicad = new javax.swing.JMenuItem();
        jm_manutencao = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jM_NovoSetor = new javax.swing.JMenuItem();
        jM_NovoUser = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PADRÃO SYSTEM");
        setExtendedState(6);
        setMinimumSize(new java.awt.Dimension(1357, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jDesktopPane.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1341, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 705, Short.MAX_VALUE)
        );

        label_data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_data.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_hora.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("VERSÂO DA COMPILAÇÃO: ");
        jLabel1.setEnabled(false);

        campo_versao.setEditable(false);
        campo_versao.setForeground(new java.awt.Color(153, 153, 153));
        campo_versao.setText("0.02");
        campo_versao.setEnabled(false);

        javax.swing.GroupLayout painel_rodapeLayout = new javax.swing.GroupLayout(painel_rodape);
        painel_rodape.setLayout(painel_rodapeLayout);
        painel_rodapeLayout.setHorizontalGroup(
            painel_rodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_rodapeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_versao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_data, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painel_rodapeLayout.setVerticalGroup(
            painel_rodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_rodapeLayout.createSequentialGroup()
                .addGroup(painel_rodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painel_rodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(campo_versao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_rodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(label_hora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                        .addComponent(label_data, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jm_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/application.png"))); // NOI18N
        jm_menu.setText("CADASTRO");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem3.setText("Patrimônio");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jm_menu.add(jMenuItem3);

        jM_NovoComputador.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jM_NovoComputador.setText("Novo Computador");
        jM_NovoComputador.setEnabled(false);
        jM_NovoComputador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_NovoComputadorActionPerformed(evt);
            }
        });
        jm_menu.add(jM_NovoComputador);
        jm_menu.add(jSeparator2);

        cbSelecionaLocal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_DOWN_MASK));
        cbSelecionaLocal.setSelected(true);
        cbSelecionaLocal.setText("No Trabalho");
        jm_menu.add(cbSelecionaLocal);
        jm_menu.add(jSeparator1);

        jmi_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jmi_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/door_in.png"))); // NOI18N
        jmi_sair.setText("Sair");
        jmi_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_sairActionPerformed(evt);
            }
        });
        jm_menu.add(jmi_sair);

        jMenuBar1.add(jm_menu);

        jm_consulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/folder.png"))); // NOI18N
        jm_consulta.setText("CONSULTA");

        jmi_clicad.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jmi_clicad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/folder_explore.png"))); // NOI18N
        jmi_clicad.setText("Patrimônios Cadastrados");
        jmi_clicad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_clicadActionPerformed(evt);
            }
        });
        jm_consulta.add(jmi_clicad);

        jMenuBar1.add(jm_consulta);

        jm_manutencao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/wrench.png"))); // NOI18N
        jm_manutencao.setText("MANUTENÇÃO");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/key.png"))); // NOI18N
        jMenuItem1.setText("Alterar Senha");
        jm_manutencao.add(jMenuItem1);

        jM_NovoSetor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jM_NovoSetor.setText("Novo Setor");
        jM_NovoSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_NovoSetorActionPerformed(evt);
            }
        });
        jm_manutencao.add(jM_NovoSetor);

        jM_NovoUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jM_NovoUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user_add.png"))); // NOI18N
        jM_NovoUser.setText("Novo Usuário");
        jM_NovoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_NovoUserActionPerformed(evt);
            }
        });
        jm_manutencao.add(jM_NovoUser);

        jMenuBar1.add(jm_manutencao);

        jMenu1.setText("AJUDA");

        jMenuItem4.setText("Sobre..");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
            .addComponent(painel_rodape, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painel_rodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1357, 794));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Antes de cadastrar um usuário é verificado a versão da aplicação.
    private void jM_NovoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_NovoUserActionPerformed
        if (!CadastroDAO.readVersion(TelaPrincipal.campo_versao.getText())) {    
            JOptionPane.showMessageDialog(this, "VERSÃO DESATUALIZADA!!! POR FAVOR VERIFIQUE\n"
                    + "VERSÃO DOS SISTEMA: " + TelaPrincipal.campo_versao.getText()
                    + "\nVERSÃO DO BANCO DE DADOS: " + CadastroDAO.readVersion(), "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else { 
            CadastroUser cadUser = new CadastroUser();
            jDesktopPane.add(cadUser);
            cadUser.setVisible(true);
            cadUser.setPosicao();
        }
    }//GEN-LAST:event_jM_NovoUserActionPerformed

    // Antes de consultar um patrimônio é verificada a versão da aplicação.
    private void jmi_clicadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_clicadActionPerformed
        if (!CadastroDAO.readVersion(TelaPrincipal.campo_versao.getText().trim())) {    
            JOptionPane.showMessageDialog(this, "VERSÃO DESATUALIZADA!!! POR FAVOR VERIFIQUE\n"
                    + "VERSÃO DOS SISTEMA: " + TelaPrincipal.campo_versao.getText().trim()
                    + "\nVERSÃO DO BANCO DE DADOS: " + CadastroDAO.readVersion().trim(), "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            ConsultaPatrimonio consuPatri = new ConsultaPatrimonio();
            consuPatri.setVisible(true);
            TelaPrincipal.jDesktopPane.add(consuPatri);
            consuPatri.setPosicao();
        }
    }//GEN-LAST:event_jmi_clicadActionPerformed

    private void jmi_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_sairActionPerformed
        dispose();
    }//GEN-LAST:event_jmi_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        label_data.setText(formato.format(dataSistema));

        Timer timer = new Timer(1000, new hora());
        timer.start();

    }//GEN-LAST:event_formWindowOpened

    // Antes de cadastrar um setor é verificada a versão da aplicação.
    private void jM_NovoSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_NovoSetorActionPerformed
        if (!CadastroDAO.readVersion(TelaPrincipal.campo_versao.getText().trim())) {    
            JOptionPane.showMessageDialog(this, "VERSÃO DESATUALIZADA!!! POR FAVOR VERIFIQUE\n"
                    + "VERSÃO DOS SISTEMA: " + TelaPrincipal.campo_versao.getText().trim()
                    + "\nVERSÃO DO BANCO DE DADOS: " + CadastroDAO.readVersion().trim(), "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else { 
            CadastroSetor cadSetor = new CadastroSetor();
            jDesktopPane.add(cadSetor);
            cadSetor.setVisible(true);
            cadSetor.setPosicao();
        }
    }//GEN-LAST:event_jM_NovoSetorActionPerformed

    private void jM_NovoComputadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_NovoComputadorActionPerformed
        
        CadastroComputador cadCopm = new CadastroComputador();
        jDesktopPane.add(cadCopm);
        cadCopm.setVisible(true);
        cadCopm.setPosicao();
        

    }//GEN-LAST:event_jM_NovoComputadorActionPerformed

    // Antes de cadastrar um patrimônio é verificada a versão da aplicação.
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (!CadastroDAO.readVersion(TelaPrincipal.campo_versao.getText())) {    
            JOptionPane.showMessageDialog(this, "VERSÃO DESATUALIZADA!!! POR FAVOR VERIFIQUE\n"
                    + "VERSÃO DOS SISTEMA: '" + TelaPrincipal.campo_versao.getText() + "'"
                    + "\nVERSÃO DO BANCO DE DADOS: '" + CadastroDAO.readVersion() + "'", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else { 
            CadastroPatrimonio cadPatrimonio = new CadastroPatrimonio();
            jDesktopPane.add(cadPatrimonio);
            cadPatrimonio.setVisible(true);
            cadPatrimonio.setPosicao();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Sobre sobre = new Sobre();
        jDesktopPane.add(sobre);
        sobre.setVisible(true);
        sobre.setPosicao();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField campo_versao;
    public static javax.swing.JCheckBoxMenuItem cbSelecionaLocal;
    public static javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jM_NovoComputador;
    private javax.swing.JMenuItem jM_NovoSetor;
    private javax.swing.JMenuItem jM_NovoUser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu jm_consulta;
    private javax.swing.JMenu jm_manutencao;
    private javax.swing.JMenu jm_menu;
    private javax.swing.JMenuItem jmi_clicad;
    private javax.swing.JMenuItem jmi_sair;
    private javax.swing.JLabel label_data;
    private javax.swing.JLabel label_hora;
    private javax.swing.JPanel painel_rodape;
    // End of variables declaration//GEN-END:variables

    class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            label_hora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }

}
