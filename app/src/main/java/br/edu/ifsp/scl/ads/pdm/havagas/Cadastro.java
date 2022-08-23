package br.edu.ifsp.scl.ads.pdm.havagas;

public class Cadastro {

    private String nome;
    private String email;
    private Boolean receberEmail;
    private String telefone;
    private String tipoTelefone;
    private String celular;
    private String sexo;
    private String dataNascimento;
    private String formacao;
    private Integer anoConclusao;
    private String instituicao;
    private String tituloMonografia;
    private String orientador;
    private String vagasDeInteresse;

    public Cadastro() {
    }

    public Cadastro(String nome, String email, Boolean receberEmail, String telefone, String tipoTelefone, String celular, String sexo, String dataNascimento, String formacao, Integer anoConclusao, String instituicao, String tituloMonografia, String orientador, String vagasDeInteresse) {
        this.nome = nome;
        this.email = email;
        this.receberEmail = receberEmail;
        this.telefone = telefone;
        this.tipoTelefone = tipoTelefone;
        this.celular = celular;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.formacao = formacao;
        this.anoConclusao = anoConclusao;
        this.instituicao = instituicao;
        this.tituloMonografia = tituloMonografia;
        this.orientador = orientador;
        this.vagasDeInteresse = vagasDeInteresse;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getReceberEmail() {
        return receberEmail;
    }

    public void setReceberEmail(Boolean receberEmail) {
        this.receberEmail = receberEmail;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public Integer getAnoConclusao() {
        return anoConclusao;
    }

    public void setAnoConclusao(Integer anoConclusao) {
        this.anoConclusao = anoConclusao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getTituloMonografia() {
        return tituloMonografia;
    }

    public void setTituloMonografia(String tituloMonografia) {
        this.tituloMonografia = tituloMonografia;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String getVagasDeInteresse() {
        return vagasDeInteresse;
    }

    public void setVagasDeInteresse(String vagasDeInteresse) {
        this.vagasDeInteresse = vagasDeInteresse;
    }

    @Override
    public String toString() {

        StringBuilder cadastro = new StringBuilder();
        cadastro.append( "Nome: " + nome +
                "\nE-mail:" + email +
                "\nReceber e-mail: " + receberEmail +
                "\nTipo de telefone: " + tipoTelefone +
                "\nTelefone: " + telefone);

        if (celular != null) {
            cadastro.append("\nCelular: " + celular);
        }

        cadastro.append("\nSexo: " + sexo +
                "\nData de nascimento: " + dataNascimento +
                "\nFormacao: " + formacao +
                "\nAno de Conclusão: " + anoConclusao);

        if (instituicao != null) {
            cadastro.append("\nInstituição: " + instituicao);
        }

        if (tituloMonografia != null) {
            cadastro.append("\nTítulo da Monografia: " + tituloMonografia);
        }

        if (orientador != null) {
            cadastro.append( "\nOrientador: " + orientador);
        }

        cadastro.append("\nVagas de interesse: " + vagasDeInteresse);

        return cadastro.toString();
    }
}
