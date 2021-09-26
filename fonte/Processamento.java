package fonte;

public class Processamento {
    public Variavel V[];

    //public String Linhas[];
    

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
        //this.Linhas = VLinhas;
        //declarar as variáveis; usar HashMap? Map?
    }
    

    //public void processa(){

    }
}