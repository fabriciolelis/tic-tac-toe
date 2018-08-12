import board.Tabuleiro;
import players.Jogador;
import players.JogadorHumano;

import java.util.Scanner;

public class PartidaLocal extends Partida{

    private Scanner entrada = new Scanner(System.in);

    private Jogador jogador1;

    private Jogador jogador2;

    private int vez = 1;


    public PartidaLocal(){

    }

    protected void imprimePlacar(){
        System.out.println(jogador1.getNomeJogador()+" "+jogador1.getVitorias()+" X "+jogador2.getVitorias()+" "+jogador2.getNomeJogador());
    }

    public void iniciar(){

        jogador1 = new JogadorHumano();
        System.out.print("Enter the name of the first player: ");
        String nomeJogador1 = entrada.next();
        jogador1.setNomeJogador(nomeJogador1);

        jogador2 = new JogadorHumano();
        System.out.print("Enter the name of the second player: ");
        String nomeJogador2 = entrada.next();
        jogador2.setNomeJogador(nomeJogador2);

        boolean jogarMais = true;

        while(jogarMais) {
            Tabuleiro tabuleiro = new Tabuleiro();
            while(vez < 10 && !terminou(tabuleiro)){
                tabuleiro.imprimeTabuleiro();

                System.out.println("Choose a position on the board");
                int posicao = entrada.nextInt();

                while(!possoJogar(tabuleiro, posicao)){
                    tabuleiro.imprimeTabuleiro();
                    System.out.println("Choose a valid position on the board");
                    posicao = entrada.nextInt();
                }
                if (vez % 2 == 0){
                    jogador2.jogar(tabuleiro, "O", posicao);
                }
                else {
                    jogador1.jogar(tabuleiro, "X", posicao);
                }
                vez++;
            }
            tabuleiro.imprimeTabuleiro();
            if(ganhou(tabuleiro) == -1) {
                System.out.println(jogador1.getNomeJogador()+" has won!!!");
                jogador1.adicionaVitoria();

            }
            else if(ganhou(tabuleiro) == 0) {
                System.out.println(jogador2.getNomeJogador()+" has won!!!");
                jogador2.adicionaVitoria();

            }
            else {
                System.out.println("TIED!!!");
            }

            imprimePlacar();
            System.out.print("Do you wish to continue? (Y/N)");
            String resposta = entrada.next();
            if(resposta.toUpperCase().equals("N")){
                jogarMais = false;
            }
            vez = 1;
        }
    }
}
