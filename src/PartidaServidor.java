import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class PartidaServidor extends Partida {

    private Scanner entrada = new Scanner(System.in);
    private int vez = 0;
    private Jogador jogador;


    PartidaServidor() {

    }

    @Override
    protected void imprimePlacar() {


    }

    @Override
    public void iniciar() throws Exception {

        int porta = 1234;
        String tabuleiroAtual;

        ServerSocket servidor = new ServerSocket(porta);

        jogador = new JogadorHumano();
        System.out.print("digite o nome do primeiro jogador: ");
        String nomeJogador1 = entrada.next();
        jogador.setNomeJogador(nomeJogador1);


        System.out.println("Esperando cliente...");
        Socket conexao = servidor.accept();
        System.out.println("Cliente Conectado...");

        BufferedReader entradaCliente =
                new BufferedReader(new InputStreamReader(conexao.getInputStream()));

        DataOutputStream saidaCliente = new DataOutputStream(conexao.getOutputStream());

        Tabuleiro tabuleiro = new Tabuleiro();

        while (true) {

            tabuleiro.imprimeTabuleiro();

            System.out.println("escolha uma posição no tabuleiro");
            int posicao = entrada.nextInt();

            while (!possoJogar(tabuleiro, posicao)) {
                tabuleiro.imprimeTabuleiro();
                System.out.println("escolha outra posição no tabuleiro");
                posicao = entrada.nextInt();
            }
            jogador.jogar(tabuleiro, 0, posicao);

            tabuleiro.imprimeTabuleiro();

            tabuleiroAtual = tabuleiro.mostraTabuleiro();
            saidaCliente.writeBytes(tabuleiroAtual + "\n");
            vez++;

            if (terminou(tabuleiro) || vez == 5) {
                break;
            }

            System.out.println("Esperando jogada do cliente\n");

            tabuleiroAtual = entradaCliente.readLine();
            tabuleiro.atualizarTabuleiro(tabuleiroAtual);

            if (terminou(tabuleiro)) {
                break;
            }
        }
        verificaVencedor(tabuleiro);
    }
}
