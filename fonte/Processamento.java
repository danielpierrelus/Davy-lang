package fonte;


/* Efetua o processamento linha a linha */

// Andrew Gabriel  (andrew.gabrielgomes@gmail.com)
// Larissa Mones  (larissamones12@gmail.com)
// Daniel Pierrelus  (pierrelusdaniel@gmail.com)
// Kerby Lovince  (lovincekerby99@gmail.com)


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Processamento {

    //public Variavel V[];
    public Map<String, Variavel> variaveis;
    public String Linhas[];
    public int qntdLinhas;

    /**
     * Construtor.
     * 
     * @param Linhas -> Vetor que contém o programa escrito pelo Cliente.
     * @param qntdLinhas -> contém a quantidades de linhas do programa.
     */
    public Processamento(String Linhas[], int qntdLinhas){
          this.Linhas = Linhas;
          this.qntdLinhas = qntdLinhas;
          this.variaveis = new LinkedHashMap<>();
        };


    /**
     * Faz o processamento linha por linha
     * 
     */
     public void Processa(){

        for(int i=0; i<qntdLinhas; i++) {
            String linhaAtual = Linhas[i];
            String tokens[] = linhaAtual.split(" ");


            /**------Verifica se é inteiro **/
            if("entier".equals(tokens[0])){ //declaração de inteiro;
                EntierTratamento(linhaAtual);
            }

            /**------Verifica se é Double **/
            else if("longue".equals(tokens[0])){ //declaração de inteiro;
                LongueTratamento(linhaAtual);
            }

            /**------Verifica se é String **/
            else if("string".equals(tokens[0])){ //declaração de inteiro;
                StringTratamento(linhaAtual);
            }

            /**------Verifica se é While **/
            else if("pendant".equals(tokens[0])){ //declaração de inteiro;
                //WhileTratamento(linhaAtual);
            }

            /**------Verifica se é IF **/
            else if("oui".equals(tokens[0])){ //declaração de inteiro;
                //IfTratamento(linhaAtual);
            }

            /**------Verifica se é Print **/
            else if("imprimer".equals(tokens[0])){ //declaração de inteiro;
                ImprimerTratamento(linhaAtual);
            }

            /**------Verifica se é Print **/
            else if("imprimerVar".equals(tokens[0])){ //declaração de inteiro;
                ImprimerVarTratamento(linhaAtual);
            }

            /**------Verifica se é Scan **/
            else if("lire".equals(tokens[0])){ //declaração de inteiro;
                ScanTratamento(linhaAtual);
            }
            /**Caso não for nenhuma das opções acima quer dizer eu ele passou uma variável, logo vamos trata-la */
            else {
                VariavelTratamento(linhaAtual);
            }

            

            

            
        }
     }

    /**
     * Faz o tratamento de variáveis do tipo Entier
     * 
     * @param linhaAtual -> contém a linha atual que está sendo trabalhada
     */
     public void EntierTratamento(String linhaAtual) {

        /**formatos: ''entier nomeVariavel = valor''' ou ''entier nomeVariavel''' */

        EntierClasse inteiro;
        String tokens[] = linhaAtual.split(" "); /*tokens[0] = entier*/
        int posIgual = linhaAtual.indexOf("="); // retorna posição do sinal igual (=)
        String VarName = tokens[1];


        if (posIgual != -1) { //verifica se tem o sinal de (=)
            String expressao = "";
            String[] depoisDoIgual = linhaEmArray(linhaAtual.substring(posIgual+1, linhaAtual.length()));
            
            /**Forma a expressão: */
            for (int i = 0; i<depoisDoIgual.length; i++) {
                expressao = expressao.concat(depoisDoIgual[i]);

            }
            /**Opera a expressão: */
            int valor = (int) Operation.qualOperacao(expressao, "entier", variaveis);
            inteiro = new EntierClasse(VarName, valor);
        }

        else {

            inteiro = new EntierClasse(VarName);
            
        }
        variaveis.put(inteiro.Nom, inteiro); //colocar na Estrutura Map que guarda todas as variáveis!
    }



    
    /**
     * Faz o tratamento de variáveis do tipo Longue
     * 
     * @param linhaAtual -> contém a linha atual que está sendo trabalhada
     */
    public void LongueTratamento(String linhaAtual) {
    
        /**formatos: ''longue nomeVariavel = valor''' ou ''longue nomeVariavel''' */

        LongueClasse longue;
        String tokens[] = linhaAtual.split(" "); /*tokens[0] = longue*/
        int posIgual = linhaAtual.indexOf("="); // retorna posição do sinal igual (=)
        String VarName = tokens[1];
        
            if (posIgual != -1) {
                String expressao = "";
                String[] depoisDoIgual = linhaEmArray(linhaAtual.substring(posIgual+1, linhaAtual.length()));
                
                /**Forma a expressão: */
                for (int i = 0; i<depoisDoIgual.length; i++) {
                    expressao = expressao.concat(depoisDoIgual[i]);
                }

                /**Opera a expressão: */
                
                double valor = (double) Operation.qualOperacao(expressao, "longue", variaveis);
                
                longue = new LongueClasse(VarName, valor);
            }

            else {
                longue = new LongueClasse(VarName);
            }
            variaveis.put(longue.Nom, longue); //colocar na Estrutura Map que guarda todas as variáveis!
    }


    /**
     * Faz o tratamento de variáveis do tipo String
     * 
     * @param linhaAtual -> contém a linha atual que está sendo trabalhada
     */
    public void StringTratamento(String linhaAtual) {

        /**formatos: ''string nomeVariavel = valor''' ou ''string nomeVariavel''' */

        StringClasse string;
        String tokens[] = linhaAtual.split(" "); /*tokens[0] = string*/
        String expressao[] = linhaAtual.split("=");
        String VarName = tokens[1];
        
            if (linhaAtual.indexOf("=") != -1) {
                /**a expressao está em expressao[1] */

                String resultado = (String) Operation.qualOperacao(expressao[1], "string", variaveis);
                string = new StringClasse(VarName, resultado);
            }

            else {
                string = new StringClasse(VarName);
            }

        variaveis.put(VarName, string);
    }

    /**
     * Faz o tratamento de leitura do teclado
     * 
     * @param linhaAtual -> contém a linha atual que está sendo trabalhada
     */
    public void ScanTratamento(String linhaAtual){

        String variavelPassada = conteudoParenteses(linhaAtual);

        if(variaveis.containsKey(variavelPassada)){

            Scanner scan = new Scanner(System.in);
            String valor = scan.nextLine();

            if (variaveis.get(variavelPassada).tipo.equals("entier")) {
                variaveis.get(variavelPassada).setValeur(Integer.parseInt(valor));
            }
            else if (variaveis.get(variavelPassada).tipo.equals("longue")) {
                variaveis.get(variavelPassada).setValeur(Double.parseDouble(valor));
            }
            else {
                variaveis.get(variavelPassada).setValeur(valor);
            }
            scan.close();
        } 
        else {
            /**lança exceção */
        }
    }


    /**
     * Faz o tratamento de variavel
     * 
     * @param linhaAtual -> contém a linha atual que está sendo trabalhada
     */
    public void VariavelTratamento(String linhaAtual) {
        String expressao = "";
        String [] pre = new String[0];
        String [] pos = new String[0];
        int posicao = 0;

        if (linhaAtual.indexOf("++") != -1) {
            posicao = linhaAtual.indexOf("++");
            pre = linhaEmArray(linhaAtual.substring(0, posicao));
            expressao += pre[0]+"+1";

        }
        else if (linhaAtual.indexOf("--") != -1) {
            posicao = linhaAtual.indexOf("--");
            pre = linhaEmArray(linhaAtual.substring(0, posicao));
            expressao += pre[0]+"-1";

        } else if (linhaAtual.indexOf("=") != -1){
            posicao = linhaAtual.indexOf("=");
            pre = linhaEmArray(linhaAtual.substring(0, posicao));
            pos = linhaEmArray(linhaAtual.substring(posicao+1, linhaAtual.length()));
            for(int i = 0; i < pos.length; i++) {
                expressao = expressao.concat(pos[i]);
            }
        }

        Variavel aux = this.variaveis.get(pre[0]);
         if(aux == null) {
             /* lança exceção */
         } 
         else {
             if(posicao != -1) {
                if(aux.tipo.equals("entier")) {
                    int resultado = (int) Operation.qualOperacao(expressao, "entier", variaveis);
                    aux.setValeur(resultado);
                }
                else if(aux.tipo.equals("longue")) {
                    double resultado = (double) Operation.qualOperacao(expressao, "longue", variaveis);
                    aux.setValeur(resultado);
                }
             }
         }  
    }
    /**
     * Retorna conteudo que esta entre parenteses
     * 
     * @param linhas -> vetor que procuraremos parenteses;
     */
    private String conteudoParenteses(String linhas) {
        int primeiroParentese = linhas.indexOf("(");
        int segundoParentese = linhas.lastIndexOf(")");

            if (primeiroParentese == -1 || segundoParentese == -1) {
                /**Lança uma exceção! */
            }

        String entreOsParenteses = linhas.substring(primeiroParentese+1, segundoParentese);

        return entreOsParenteses;
    }


    /**
     * Pega uma linha, retira os espaços, e coloca numa array;
     * 
     * @param linhas linha a ser tratada
     */
    public static String[] linhaEmArray(String linhas) {
        String palavras[] = linhas.split("");
        String semEspacos[] = new String[0];

        for (int c = 0; c < palavras.length; c++){
            if(!" ".equals(palavras[c])) {
                semEspacos = Lecteur.novaArray(semEspacos, palavras[c], semEspacos.length);
            }
        }
        return semEspacos;
    }




/**O QUE FALTA FAZER: */
/**
 * - PENDANT; (LAÇO/WHILE)
 * - OUI - SINON; (IF/ELSE)
 * - IMPRIMER; (PRINT)
 * - TESTAR OPERAÇÕES;
 * - TESTAR LIRE; (SCAN)
 * - LANÇAMENTO DE EXCEÇÕES;
 * - TRATAMENTO CASO O CLIENTE PASSE UMA VARIaVEL (ALTERAÇÃO DE VALOR DE VARIaVEIS COM E SEM OPERAÇÃO)
 * - RESOLVER PROBLEMA DE COMPILAÇÃO; SYMBOl NOT FOUND;
 * 
 */


/**NAO ESTA PRONTO:::: */



    /**
     * Faz o tratamento de impressão na tela
     * Imprime apenas textos entre aspas
     * 
     * @param linhaAtual -> contém a linha atual que está sendo trabalhada
     */
    public void ImprimerTratamento(String linhaAtual){

        if (linhaAtual.indexOf("\"") != -1){
            int primeira = linhaAtual.indexOf("\"");
            int segunda = linhaAtual.indexOf("\"");
            String conteudo = linhaAtual.substring(primeira+1, segunda);
            System.out.println(conteudo);
        }
    }



    /**
     * Faz o tratamento de impressão na tela
     * Imprime apenas variáveis.
     * 
     * @param linhaAtual -> contém a linha atual que está sendo trabalhada
     */
    public void ImprimerVarTratamento(String linhaAtual){

        String variavelPassada = conteudoParenteses(linhaAtual);

        if(variaveis.containsKey(variavelPassada)){

            System.out.println(variaveis.get(variavelPassada).getValeur());

        } 
    }
}