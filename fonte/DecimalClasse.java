package fonte;

public class DecimalClasse extends Variavel {
    public DecimalClasse(String Nom, String Valeur){
        this.Nom = Nom;
        //verifie un nombre decimal
        this.Valeur = Double.valueOf(Valeur).doubleValue();
    }
    
}
