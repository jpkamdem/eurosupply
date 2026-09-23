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
import modele.Aliments;

public class V_Aliment extends JFrame implements ActionListener {

    private C_Aliments alimentController;

    private JLabel lblTitre;
    private JLabel lblNom;

    private JTable tableauAliments;
    private JScrollPane scrollPane;

    private JButton btnRetour;
    private JButton btnConsulterMateriels;
    private JButton btnAjouterAliment;
    private JButton btnPanier;

    private JTextField txtQuantite;
    private JTextField txtNom;

    private ArrayList<Aliments> lesAliments;


    public V_Aliment() {

        alimentController = new C_Aliments();

        setTitle("Gestion des aliments");

        setSize(800, 600);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        // Positionnement manuel
        setLayout(null);


        // Titre
        lblTitre = new JLabel("Catalogue des aliments");
        lblTitre.setBounds(300, 30, 250, 40);
        add(lblTitre);


        // Tableau
        String[] colonnes = {
            "ID",
            "Nom",
            "Quantité",
            "Date de péremption"
        };

        DefaultTableModel modeleTableau =
                new DefaultTableModel(colonnes, 0);


        // Récupération des aliments
        lesAliments = alimentController.afficherAliment();


        // Ajout des aliments dans le tableau
        for (Aliments aliment : lesAliments) {

            Object[] ligne = {
                aliment.getIdAliment(),
                aliment.getNom(),
                aliment.getQuantité(),
                aliment.getDate_P()
            };

            modeleTableau.addRow(ligne);
        }


        tableauAliments = new JTable(modeleTableau);

        scrollPane = new JScrollPane(tableauAliments);

        scrollPane.setBounds(50, 100, 700, 280);

        add(scrollPane);


        // Label Nom
        lblNom = new JLabel("Nom de l'aliment :");
        lblNom.setBounds(50, 400, 120, 30);
        add(lblNom);


        // Champ Nom
        txtNom = new JTextField();
        txtNom.setBounds(170, 400, 150, 30);
        add(txtNom);


        // Label Quantité
        JLabel lblQuantite = new JLabel("Quantité :");
        lblQuantite.setBounds(330, 400, 70, 30);
        add(lblQuantite);


        // Champ Quantité
        txtQuantite = new JTextField();
        txtQuantite.setBounds(400, 400, 80, 30);
        add(txtQuantite);


        // Bouton Ajouter
        btnAjouterAliment = new JButton("Ajouter");
        btnAjouterAliment.setBounds(490, 400, 100, 30);
        add(btnAjouterAliment);
        btnAjouterAliment.addActionListener(this);


        // Bouton Panier
        btnPanier = new JButton("Panier");
        btnPanier.setBounds(600, 400, 100, 30);
        add(btnPanier);
        btnPanier.addActionListener(this);


        // Bouton Retour
        btnRetour = new JButton("Retour");
        btnRetour.setBounds(50, 450, 100, 40);
        add(btnRetour);
        btnRetour.addActionListener(this);


        // Bouton Consulter Matériels
        btnConsulterMateriels = new JButton("Consulter Materiels");
        btnConsulterMateriels.setBounds(170, 450, 150, 40);
        add(btnConsulterMateriels);
        btnConsulterMateriels.addActionListener(this);


        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // Retour
        if (e.getSource() == btnRetour) {

            new Accueil();
            dispose();
        }


        // Consulter les matériels
        else if (e.getSource() == btnConsulterMateriels) {

            new V_Materiel();
            dispose();
        }


        // Ajouter l'aliment au panier
        else if (e.getSource() == btnAjouterAliment) {

            String nom = txtNom.getText();

            String quantiteTexte = txtQuantite.getText();

            boolean trouve = false;

            if (!quantiteTexte.isEmpty()) {

                int quantité = Integer.parseInt(quantiteTexte);

                for (Aliments aliment : lesAliments) {

                    if (aliment.getNom().equalsIgnoreCase(nom)) {

                        boolean resultat = alimentController.ajouterPanier(
                                aliment.getIdAliment(),
                                aliment.getNom(),
                                quantité
                        );

                        if (resultat) {

                            System.out.println(
                                "Aliment ajouté au panier : "
                                + aliment.getNom()
                                + " | Quantité : "
                                + quantité
                            );
                        }

                        trouve = true;

                        break;
                    }
                }

                if (!trouve) {

                    System.out.println("Aliment introuvable.");
                }
            }

            else {

                System.out.println("Veuillez saisir une quantité.");
            }
        }

        // Ouvrir le panier
        else if (e.getSource() == btnPanier) {

            new V_Panier();
            dispose();
        }
    }
}