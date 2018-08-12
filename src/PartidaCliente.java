import board.Tabuleiro;
import players.Jogador;
import players.JogadorHumano;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class PartidaCliente extends Partida {

    private Scanner entrada = new Scanner(System.in);
    private int vez = 0;
    private Jogador jogador;


    @Override
    protected void imprimePlacar() {

    }

    @Override
    public void iniciar() throws Exception {

        String host = "127.0.0.1";
        int porta = 1234;
        String tabuleiroAtual;

        jogador = new JogadorHumano();
        System.out.print("digite o nome do primeiro jogador: ");
        String nomeJogador1 = entrada.next();
        jogador.setNomeJogador(nomeJogador1);

        System.out.println("Rodando...");
        System.out.println("Conectando com servidor...");

        Socket socketCliente = new Socket(host, porta);
        System.out.println("Conectado...");

        System.out.println("Começando...");

        BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
        DataOutputStream saidaServidor = new DataOutputStream(socketCliente.getOutputStream());

        Tabuleiro tabuleiro = new Tabuleiro();

        while (true) {
            tabuleiroAtual = entradaServidor.readLine();
            tabuleiro.atualizarTabuleiro(tabuleiroAtual);
            tabuleiro.imprimeTabuleiro();
            vez++;

            if (terminou(tabuleiro) || vez > 4) {
                break;
            }

            System.out.println("escolha uma posição no tabuleiro");
            int posicao = entrada.nextInt();

            while (!possoJogar(tabuleiro, posicao)) {
                tabuleiro.imprimeTabuleiro();
                System.out.println("escolha outra posição no tabuleiro");
                posicao = entrada.nextInt();
            }
            jogador.jogar(tabuleiro, "X", posicao);

            tabuleiro.imprimeTabuleiro();

            tabuleiroAtual = tabuleiro.mostraTabuleiro();

            saidaServidor.writeBytes(tabuleiroAtual + "\n");

            if (terminou(tabuleiro)) {
                break;
            }
            System.out.println("Esperando jogada do servidor");
        }
        verificaVencedor(tabuleiro);
    }
}

