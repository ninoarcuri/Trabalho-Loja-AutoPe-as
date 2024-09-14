/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.poo.view;

import br.uninove.poo.dao.CarroDAO;
import br.uninove.poo.dao.Conexao;
import br.uninove.poo.negocio.Carro;
import com.mysql.jdbc.Connection;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author internet
 */
public class Principal {

    public static void main(String[] args) {
        Conexao objConexao = new Conexao();
        Connection conn = objConexao.getConexao();//chamando o método conectar
        System.out.println(objConexao.getStatusConexao());

        CarroDAO objCarroDao = new CarroDAO();
        Carro objCarroNew = new Carro();
        objCarroNew.setAnoFabricacao(2018);
        objCarroNew.setCor("Vermelho");
        objCarroNew.setFabricante("Fiat");
        objCarroNew.setPeca("Motor Parcial");
        objCarroNew.setModelo("Uno");
        objCarroNew.setValor(350000);

        if (objCarroDao.inserir(objCarroNew)) {
            System.out.println("Inserido com sucesso");
        } else {
            System.out.println("Erro ao inserir");
        }

        List<Carro> lista = objCarroDao.getListarCarro();
        for (Carro item : lista) {
            System.out.print(item.getIdCarro() + ",");
            System.out.print(item.getAnoFabricacao() + ",");
            System.out.print(item.getCor() + ",");
            System.out.print(item.getFabricante() + ",");
            System.out.print(item.getPeca() + ",");
            System.out.print(item.getModelo() + ",");
            System.out.print(item.getValor() + ",");
            System.out.println("");
        }

        Scanner teclado = new Scanner(System.in);
        Carro objCarroAtualizar = new Carro();
        System.out.println("Escolha o id de um veiculo");
        int id = teclado.nextInt();

        System.out.println("Informe o modelo");
        String modelo = teclado.next();

        objCarroAtualizar.setIdCarro(id);
        objCarroAtualizar.setModelo(modelo);
        objCarroDao.atualizar(objCarroAtualizar);

    }
    
    
}
