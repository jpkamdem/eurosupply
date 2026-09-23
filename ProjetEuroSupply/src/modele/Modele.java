
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
                    "INSERT INTO panier "
                    + "(idAliment, nom, quantité) VALUES ("
                    + idAliment + ", '"
                    + unNomAliment + "', "
                    + quantité + ")";

                int result =
                        st.executeUpdate(query);

                return result > 0;

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
    }
   



    

    public static boolean ajouterPanierMateriel(
            int idMateriel,
            String unNomMateriel,
            int quantité) {

        if (quantité > 0 && quantité <= 3) {

            try {

                String query =
                    "INSERT INTO panier "
                    + "(idMateriel, nom, quantité) VALUES ("
                    + idMateriel + ", '"
                    + unNomMateriel + "', "
                    + quantité + ")";

                int result =
                        st.executeUpdate(query);

                return result > 0;

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
    }


    public static boolean supprimerPanierMateriel(
            String unNomPanierMateriel) {

        try {

            String query =
                "DELETE FROM panier "
                + "WHERE idMateriel IS NOT NULL "
                + "AND nom = '"
                + unNomPanierMateriel
                + "'";

            int result =
                    st.executeUpdate(query);

            return result > 0;

        } catch (SQLException erreur) {

            System.out.println(
                "Erreur lors de la suppression du materiel : "
                + erreur.getMessage()
            );

            return false;
        }
    }


    public static boolean supprimerPanierAliment(
            String unNomPanierAliment) {

        try {

            String query =
                "DELETE FROM panier "
                + "WHERE idAliment IS NOT NULL "
                + "AND nom = '"
                + unNomPanierAliment
                + "'";

            int result =
                    st.executeUpdate(query);

            return result > 0;

        } catch (SQLException erreur) {

            System.out.println(
                "Erreur lors de la suppression de l'aliment : "
                + erreur.getMessage()
            );

            return false;
        }
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
}


