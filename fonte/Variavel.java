package fonte;


/* Variável Abstrata */

// Andrew Gabriel  (andrew.gabrielgomes@gmail.com)
// Larissa Mones  (larissamones12@gmail.com)
// Daniel Pierrelus  (pierrelusdaniel@gmail.com)
// Kerby Lovince  (lovincekerby99@gmail.com)


abstract class Variavel {
    
    public String tipo;
    public String Nom;
    public Object Valeur;

    /**
     * Getter
     * 
     * @return retorna valor da variável.
     */
    abstract Object getValeur();

    /**
     * Setter
     * 
     * @param Valeur -> seta Valeur como valor da variável.
     */
    abstract void setValeur(Object Valeur);

}
