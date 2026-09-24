package controller;

import java.util.ArrayList;

import modele.Aliments;

import modele.Materiel;

import modele.Medical;

import modele.Modele;

public class C_Historique {

    public ArrayList<Aliments> afficherHistoriqueAliments() {

        return Modele.afficherHistoriqueAliments();

    }


    public ArrayList<Materiel> afficherHistoriqueMateriels() {

        return Modele.afficherHistoriqueMateriels();

    }


    public ArrayList<Medical> afficherHistoriqueMedicaux() {

        return Modele.afficherHistoriqueMedicaux();

    }

}