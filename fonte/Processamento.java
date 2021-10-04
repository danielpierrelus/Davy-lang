package fonte;

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






  /*   public Processamento(){
        V = new Variavel[200]; 
        };


        
    public void CriarVariavel(String g){
        for (int i = 0; i<V.length; i++){
            if (this.V[i] == null) {
                if(g.startsWith("int")){
                    if (ChangeVariavel(getName(g),getValue(g)));
    //Pesquisa se a variavél ja existe, caso já tenha uma com o mesmo nome ele subscrever ela
                }

            }
        }
    }


    public boolean ChangeVariavel(String Name, String Value){
        for(int i =0; i<V.length; i++){
            if(V[i] != null){
                if(V[i].Nom.equals(Name)){
                    if(V[i] instanceof LongueClasse){
                        V[i].Valeur= Double.valueOf(Value).doubleValue();
                    }else if( V[i] instanceof EntierClasse){
                        V[i].Valeur= (int) Double.parseDouble(Value);
                    }else if (V[i] instanceof StringClasse){
                        V[i].Valeur += Value;

                    }
                    return true;
                }
            }
        }
    }


    
    public String getName(String g){ // string valeur
        int count = 0;
        if (g.startsWith("int") || g.startsWith("let") || g.startsWith("double")) 
        count=1;
        //caso for na declaracão de variavel o nome vai se encontrar no indice 1 do vetor,
        //pois no split está mandado quebrar espaços
        g=g.replaceAll("[\\=\\;]"," "); // retira esses caracteres
        String[] vet =g.split("");
        return vet[count];

    }




    public String get_StringValeur(String g){ // string valeur
        int x = 0;
        String Valeur= " ";
        while(g.charAt(x) !='"') x++;
        x++;
        while(g.charAt(x) !='"') { // copiar até achar as aspas
            Valeur += g.charAt(x);
            x++;
        }
        return Valeur;


    }



    public String getValue( String n){
        if(!n.contains("=")){ //caso seja só uma variavél sem valor. ex double j
            return "0"; //retorna o valor Zero pra a variavel que esta sendo criada

        }
        n=n.replaceAll(" ",""); // retira os espacos
        String[] valor= n.split("\\="); // separa o valor do nome, exemplo int N=20-A; no valor[1] vai conter 20-A
        if(Operation.TokensAritmeticos(n) != '0'){ // caso retornar diferente de zero quer dizer que existe uma operacão aritmeticá
            Valor[1] = String.valueOf(Operation.ExpressoesAritmeticas(Valor[1])); // faz a operação e retorna o valor

        }else{
            Valor[1]= Valor[1].replaceAll("\\;","");// se existe um numero ou um variavel
            Valor [1]= VariavelLocalisation(valor[1]); // se tiver uma variavel vai retorna o valor dela
        }
        return Valor[1];
    } */
    


    



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
 * - IMPLEMENTAR OPERAÇÃO DE INCREMENTO+1 E REDUZ-1; (++,--)
 * - LANÇAMENTO DE EXCEÇÕES;
 * - TRATAMENTO CASO O CLIENTE PASSE UMA VARIÁVEL (ALTERAÇÃO DE VALOR DE VARIÁVEIS COM E SEM OPERAÇÃO)
 * - RESOLVER PROBLEMA DE COMPILAÇÃO; SYMBOM NOT FOUND;
 * 
 */


/**NAO ESTA PRONTO:::: */



    /**
     * Faz o tratamento de impressão na tela
     * 
     * @param linhaAtual -> contém a linha atual que está sendo trabalhada
     */
    public void ImprimerTratamento(String linhaAtual){

        String variavelPassada = conteudoParenteses(linhaAtual);

        if(variaveis.containsKey(variavelPassada)){

            System.out.println(variaveis.get(variavelPassada).getValeur());

        } 
    }
}