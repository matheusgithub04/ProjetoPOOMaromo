package br.edu.fatecmm.projetofinalpoo.view;

import br.edu.fatecmm.projetofinalpoo.control.FornecedorDAO;
import br.edu.fatecmm.projetofinalpoo.model.Contato;
import br.edu.fatecmm.projetofinalpoo.model.Fornecedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaFornecedor extends JFrame {
    private JPanel panel;

    private JTextField tfCodFor;
    private JTextField tfRazaoSocial;
    private JTextField tfNome;
    private JTextField tfTelefone;
    private JTextField tfEndereco;
    private JTextField tfCidade;
    private JTextField tfEmail;

    private JLabel lbCodFor;
    private JLabel lbRazaoSocial;
    private JLabel lbNome;
    private JLabel lbTelefone;
    private JLabel lbEndereco;
    private JLabel lbCidade;
    private JLabel lbEstado;
    private JLabel lbEmail;

    private JButton btCadastrar;
    private JButton btVoltar;

    private JComboBox jcEstado;

    private FornecedorDAO fdao = new FornecedorDAO();

    public TelaFornecedor(){
        setTitle("Cadastrar Fornecedor");
        setBounds(190, 30, 1000, 500);
        panel = new JPanel();
        panel.setBackground(Color.white);
        setContentPane(panel);
        getContentPane().setLayout(null);

        lbCodFor = new JLabel("Código");
        lbCodFor.setBounds(59, 40, 80, 30);
        panel.add(lbCodFor);

        tfCodFor = new JTextField();
        tfCodFor.setBounds(59, 70, 138, 30);
        panel.add(tfCodFor);

        lbRazaoSocial = new JLabel("Razão social");
        lbRazaoSocial.setBounds(220, 40, 80, 30);
        panel.add(lbRazaoSocial);

        tfRazaoSocial = new JTextField();
        tfRazaoSocial.setBounds(220, 70, 723, 30);
        panel.add(tfRazaoSocial);

        lbNome = new JLabel("Nome");
        lbNome.setBounds(59, 110, 40, 30);
        panel.add(lbNome);

        tfNome = new JTextField();
        tfNome.setBounds(59, 140, 643, 30);
        panel.add(tfNome);

        lbTelefone = new JLabel("Telefone");
        lbTelefone.setBounds(725, 110, 80, 30);
        panel.add(lbTelefone);

        tfTelefone = new JTextField();
        tfTelefone.setBounds(725, 140, 218, 30);
        panel.add(tfTelefone);

        lbEndereco = new JLabel("Endereço");
        lbEndereco.setBounds(59, 175, 80, 30);
        panel.add(lbEndereco);

        tfEndereco = new JTextField();
        tfEndereco.setBounds(59, 205, 884, 30);
        panel.add(tfEndereco);

        lbCidade = new JLabel("Cidade");
        lbCidade.setBounds(59, 235, 80, 30);
        panel.add(lbCidade);

        tfCidade = new JTextField();
        tfCidade.setBounds(59, 265, 606, 30);
        panel.add(tfCidade);

        lbEstado = new JLabel("Estado");
        lbEstado.setBounds(728, 235, 80, 30);
        panel.add(lbEstado);

        String[] estadoSigla = {"AC", "SP", "RJ"};
        jcEstado = new JComboBox(estadoSigla);
        jcEstado.setBounds(728, 265, 215, 30);
        panel.add(jcEstado);

        lbEmail = new JLabel("Email");
        lbEmail.setBounds(59, 300, 80, 30);
        panel.add(lbEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(59, 330, 884, 30);
        panel.add(tfEmail);

        btVoltar = new JButton("VOLTAR");
        btVoltar.setBounds(59, 370, 150, 30);
        btVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                TelaIniciar ti = new TelaIniciar();
                ti.setVisible(true);
            }
        });
        panel.add(btVoltar);

        btCadastrar = new JButton("CADASTRAR");
        btCadastrar.setBounds(793, 370, 150, 30);
        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contato c = new Contato(tfNome.getText(), tfTelefone.getText(), tfEmail.getText());
                Fornecedor f = new Fornecedor(Integer.parseInt(tfCodFor.getText()), tfRazaoSocial.getText(), tfEndereco.getText(), tfCidade.getText(), String.valueOf(jcEstado.getSelectedItem()), c);
                fdao.cadastrar(f);
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "CADASTRO", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                TelaIniciar ti = new TelaIniciar();
                ti.setVisible(true);
            }
        });
        panel.add(btCadastrar);
    }
}
