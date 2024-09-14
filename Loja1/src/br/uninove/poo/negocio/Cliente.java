/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.poo.negocio;

/**
 *
 * @author internet
 */
public class Cliente {
    private String nomecli, Endereco, Email,Bairro,Cidade,Uf,CNPJ,Tel,Cel,CEP;
    private int idCli;

    /**
     * @return the nomecli
     */
    public String getNomecli() {
        return nomecli;
    }

    /**
     * @param nomecli the nomecli to set
     */
    public void setNomecli(String nomecli) {
        this.nomecli = nomecli;
    }

    /**
     * @return the Endereco
     */
    public String getEndereco() {
        return Endereco;
    }

    /**
     * @param Endereco the Endereco to set
     */
    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Bairro
     */
    public String getBairro() {
        return Bairro;
    }

    /**
     * @param Bairro the Bairro to set
     */
    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    /**
     * @return the Cidade
     */
    public String getCidade() {
        return Cidade;
    }

    /**
     * @param Cidade the Cidade to set
     */
    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    /**
     * @return the Uf
     */
    public String getUf() {
        return Uf;
    }

    /**
     * @param Uf the Uf to set
     */
    public void setUf(String Uf) {
        this.Uf = Uf;
    }

    /**
     * @return the CNPJ
     */
    public String getCNPJ() {
        return CNPJ;
    }

    /**
     * @param CNPJ the CNPJ to set
     */
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    /**
     * @return the Tel
     */
    public String getTel() {
        return Tel;
    }

    /**
     * @param Tel the Tel to set
     */
    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    /**
     * @return the Cel
     */
    public String getCel() {
        return Cel;
    }

    /**
     * @param Cel the Cel to set
     */
    public void setCel(String Cel) {
        this.Cel = Cel;
    }

    /**
     * @return the CEP
     */
    public String getCEP() {
        return CEP;
    }

    /**
     * @param CEP the CEP to set
     */
    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    /**
     * @return the idCli
     */
    public int getIdCli() {
        return idCli;
    }

    /**
     * @param idCli the idCli to set
     */
    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    
}
