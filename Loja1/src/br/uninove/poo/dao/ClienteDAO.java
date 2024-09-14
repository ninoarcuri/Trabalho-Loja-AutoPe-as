/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.poo.dao;

import br.uninove.poo.negocio.Cliente;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public List<Cliente> getListarCliente() {
        Conexao conn = new Conexao();
        Connection conexao = conn.getConexao();
        String sql = "SELECT * FROM cliente";
        List<Cliente> listCliente = new ArrayList<>();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();   
            while (resultado.next()) {
                Cliente objCliente = new Cliente();
                objCliente.setIdCli(resultado.getInt("idCli"));
                objCliente.setNomecli(resultado.getString("nomeCli"));
                objCliente.setCNPJ(resultado.getString("cnpj"));
                objCliente.setEmail(resultado.getString("email"));
                objCliente.setEndereco(resultado.getString("endereco"));
                objCliente.setBairro(resultado.getString("bairro"));
                objCliente.setCidade(resultado.getString("cidade"));
                objCliente.setUf(resultado.getString("uf"));
                objCliente.setCEP(resultado.getString("CEP"));
                objCliente.setTel(resultado.getString("tel"));
                objCliente.setCel(resultado.getString("cel"));
                listCliente.add(objCliente);
            }
        } catch (SQLException ex) {

        }
        return listCliente;
    }

    public boolean inserir(Cliente objCliente) {
        try {
            Conexao conn = new Conexao();
            Connection conexao = conn.getConexao();
            String sql = "INSERT INTO `cliente`(`nomeCli`, `cnpj`, `email`, `endereco`, `bairro`, `cidade`, `UF`, `CEP`, `tel`, `cel`)";
                                                 
            sql += " VALUES(";
            sql += "'" + objCliente.getNomecli()+ "',"; //varchar
            sql += "'" + objCliente.getCNPJ() + "',"; //varchar 
            sql += "'" + objCliente.getEmail() + "',"; //varchar 
            sql += "'" + objCliente.getEndereco() + "',"; //varchar 
            sql += "'" + objCliente.getBairro() + "',"; //varchar 
            sql += "'" + objCliente.getCidade() + "',"; //varchar 
            sql += "'" + objCliente.getUf() + "',"; //varchar 
            sql += "'" + objCliente.getCEP() + "',"; //varchar  
            sql += "'" + objCliente.getTel() + "',"; //varchar   
            sql += "'" + objCliente.getCel() + "'"; //varchar 
            sql += " );";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean atualizar(Cliente objCliente) {
        Conexao conn = new Conexao();

        try {
            Connection conexao = conn.getConexao();
            String sql = "Update cliente set ";
            sql += "nomeCli = '" + objCliente.getNomecli()+ "',"; //varchar 
            sql += "cnpj = '" + objCliente.getCNPJ() + "',"; //varchar 
            sql += "email = '" + objCliente.getEmail() + "',"; //varchar 
            sql += "endereco = '" + objCliente.getEndereco() + "',"; //varchar 
            sql += "bairro = '" + objCliente.getBairro() + "',"; //varchar 
            sql += "cidade = '" + objCliente.getCidade() + "',"; //varchar 
            sql += "uf = '" + objCliente.getUf() + "',"; //varchar 
            sql += "CEP = '" + objCliente.getCEP() + "',"; //varchar 
            sql += "tel = '" + objCliente.getTel() + "',"; //varchar 
            sql += "cel = '" + objCliente.getCel() + "'"; //varchar  No ultimo não há necessidade de virgula
            sql += " where idCli = " + objCliente.getIdCli() + ";";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.executeUpdate(sql);
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;

        }

    }

    public boolean delete(int idCli) {
        String sql = "delete from cliente where idCli =?";
        Conexao conn = new Conexao();
        Connection conexao = conn.getConexao();

        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, idCli);
            //execute delete sql stetement
            comando.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
