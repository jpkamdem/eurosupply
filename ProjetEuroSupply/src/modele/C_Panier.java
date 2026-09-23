package modele;

import java.util.ArrayList;

import modele.Aliments;
import modele.Materiel;

public class C_Panier {

    private ArrayList<Aliments> lesAliments;
    private ArrayList<Materiel> lesMateriels;

    public C_Panier() {
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