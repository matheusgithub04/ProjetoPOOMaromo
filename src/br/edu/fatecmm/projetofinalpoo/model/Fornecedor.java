package br.edu.fatecmm.projetofinalpoo.model;

public class Fornecedor {
    private int codForn;
    private String razaoSocial;
    private String endereco;
    private String cidade;
    private String estado;
    private Contato contato;

    public int getCodForn() {
        return codForn;
    }

    public void setCodForn(int codForn) {
        this.codForn = codForn;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Fornecedor(int codForn, String razaoSocial, String endereco, String cidade, String estado, Contato contato) {
        this.codForn = codForn;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.contato = contato;
    }

    public Fornecedor(int codForn, String razaoSocial, String endereco, Contato contato) {
        this.codForn = codForn;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        cidade = "Mogi Mirim";
        estado = "SP";
        this.contato = contato;
    }

    public Fornecedor(){

    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "codForn=" + codForn +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", contato=" + contato +
                '}';
    }

    public String retInfo(){
        String linha = "";
        linha = this.codForn + ";" + this.razaoSocial + ";" + contato.getNome() + ";" + contato.getTelefone()+ ";" + this.endereco + ";" + this.cidade + ";" + this.estado + ";" + contato.getEmail() + "\n";
        return linha;
    }
}
