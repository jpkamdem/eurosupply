
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

import controller.C_Materiels;
import modele.Materiel;

public class V_Materiel extends JFrame implements ActionListener {

    private C_Materiels materielController;

    private JLabel lblTitre;
    private JLabel lblNom;

    private JTable tableauMateriel;
    private JScrollPane scrollPane;

    private JButton btnRetour;
    private JButton btnConsulterAliments;
    private JButton btnConsulterMedicaux;
    private JButton btnAjouterMateriel;
    private JButton btnPanier;

    private JTextField txtQuantite;
    private JTextField txtNom;

    private ArrayList<Materiel> lesMateriels;


    public V_Materiel() {

        materielController = new C_Materiels();

        setTitle("Gestion des materiels");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);


        // Titre

        lblTitre = new JLabel("Catalogue des materiels");
        lblTitre.setBounds(300, 30, 250, 40);
        add(lblTitre);


        // Tableau

        String[] colonnes = {
            "ID",
            "Nom",
            "Quantité"
        };

        DefaultTableModel modeleTableau =
                new DefaultTableModel(colonnes, 0);

        lesMateriels = materielController.afficherMateriel();


        for (Materiel materiel : lesMateriels) {

            Object[] ligne = {
                materiel.idMateriel(),
                materiel.getNom(),
                materiel.getQuantité()
            };

            modeleTableau.addRow(ligne);
        }


        tableauMateriel = new JTable(modeleTableau);

        scrollPane = new JScrollPane(tableauMateriel);
        scrollPane.setBounds(50, 100, 700, 280);
        add(scrollPane);


        // Nom

        lblNom = new JLabel("Nom du matériel :");
        lblNom.setBounds(50, 400, 120, 30);
        add(lblNom);


        txtNom = new JTextField();
        txtNom.setBounds(170, 400, 150, 30);
        add(txtNom);


        // Quantité

        JLabel lblQuantite = new JLabel("Quantité :");
        lblQuantite.setBounds(330, 400, 70, 30);
        add(lblQuantite);


        txtQuantite = new JTextField();
        txtQuantite.setBounds(400, 400, 80, 30);
        add(txtQuantite);


        // Ajouter

        btnAjouterMateriel = new JButton("Ajouter");
        btnAjouterMateriel.setBounds(490, 400, 100, 30);
        add(btnAjouterMateriel);
        btnAjouterMateriel.addActionListener(this);


        // Panier

        btnPanier = new JButton("Panier");
        btnPanier.setBounds(600, 400, 100, 30);
        add(btnPanier);
        btnPanier.addActionListener(this);


        // Retour

        btnRetour = new JButton("Retour");
        btnRetour.setBounds(50, 450, 100, 40);
        add(btnRetour);
        btnRetour.addActionListener(this);


        // Consulter les aliments

        btnConsulterAliments = new JButton("Consulter Aliments");
        btnConsulterAliments.setBounds(170, 450, 150, 40);
        add(btnConsulterAliments);
        btnConsulterAliments.addActionListener(this);


        // Consulter les médicaux

        btnConsulterMedicaux = new JButton("Consulter Médicaux");
        btnConsulterMedicaux.setBounds(330, 450, 150, 40);
        add(btnConsulterMedicaux);
        btnConsulterMedicaux.addActionListener(this);


        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // Retour

        if (e.getSource() == btnRetour) {

            new Accueil();
            dispose();
        }


        // Aller vers les aliments

        else if (e.getSource() == btnConsulterAliments) {

            new V_Aliment();
            dispose();
        }


        // Aller vers les médicaux

        else if (e.getSource() == btnConsulterMedicaux) {

            new V_Medical();
            dispose();
        }


        // Ajouter au panier

        else if (e.getSource() == btnAjouterMateriel) {

            String nom = txtNom.getText();

            String quantiteTexte = txtQuantite.getText();

            boolean trouve = false;


            if (!quantiteTexte.isEmpty()) {

                int quantite = Integer.parseInt(quantiteTexte);


                for (Materiel materiel : lesMateriels) {

                    if (materiel.getNom().equalsIgnoreCase(nom)) {

                        boolean resultat =
                                materielController.ajouterPanier(
                                    materiel.idMateriel(),
                                    materiel.getNom(),
                                    quantite
                                );


                        if (resultat) {

                            System.out.println(
                                "Matériel ajouté au panier : "
                                + materiel.getNom()
                                + " | Quantité : "
                                + quantite
                            );
                        }


                        trouve = true;

                        break;
                    }
                }


                if (!trouve) {

                    System.out.println("Matériel introuvable.");
                }
            }

            else {

                System.out.println("Veuillez saisir une quantité.");
            }
        }


        // Panier

        else if (e.getSource() == btnPanier) {

            new V_Panier();
            dispose();
        }
    }
}

