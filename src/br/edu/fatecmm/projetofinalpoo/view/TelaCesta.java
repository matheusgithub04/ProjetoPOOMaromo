package br.edu.fatecmm.projetofinalpoo.view;

import br.edu.fatecmm.projetofinalpoo.model.Cesta;
import br.edu.fatecmm.projetofinalpoo.model.Contato;
import br.edu.fatecmm.projetofinalpoo.model.Fornecedor;
import br.edu.fatecmm.projetofinalpoo.model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaCesta extends JFrame {
    private JPanel panel;

    private JButton btVoltar;
    private JButton btFinalizar;

    private JScrollPane jsp;
    private JTable jt;
    private DefaultTableModel dtm;
    private JFrame al;

    public TelaCesta(){}

    public TelaCesta(ArrayList<Produto> prod, JFrame j){
        this.al = j;
        setTitle("CARRINHO");
        setBounds(400, 100, 500, 500);
        panel = new JPanel();
        panel.setBackground(Color.white);
        getContentPane().setLayout(null);
        setContentPane(panel);

        dtm = new DefaultTableModel();
        dtm.addColumn("Descrição");
        dtm.addColumn("Fornecedor");
        dtm.addColumn("Valor");
        dtm.addColumn("Fornecedor");

        jt = new JTable(dtm);

        for(Produto p : prod){
            Object[] v = {p.getDescricao(), p.getFornecedor().getContato().getNome(), p.getPreco(), p.getFornecedor().getContato().getNome()};
            dtm.addRow(v);
        }

        jsp = new JScrollPane(jt);
        jsp.setBounds(40, 110, 480, 400);
        panel.add(jsp);

        btVoltar = new JButton("VOLTAR");
        btVoltar.setBounds(0, 0, 50, 30);
        btVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                al.setVisible(true);
            }
        });
        panel.add(btVoltar);

        btFinalizar = new JButton("FINALIZAR");
        btFinalizar.setBounds(0,0,50, 50);
        btFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cesta c = new Cesta();
                switch(JOptionPane.showConfirmDialog(null, "Deseja finalizar a compra? Total de "+c.calcularTotal(prod)+".")){
                    case 0:
                        dispose();
                        al.dispose();
                        JOptionPane.showMessageDialog(null, "OBRIGADO!");
                        TelaIniciar ti = new TelaIniciar();
                        ti.setVisible(true);
                        break;
                }
            }
        });
        panel.add(btFinalizar);


    }
}
