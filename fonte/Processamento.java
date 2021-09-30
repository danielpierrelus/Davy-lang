package fonte;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Processamento {

    public Variavel V[];
    public Map<String, Variavel> variaveis;
    public String Linhas[];
    public int qntdLinhas;



    /**
     * Construtor.
     * 
     * @param Linhas Vetor que contém o programa escrito pelo Cliente.
     */
    public Processamento(String[] Linhas, int qntdLinhas){
          this.Linhas = Linhas;
          this.qntdLinhas = qntdLinhas;
        };



    public Processamento(){
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
    }
    


    




     public void processa(){

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
                //PrintTratamento(linhaAtual);
            }

            /**------Verifica se é Scan **/
            else if("lire".equals(tokens[0])){ //declaração de inteiro;
                ScanTratamento(linhaAtual);
            }
            /**Caso não for nenhuma das opções acima quer dizer eu ele passou uma variável, logo vamos trata-la */
            else {
                //VariavelTratamento(LinhaAtual);
            }


            


            
        }
     }


     public void EntierTratamento(String linhaAtual) {

        /**formatos: ''entier nomeVariavel = valor''' ou ''entier nomeVariavel''' */

        EntierClasse inteiro;
        String tokens[] = linhaAtual.split(" "); /*tokens[0] = entier*/
        int posIgual = linhaAtual.indexOf("="); // retorna posição do sinal igual (=)
        String VarName = tokens[1];


        if (posIgual != -1) { //verifica se tem o sinal de (=)
            String expressao = "";
            String[] antesDoIgual = linhaEmArray(linhaAtual.substring(0, posIgual));
            String[] depoisDoIgual = linhaEmArray(linhaAtual.substring(posIgual+1, linhaAtual.length()));
            
            /**Forma a expressão: */
            for (int i = 0; i<depoisDoIgual.length; i++) {
                expressao = expressao.concat(depoisDoIgual[i]);
            }

            /**Opera a expressão: */
            
            //int valor = 

            inteiro = new EntierClasse(VarName, valor);
            variaveis.put(VarName, inteiro);
        }

        else {

            inteiro = new EntierClasse(VarName);
            variaveis.put(VarName, inteiro); //colocar na Estrutura Map que guarda todas as variáveis!
        }
    }




    public void LongueTratamento(String linhaAtual) {

        /**formatos: ''longue nomeVariavel = valor''' ou ''longue nomeVariavel''' */

        LongueClasse longue;
        String tokens[] = linhaAtual.split(" "); /*tokens[0] = longue*/
        int posIgual = linhaAtual.indexOf("="); // retorna posição do sinal igual (=)
        String VarName = tokens[1];
        
            if (posIgual != -1) {
                String expressao = "";
                String[] antesDoIgual = linhaEmArray(linhaAtual.substring(0, posIgual));
                String[] depoisDoIgual = linhaEmArray(linhaAtual.substring(posIgual+1, linhaAtual.length()));
                
                /**Forma a expressão: */
                for (int i = 0; i<depoisDoIgual.length; i++) {
                    expressao = expressao.concat(depoisDoIgual[i]);
                }

                /**Opera a expressão: */
                
                //double valor = 
                
                longue = new LongueClasse(VarName, valor);
                variaveis.put(VarName, longue);
            }

            else {

                longue = new LongueClasse(VarName);
                variaveis.put(VarName, longue); //colocar na Estrutura Map que guarda todas as variáveis!
            }
    }



    public void StringTratamento(String linhaAtual) {

        /**formatos: ''string nomeVariavel = valor''' ou ''string nomeVariavel''' */

        StringClasse string;
        String tokens[] = linhaAtual.split(" "); /*tokens[0] = string*/
        String expressao[] = linhaAtual.split("=");
        String VarName = tokens[1];
        
            if (linhaAtual.indexOf("=") != -1) {
                /**a expressao está em expressao[1] */

                //String resultado = 
                string = new StringClasse(VarName, resultado);
            }

            else {
                string = new StringClasse(VarName);
            }

        variaveis.put(VarName, string);
    }


    public void ScanTratamento(String linhaAtual){

        String variavelPassada = conteudoParenteses(linhaAtual);

        if(variaveis.containsKey(variavelPassada)){

            Scanner scan = new Scanner(System.in);
            String valor = scan.nextLine();

            if (variaveis.get(variavelPassada).tipo.equals("int")) {
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



    private String conteudoParenteses(String linhas) {
        int primeiroParentese = linhas.indexOf("(");
        int segundoParentese = linhas.lastIndexOf(")");

            if (primeiroParentese == -1 || segundoParentese == -1) {
                /**Lança uma exceção! */
            }

        String entreOsParenteses = linhas.substring(primeiroParentese+1, segundoParentese);

        return entreOsParenteses;
    }

    //private void VariavelTratamento(String linhas);








    public static String[] linhaEmArray(String linhas) {
        String palavras[] = linhas.split(" ");
        String semEspacos[] = new String[0];

        for (int c = 0; c < palavras.length; c++){
            if(!" ".equals(palavras[c])) {
                semEspacos = Lecteur.novaArray(semEspacos, palavras[c], semEspacos.length);
            }
        }
        return semEspacos;
    }


}