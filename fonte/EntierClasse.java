package fonte;

public class EntierClasse extends Variavel {

   // public int Valeur;

    public EntierClasse(String Nom, String Valeur){
        this.tipo = "Entier";
        this.Nom = Nom;
        // pour verifier  um entier
        this.Valeur = Valeur;
    }

    //public EntierClasse(String Nom){
       // this.tipo = "Entier";
        this.Nom = Nom;
        this.Valeur = (int) Double.parseDouble(Valeur);
    }

// @Override
// public Integer getValeur(){
//     return this.Valeur;
// }

// @Override
// void setValeur(Object Valeur){
//     this.Valeur = (int) Valeur;
// }
    
}
