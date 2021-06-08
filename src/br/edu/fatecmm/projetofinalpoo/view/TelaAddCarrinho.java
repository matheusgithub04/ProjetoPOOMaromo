package br.edu.fatecmm.projetofinalpoo.view;

import br.edu.fatecmm.projetofinalpoo.control.ProdutoDAO;
import br.edu.fatecmm.projetofinalpoo.model.Cesta;
import br.edu.fatecmm.projetofinalpoo.model.Contato;
import br.edu.fatecmm.projetofinalpoo.model.Fornecedor;
import br.edu.fatecmm.projetofinalpoo.model.Produto;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaAddCarrinho extends JFrame {
    private JPanel panel;

    private JLabel lbDescricao;
    private JLabel lbPreco;
    private JLabel lbFornecedor;

    private JButton btAdd;
    private JButton btCarrinho;
    private JButton btVoltar;

    private JScrollPane jsp;

    private JTable jt;
    private DefaultTableModel dtm;

    private ProdutoDAO pdao = new ProdutoDAO();
    private ArrayList<Produto> listProd = pdao.readProdutos();
    private Cesta cesta = new Cesta();
    private Produto p;
    private Fornecedor f;
    private Contato c;
    private int v;
    private JFrame j;

    public TelaAddCarrinho(){
        this.j = this;
        setTitle("PRODUTOS");
        setBounds(400, 100, 500, 500);
        panel = new JPanel();
        panel.setBackground(Color.white);
        getContentPane().setLayout(null);
        setContentPane(panel);

        dtm = new DefaultTableModel();
        dtm.addColumn("Descrição");
        dtm.addColumn("Fornecedor");
        dtm.addColumn("Valor");

        jt = new JTable(dtm);
        for(Produto p : listProd){
            Object[] v = {p.getDescricao(), p.getFornecedor().getContato().getNome(), p.getPreco()};
            dtm.addRow(v);
        }

        jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                v = jt.getSelectedRow();
                switch(JOptionPane.showConfirmDialog(null, "Deseja confirmar compra de "+listProd.get(v).getDescricao()+"?")){
                    case 0:
                        p = new Produto();
                        f = new Fornecedor();
                        c = new Contato();

                        p.setCodProd(listProd.get(v).getCodProd());
                        p.setDescricao(listProd.get(v).getDescricao());
                        p.setPreco(listProd.get(v).getPreco());
                        p.setQntEsto(listProd.get(v).getQntEsto());

                        f.setCodForn(listProd.get(v).getFornecedor().getCodForn());
                        f.setRazaoSocial(listProd.get(v).getFornecedor().getRazaoSocial());
                        f.setEndereco(listProd.get(v).getFornecedor().getEndereco());
                        f.setCidade(listProd.get(v).getFornecedor().getCidade());
                        f.setEstado(listProd.get(v).getFornecedor().getEstado());

                        c.setNome(listProd.get(v).getFornecedor().getContato().getNome());
                        c.setTelefone(listProd.get(v).getFornecedor().getContato().getTelefone());
                        c.setEmail(listProd.get(v).getFornecedor().getContato().getEmail());

                        f.setContato(c);
                        p.setFornecedor(f);
                        cesta.adicionarItem(p);
                        break;
                }
            }
        });

        jsp = new JScrollPane(jt);
        jsp.setBounds(40, 110, 480, 400);
        panel.add(jsp);

        btVoltar = new JButton("VOLTAR");
        btVoltar.setBounds(0, 0, 50, 30);
        btVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                TelaIniciar ti = new TelaIniciar();
                ti.setVisible(true);
            }
        });
        panel.add(btVoltar);

        btCarrinho = new JButton("CARRINHO");
        btCarrinho.setBounds(0,0,50, 50);
        btCarrinho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.setVisible(false);
                cesta.exibirLista();
                TelaCesta tc = new TelaCesta(cesta.getPro(), j);
                tc.setVisible(true);
            }
        });

        panel.add(btCarrinho);
    }
}
