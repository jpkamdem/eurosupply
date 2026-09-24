package controller;

import java.util.ArrayList;

import modele.Medical;

import modele.Modele;

public class C_Medical {

    public ArrayList<Medical> afficherMedical() {

        return Modele.afficherMedical();

    }


    public boolean ajouterPanierMedical(
            int idMedical,
            String nom,
            int quantité) {

        return Modele.ajouterPanierMedical(
            idMedical,
            nom,
            quantité
        );

    }


    public ArrayList<Medical> afficherPanierMedicaux() {

        return Modele.afficherPanierMedicaux();

    }


    public boolean supprimerPanierMedical(String nom) {

        return Modele.supprimerPanierMedical(nom);

    }
    public int getQuantiteTotaleMedicaux() {

        return Modele.getQuantiteTotaleMedicaux();
    }

}