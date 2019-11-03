
package br.com.sap.controler;

import java.sql.*;
import br.com.sap.dao.ModuloConexao;
import javax.swing.JOptionPane;
import br.com.sap.view.TelaLogin;
import br.com.sap.view.TelaPrincipal;


public class LoginControler {
    
    // usando variável de conexão do DAL
    Connection conexao = null;
    // Criando variáveis especiais para conexão do banco
    // Prepareted Statement e Resultset são frameworks do pacote java.sql
    // e servem para preparar e executar as instruções SQL
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    TelaLogin login = new TelaLogin();
    
    private String mail = login.txtMail.getText();
    private String senha = login.txtSenha.getText();
    
    
    // criando o método logar
    public void logar() {
        conexao = ModuloConexao.conector();
        
        TelaLogin.txtMail.getText();
        TelaLogin.txtSenha.getText();
        
        String sql = "select * from usuario where email=? and senha=?";
        try {
            // as linhas abaixo preparam a consulta ao banco em função do que foi digitado nas caixas de texto
            // o ? é substituido pelo conteúdo das variáveis
            pst = conexao.prepareStatement(sql);
            pst.setString(1, mail);
            pst.setString(2, senha);
            

            // a linha abaixo executa a consulta ao banco de dados
            rs = pst.executeQuery();
            
            System.out.println(sql);
            System.out.println(pst);
            // se existir usuário e senha correspondente
            if (rs.next()) {
                // a linha abaixo obtem o conteudo do campo perfil da tabela tbusuario
                //String perfil = rs.getString(6);
                //System.out.println(perfil);
                // a estrutura abaixo faz o tratamento do perfil
                //if (perfil.equals("admin")) {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    
                //    // fechando a tela de login ao logar
                    login.dispose();
                    
                //} else {
                //    TelaPrincipal principal = new TelaPrincipal();
                //    principal.setVisible(true);
                //    TelaPrincipal.lblUsuario.setText(rs.getString(2));
                    login.dispose();
                //}
                // fechando a conexão com o banco de dados
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e ou senha inválido(s)");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
    

