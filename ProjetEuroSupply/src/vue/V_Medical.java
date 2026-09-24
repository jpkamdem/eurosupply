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

import controller.C_Medical;
import modele.Medical;

public class V_Medical extends JFrame implements ActionListener {

    private C_Medical medicalController;

    private JLabel lblTitre;
    private JLabel lblNom;

    private JTable tableauMedicaux;
    private JScrollPane scrollPane;

    private JButton btnRetour;
    private JButton btnConsulterMateriels;
    private JButton btnConsulterAliments;
    private JButton btnAjouterMedical;
    private JButton btnPanier;

    private JTextField txtQuantite;
    private JTextField txtNom;

    private ArrayList<Medical> lesMedicaux;


    public V_Medical() {

        medicalController = new C_Medical();

        setTitle("Gestion des médicaux");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);


        // Titre

        lblTitre = new JLabel("Catalogue des médicaux");
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

        lesMedicaux = medicalController.afficherMedical();


        for (Medical medical : lesMedicaux) {

            Object[] ligne = {
                medical.getIdMedical(),
                medical.getNom(),
                medical.getQuantité(),
                medical.getDatePeremption()
            };

            modeleTableau.addRow(ligne);
        }


        tableauMedicaux = new JTable(modeleTableau);

        scrollPane = new JScrollPane(tableauMedicaux);
        scrollPane.setBounds(50, 100, 700, 280);
        add(scrollPane);


        // Nom

        lblNom = new JLabel("Nom du médical :");
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

        btnAjouterMedical = new JButton("Ajouter");
        btnAjouterMedical.setBounds(490, 400, 100, 30);
        add(btnAjouterMedical);
        btnAjouterMedical.addActionListener(this);


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


        // Consulter les matériels

        btnConsulterMateriels = new JButton("Consulter Materiels");
        btnConsulterMateriels.setBounds(170, 450, 150, 40);
        add(btnConsulterMateriels);
        btnConsulterMateriels.addActionListener(this);


        // Consulter les aliments

        btnConsulterAliments = new JButton("Consulter Aliments");
        btnConsulterAliments.setBounds(330, 450, 150, 40);
        add(btnConsulterAliments);
        btnConsulterAliments.addActionListener(this);


        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // Retour

        if (e.getSource() == btnRetour) {

            new Accueil();
            dispose();
        }


        // Aller vers les matériels

        else if (e.getSource() == btnConsulterMateriels) {

            new V_Materiel();
            dispose();
        }


        // Aller vers les aliments

        else if (e.getSource() == btnConsulterAliments) {

            new V_Aliment();
            dispose();
        }


        // Ajouter au panier

        else if (e.getSource() == btnAjouterMedical) {

            String nom = txtNom.getText();

            String quantiteTexte = txtQuantite.getText();

            boolean trouve = false;


            if (!quantiteTexte.isEmpty()) {

                int quantité = Integer.parseInt(quantiteTexte);


                for (Medical medical : lesMedicaux) {

                    if (medical.getNom().equalsIgnoreCase(nom)) {

                        boolean resultat =
                                medicalController.ajouterPanierMedical(
                                    medical.getIdMedical(),
                                    medical.getNom(),
                                    quantité
                                );


                        if (resultat) {

                            System.out.println(
                                "Médical ajouté au panier : "
                                + medical.getNom()
                                + " | Quantité : "
                                + quantité
                            );
                        }


                        trouve = true;

                        break;
                    }
                }


                if (!trouve) {

                    System.out.println("Médical introuvable.");
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