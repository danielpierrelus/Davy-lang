package fonte;


/* Variável Inteira */

// Andrew Gabriel  (andrew.gabrielgomes@gmail.com)
// Larissa Mones  (larissamones12@gmail.com)
// Daniel Pierrelus  (pierrelusdaniel@gmail.com)
// Kerby Lovince  (lovincekerby99@gmail.com)


public class EntierClasse extends Variavel {

    public int Valeur;

    /**
     * Construtor com inicialização de valor
     * 
     * @param Nom -> nome da variável.
     * @param Valeur -> valor que será atribuido a Variável.
     */
    public EntierClasse(String Nom, int Valeur){
        this.tipo = "entier";
        this.Nom = Nom;
        this.Valeur = Valeur;
    }


    /**
     * Construtor sem inicialização de valor
     * 
     * @param Nom -> nome da variável.
     */
    public EntierClasse(String Nom){
        this.tipo = "entier";
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
