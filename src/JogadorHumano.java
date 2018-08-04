public class JogadorHumano extends Jogador {

    private String nomeJogador;
    private int vitorias;

    // construtor

    public JogadorHumano(){

        vitorias = 0;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public int getVitorias(){
        return vitorias;
    }

    @Override
    public void adicionaVitoria() {
        this.vitorias = this.vitorias +1;

    }



    public void jogar ( Tabuleiro tabuleiro, int sinal, int posicao){

        if (posicao == 1 ){
            tabuleiro.matriz[0][0] = Integer.toString(sinal);
        }
        else if (posicao == 2){
            tabuleiro.matriz[0][1] = Integer.toString(sinal);
        }
        else if (posicao == 3){
            tabuleiro.matriz[0][2] = Integer.toString(sinal);
        }
        else if (posicao == 4){
            tabuleiro.matriz[1][0] = Integer.toString(sinal);
        }
        else if (posicao == 5){
            tabuleiro.matriz[1][1] = Integer.toString(sinal);
        }
        else if (posicao == 6){
            tabuleiro.matriz[1][2] = Integer.toString(sinal);
        }
        else if (posicao == 7){
            tabuleiro.matriz[2][0] = Integer.toString(sinal);
        }
        else if (posicao == 8){
            tabuleiro.matriz[2][1] = Integer.toString(sinal);
        }
        else if (posicao == 9){
            tabuleiro.matriz[2][2] = Integer.toString(sinal);
        }

    }

}

