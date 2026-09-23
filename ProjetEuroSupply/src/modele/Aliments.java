package modele;

import java.util.Date;

public class Aliments {

    private int idAliment;
    private String nom;
    private int quantité;
    private Date date_P;
    
    public Aliments() {
    	
    }

    public Aliments(int idAliment, String nom, int quantité, Date date_P) {

        this.idAliment = idAliment;
        this.nom = nom;
        this.quantité = quantité;
        this.date_P = date_P;
    }

    public int getIdAliment() {
        return idAliment;
    }

    public void setIdAliment(int idAliment) {
        this.idAliment = idAliment;
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

    public Date getDate_P() {
        return date_P;
    }

    public void setDate_P(Date date_P) {
        this.date_P = date_P;
    }
}