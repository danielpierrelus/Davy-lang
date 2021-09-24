package fonte;

import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class Lecteur {
    protected String linhas[];


    /**
     * Adiciona um novo elemento na array.
     * 
     * @param novo valor que será adicionado no array novo.
     */

    public static String[] novaArray(String[] original, String novo, int tamanho){
        String[] NArray = Arrays.copyOf(original, tamanho+1);
        NArray[NArray.length-1] = novo;
        return NArray;
    }



    /**
     * Imprime todas as linhas;
     * 
     */
    public void ImprimeLinhas() {
        for (int i = 0; i < this.linhas.length; i++) {
            System.out.println("Linha " + i + ": " + this.linhas[i]);
        }
    }



    /**
     * Faz a leitura do arquivo com o código.
     * 
     * @param arquivo: Nome do arquivo que será lido e depois passado para o vetor.
     */
    public void LeTudo(String arquivo) {

        try {
            this.linhas = new String[0];
            File file = new File(arquivo);
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                this.linhas = novaArray(this.linhas, line, this.linhas.length);
            }

        input.close();

        } catch (Exception e) {

            System.out.println("Nao foi possivel abrir o arquivo " + arquivo);
            System.out.println("Ele existe mesmo?");
    
            e.printStackTrace();

        }
    }
    
}
