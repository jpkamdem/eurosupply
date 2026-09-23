package controller;

import java.util.ArrayList;

import modele.Materiel;
import modele.Modele;

public class C_Materiels {
	public ArrayList <Materiel> afficherMateriel(){
		return Modele.afficherMateriel();

	}
	public boolean ajouterPanier(int idMateriel, String unNomMateriel,int quantité) {
	    return Modele.ajouterPanierMateriel(idMateriel, unNomMateriel,quantité);
	}
public boolean supprimerPanierMateriel(String unNomPanierMateriel) {
	return Modele.supprimerPanierMateriel(unNomPanierMateriel);
}
public ArrayList<Materiel> afficherPanierMateriels() {
    return Modele.afficherPanierMateriels();
}
	
}
