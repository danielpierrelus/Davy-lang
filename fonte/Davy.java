package fonte;

import java.io.File;
import java.util.Scanner;

class Davy {
    public static void main(String[] args) {
        Processamento p;
        try {
            File file = new File("teste.txt");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();
        } catch (Exception e) {
            System.out.println("Nao foi possivel abrir o arquivo teste.txt.");
            System.out.println("Ele existe mesmo?");
            e.printStackTrace();
        }
    }
}
    

//         if (args.length != 1) { //verifica se foi passado corretamente o parâmetro/programa;

//             System.out.println("Deu errado! Tente outra vez: java Davy.java CaminhoDoArquivo.davy");

//         }

//         String arquivo = args[0]; //o programa que a pessoa criou;

//         Lecteur scanner = new Lecteur(); // para fazer a leitura do programa;

//         scanner.LeTudo(arquivo);    // faz a leitura

//         Processamento processador = new Processamento(scanner.linhas);
        
//         processador.processa();


//     }
// }