package fonte;

public class StringClasse extends Variavel{
    public String Valeur;

    public StringClasse(String Nom, String Valeur){
        this.tipo = "String";
        this.Nom = Nom;
        this.Valeur = Valeur;
    }

    public StringClasse(String Nom){
        this.tipo = "String";
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
