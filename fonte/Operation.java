package fonte;

public class Operation {
    private Processamento out ;

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
    
}
