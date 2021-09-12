package fonte;

public class EntierClasse extends Variavel {
    public EntierClasse(String Nom, String Valeur){
        this.Nom = Nom;
        // pour verifier  um entier
        this.Valeur = (int) Double.parseDouble(Valeur);
    }
    
}
