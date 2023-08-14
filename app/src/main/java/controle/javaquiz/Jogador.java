package controle.javaquiz;

public class Jogador {
    private String nome;
    private String senha;
    private int pontuacao;

    public int getPontuacao() {
        return pontuacao;// esse cometario é maneiro
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getName() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
