package fonte;

import java.io.File;
import java.util.Scanner;
import java.util.*;

public class Lecteur {
    protected String linhas[];
    public int qntdLinhas = 0;


    /**
     * Adiciona um novo elemento na array.
     * 
     * @param original -> array onde será adicionado um novo elemento.
     * @param novo -> novo elemento que será adicionado.
     * @param tamanho -> tamanho do array original.
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
     * @param arquivo -> nome do arquivo que será lido.
     */
    public void leTudo(String arquivo) {

        try {
            this.linhas = new String[0];
            File file = new File(arquivo);
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                this.linhas = novaArray(this.linhas, line, this.linhas.length);
                qntdLinhas++;
            }
            input.close();

        } catch (Exception e) {

            System.out.println("Nao foi possivel abrir o arquivo " + arquivo);
            System.out.println("Ele existe mesmo?");
    
            e.printStackTrace();

        }
        ImprimeLinhas();
    }
    
}
