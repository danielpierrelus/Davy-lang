package fonte;

public class LongueClasse extends Variavel {
    public double Valeur;

    public LongueClasse(String Nom, double Valeur){
        this.tipo = "longue";
        this.Nom = Nom;
        this.Valeur = Valeur;
    }

    public LongueClasse(String Nom){
        this.tipo = "longue";
        this.Nom = Nom;
        this.Valeur = 0;
    }

    @Override
    public Double getValeur(){
        return Valeur;
    }
    
    @Override
    public void setValeur(Object Valeur){
        this.Valeur = (double) Valeur;
    }


    
}
