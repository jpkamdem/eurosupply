package modele;

import java.util.Date;

public class Materiel {
	private int idMateriel;
    private String nom;
    private int quantité;
    
    public Materiel() {
    	
    }

    public Materiel(int idMateriel, String nom, int quantité) {

        this.idMateriel = idMateriel;
        this.nom = nom;
        this.quantité = quantité;
    }

    public int idMateriel() {
        return idMateriel;
    }

    public void setidMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }


}
