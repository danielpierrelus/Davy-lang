package fonte;

public class Davy {
public static void main(String[] args) {
        if (args.length != 1) { //      verifica se foi passado corretamente o parâmetro/programa;
            System.out.println("Deu errado! Tente outra vez: java Davy.java CaminhoDoArquivo.davy");
        }

        String arquivo = args[0];
        Lecteur scanner = new Lecteur();
        scanner.LeTudo(arquivo);    
    }
}