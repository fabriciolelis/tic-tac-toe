public abstract class  Jogador {

    public abstract void setNomeJogador(String nomeJogador);

    public abstract String getNomeJogador();

    public abstract void adicionaVitoria();

    public abstract int getVitorias();

    public abstract void jogar(Tabuleiro tabuleiro, int sinal, int posicao);

}

