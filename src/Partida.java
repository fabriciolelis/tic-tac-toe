public abstract class  Partida {

    private boolean verificaPosicaoValida(int valor) {
        if (!(valor == -1) && !(valor == 0)) {
            return true;
        } else {
            System.out.println("posição invalida");
            return false;
        }
    }

    boolean possoJogar(Tabuleiro tabuleiro, int posicao) {
        if (posicao == 1) {
            return verificaPosicaoValida(Integer.parseInt(tabuleiro.matriz[0][0]));
        } else if (posicao == 2) {
            return verificaPosicaoValida(Integer.parseInt(tabuleiro.matriz[0][1]));
        } else if (posicao == 3) {
            return verificaPosicaoValida(Integer.parseInt(tabuleiro.matriz[0][2]));
        } else if (posicao == 4) {
            return verificaPosicaoValida(Integer.parseInt(tabuleiro.matriz[1][0]));
        } else if (posicao == 5) {
            return verificaPosicaoValida(Integer.parseInt(tabuleiro.matriz[1][1]));
        } else if (posicao == 6) {
            return verificaPosicaoValida(Integer.parseInt(tabuleiro.matriz[1][2]));
        } else if (posicao == 7) {
            return verificaPosicaoValida(Integer.parseInt(tabuleiro.matriz[2][0]));
        } else if (posicao == 8) {
            return verificaPosicaoValida(Integer.parseInt(tabuleiro.matriz[2][1]));
        } else if(posicao == 9) {
            return verificaPosicaoValida(Integer.parseInt(tabuleiro.matriz[2][2]));
        }
        return false;
    }

    int ganhou(Tabuleiro tabuleiro){
        if (tabuleiro.verificaLinhas() == -1 || tabuleiro.verificaColuna() == -1 || tabuleiro.verificaDiagonal() == -1  ){
            return -1;
        }
        if (tabuleiro.verificaLinhas() == 0 || tabuleiro.verificaColuna() == 0 || tabuleiro.verificaDiagonal() == 0 ){
            return 0;
        }

        return 10;
    }

    void verificaVencedor(Tabuleiro tabuleiro) {
        if (ganhou(tabuleiro) == -1) {
            System.out.println("Cliente ganhou!!!");
        } else if (ganhou(tabuleiro) == 0) {
            System.out.println("Servidor ganhou!!!");
        } else {
            System.out.println("Deu velha!!!");
        }
    }

    boolean terminou(Tabuleiro tabuleiro){
        return ganhou(tabuleiro) != 10;
    }

    protected abstract  void imprimePlacar();

    public abstract void iniciar() throws Exception;

}
