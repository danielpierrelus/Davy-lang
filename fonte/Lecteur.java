package fonte;

import java.io.File;
import java.util.Scanner;

public class Lecteur {
    protected String linhas[];


    public void ImprimeLinhas() {
        for (int i = 0; i < this.linhas.length; i++) {
            System.out.println("Linha " + i + ": " + this.linhas[i]);
        }
    }


    public void LeTudo(String arquivo) {

        try {

            this.linhas = new String[0];
            File file = new File(arquivo);
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {

                String line = input.nextLine();
                //precisa adicionar o ^line^ no this.linhas
                //talvez criar um metodo em outra classe que crie um array novo com (line + this.linhas) tipo um append
            }

        input.close();

        } catch (Exception e) {

            System.out.println("Nao foi possivel abrir o arquivo " + arquivo);
            System.out.println("Ele existe mesmo?");
    
            e.printStackTrace();

        }
    }
    
}
