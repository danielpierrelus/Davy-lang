package fonte;

public class DecimalClasse extends Variavel {
    public float Valeur;

    public DecimalClasse(String Nom, float Valeur){
        this.tipo = "Decimal";
        this.Nom = Nom;
        //verifie un nombre decimal
        this.Valeur = Valeur;
    }

    public DecimalClasse(String Nom){
        this.tipo = "Decimal";
        this.Nom = Nom;
        //verifie un nombre decimal
        this.Valeur = 0;
    }

    @Override
    public Float getValeur(){
        return Valeur;
    }
    
    @Override
    public void setValeur(Object Valeur){
        this.Valeur = (float) Valeur;
    }


    
}
