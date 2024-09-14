/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.poo.dao;

import br.uninove.poo.negocio.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ninoa
 */
public class CaixaDAO {

    public List<Caixa> getListarCaixa() {
        Conexao conn = new Conexao();
        Connection conexao = conn.getConexao();
        String sql = "SELECT * FROM caixa";
        List<Caixa> listCarros = new ArrayList<>();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Caixa objCaixa = new Caixa();
                objCaixa.setIdVenda(resultado.getInt("idCarro"));
                objCaixa.setQauntItem(resultado.getInt("quantidade"));
                objCaixa.setData(resultado.getString("data_venda"));
                objCaixa.setNomeProduto(resultado.getString("peca"));
                objCaixa.setValorVenda(resultado.getFloat("valor"));
                listCarros.add(objCaixa);
            }
        } catch (SQLException ex) {

        }
        return listCarros;
    }
    
    public List<Caixa> getListarvendas() {
        Conexao conn = new Conexao();
        java.sql.Connection conexao = conn.getConexao();
        String sql = "SELECT * FROM vendas";
        List<Caixa> listvendas = new ArrayList<>();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Caixa objCaixa = new Caixa();
                objCaixa.setIdVenda(resultado.getInt("nomeClie"));
                objCaixa.setQauntItem(resultado.getInt("quantidade"));
                objCaixa.setData(resultado.getString("data_venda"));
                objCaixa.setNomeProduto(resultado.getString("peca"));
                objCaixa.setValorVenda(resultado.getFloat("valor"));
                listvendas.add(objCaixa);
            }
        } catch (SQLException ex) {

        }
        return listvendas;
    }

    public boolean inserir(Caixa objCarro) {
        try {
            Conexao conn = new Conexao();
            Connection conexao = conn.getConexao();
            String sql = "INSERT INTO `caixa`(`data_venda`, `peca`, `quantidade`, `valor`, `idCarro`)";

            sql += " VALUES(";
            sql += "'" + objCarro.getData() + "',"; //varchar 
            sql += "'" + objCarro.getNomeProduto() + "',"; //varchar 
            sql += objCarro.getQauntItem() + ","; //inteiro
            sql += objCarro.getValorVenda() + ",";//decimal
            sql += objCarro.getIdVenda();//inteiro 
            sql += " );";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean inserir2(Caixa objCarro) {
        try {
            Conexao conn = new Conexao();
            Connection conexao = conn.getConexao();
            String sql = "INSERT INTO `vendas`(`data_venda`, `peca`, `quantidade`, `valor`, `nomeClie`)";

            sql += " VALUES(";
            sql += "'" + objCarro.getData() + "',"; //varchar 
            sql += "'" + objCarro.getNomeProduto() + "',"; //varchar 
            sql += objCarro.getQauntItem() + ","; //inteiro
            sql += objCarro.getValorVenda() + ",";//decimal
            sql += "'" + objCarro.getNomeCliente()+ "'";//char 
            sql += " );";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}

