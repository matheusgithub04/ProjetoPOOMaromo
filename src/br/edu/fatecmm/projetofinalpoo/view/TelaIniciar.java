package br.edu.fatecmm.projetofinalpoo.view;

import br.edu.fatecmm.projetofinalpoo.control.ProdutoDAO;
import br.edu.fatecmm.projetofinalpoo.model.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaIniciar extends JFrame {
    private JPanel panel;

    private JButton btCadFor;
    private JButton btCadProd;

    public TelaIniciar(){
        setTitle("TELA INICIAL");
        setBounds(400, 200, 510, 200);
        panel = new JPanel();
        panel.setBackground(Color.white);
        setContentPane(panel);
        getContentPane().setLayout(null);

        btCadFor = new JButton("CADASTRAR FORNECEDOR");
        btCadFor.setBounds(50, 50, 200, 30);
        btCadFor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                TelaFornecedor tf = new TelaFornecedor();
                tf.setVisible(true);
            }
        });
        panel.add(btCadFor);

        btCadProd = new JButton("CADASTRAR PRODUTO");
        btCadProd.setBounds(260, 50, 200, 30);
        btCadProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                TelaProduto tp = new TelaProduto();
                tp.setVisible(true);
            }
        });
        panel.add(btCadProd);

        JButton bt = new JButton("COMPRAR");
        bt.setBounds(150, 90, 200, 30);
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                TelaAddCarrinho tac = new TelaAddCarrinho();
                tac.setVisible(true);
            }
        });
        panel.add(bt);

    }
}
