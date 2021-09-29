package fonte;

public class EntierClasse extends Variavel {

    public int Valeur;

    public EntierClasse(String Nom, int Valeur){
        this.tipo = "entier";
        this.Nom = Nom;
        this.Valeur = Valeur;
    }

    public EntierClasse(String Nom){
        this.tipo = "Entier";
        this.Nom = Nom;
        this.Valeur = 0;
    }

    @Override
    public Integer getValeur(){
        return this.Valeur;
    }

    @Override
    void setValeur(Object Valeur){
        this.Valeur = (int) Valeur;
    }
    
}
