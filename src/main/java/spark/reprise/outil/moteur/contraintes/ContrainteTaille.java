package spark.reprise.outil.moteur.contraintes;

import java.util.ArrayList;
import java.util.List;

import spark.reprise.outil.moteur.ContrainteUniCol;



/**
 * Cette contrainte sert � v�rifier que les valeurs du champ poss�dent une
 *  taille maximale inf�rieure � une taille limite d�termin�e.
 * @author maazreibi
 *
 */
public class ContrainteTaille extends ContrainteUniCol {
	protected int tailleMax=0;

	/**
	 * Construit une ContrainteTaille.
	 * @param taille la taille limite � ne pas d�passer
	 */
	public ContrainteTaille(int taille){
		super();//pour PMD
		tailleMax=taille;
	}
	/**{@inheritDoc}*/
	@Override
	public  String interprete(String balise, int indice){
		if("taille_champ".equals(balise)){
		    return Integer.toString(tailleMax);		
		}
		return super.interprete(balise, indice);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public  boolean estConforme(final String valeur) {
		return valeur.length()<=tailleMax;
	}
	/**{@inheritDoc}*/
	@Override
	public List<String> getListeParam() {
		List<String> params= new ArrayList<String>();
		params.add(Integer.toString(tailleMax));		
		return params;
	}

	/**
	 *La taille de la valeur v�rifi�e doit �te inf�rieure � la taille maximale d�finie ici.
	 * @return la taille maximale permise. 
	 */
	public int getTailleMax() {
	    return tailleMax;
	}
	/**
	 * La taille de la valeur v�rifi�e doit �te inf�rieure � la taille maximale d�finie ici.
	 * @param tailleMax la taille maximale permise. 
	 */
	public void setTailleMax(int tailleMax) {
	    this.tailleMax = tailleMax;
	}
	
	/**{@inheritDoc}*/
	@Override
	public ContrainteTaille copy() {
	    return new ContrainteTaille(tailleMax);
	}
	
}
