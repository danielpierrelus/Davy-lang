package fonte;


/* Variável double */

// Andrew Gabriel  (andrew.gabrielgomes@gmail.com)
// Larissa Mones  (larissamones12@gmail.com)
// Daniel Pierrelus  (pierrelusdaniel@gmail.com)
// Kerby Lovince  (lovincekerby99@gmail.com)


public class LongueClasse extends Variavel {
    public double Valeur;


    /**
     * Construtor com inicialização de valor
     * 
     * @param Nom -> nome da variável.
     * @param Valeur -> valor que será atribuido a Variável.
     */
    public LongueClasse(String Nom, double Valeur){
        this.tipo = "longue";
        this.Nom = Nom;
        this.Valeur = Valeur;
    }

    /**
     * Construtor sem inicialização de valor
     * 
     * @param Nom -> nome da variável.
     */    
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
