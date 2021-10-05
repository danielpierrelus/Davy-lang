package fonte;


/* Efetua expressões de até 2 operandos */

// Andrew Gabriel  (andrew.gabrielgomes@gmail.com)
// Larissa Mones  (larissamones12@gmail.com)
// Daniel Pierrelus  (pierrelusdaniel@gmail.com)
// Kerby Lovince  (lovincekerby99@gmail.com)


import java.util.Map;

public class Operation {

    /**
     * Pré-resolve as operações
     * 
     * @param expressao -> string que contém a expressao que sera resolvida.
     * @param tipo -> tipo da Variável que será resolvida .
     * @param variaveis ->  estrutura de dados que contém todas as variáveis.
     */
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
     * @param valor -> valor ou variavel.
     * @param variaveis -> estrutura de dados que armezena as variaveis
     * @param tipo -> tipo da variavel.
     */
    private static String ehVariavel(String valor, Map<String, Variavel> variaveis, String tipo){
        if(variaveis.containsKey(valor)) {
            return variaveis.get(valor).getValeur().toString();
        }
        return valor;
    }



    /**
     * Opera soma
     * 
     * @param valores -> onde está a expressão
     * @param tipo -> tipo da variavel.
     * @param antecessor -> valor que está antes do operador
     * @param sucessor -> valor que está após o operador
     */
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


    /**
     * Opera subtração
     * 
     * @param valores -> onde está a expressão
     * @param tipo -> tipo da variavel.
     * @param antecessor -> valor que está antes do operador
     * @param sucessor -> valor que está após o operador
     */
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

    /**
     * Opera divisão
     * 
     * @param valores -> onde está a expressão
     * @param tipo -> tipo da variavel.
     * @param antecessor -> valor que está antes do operador
     * @param sucessor -> valor que está após o operador
     */
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

    
    /**
     * Opera multiplicação
     * 
     * @param valores -> onde está a expressão
     * @param tipo -> tipo da variavel.
     * @param antecessor -> valor que está antes do operador
     * @param sucessor -> valor que está após o operador
     */    
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

    /**
     * Opera módulo
     * 
     * @param valores -> onde está a expressão
     * @param tipo -> tipo da variavel.
     * @param antecessor -> valor que está antes do operador
     * @param sucessor -> valor que está após o operador
     */    
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


    /**
     * Opera soma entre strings
     * 
     * @param expressao -> onde está a expressão
     * @param variaveis -> estrutura onde esta as variaveis
     */
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