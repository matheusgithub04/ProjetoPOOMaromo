package br.edu.fatecmm.projetofinalpoo.control;

import br.edu.fatecmm.projetofinalpoo.model.Fornecedor;

import java.io.*;
import java.util.ArrayList;

public class FornecedorDAO {
    private BufferedWriter bw;
    private BufferedReader br;
    private String file = "Fornecedor.csv";
    private boolean apnd = true;
    private String[] dados;

    public boolean cadastrar(Fornecedor f){
        try{
            bw = new BufferedWriter(new FileWriter(file, apnd));
            bw.write(f.retInfo());
            bw.close();
            return true;
        }catch (IOException e){
            System.out.println("Erro cadastrar " + e);
        }
        return false;
    }

    public ArrayList<String> readFornecedores(){
        ArrayList<String> listFor = new ArrayList();
        try {
            br = new BufferedReader(new FileReader(file));
            String linha = br.readLine();
            while (linha != null) {
                dados = linha.split(";");
                listFor.add(dados[2]);
                linha = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Erro readFornecedores " + e);
        }
        return listFor;
    }
}
