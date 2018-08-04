public class Tabuleiro {

    public String[][] matriz;


    public Tabuleiro() {

        int count = 1;
        matriz  = new String[3][3];
        for(int linha=0 ; linha < 3 ; linha++){
            for(int coluna = 0; coluna < 3 ; coluna ++){
                matriz[linha][coluna]= Integer.toString(count);
                count = count + 1;
            }
        }
    }

    public String mostraTabuleiro(){
        String mostraTabuleiro = "";

        for (int i = 0; i< 3; i++){
            for (int j = 0; j < 3; j++){
                mostraTabuleiro += matriz[i][j];
            }
        }
        //imprimeTabuleiro();
        return mostraTabuleiro;
    }

    public void atualizarTabuleiro(String situacao){
        int cont = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j <3; j++){
                if(String.valueOf(situacao.charAt(cont)).equals("-")) {
                    matriz[i][j] = "-1";
                    cont = cont+2;
                } else {
                    matriz[i][j] = String.valueOf(situacao.charAt(cont));
                    cont++;
                }
            }
        }

    }


    public int verificaLinhas(){

        for (int linha = 0; linha<3; linha++){
            if(Integer.parseInt(matriz[linha][0]) + Integer.parseInt(matriz[linha][1]) + Integer.parseInt(matriz[linha][2]) == -3){
                return -1;
            }
            if (Integer.parseInt(matriz[linha][0]) + Integer.parseInt(matriz[linha][1]) + Integer.parseInt(matriz[linha][2]) == 0){
                return 0;
            }
        }
        return 10;
    }

    public int verificaColuna(){
        for (int coluna = 0; coluna<3; coluna++){
            if (Integer.parseInt(matriz[0][coluna]) + Integer.parseInt(matriz[1][coluna]) + Integer.parseInt(matriz[2][coluna]) == -3){
                return -1;
            }
            if (Integer.parseInt(matriz[0][coluna]) + Integer.parseInt(matriz[1][coluna]) + Integer.parseInt(matriz[2][coluna]) == 0 ){
                return 0;
            }

        }
        return 10;
    }
    public int verificaDiagonal(){
        if(Integer.parseInt(matriz[0][0]) + Integer.parseInt(matriz[1][1]) + Integer.parseInt(matriz[2][2]) == -3){
            return -1;
        }
        if (Integer.parseInt(matriz[2][0]) + Integer.parseInt(matriz[1][1]) + Integer.parseInt(matriz[0][2]) == -3){
            return -1;
        }
        if(Integer.parseInt(matriz[0][0]) + Integer.parseInt(matriz[1][1]) + Integer.parseInt(matriz[2][2]) == 0){
            return 0;
        }
        if (Integer.parseInt(matriz[2][0]) + Integer.parseInt(matriz[1][1]) + Integer.parseInt(matriz[0][2]) == 0){
            return 0;
        }
        return 10;
    }

    public void imprimeTabuleiro() {

        for (int linha = 0; linha<3; linha++){
            for (int coluna = 0; coluna<3; coluna++) {
                if (Integer.parseInt(matriz[linha][coluna]) == -1){
                    System.out.print(" X ");
                }
                else if (Integer.parseInt(matriz[linha][coluna]) == 0){
                    System.out.print(" O ");
                }
                else{
                    System.out.print(" "+ matriz[linha][coluna] +" ");
                }
                if(coluna == 0 || coluna == 1){
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
}
