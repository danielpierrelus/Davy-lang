package fonte;

public class StringClasse extends Variavel{
    public String Valeur;


    /**
     * Construtor com inicialização de valor
     * 
     * @param Nom -> nome da variável.
     * @param Valeur -> valor que será atribuido a Variável.
     */
    public StringClasse(String Nom, String Valeur){
        this.tipo = "string";
        this.Nom = Nom;
        this.Valeur = Valeur;
    }


    /**
     * Construtor sem inicialização de valor, valor = null
     * 
     * @param Nom -> nome da variável.
     */
    public StringClasse(String Nom){
        this.tipo = "string";
        this.Nom = Nom;
        this.Valeur = null;
    }


    @Override
    public String getValeur(){
        return Valeur;
    }

    @Override
    public void setValeur(Object Valeur) {
        this.Valeur = (String) Valeur;
    }

}
