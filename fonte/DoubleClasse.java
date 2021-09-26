package fonte;

public class DoubleClasse extends Variavel {
    public double Valeur;

    public DoubleClasse(String Nom, double Valeur){
        this.tipo = "Double";
        this.Nom = Nom;
        //verifie un nombre decimal
        this.Valeur = Valeur;
    }

    public DoubleClasse(String Nom){
       // this.tipo = "Double";
        this.Nom = Nom;
        //verifie un nombre decimal
        this.Valeur = 0;
    }

    // @Override
    // public Double getValeur(){
    //     return Valeur;
    // }
    
    // @Override
    // public void setValeur(Object Valeur){
    //     this.Valeur = (double) Valeur;
    // }


    
}
