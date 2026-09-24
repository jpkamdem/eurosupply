
package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class Modele {

    private static Connection connexion;
    private static ResultSet rs;
    private static Statement st;


    public static void connexion() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connexion = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/eurosupply?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC",
                "root",
                ""
            );

            st = connexion.createStatement();

            System.out.println("Connexion réussie à la base de données !");

        } catch (ClassNotFoundException erreur) {

            System.out.println("Driver non chargé ! " + erreur);

        } catch (SQLException erreur) {

            System.out.println(
                "La connexion à la base de données a échoué ou Erreur SQL : "
                + erreur
            );
        }
    }


    public static boolean testConnexionFoodTech(String login, String mdp) {

        boolean rep = false;

        try {

            String query =
                "SELECT * FROM utilisateur "
                + "WHERE login = ? "
                + "AND mdp = ? "
                + "AND type = 'Food-Tech'";

            PreparedStatement pst = connexion.prepareStatement(query);

            pst.setString(1, login);
            pst.setString(2, mdp);

            rs = pst.executeQuery();

            if (rs.next()) {

                rep = true;
            }

        } catch (SQLException erreur) {

            System.out.println(
                "Erreur SQL dans la vérification du Food-Tech : "
                + erreur.getMessage()
            );
        }

        return rep;
    }


    public static ArrayList<Aliments> afficherAliment() {

        ArrayList<Aliments> lesAliments =
                new ArrayList<Aliments>();

        try {

            String query =
                "SELECT * FROM alimentaire ORDER BY Date_P asc";

            rs = st.executeQuery(query);

            while (rs.next()) {

                int id = rs.getInt("id");

                String nom = rs.getString("nom");

                int quantité = rs.getInt("quantité");

                Date Date_P = rs.getDate("Date_P");

                lesAliments.add(
                    new Aliments(
                        id,
                        nom,
                        quantité,
                        Date_P
                    )
                );
            }

        } catch (SQLException erreur) {

            System.out.println(
                "Erreur lors de l'affichage des Aliments : "
                + erreur.getMessage()
            );
        }

        return lesAliments;
    }


    public static ArrayList<Materiel> afficherMateriel() {

        ArrayList<Materiel> lesMateriels =
                new ArrayList<Materiel>();

        try {

            String query = "Select * From materiel";

            rs = st.executeQuery(query);

            while (rs.next()) {

                int id = rs.getInt("id");

                String nom = rs.getString("nom");

                int quantité = rs.getInt("quantité");

                lesMateriels.add(
                    new Materiel(
                        id,
                        nom,
                        quantité
                    )
                );
            }

        } catch (SQLException erreur) {

            System.out.println(
                "Erreur lors de l'affichage des Materiels : "
                + erreur.getMessage()
            );
        }

        return lesMateriels;
    }


    
    public static boolean ajouterPanierAliment(
            int idAliment,
            String unNomAliment,
            int quantité) {

        if (quantité > 0 && quantité <= 3) {

            try {

                String query =
                    "SELECT quantité FROM alimentaire "
                    + "WHERE id = " + idAliment;

                rs = st.executeQuery(query);

                if (rs.next()) {

                    int quantiteDisponible =
                            rs.getInt("quantité");

                    if (quantité <= quantiteDisponible) {

                        String insert =
                            "INSERT INTO panier "
                            + "(idAliment, nom, quantité) VALUES ("
                            + idAliment + ", '"
                            + unNomAliment + "', "
                            + quantité + ")";

                        int result =
                                st.executeUpdate(insert);

                        if (result > 0) {

                            String update =
                                "UPDATE alimentaire "
                                + "SET quantité = quantité - "
                                + quantité
                                + " WHERE id = "
                                + idAliment;

                            st.executeUpdate(update);

                            return true;
                        }
                    }
                    else {

                        System.out.println(
                            "Stock insuffisant. Stock disponible : "
                            + quantiteDisponible
                        );

                        return false;
                    }
                }

            } catch (SQLException erreur) {

                System.out.println(
                    "Erreur lors de l'ajout de l'aliment au panier : "
                    + erreur.getMessage()
                );

                return false;
            }
        }
        else {

            System.out.println(
                "Quantité maximale : 3"
            );

            return false;
        }

        return false;
    }


    

    public static boolean ajouterPanierMateriel(
            int idMateriel,
            String unNomMateriel,
            int quantité) {

        if (quantité > 0 && quantité <= 3) {

            try {

                String query =
                    "SELECT quantité FROM materiel "
                    + "WHERE id = " + idMateriel;

                rs = st.executeQuery(query);

                if (rs.next()) {

                    int quantiteDisponible =
                            rs.getInt("quantité");

                    if (quantité <= quantiteDisponible) {

                        String insert =
                            "INSERT INTO panier "
                            + "(idMateriel, nom, quantité) VALUES ("
                            + idMateriel + ", '"
                            + unNomMateriel + "', "
                            + quantité + ")";

                        int result =
                                st.executeUpdate(insert);

                        if (result > 0) {

                            String update =
                                "UPDATE materiel "
                                + "SET quantité = quantité - "
                                + quantité
                                + " WHERE id = "
                                + idMateriel;

                            st.executeUpdate(update);

                            return true;
                        }
                    }
                    else {

                        System.out.println(
                            "Stock insuffisant. Stock disponible : "
                            + quantiteDisponible
                        );

                        return false;
                    }
                }

            } catch (SQLException erreur) {

                System.out.println(
                    "Erreur lors de l'ajout du matériel au panier : "
                    + erreur.getMessage()
                );

                return false;
            }
        }
        else {

            System.out.println(
                "Quantité maximale : 3"
            );

            return false;
        }

        return false;
    }
    public static boolean supprimerPanierMateriel(String unNomPanierMateriel) {

        try {

            String query =
                "SELECT idMateriel, quantité "
                + "FROM panier "
                + "WHERE idMateriel IS NOT NULL "
                + "AND nom = '"
                + unNomPanierMateriel
                + "'";

            rs = st.executeQuery(query);

            if (rs.next()) {

                int idMateriel = rs.getInt("idMateriel");
                int quantité = rs.getInt("quantité");

                String update =
                    "UPDATE materiel "
                    + "SET quantité = quantité + "
                    + quantité
                    + " WHERE id = "
                    + idMateriel;

                st.executeUpdate(update);

                String delete =
                    "DELETE FROM panier "
                    + "WHERE idMateriel = "
                    + idMateriel;

                int result =
                        st.executeUpdate(delete);

                return result > 0;
            }

        } catch (SQLException erreur) {

            System.out.println(
                "Erreur lors de la suppression du matériel : "
                + erreur.getMessage()
            );

            return false;
        }

        return false;
    }


    public static boolean supprimerPanierAliment(String unNomPanierAliment) {

        try {

            String query =
                "SELECT idAliment, quantité "
                + "FROM panier "
                + "WHERE idAliment IS NOT NULL "
                + "AND nom = '"
                + unNomPanierAliment
                + "'";

            rs = st.executeQuery(query);

            if (rs.next()) {

                int idAliment = rs.getInt("idAliment");
                int quantité = rs.getInt("quantité");

                String update =
                    "UPDATE alimentaire "
                    + "SET quantité = quantité + "
                    + quantité
                    + " WHERE id = "
                    + idAliment;

                st.executeUpdate(update);

                String delete =
                    "DELETE FROM panier "
                    + "WHERE idAliment = "
                    + idAliment;

                int result =
                        st.executeUpdate(delete);

                return result > 0;
            }

        } catch (SQLException erreur) {

            System.out.println(
                "Erreur lors de la suppression de l'aliment : "
                + erreur.getMessage()
            );

            return false;
        }

        return false;
    }

    public static ArrayList<Materiel> afficherPanierMateriels() {

        ArrayList<Materiel> lesMateriels =
                new ArrayList<Materiel>();

        try {

            String query =
                "SELECT materiel.id, materiel.nom, "
                + "panier.quantité "
                + "FROM panier "
                + "INNER JOIN materiel "
                + "ON panier.idMateriel = materiel.id "
                + "WHERE panier.idMateriel IS NOT NULL";

            rs = st.executeQuery(query);

            while (rs.next()) {

                int id = rs.getInt("id");

                String nom = rs.getString("nom");

                int quantité = rs.getInt("quantité");

                lesMateriels.add(
                    new Materiel(
                        id,
                        nom,
                        quantité
                    )
                );
            }

        } catch (SQLException erreur) {

            System.out.println(
                "Erreur lors de l'affichage des matériels du panier : "
                + erreur.getMessage()
            );
        }

        return lesMateriels;
    }


    public static ArrayList<Aliments> afficherPanierAliments() {

        ArrayList<Aliments> lesAliments =
                new ArrayList<Aliments>();

        try {

            String query =
                "SELECT alimentaire.id, alimentaire.nom, "
                + "panier.quantité, alimentaire.Date_P "
                + "FROM panier "
                + "INNER JOIN alimentaire "
                + "ON panier.idAliment = alimentaire.id "
                + "WHERE panier.idAliment IS NOT NULL";

            rs = st.executeQuery(query);

            while (rs.next()) {

                int id = rs.getInt("id");

                String nom = rs.getString("nom");

                int quantité = rs.getInt("quantité");

                Date Date_P = rs.getDate("Date_P");

                lesAliments.add(
                    new Aliments(
                        id,
                        nom,
                        quantité,
                        Date_P
                    )
                );
            }

        } catch (SQLException erreur) {

            System.out.println(
                "Erreur lors de l'affichage des aliments du panier : "
                + erreur.getMessage()
            );
        }

        return lesAliments;
    }
    public static boolean validerPanier() {

        try {

            String insertCommande =
                "INSERT INTO commande (statut) "
                + "VALUES ('Validée')";

            int resultat =
                    st.executeUpdate(
                        insertCommande,
                        Statement.RETURN_GENERATED_KEYS
                    );


            if (resultat > 0) {

                ResultSet generatedKeys =
                        st.getGeneratedKeys();

                int idCommande = 0;

                if (generatedKeys.next()) {

                    idCommande =
                            generatedKeys.getInt(1);
                }


                String query =
                    "SELECT idAliment, idMateriel, idMedical, quantité "
                    + "FROM panier";

                rs = st.executeQuery(query);


                Statement stCommande =
                        connexion.createStatement();


                while (rs.next()) {

                    int idAliment =
                            rs.getInt("idAliment");

                    int idMateriel =
                            rs.getInt("idMateriel");

                    int idMedical =
                            rs.getInt("idMedical");

                    int quantité =
                            rs.getInt("quantité");


                    // ALIMENT

                    if (idAliment != 0) {

                        String insert =
                            "INSERT INTO ligne_commande "
                            + "(id_commande, id_alimentaire, quantite) "
                            + "VALUES ("
                            + idCommande + ", "
                            + idAliment + ", "
                            + quantité + ")";

                        stCommande.executeUpdate(insert);
                    }


                    // MATERIEL

                    else if (idMateriel != 0) {

                        String insert =
                            "INSERT INTO ligne_commande "
                            + "(id_commande, id_materiel, quantite) "
                            + "VALUES ("
                            + idCommande + ", "
                            + idMateriel + ", "
                            + quantité + ")";

                        stCommande.executeUpdate(insert);
                    }


                    // MEDICAL

                    else if (idMedical != 0) {

                        String insert =
                            "INSERT INTO ligne_commande "
                            + "(id_commande, id_medical, quantite) "
                            + "VALUES ("
                            + idCommande + ", "
                            + idMedical + ", "
                            + quantité + ")";

                        stCommande.executeUpdate(insert);
                    }
                }


                stCommande.close();


                String delete =
                    "DELETE FROM panier";

                st.executeUpdate(delete);


                generatedKeys.close();

                return true;
            }

        } catch (SQLException erreur) {

            System.out.println(
                "Erreur lors de la validation du panier : "
                + erreur.getMessage()
            );

            return false;
        }
        
        return false;
    }
    public static ArrayList<Aliments> afficherHistoriqueAliments() {

        ArrayList<Aliments> lesAliments =
                new ArrayList<Aliments>();

        try {

            String query =
                "SELECT alimentaire.id, alimentaire.nom, "
                + "SUM(ligne_commande.quantite) AS quantité, "
                + "commande.date_commande "
                + "FROM ligne_commande "
                + "INNER JOIN alimentaire "
                + "ON ligne_commande.id_alimentaire = alimentaire.id "
                + "INNER JOIN commande "
                + "ON ligne_commande.id_commande = commande.id "
                + "WHERE commande.statut = 'Validée' "
                + "GROUP BY alimentaire.id, alimentaire.nom, "
                + "commande.date_commande";

            rs = st.executeQuery(query);

            while (rs.next()) {

                int id =
                    rs.getInt("id");

                String nom =
                    rs.getString("nom");

                int quantité =
                    rs.getInt("quantité");

                Date Date_P =
                    rs.getTimestamp("date_commande");

                lesAliments.add(

                    new Aliments(

                        id,
                        nom,
                        quantité,
                        Date_P

                    )

                );
            }

        } catch (SQLException erreur) {

            System.out.println(

                "Erreur lors de l'affichage de l'historique des aliments : "
                + erreur.getMessage()

            );
        }

        return lesAliments;
    }
    public static ArrayList<Materiel> afficherHistoriqueMateriels() {

        ArrayList<Materiel> lesMateriels =
                new ArrayList<Materiel>();

        try {

            String query =
                "SELECT materiel.id, materiel.nom, "
                + "SUM(ligne_commande.quantite) AS quantité "
                + "FROM ligne_commande "
                + "INNER JOIN materiel "
                + "ON ligne_commande.id_materiel = materiel.id "
                + "INNER JOIN commande "
                + "ON ligne_commande.id_commande = commande.id "
                + "WHERE commande.statut = 'Validée' "
                + "GROUP BY materiel.id, materiel.nom";

            rs = st.executeQuery(query);

            while (rs.next()) {

                int id =
                    rs.getInt("id");

                String nom =
                    rs.getString("nom");

                int quantité =
                    rs.getInt("quantité");

                lesMateriels.add(

                    new Materiel(

                        id,
                        nom,
                        quantité

                    )

                );
            }

        } catch (SQLException erreur) {

            System.out.println(

                "Erreur lors de l'affichage de l'historique des matériels : "
                + erreur.getMessage()

            );
        }

        return lesMateriels;
    }
    public static ArrayList<Medical> afficherMedical() {

        ArrayList<Medical> lesMedicaux =
                new ArrayList<Medical>();

        try {

            String query =
                "SELECT * FROM medical "
                + "ORDER BY date_peremption asc";

            rs = st.executeQuery(query);

            while (rs.next()) {

                int id =
                        rs.getInt("id");

                String nom =
                        rs.getString("nom");

                int quantité =
                        rs.getInt("quantite");

                Date datePeremption =
                        rs.getDate("date_peremption");

                lesMedicaux.add(

                    new Medical(
                        id,
                        nom,
                        quantité,
                        datePeremption
                    )

                );
            }

        } catch (SQLException erreur) {

            System.out.println(
                "Erreur lors de l'affichage des Medicaux : "
                + erreur.getMessage()
            );
        }

        return lesMedicaux;
    }
    public static boolean ajouterPanierMedical(
            int idMedical,
            String unNomMedical,
            int quantité) {

        if (quantité > 0 && quantité <= 3) {

            try {

                String query =
                    "SELECT quantite FROM medical "
                    + "WHERE id = " + idMedical;

                rs = st.executeQuery(query);

                if (rs.next()) {

                    int quantiteDisponible =
                            rs.getInt("quantite");

                    if (quantité <= quantiteDisponible) {

                        String insert =
                            "INSERT INTO panier "
                            + "(idMedical, nom, quantité) VALUES ("
                            + idMedical + ", '"
                            + unNomMedical + "', "
                            + quantité + ")";

                        int result =
                                st.executeUpdate(insert);

                        if (result > 0) {

                            String update =
                                "UPDATE medical "
                                + "SET quantite = quantite - "
                                + quantité
                                + " WHERE id = "
                                + idMedical;

                            st.executeUpdate(update);

                            return true;
                        }
                    }

                    else {

                        System.out.println(
                            "Stock insuffisant. Stock disponible : "
                            + quantiteDisponible
                        );

                        return false;
                    }
                }

            } catch (SQLException erreur) {

                System.out.println(
                    "Erreur lors de l'ajout du médical au panier : "
                    + erreur.getMessage()
                );

                return false;
            }
        }

        else {

            System.out.println(
                "Quantité maximale : 3"
            );

            return false;
        }

        return false;
    }
    public static ArrayList<Medical> afficherPanierMedicaux() {

        ArrayList<Medical> lesMedicaux =
                new ArrayList<Medical>();

        try {

            String query =
                "SELECT medical.id, medical.nom, "
                + "panier.quantité, medical.date_peremption "
                + "FROM panier "
                + "INNER JOIN medical "
                + "ON panier.idMedical = medical.id "
                + "WHERE panier.idMedical IS NOT NULL";

            rs = st.executeQuery(query);

            while (rs.next()) {

                int id =
                        rs.getInt("id");

                String nom =
                        rs.getString("nom");

                int quantité =
                        rs.getInt("quantité");

                Date datePeremption =
                        rs.getDate("date_peremption");

                lesMedicaux.add(

                    new Medical(
                        id,
                        nom,
                        quantité,
                        datePeremption
                    )

                );
            }

        } catch (SQLException erreur) {

            System.out.println(
                "Erreur lors de l'affichage des médicaux du panier : "
                + erreur.getMessage()
            );
        }

        return lesMedicaux;
    }
    public static boolean supprimerPanierMedical(String unNomPanierMedical) {

        try {

            String query =
                "SELECT idMedical, quantité "
                + "FROM panier "
                + "WHERE idMedical IS NOT NULL "
                + "AND nom = '"
                + unNomPanierMedical
                + "'";

            rs = st.executeQuery(query);

            if (rs.next()) {

                int idMedical =
                        rs.getInt("idMedical");

                int quantité =
                        rs.getInt("quantité");

                String update =
                    "UPDATE medical "
                    + "SET quantite = quantite + "
                    + quantité
                    + " WHERE id = "
                    + idMedical;

                st.executeUpdate(update);

                String delete =
                    "DELETE FROM panier "
                    + "WHERE idMedical = "
                    + idMedical;

                int result =
                        st.executeUpdate(delete);

                return result > 0;
            }

        } catch (SQLException erreur) {

            System.out.println(
                "Erreur lors de la suppression du médical : "
                + erreur.getMessage()
            );

            return false;
        }

        return false;
    }
    public static ArrayList<Medical> afficherHistoriqueMedicaux() {

        ArrayList<Medical> lesMedicaux =
                new ArrayList<Medical>();

        try {

            String query =
                "SELECT medical.id, medical.nom, "
                + "SUM(ligne_commande.quantite) AS quantité, "
                + "commande.date_commande "
                + "FROM ligne_commande "
                + "INNER JOIN medical "
                + "ON ligne_commande.id_medical = medical.id "
                + "INNER JOIN commande "
                + "ON ligne_commande.id_commande = commande.id "
                + "WHERE commande.statut = 'Validée' "
                + "GROUP BY medical.id, medical.nom, "
                + "commande.date_commande";

            rs = st.executeQuery(query);

            while (rs.next()) {

                int id =
                        rs.getInt("id");

                String nom =
                        rs.getString("nom");

                int quantité =
                        rs.getInt("quantité");

                Date dateCommande =
                        rs.getTimestamp("date_commande");

                lesMedicaux.add(
                    new Medical(
                        id,
                        nom,
                        quantité,
                        dateCommande
                    )
                );
            }

        } catch (SQLException erreur) {

            System.out.println(
                "Erreur lors de l'affichage de l'historique des médicaux : "
                + erreur.getMessage()
            );
        }

        return lesMedicaux;
    }
    public static int getQuantiteTotaleAliments() {

        int quantitéTotale = 0;

        try {

            String query =
                "SELECT SUM(quantité) AS total "
                + "FROM alimentaire";

            rs = st.executeQuery(query);

            if (rs.next()) {

                quantitéTotale = rs.getInt("total");
            }

            System.out.println(
                "Quantité totale des aliments : "
                + quantitéTotale
            );

        } catch (SQLException erreur) {

            System.out.println(
                "Erreur lors du calcul de la quantité totale des aliments : "
                + erreur.getMessage()
            );
        }

        return quantitéTotale;
    }
    public static int getQuantiteTotaleMateriels() {

        int quantitéTotale = 0;

        try {

            String query =
                "SELECT SUM(quantité) AS total "
                + "FROM materiel";

            rs = st.executeQuery(query);

            if (rs.next()) {

                quantitéTotale = rs.getInt("total");
            }

            System.out.println(
                "Quantité totale des matériels : "
                + quantitéTotale
            );

        } catch (SQLException erreur) {

            System.out.println(
                "Erreur lors du calcul de la quantité totale des matériels : "
                + erreur.getMessage()
            );
        }

        return quantitéTotale;
    }
    public static int getQuantiteTotaleMedicaux() {

        int quantitéTotale = 0;

        try {

            String query =
                "SELECT SUM(quantite) AS total "
                + "FROM medical";

            rs = st.executeQuery(query);

            if (rs.next()) {

                quantitéTotale = rs.getInt("total");
            }

            System.out.println(
                "Quantité totale des médicaux : "
                + quantitéTotale
            );

        } catch (SQLException erreur) {

            System.out.println(
                "Erreur lors du calcul de la quantité totale des médicaux : "
                + erreur.getMessage()
            );
        }

        return quantitéTotale;
    }
}


