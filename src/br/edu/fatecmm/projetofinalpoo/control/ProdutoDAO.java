package br.edu.fatecmm.projetofinalpoo.control;

import br.edu.fatecmm.projetofinalpoo.model.Contato;
import br.edu.fatecmm.projetofinalpoo.model.Fornecedor;
import br.edu.fatecmm.projetofinalpoo.model.Produto;

import java.io.*;
import java.util.ArrayList;

public class ProdutoDAO {
    private BufferedWriter bw;
    private BufferedReader br;
    private String file = "Produto.csv";
    private String fileFor = "Fornecedor.csv";
    private boolean apnd = true;
    private String[] dados;

    private Produto p;
    private Fornecedor f;
    private Contato c;

    public boolean cadastrar(Produto p, String fornecedor){
        try{
            bw = new BufferedWriter(new FileWriter(file, apnd));
            bw.write(p.retInfo(fornecedor));
            bw.close();
            return true;
        }catch (IOException e){
            System.out.println("Erro cadastrar " + e);
        }
        return false;
    }

    public ArrayList<Produto> readProdutos(){
        ArrayList<Produto> listProd = new ArrayList();
        try {
            br = new BufferedReader(new FileReader(file));
            String linha = br.readLine();
            while (linha != null) {
                dados = linha.split(";");
                p = new Produto();
                f = new Fornecedor();
                c = new Contato();

                p.setCodProd(Integer.parseInt(dados[0]));
                p.setDescricao(dados[1]);
                p.setPreco(Double.parseDouble(dados[2]));
                p.setQntEsto(Integer.parseInt(dados[3]));

                f.setCodForn(Integer.parseInt(dados[5]));
                f.setRazaoSocial(dados[6]);
                f.setEndereco(dados[9]);
                f.setCidade(dados[10]);
                f.setEstado(dados[11]);

                c.setNome(dados[7]);
                c.setTelefone(dados[8]);
                c.setEmail(dados[12]);

                f.setContato(c);
                p.setFornecedor(f);
                listProd.add(p);

                linha = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Erro readProdutos " + e);
        }
        return listProd;
    }

    public ArrayList<Fornecedor> readFornecedores(String nomeFornecedor){
        ArrayList<Fornecedor> listFor = new ArrayList();
        try {
            br = new BufferedReader(new FileReader(fileFor));
            String linha = br.readLine();
            while (linha != null) {
                dados = linha.split(";");
                p = new Produto();
                f = new Fornecedor();
                c = new Contato();
                if(dados[2].equalsIgnoreCase(nomeFornecedor)){
                    f.setCodForn(Integer.parseInt(dados[0]));
                    f.setRazaoSocial(dados[1]);
                    c.setNome(dados[2]);
                    c.setTelefone(dados[3]);
                    c.setEmail(dados[7]);
                    f.setContato(c);
                    f.setEndereco(dados[4]);
                    f.setCidade(dados[5]);
                    f.setEstado(dados[6]);
                    listFor.add(f);
                }
                linha = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Erro readFornecedores " + e);
        }
        return listFor;
    }
}
