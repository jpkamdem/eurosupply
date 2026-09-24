package modele;

import java.util.Date;

public class Medical {

    private int idMedical;
    private String nom;
    private int quantité;
    private Date datePeremption;

    public Medical(
            int idMedical,
            String nom,
            int quantité,
            Date datePeremption) {

        this.idMedical = idMedical;
        this.nom = nom;
        this.quantité = quantité;
        this.datePeremption = datePeremption;
    }

    public int getIdMedical() {
        return idMedical;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantité() {
        return quantité;
    }

    public Date getDatePeremption() {
        return datePeremption;
    }
}