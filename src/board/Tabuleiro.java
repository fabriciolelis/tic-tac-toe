package board;

public class Tabuleiro {

    public String[][] matriz;


    public Tabuleiro() {

        int count = 1;
        matriz = new String[3][3];
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                matriz[linha][coluna] = Integer.toString(count);
                count = count + 1;
            }
        }
    }

    public String mostraTabuleiro() {
        StringBuilder mostraTabuleiro = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mostraTabuleiro.append(matriz[i][j]);
            }
        }
        return mostraTabuleiro.toString();
    }

    public void atualizarTabuleiro(String situacao) {
        int cont = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (String.valueOf(situacao.charAt(cont)).equals("-")) {
                    matriz[i][j] = "-1";
                    cont = cont + 2;
                } else {
                    matriz[i][j] = String.valueOf(situacao.charAt(cont));
                    cont++;
                }
            }
        }
    }

    public int verificaLinhas() {
        for (int linha = 0; linha < 3; linha++) {
            if ((matriz[linha][0] + matriz[linha][1] + matriz[linha][2]).equals("XXX")) {
                return -1;
            }
            if ((matriz[linha][0] + matriz[linha][1] + matriz[linha][2]).equals("OOO")) {
                return 0;
            }
        }
        return 10;
    }

    public int verificaColuna() {
        for (int coluna = 0; coluna < 3; coluna++) {
            if ((matriz[0][coluna] + matriz[1][coluna] + matriz[2][coluna]).equals("XXX")) {
                return -1;
            }
            if ((matriz[0][coluna] + matriz[1][coluna] + matriz[2][coluna]).equals("OOO")){
                return 0;
            }
        }
        return 10;
    }

    public int verificaDiagonal() {
        if ((matriz[0][0] + matriz[1][1] + matriz[2][2]).equals("XXX")) {
            return -1;
        }
        if ((matriz[2][0] + matriz[1][1] + matriz[0][2]).equals("XXX")) {
            return -1;
        }
        if((matriz[0][0] + matriz[1][1] + matriz[2][2]).equals("OOO")) {
            return 0;
        }
        if((matriz[2][0] + matriz[1][1] + matriz[0][2]).equals("OOO")) {
            return 0;
        }
        return 10;
    }

    public void imprimeTabuleiro() {

        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print(" " + matriz[linha][coluna] + " ");
                if (coluna == 0 || coluna == 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
}
