package fonte;

import java.io.File;
import java.util.Scanner;

public class Davy1 {

    public static void main (String[] args){

        if (args.length==0){

            System.out.println("Não foi passado parâmetro");
            return;
        }

        String StringArquivo = args[0]; 

    
        String vetLinha[] =  new String[2000];

        int contLinha=0;
        
        try { 
            File file = new File(StringArquivo); 
            Scanner entrada = new Scanner(file);
            
            while(entrada.hasNextLine()){ 

                vetLinha[contLinha]= entrada.nextLine();
                contLinha++;
            }

            entrada.close();
            
        } catch (Exception erro){

            System.out.println("Não foi possível abrir o arquivo");

        }
        Processamento Davy = new Processamento(vetLinha, contLinha);

        Davy.processa();
    }
}
