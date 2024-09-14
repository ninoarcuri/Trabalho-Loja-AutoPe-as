/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.poo.dao;

import br.uninove.poo.negocio.Carro;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {

    public List<Carro> getListarCarro() {
        Conexao conn = new Conexao();
        Connection conexao = conn.getConexao();
        String sql = "SELECT * FROM carros";
        List<Carro> listCarros = new ArrayList<>();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Carro objCarro = new Carro();
                objCarro.setIdCarro(resultado.getInt("idCarro"));
                objCarro.setAnoFabricacao(resultado.getInt("anoFabricacao"));
                objCarro.setCor(resultado.getString("cor"));
                objCarro.setFabricante(resultado.getString("fabricante"));
                objCarro.setPeca(resultado.getString("peca"));
                objCarro.setModelo(resultado.getString("modelo"));
                objCarro.setValor(resultado.getDouble("valor"));
                objCarro.setQuat(resultado.getInt("quantidade"));
                listCarros.add(objCarro);
            }
        } catch (SQLException ex) {

        }
        return listCarros;
    }

    

    public boolean inserir(Carro objCarro) {
        try {
            Conexao conn = new Conexao();
            Connection conexao = conn.getConexao();
            String sql = "INSERT INTO `carros`(`peca`, `fabricante`, `modelo`, `anoFabricacao`, `cor`, `valor`, `quantidade`)";

            sql += " VALUES(";
            sql += "'" + objCarro.getPeca() + "',"; //varchar 
            sql += "'" + objCarro.getFabricante() + "',"; //varchar 
            sql += "'" + objCarro.getModelo() + "',"; //varchar 
            sql += objCarro.getAnoFabricacao() + ","; //inteiro 
            sql += "'" + objCarro.getCor() + "',"; //varchar 
            sql += objCarro.getValor() + ",";//decimal
            sql += objCarro.getQuat();//inteiro 
            sql += " );";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean atualizar(Carro objCarro) {
        Conexao conn = new Conexao();

        try {
            Connection conexao = conn.getConexao();
            String sql = "Update carros set ";
            sql += "peca = '" + objCarro.getPeca() + "',"; //varchar 
            sql += "fabricante = '" + objCarro.getFabricante() + "',"; //Varchar
            sql += "modelo = '" + objCarro.getModelo() + "',"; //Varchar
            sql += "anoFabricacao =" + objCarro.getAnoFabricacao() + ","; //inteiro 
            sql += "cor = '" + objCarro.getCor() + "',"; //varchar 
            sql += "valor = " + objCarro.getValor() + ","; //decimal. 
            sql += "quantidade = " + objCarro.getQuat(); //decimal. No ultimo não há necessidade de virgula
            sql += " where idCarro = " + objCarro.getIdCarro() + ";";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.executeUpdate(sql);
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;

        }

    }

    public boolean delete(int idCarro) {
        String sql = "delete from carros where idCarro =?";
        Conexao conn = new Conexao();
        Connection conexao = conn.getConexao();

        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, idCarro);
            //execute delete sql stetement
            comando.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
