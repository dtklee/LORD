package spark.reprise.outil.moteur.contraintes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import spark.reprise.outil.moteur.ContrainteUniCol;



/**
 * Cette contrainte est une contrainte auxiliaire � la contrainte de r�f�rence. <br><br>
 * Elle sert 
 * � stocker les valeurs de la colonne r�f�renc�e dans un HashSet, qui sera utilis� par la 
 * contrainte de r�f�rence principale(ContrainteReference) pour d�terminer si la 
 * valeur r�f�renc�e existe ou pas. 
 * @author maazreibi
 *
 */
public class ContrainteReferenceLookup extends ContrainteUniCol{

	
	protected Set<String> dict= new HashSet<String>();
	/**
	 * {@inheritDoc}	  
	 */
	@Override
	public boolean estConforme(final String valeur){
		dict.add(valeur);
		return true;			
	}
	/**
	 * 	Cette m�thode permet de d�terminer si une valeur a d�j� �t� rencontr�e dans la colonne
	 * r�f�renc�e.
	 * @param valeur la valeur � tester
	 * @return <code>true</code> si la valeur a d�j� �t� rencontr�e, <code>false</code> sinon  
	 */
	public boolean lookup (final String valeur){
		return dict.contains(valeur);
	}
	
	/**
	 * {@inheritDoc}	  
	 */
//	@Override
//	public String getMessageErreur(){
//		return "Pas d'erreur";		
//	}
	/**{@inheritDoc}*/
	@Override
	public List<String> getListeParam() {
		return new ArrayList<String>();
	}
	
	/**{@inheritDoc}*/
	@Override
	public void clean(){
	    dict.clear();
	}
	
	/**Il est inutile de copier cette contrainte. <br>Elle sera automatiquement cr�e lors 
	 * de l'ajout de la r�f�rence en utilisant la fonction 
	 * {@link spark.reprise.outil.moteur.Fichier#addReference(String, spark.reprise.outil.moteur.Colonne)}
	 * @return une contrainte de type {@link ContrainteTRUE}
	 * */
	@Override
	public ContrainteTRUE copy() {
	    return new ContrainteTRUE();
	}


}