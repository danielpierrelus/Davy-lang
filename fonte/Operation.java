package fonte;

import java.util.Map;


public class Operation {

    
/*     private Processamento out ;

    public Operation(Processamento h){
        out = h;
    }

    public double OperacaoAritmetica(char Token, double A, double B){
        if(Token == '+') return A + B;
        else if(Token == '-') return A - B;
        else if(Token == '*') return A * B;
        else if(Token == '/') return A / B;
        else if(Token == '%') return A % B;
        return 0;

    }

    public char TokensAritmeticos(String n){
        for( int x=0; x<n.length(); x++){
            if(n.charAt(x) == '+') return n.charAt(x);
            else if(n.charAt(x) == '-') return n.charAt(x);
            else if(n.charAt(x) == '*') return n.charAt(x);
            else if(n.charAt(x) == '/') return n.charAt(x);
            else if(n.charAt(x) == '%') return n.charAt(x);




        }
        return '0';
    }
    
    public boolean verificaComparacao(String n, double A, double B){
        for(int x=0; x<n.length(); x++){
            if(n.charAt(x) == '<'){
                if(A<B){
                    return true;
                }
            }else if(n.charAt(x) == '>' && n.charAt(x+1) == '>'){
                if(A<=B){
                    return true;
                }
            }else if(n.charAt(x) == '<' && n.charAt(x) == '>'){
                if(A<=B){
                    return true;
                }
            }else if(n.charAt(x) == '=' && n.charAt(x+1) == '='){
                if(A==B){
                    return true;
                }
            }else if(n.charAt(x) == '!' && n.charAt(x+1) == '='){
                if(A!=B){
                    return true;
                }
            }
        }
        return false;
    }

    public double transformaDouble(String Valeur){
        return Double.valueOf(out.VariavelLocalisation(Valeur)).doubleValue();
    }

    public String ExpComComparacao(String n){
        if(TokensAritmeticos(n) !='0') return String.valueOf(ExpressoesAritmeticas(n));
        return n;
    }
    public boolean ExpressoesComparacao(String n){
        String Teste= " ";
        int x=0;
        Teste = n.replaceAll("[ \\;]","");
        Teste = Teste.replaceAll("[ \\<\\>\\==\\;]"," .");
        Teste = Teste.replaceAll(" \\;)\\{","");
        String [] vet= Teste.split("\\.");
        return verificaComparacao(n,transformaEmDouble(ExpComComparacao(vet[0])) transformaDouble(ExpComComparacao(vet[2])));


    }

    public double ExpressoesAritmeticas(String n){
        n=n.replaceAll(" "," ");
        String [] vet = n.split("[^a-z,^0-9,^A-Z");
        return OperacaoAritmetica(TokensAritmeticos(n), transformaDouble(vet[1]));
    }


 */

    
    /* public static String[] trataExpressao(String expressaoAntiga) {
        String expressaoNova[] = new String[0];
        String aux = "";
        String analise[] = expressaoAntiga.split("");

        for (int c = 0; c < analise.length; c++) {
            if (analise[c].equals("+") || analise[c].equals("-") || analise[c].equals("*") || analise[c].equals("/") || analise[c].equals("%")) {

            } else {
                aux = aux.concat(analise[c]);
            }
        }
        return expressaoNova;


    } */




    public static Object qualOperacao(String expressao, String tipo, Map<String, Variavel> variaveis) {

        Object resultado = new Object();
        Object resultadoTemp = new Object();
        String[] aux = new String[]{""};
        String [] expressaoT = expressao.split(" ");

        /**Se existe os sinais */
        if(expressao.indexOf("+") != -1|| expressao.indexOf("-") != -1 || expressao.indexOf("*") != -1 || expressao.indexOf("/") != -1|| expressao.indexOf("%") != -1) {
            
            
            if (tipo.equals("string")) {
                return stringando(expressao, variaveis);
            }
            


            for (int i = 0; i< expressaoT.length; i++) {
                if (expressaoT[i].equals("+")){
                    expressaoT[i+1] = ehVariavel(expressaoT[i+1], variaveis, tipo);
                    expressaoT[i-1] = ehVariavel(expressaoT[i-1], variaveis, tipo);
                    resultadoTemp = soma(expressaoT, tipo, i+1, i-1);
                    aux[0] = resultadoTemp.toString();
                }
            }

            
            for (int i = 0; i< expressaoT.length; i++) {
                if (expressaoT[i].equals("-")){
                    expressaoT[i+1] = ehVariavel(expressaoT[i+1], variaveis, tipo);
                    expressaoT[i-1] = ehVariavel(expressaoT[i-1], variaveis, tipo);
                    resultadoTemp = subtrai(expressaoT, tipo, i+1, i-1);
                    aux[0] = resultadoTemp.toString();
                }
            }

            
            for (int i = 0; i< expressaoT.length; i++) {
                if (expressaoT[i].equals("*")){
                    expressaoT[i+1] = ehVariavel(expressaoT[i+1], variaveis, tipo);
                    expressaoT[i-1] = ehVariavel(expressaoT[i-1], variaveis, tipo);
                    resultadoTemp = multiplica(expressaoT, tipo, i+1, i-1);
                    aux[0] = resultadoTemp.toString();
                }
            }

            
            for (int i = 0; i< expressaoT.length; i++) {
                if (expressaoT[i].equals("/")){
                    expressaoT[i+1] = ehVariavel(expressaoT[i+1], variaveis, tipo);
                    expressaoT[i-1] = ehVariavel(expressaoT[i-1], variaveis, tipo);
                    resultadoTemp = divide(expressaoT, tipo, i+1, i-1);
                    aux[0] = resultadoTemp.toString();
                }
            }

            
            for (int i = 0; i< expressaoT.length; i++) {
                if (expressaoT[i].equals("%")){
                    expressaoT[i+1] = ehVariavel(expressaoT[i+1], variaveis, tipo);
                    expressaoT[i-1] = ehVariavel(expressaoT[i-1], variaveis, tipo);
                    resultadoTemp = modula(expressaoT, tipo, i+1, i-1);
                    aux[0] = resultadoTemp.toString();
                }
            }
        } else { //so tem um valor e n tem nenhuma expressão
            aux[0] = Operation.ehVariavel(aux[0], variaveis, tipo);
            aux[0] = expressao.trim();
        }
        if(tipo.equals("longue")){
            resultado = Double.parseDouble(aux[0]);
        }
        if(tipo.equals("entier")){
            resultado = Integer.parseInt(aux[0]);
        }

        return resultado;
    }



   /**
     * Verifica se o que a pessoa digitou é uma variável ou simplesmente um valor.
     * 
     * @param valor valor ou variavel.
     */
    private static String ehVariavel(String valor, Map<String, Variavel> variaveis, String tipo){
        if(variaveis.containsKey(valor)) {
            return variaveis.get(valor).getValeur().toString();
        }
        return valor;
    }




    public static Object soma(String[] valores, String tipo, int antecessor, int sucessor){

        if(tipo.equals("longue")){
            double result = Double.parseDouble(valores[antecessor]) + Double.parseDouble(valores[sucessor]);
            return result;
        }

        if(tipo.equals("entier")){
            int result = Integer.parseInt(valores[antecessor]) + Integer.parseInt(valores[sucessor]);
            return result;
            
        }
        return 0;
    }



    public static Object subtrai(String[] valores, String tipo, int antecessor, int sucessor){

        if(tipo.equals("longue")){
            double result = Double.parseDouble(valores[antecessor]) - Double.parseDouble(valores[sucessor]);
            return result;
        }
        if(tipo.equals("entier")){
            int result = Integer.parseInt(valores[antecessor]) - Integer.parseInt(valores[sucessor]);
            return result;
            
        }
        return 0;
    }


    public static Object divide(String[] valores, String tipo, int antecessor, int sucessor){

        if(tipo.equals("longue")){
            double result = Double.parseDouble(valores[antecessor]) / Double.parseDouble(valores[sucessor]);
            return result;
        }
        if(tipo.equals("entier")){
            int result = Integer.parseInt(valores[antecessor]) / Integer.parseInt(valores[sucessor]);
            return result;
            
        }
        return 0;
    }

    public static Object multiplica(String[] valores, String tipo, int antecessor, int sucessor){

        if(tipo.equals("longue")){
            double result = Double.parseDouble(valores[antecessor]) * Double.parseDouble(valores[sucessor]);
            return result;
        }
        if(tipo.equals("entier")){
            int result = Integer.parseInt(valores[antecessor]) * Integer.parseInt(valores[sucessor]);
            return result;
            
        }
        return 0;
    }

    public static Object modula(String[] valores, String tipo, int antecessor, int sucessor){

        if(tipo.equals("longue")){
            double result = Double.parseDouble(valores[antecessor]) % Double.parseDouble(valores[sucessor]);
            return result;
        }
        if(tipo.equals("entier")){
            int result = Integer.parseInt(valores[antecessor]) % Integer.parseInt(valores[sucessor]);
            return result;
            
        }
        return 0;
    }

    public static String stringando(String expressao, Map<String, Variavel> variaveis) {
        String resultado = "";
        boolean check = true;

        for (int i = 0; i < expressao.length(); i++) {
            if(expressao.charAt(i) == '\"'){
                check = !check;
            }
            if(expressao.charAt(i) == '+' && check == true) {
                String antecessor = expressao.substring(0, i);
                String sucessor = expressao.substring(i+1, expressao.length());
                resultado = antecessor + sucessor;
                return resultado;
            }

        }
        return expressao.replace("\"", "");

    }
}