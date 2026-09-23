package modele;

import java.util.ArrayList;

public class panier {

    private ArrayList<Aliments> lesAliments;
    private ArrayList<Materiel> lesMateriels;

    public panier() {
        lesAliments = new ArrayList<Aliments>();
        lesMateriels = new ArrayList<Materiel>();
    }

    public void ajouterAliment(Aliments aliment) {
        lesAliments.add(aliment);
    }

    public void ajouterMateriel(Materiel materiel) {
        lesMateriels.add(materiel);
    }

    public ArrayList<Aliments> getLesAliments() {
        return lesAliments;
    }

    public ArrayList<Materiel> getLesMateriels() {
        return lesMateriels;
    }
}