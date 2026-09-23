
package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.C_Aliments;
import controller.C_Materiels;
import modele.Aliments;
import modele.Materiel;

public class V_Panier extends JFrame implements ActionListener {

    private JLabel lblTitre;
    private JLabel lblAliments;
    private JLabel lblMateriels;

    private JTable tableauAliments;
    private JTable tableauMateriels;

    private JScrollPane scrollAliments;
    private JScrollPane scrollMateriels;
    private JButton btnSupprimerMateriel;
    private JTextField txtNomMateriel;
    private C_Materiels materielController;
    private C_Aliments alimentController;

    private JTextField txtNomAliment;
    private JButton btnSupprimerAliment;
  

    private JButton btnRetour;


    public V_Panier() {
    	  materielController = new C_Materiels();
    	  alimentController = new C_Aliments();

        setTitle("Mon panier");

        setSize(800, 600);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        // Positionnement manuel
        setLayout(null);


        // Titre
        lblTitre = new JLabel("Mon panier");
        lblTitre.setBounds(350, 20, 150, 30);
        add(lblTitre);


        // -------------------------
        // ALIMENTS
        // -------------------------

        lblAliments = new JLabel("Aliments");
        lblAliments.setBounds(50, 70, 150, 30);
        add(lblAliments);


        String[] colonnesAliments = {
            "ID",
            "Nom",
            "Quantité",
            "Date de péremption"
        };

        DefaultTableModel modeleAliments =
                new DefaultTableModel(colonnesAliments, 0);


        // Récupération des aliments du panier
        ArrayList<Aliments> lesAliments =
                alimentController.afficherPanierAliments();


        // Ajout des aliments dans le tableau
        for (Aliments aliment : lesAliments) {

            Object[] ligne = {
                aliment.getIdAliment(),
                aliment.getNom(),
                aliment.getQuantité(),
                aliment.getDate_P()
            };

            modeleAliments.addRow(ligne);
        }


        tableauAliments = new JTable(modeleAliments);

        scrollAliments = new JScrollPane(tableauAliments);

        scrollAliments.setBounds(50, 100, 700, 150);

        add(scrollAliments);


        // -------------------------
        // MATERIELS
        // -------------------------

        lblMateriels = new JLabel("Matériels");
        lblMateriels.setBounds(50, 270, 150, 30);
        add(lblMateriels);


        String[] colonnesMateriels = {
            "ID",
            "Nom",
            "Quantité"
        };

        DefaultTableModel modeleMateriels =
                new DefaultTableModel(colonnesMateriels, 0);


        // Récupération des matériels du panier
        ArrayList<Materiel> lesMateriels =
                materielController.afficherPanierMateriels();


        // Ajout des matériels dans le tableau
        for (Materiel materiel : lesMateriels) {

            Object[] ligne = {
                materiel.idMateriel(),
                materiel.getNom(),
                materiel.getQuantité()
            };

            modeleMateriels.addRow(ligne);
        }


        tableauMateriels = new JTable(modeleMateriels);

        scrollMateriels = new JScrollPane(tableauMateriels);

        scrollMateriels.setBounds(50, 300, 700, 150);

        add(scrollMateriels);


        // -------------------------
        // RETOUR
        // -------------------------

        btnRetour = new JButton("Retour");
        btnRetour.setBounds(50, 480, 100, 40);
        add(btnRetour);
        
        
        txtNomMateriel = new JTextField();
        txtNomMateriel.setBounds(250, 470, 200, 40);
        add(txtNomMateriel);

        btnSupprimerMateriel = new JButton("Supprimer");
        btnSupprimerMateriel.setBounds(470, 470, 120, 40);
        add(btnSupprimerMateriel);

        btnSupprimerMateriel.addActionListener(this);
        
        txtNomAliment = new JTextField();
        txtNomAliment.setBounds(250, 255, 200, 40);
        add(txtNomAliment);

        btnSupprimerAliment = new JButton("Supprimer");
        btnSupprimerAliment.setBounds(470, 255, 120, 40);
        add(btnSupprimerAliment);

        btnSupprimerAliment.addActionListener(this);

        

        btnRetour.addActionListener(this);


        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnRetour) {

            new Accueil();

            dispose();
        }
        else if (e.getSource() == btnSupprimerMateriel) {

            String nom = txtNomMateriel.getText();

            if (!nom.isEmpty()) {

                boolean resultat =
                		materielController.supprimerPanierMateriel(nom);

                if (resultat) {
                    System.out.println(
                        "Matériel supprimé du panier : " + nom
                    );

                    new V_Panier();
                    dispose();

                } else {
                    System.out.println(
                        "Matériel introuvable dans le panier."
                    );
                }

            } else {
                System.out.println(
                    "Veuillez saisir le nom du matériel."
                );
            }
        }
        else if (e.getSource() == btnSupprimerAliment) {

            String nom = txtNomAliment.getText();

            if (!nom.isEmpty()) {

                boolean resultat =
                        alimentController.supprimerPanierAliment(nom);

                if (resultat) {

                    System.out.println(
                        "Aliment supprimé du panier : " + nom
                    );

                    new V_Panier();
                    dispose();

                } else {

                    System.out.println(
                        "Aliment introuvable dans le panier."
                    );
                }

            } else {

                System.out.println(
                    "Veuillez saisir le nom de l'aliment."
                );
            }
        }
    }
}


