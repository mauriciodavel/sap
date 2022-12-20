package br.com.sap.controler;

import java.sql.*;
import br.com.sap.dao.ModuloConexao;
import br.com.sap.view.TelaDefeito;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author mdavel
 */
public class TelaDefeitoController {

   

    Connection conexao = null;

    // Criando variáveis especiais para conexão do banco
    //Prepareted Statement e Resultset são frameworks do pacote java.sql
    // e servem para preparar e executar as instruções SQL
    PreparedStatement pst = null;
    ResultSet rs = null;

    TelaDefeito defeito = new TelaDefeito();
    
      
    //Criando o método para o botão salvar
    public void salvar() {

        conexao = ModuloConexao.conector();

        String sql = "insert into registro_defeito(data,idEquipamento,idTipoDefeito,horaInicial,horaFinal) values(?,?,?,?,?)";

        try {

            pst = conexao.prepareStatement(sql);
            System.out.println("1");
            
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            TelaDefeito.txtData1.setText(df.format(TelaDefeito.txtData.getDate()));
            //TelaDefeito.txtData1.getText();
            pst.setString(1, TelaDefeito.txtData1.getText());
            System.out.println("2");
            pst.setString(2, TelaDefeito.cbbEquipamento.getSelectedItem().toString());
            System.out.println("3");
            pst.setString(3, TelaDefeito.cbbDefeito.getSelectedItem().toString());
            System.out.println("4");
            pst.setString(4, TelaDefeito.txtInicio.getText());
            pst.setString(5, TelaDefeito.txtFim.getText());

            // validação dos campos obrigatórios
            if ((TelaDefeito.txtData.getDateFormatString().isEmpty()) || (TelaDefeito.txtInicio.getText().isEmpty()) || (TelaDefeito.txtFim.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Campo de preenchimento obrigatório está em branco!");

            } else {

                // a linha abaixo atualiza a tabela de usuário com os dados do formulário
                // a linha abaixo é usada para confirmar a inserção dos dados na tabela
                int adicionado = pst.executeUpdate();
                // a linha abaixo serve de apoio ao entendimento da lógica
                System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Defeito registrado com sucesso");
                    // as linhas abaixo limpam os campos para que o usuario possa cadastrar um novo

                    TelaDefeito.txtData.setDate(null);
                    TelaDefeito.txtInicio.setText(null);
                    TelaDefeito.txtFim.setText(null);
                    TelaDefeito.cbbDefeito.setName(null);
                    TelaDefeito.cbbEquipamento.setName(null);

                }
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        }
    }
    
   public void limpar_campos(){
       TelaDefeito.txtInicio.setText(null);
       TelaDefeito.txtFim.setText(null);
       
   } 

}
