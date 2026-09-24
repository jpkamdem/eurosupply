package controller;

import java.util.ArrayList;

import modele.Aliments;
import modele.Modele;

public class C_Aliments {
	public ArrayList <Aliments> afficherAliment(){
		return Modele.afficherAliment();
	}
	public boolean ajouterPanier(int idAliment,String unNomAliment, int quantité) {
	    return Modele.ajouterPanierAliment(idAliment,unNomAliment,quantité);
	}
	public ArrayList<Aliments> afficherPanierAliments() {
	    return Modele.afficherPanierAliments();
	}
	 public boolean supprimerPanierAliment(String nom) {
	        return Modele.supprimerPanierAliment(nom);
	    }
	 public int getQuantiteTotaleAliments() {

		    return Modele.getQuantiteTotaleAliments();
		}
	
}
