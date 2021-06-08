package br.edu.fatecmm.projetofinalpoo.model;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Cesta {
    ArrayList<Produto> itens = new ArrayList<Produto>();
    public void adicionarItem(Produto p){
        itens.add(p);
    }

    public double calcularTotal(ArrayList<Produto> aP){
        double valor  = 0;
        for(Produto p : aP){
            valor += p.getPreco();
        }
        return valor;
    }

    public void exibirLista(){
        /*for (Produto p : itens) {
            System.out.println("Produto: "+p.getCodProd()+" "+p.getDescricao()+" "+p.getPreco()+" "+p.getQntEsto());

            System.out.println("Fornecedor: "+p.getFornecedor().getCodForn()+" "+p.getFornecedor().getRazaoSocial()+" "+p.getFornecedor().getEndereco()+" "+p.getFornecedor().getCidade()+" "+p.getFornecedor().getEstado());

            System.out.println("Contato: "+p.getFornecedor().getContato().getNome()+" "+p.getFornecedor().getContato().getTelefone()+" "+p.getFornecedor().getContato().getEmail());

            System.out.println("----------------------------------------------");
        }*/
    }

    public ArrayList<Produto> getPro(){
        return itens;
    }
}
