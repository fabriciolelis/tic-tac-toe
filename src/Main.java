import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner entrada = new Scanner(System.in);
        Partida partida;

        System.out.println("1 - Local Match");
        System.out.println("2 - Network Match - Server");
        System.out.println("3 - Network Match -  Client");
        System.out.println("Choose a match kind: ");
        int option = entrada.nextInt();
        switch (option) {
            case 1:
                partida = new PartidaLocal();
                partida.iniciar();
                break;
            case 2:
//                partida = new PartidaServidor();
//                partida.iniciar();
                break;
            case 3:
//                partida = new PartidaCliente();
//                partida.iniciar();
                break;
        }
    }
}
