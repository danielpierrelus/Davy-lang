package fonte;

public class Davy {
public static void main(String[] args) {
        if (args.length != 1) { //      verifica se foi passado corretamente o parâmetro/programa;
            System.out.println("Deu errado! Tente outra vez: java Davy.java CaminhoDoArquivo.davy");
        }

        String arquivo = args[0]; //o programa que a pessoa criou;
        Lecteur scanner = new Lecteur(); // para fazer a leitura do programa;
        scanner.LeTudo(arquivo);    // faz a leitura
        //aqui implemententa o processamento com o parâmetro scanner.Linhas

    }
}