package controller;

import modele.Modele;

public class C_Utilisateur {

    public boolean testConnexionFoodTech(String login, String mdp) {

        return Modele.testConnexionFoodTech(login, mdp);

    }
}