/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sap.view;

import br.com.sap.dao.ModuloConexao;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author MDAVEL
 */
public class TelaDefeito extends javax.swing.JInternalFrame {
    
     // usando variável de conexão do DAL
    Connection conexao = null;

    // Criando variáveis especiais para conexão do banco
    //Prepareted Statement e Resultset são frameworks do pacote java.sql
    // e servem para preparar e executar as instruções SQL
    PreparedStatement pst = null;
    ResultSet rs = null;
           
    public void populaEquipamento() {
        
        String sqlcombo = "Select * from tipo_equipamento";
        
        try {
            pst = conexao.prepareStatement(sqlcombo);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                 cbbEquipamento.addItem(rs.getString("tipo"));
                
            }
                                    
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
            
        }
     
    }
    
    public void populaDefeito() {
        
        String sqldefeito = "Select * from defeito";
        
        try {
            pst = conexao.prepareStatement(sqldefeito);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                 cbbDefeito.addItem(rs.getString("defeito"));
                
            }
                                                
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
            
        }
                
    }
    
    public void cadastro(){
        
        String sql = "insert into registro_defeito (data, id_Equipamento, idTipoDefeito, horaInicial, horaFinal) values(?,?,?,?,?)";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtData.getDateFormatString());
            pst.setString(2, cbbEquipamento.getSelectedItem().toString());
            pst.setString(3, cbbDefeito.getSelectedItem().toString());
            
            if (rootPaneCheckingEnabled) {
                
            } else {
                
                
            }
        } catch (Exception e) {
        }
                
    }
    
        
    /**
     * Creates new form TelaDefeito
     */
    public TelaDefeito() {
        initComponents();
        
        conexao = ModuloConexao.conector();
        this.populaEquipamento();
        this.populaDefeito();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblData = new javax.swing.JLabel();
        lblEquipamento = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();
        lblFim = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtData = new com.toedter.calendar.JDateChooser();
        cbbEquipamento = new javax.swing.JComboBox<>();
        cbbDefeito = new javax.swing.JComboBox<>();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFim = new javax.swing.JFormattedTextField();
        txtInicio = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("SISDEF - Tela de Cadastro de Defeitos");
        setToolTipText("");

        lblData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblData.setText("Data:");

        lblEquipamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEquipamento.setText("Equipamento");

        lblInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio.setText("Horário Início Defeito");

        lblFim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFim.setText("Horário Final Defeito");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tipo Defeito");

        txtData.setToolTipText("");
        txtData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cbbEquipamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbEquipamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Equipamento" }));

        cbbDefeito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbDefeito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Defeito" }));

        btnLimpar.setBackground(new java.awt.Color(102, 102, 255));
        btnLimpar.setText("Limpar");

        btnSalvar.setBackground(new java.awt.Color(102, 102, 255));
        btnSalvar.setText("Salvar");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sap/icones/logo (1).png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        try {
            txtFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFim.setToolTipText("");
        txtFim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            txtInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtInicio.setToolTipText("");
        txtInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInicio)
                            .addComponent(lblEquipamento)
                            .addComponent(lblData))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbEquipamento, 0, 187, Short.MAX_VALUE)
                                    .addComponent(txtInicio))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFim)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbDefeito, 0, 193, Short.MAX_VALUE)
                                    .addComponent(txtFim)))
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblData)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEquipamento)
                            .addComponent(cbbEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblInicio)
                            .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(cbbDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFim)
                            .addComponent(txtFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        setBounds(0, 0, 708, 554);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbbDefeito;
    private javax.swing.JComboBox<String> cbbEquipamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEquipamento;
    private javax.swing.JLabel lblFim;
    private javax.swing.JLabel lblInicio;
    private com.toedter.calendar.JDateChooser txtData;
    private javax.swing.JFormattedTextField txtFim;
    private javax.swing.JFormattedTextField txtInicio;
    // End of variables declaration//GEN-END:variables
}