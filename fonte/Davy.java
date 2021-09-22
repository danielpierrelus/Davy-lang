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










/* try {
        File file = new File("teste.davy");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
        }
    input.close();
    } catch (Exception e) {
        System.out.println("Nao foi possivel abrir o arquivo teste.davy.");
        System.out.println("Ele existe mesmo?");

        e.printStackTrace();
    } */