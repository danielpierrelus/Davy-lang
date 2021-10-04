package fonte;

public class Davy {
    public static void main(String[] args) {
        
         if (args.length != 1) { //verifica se foi passado corretamente o parâmetro/programa;

             System.out.println("Deu errado! Tente outra vez: java Davy.java CaminhoDoArquivo.Davy");
             return;

         }

        String arquivo = args[0]; //o programa que a pessoa criou;
        Lecteur l = new Lecteur(); // para fazer a leitura do programa;
        l.leTudo(arquivo);    // faz a leitura e guarda em l.linhas[]
        Processamento p = new Processamento(l.linhas, l.qntdLinhas);
        p.Processa();


     }
 }