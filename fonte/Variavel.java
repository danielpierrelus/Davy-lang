package fonte;

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
