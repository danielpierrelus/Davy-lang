package fonte;

abstract class Variavel {
    
    public String tipo;
    public String Nom;
    public Object Valeur;


    abstract Object getValeur();

    abstract void setValeur(Object Valeur);

}
