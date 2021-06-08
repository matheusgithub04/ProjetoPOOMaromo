package br.edu.fatecmm.projetofinalpoo.model;

import br.edu.fatecmm.projetofinalpoo.control.ProdutoDAO;

import java.util.ArrayList;

public class Produto {
    private int codProd;
    private String descricao;
    private double preco;
    private int qntEsto;
    private Fornecedor fornecedor;

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQntEsto() {
        return qntEsto;
    }

    public void setQntEsto(int qntEsto) {
        this.qntEsto = qntEsto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto(int codProd, String descricao, double preco, int qntEsto, Fornecedor fornecedor) {
        this.codProd = codProd;
        this.descricao = descricao;
        this.preco = preco;
        this.qntEsto = qntEsto;
        this.fornecedor = fornecedor;
    }

    public Produto(String nome){

    }

    public Produto(){

    }

    @Override
    public String toString() {
        return "Produto{" +
                "codProd=" + codProd +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", qntEsto=" + qntEsto +
                ", fornecedor=" + fornecedor +
                '}';
    }

    public String retInfo(String fornecedor){
        String linha = "";
        ProdutoDAO pdao = new ProdutoDAO();
        ArrayList<Fornecedor> listFor = pdao.readFornecedores(fornecedor);
        for (Fornecedor f: listFor) {
            linha = this.codProd + ";" + this.descricao + ";" + this.preco + ";" + this.qntEsto + ";" + f.getContato().getNome() + ";" + f.getCodForn() + ";" + f.getRazaoSocial() + ";" + f.getContato().getNome() + ";" + f.getContato().getTelefone() + ";" + f.getEndereco() + ";" + f.getCidade() + ";" + f.getEstado() + ";" + f.getContato().getEmail()+ "\n";
        }
        //linha = this.codProd + ";" + this.descricao + ";" + this.preco + ";" + this.qntEsto + ";" + fornecedor.getContato().getNome() + "\n";
        return linha;
    }
}
