package TheaterSimplon;

import java.util.Scanner;

public class MainActivity {

	/** Enonce
	 * Avoir 8 ranges (une table de 8) sur 9 (sur une table de 9) = un double tableau
	 * un client doit pouvoir choisir la 1er range avec le nombre de place voulu 
	 * SI il n'y a plus de place sur la rangé, l'utilisateur doit etre prevenu
	 */
	
	/** les points et idees
	 * donner a l'utilisateur la possibilite de choisir sa range
	 * donner a l'utilisateur la possibilite de choisir le nombre de place
	 * 
	 * faire une variable comprise entre 0 et le nombre de la range
	 * l'organisation commencera toujours par l'emplacement0 (tab[0])
	 * 0 >= choix =< 8
	 * 
	 * 1er commande
	 * selon le num de la range, il faudra faire : placeMax - nbPlace = placeRest
	 * Si placeRest = 0 alors "il n'y a plus de place"
	 * Si placeRest = plus grand que 0 alors il y a de place et donc valider le choix
	 * Si placeRest = plus petit que 0 alors "plus de place" (revenir a la demande et indiquer le Nb de place restante sur la range)
	 * 
	 * 2e commande
	 * selon le num de la range, il faudra faire : placeRest - placeMax = Indication "il n'y a pas assez de place" indiquer pour l'utilisateur le nombre de places restantent
	 * 
	 * idee graphique "tab[i]" | [ "O" ] puis "tab[i]" | [ "X" ]
	 */
	
	static Scanner scan = new Scanner(System.in);
	static boolean isContinue = true;
	
	public static void main(String[] args) {

		//présentation graphique basic
		int[][] tableau;
		//variable pour naviguer dans le tableau
		int i, j;
		
		String varLibre = "O";
		String varChoisi = "X";
		int rangMax = 8;
		int placeMax = 9;
		


		System.out.println("Nombre de places dans le cinema");
		tableau = new int[rangMax][placeMax];
		for (i = 0; i < tableau.length;  i++) {
			// j'ai mis une range en +1 pour que le client n'est pas a se dire qu'il y a un rang 0
			System.out.print("Rangée "+ (i+1) + " | ");
			for (j = 0;j < tableau[ i].length;j++) {
				System.out.print("[ "+ varLibre + " ]");
			}
			System.out.println();
		}
		System.out.println();
		
		
		//interface utilisateur
//possibilite de faire une boucle infini pour eviter de relancer l'application
		
		while(isContinue != false) {
	
			int[][] tabClient;
			
			System.out.println("Dans quelle rangée voulez-vous être? (Il y a "+ rangMax + " rangées).");
			int rangeClient = scan.nextInt();
			//verification de la range
			/*	idees
			 * chaques ranges ont un calcul de places bien a eux
			 * memoriser les calcules pour chaque ranges
			 */

			if(0 < rangeClient && rangeClient <= (rangMax)) {
				System.out.println("Rangée : "+ rangeClient);
				System.out.println();
//verification de la range reussite
				
				//verifier s'il y a des places deja existantent
				int placeExist = 0;
				placeExist = placeMax;
				System.out.println("Combien de place(s) voulez-vous? (Il en reste " + placeExist + " dans cette rangée).");
				int nbPlaceClient = scan.nextInt();
				
				if(nbPlaceClient > 0 && nbPlaceClient <= placeExist) {
					placeExist = placeExist - nbPlaceClient;
					System.out.println("Nombre de place choisi : "+ nbPlaceClient + " il en reste : "+ placeExist +".");
					System.out.println();				
					
						
//lancer les nouvelles places
									
					tableau = new int[rangMax][placeMax];
					for (i = 0; i < tableau.length;  i++) {
						System.out.print("Rangée "+ (i + 1) + " | ");
						// j'ai mis -1 sur le rangeClient car le tableau commence a 0 et il est rare qu'un client sache que les rang commence a 0
						if(i == (rangeClient - 1)) {
							for(j = 0; j < nbPlaceClient; j++) {
								System.out.print("[ "+ varChoisi + " ]");
							}
							for(j = nbPlaceClient; j < (tableau[ i].length); j++) {
								System.out.print("[ "+ varLibre + " ]");
							}
						}else {
							for (j = 0;j < tableau[ i].length;j++) {
								System.out.print("[ "+ varLibre + " ]");
							}
						}
						
						System.out.println();

					}
					System.out.println();
						
// sortir de la boucle
					retry();
					
				}else {
					System.out.println("Il n'y a pas assez de places (recommencez votre choix).");
					retry();
				}
					
			} else {
				// il faut relancer le programme
				System.out.println("Vous n'avez pas choisi la bonne rangée (recommencez votre choix).");
				retry();
			}
	
		} //fin boucle
		
	} //fin static
	
	static void retry() {
		System.out.println("Voulez vous continuer? (pressez o ou O pour continuer)");
		String vrai1 = "o";
		String vrai2 = "O";
		String validation = scan.next();
		if(validation.equals(vrai1)||validation.equals(vrai2)) {
			isContinue = true;
		}else {
			isContinue = false;
		}
	}
} // fin classe


