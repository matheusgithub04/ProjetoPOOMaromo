package br.edu.fatecmm.projetofinalpoo.view;

import br.edu.fatecmm.projetofinalpoo.control.FornecedorDAO;
import br.edu.fatecmm.projetofinalpoo.control.ProdutoDAO;
import br.edu.fatecmm.projetofinalpoo.model.Contato;
import br.edu.fatecmm.projetofinalpoo.model.Fornecedor;
import br.edu.fatecmm.projetofinalpoo.model.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaProduto extends JFrame {
    private JPanel panel;

    private JTextField tfCodProd;
    private JTextField tfPreco;
    private JTextField tfQtd;
    private JTextField tfDescricao;

    private JLabel lbCodProd;
    private JLabel lbFornecedor;
    private JLabel lbPreco;
    private JLabel lbQtd;
    private JLabel lbDescricao;

    private JButton btAdicionar;
    private JButton btVoltar;

    private JComboBox jcFornecedor;

    private ProdutoDAO pdao = new ProdutoDAO();
    private FornecedorDAO fdao = new FornecedorDAO();

    public TelaProduto() {
        setTitle("Cadastrar Produto");
        setBounds(190, 30, 1000, 370);
        panel = new JPanel();
        panel.setBackground(Color.white);
        setContentPane(panel);
        getContentPane().setLayout(null);

        lbCodProd = new JLabel("Código");
        lbCodProd.setBounds(59, 40, 80, 30);
        panel.add(lbCodProd);

        tfCodProd = new JTextField();
        tfCodProd.setBounds(59, 70, 138, 30);
        panel.add(tfCodProd);

        lbFornecedor = new JLabel("Fornecedor");
        lbFornecedor.setBounds(220, 40, 80, 30);
        panel.add(lbFornecedor);

        jcFornecedor = new JComboBox();
        jcFornecedor.setBounds(220, 70, 723, 30);
        ArrayList<String> listFor = fdao.readFornecedores();
        for(String fornecedores: listFor){
            jcFornecedor.addItem(fornecedores);
        }
        panel.add(jcFornecedor);

        lbPreco = new JLabel("Preço");
        lbPreco.setBounds(59, 110, 40, 30);
        panel.add(lbPreco);

        tfPreco = new JTextField();
        tfPreco.setBounds(59, 140, 643, 30);
        panel.add(tfPreco);

        lbQtd = new JLabel("Quantidade");
        lbQtd.setBounds(725, 110, 80, 30);
        panel.add(lbQtd);

        tfQtd = new JTextField();
        tfQtd.setBounds(725, 140, 218, 30);
        panel.add(tfQtd);

        lbDescricao = new JLabel("Descrição");
        lbDescricao.setBounds(59, 175, 80, 30);
        panel.add(lbDescricao);

        tfDescricao = new JTextField();
        tfDescricao.setBounds(59, 205, 884, 30);
        panel.add(tfDescricao);

        btVoltar = new JButton("VOLTAR");
        btVoltar.setBounds(59, 245, 150, 30);
        btVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                TelaIniciar ti = new TelaIniciar();
                ti.setVisible(true);
            }
        });
        panel.add(btVoltar);

        btAdicionar = new JButton("ADICIONAR");
        btAdicionar.setBounds(793, 245, 150, 30);
        btAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contato c = new Contato();
                Fornecedor f = new Fornecedor();
                String fornecedor = jcFornecedor.getSelectedItem().toString();
                c.setNome(jcFornecedor.getSelectedItem().toString());
                f.setContato(c);
                Produto p = new Produto(Integer.parseInt(tfCodProd.getText()), tfDescricao.getText(), Double.parseDouble(tfPreco.getText()), Integer.parseInt(tfQtd.getText()), f);
                pdao.cadastrar(p, fornecedor);
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "CADASTRO", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                TelaIniciar ti = new TelaIniciar();
                ti.setVisible(true);
            }
        });
        panel.add(btAdicionar);
    }
}
