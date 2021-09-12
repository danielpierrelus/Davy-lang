import java.io.File;
import java.util.Scanner;
public class Davy {
public static void main(String[] args) {
    try {
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
    }
    }
}