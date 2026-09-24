package vue;

import javax.swing.JOptionPane;

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

import controller.C_Medical;

import modele.Aliments;

import modele.Materiel;

import modele.Medical;

import modele.Modele;

public class V_Panier extends JFrame implements ActionListener {

    private JLabel lblTitre;

    private JLabel lblAliments;

    private JLabel lblMateriels;

    private JLabel lblMedicaux;

    private JTable tableauAliments;

    private JTable tableauMateriels;

    private JTable tableauMedicaux;

    private JScrollPane scrollAliments;

    private JScrollPane scrollMateriels;

    private JScrollPane scrollMedicaux;

    private JButton btnSupprimerMateriel;

    private JTextField txtNomMateriel;

    private C_Materiels materielController;

    private C_Aliments alimentController;

    private C_Medical medicalController;

    private JTextField txtNomAliment;

    private JButton btnSupprimerAliment;

    private JTextField txtNomMedical;

    private JButton btnSupprimerMedical;

    private JButton btnValiderPanier;

    private JButton btnRetour;


    public V_Panier() {

        materielController = new C_Materiels();

        alimentController = new C_Aliments();

        medicalController = new C_Medical();


        setTitle("Mon panier");

        setSize(800, 850);

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

        scrollAliments.setBounds(50, 100, 700, 130);

        add(scrollAliments);


        // -------------------------

        // SUPPRIMER ALIMENT

        // -------------------------

        txtNomAliment = new JTextField();

        txtNomAliment.setBounds(250, 235, 200, 35);

        add(txtNomAliment);


        btnSupprimerAliment = new JButton("Supprimer");

        btnSupprimerAliment.setBounds(470, 235, 120, 35);

        add(btnSupprimerAliment);

        btnSupprimerAliment.addActionListener(this);


        // -------------------------

        // MATERIELS

        // -------------------------

        lblMateriels = new JLabel("Matériels");

        lblMateriels.setBounds(50, 285, 150, 30);

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

        scrollMateriels.setBounds(50, 315, 700, 130);

        add(scrollMateriels);


        // -------------------------

        // SUPPRIMER MATERIEL

        // -------------------------

        txtNomMateriel = new JTextField();

        txtNomMateriel.setBounds(250, 450, 200, 35);

        add(txtNomMateriel);


        btnSupprimerMateriel = new JButton("Supprimer");

        btnSupprimerMateriel.setBounds(470, 450, 120, 35);

        add(btnSupprimerMateriel);

        btnSupprimerMateriel.addActionListener(this);


        // -------------------------

        // MEDICAUX

        // -------------------------

        lblMedicaux = new JLabel("Médicaux");

        lblMedicaux.setBounds(50, 500, 150, 30);

        add(lblMedicaux);


        String[] colonnesMedicaux = {

            "ID",

            "Nom",

            "Quantité",

            "Date de péremption"

        };

        DefaultTableModel modeleMedicaux =

                new DefaultTableModel(colonnesMedicaux, 0);


        // Récupération des médicaux du panier

        ArrayList<Medical> lesMedicaux =

                medicalController.afficherPanierMedicaux();


        // Ajout des médicaux dans le tableau

        for (Medical medical : lesMedicaux) {

            Object[] ligne = {

                medical.getIdMedical(),

                medical.getNom(),

                medical.getQuantité(),

                medical.getDatePeremption()

            };

            modeleMedicaux.addRow(ligne);

        }


        tableauMedicaux = new JTable(modeleMedicaux);

        scrollMedicaux = new JScrollPane(tableauMedicaux);

        scrollMedicaux.setBounds(50, 530, 700, 130);

        add(scrollMedicaux);


        // -------------------------

        // SUPPRIMER MEDICAL

        // -------------------------

        txtNomMedical = new JTextField();

        txtNomMedical.setBounds(250, 665, 200, 35);

        add(txtNomMedical);


        btnSupprimerMedical = new JButton("Supprimer");

        btnSupprimerMedical.setBounds(470, 665, 120, 35);

        add(btnSupprimerMedical);

        btnSupprimerMedical.addActionListener(this);


        // -------------------------

        // RETOUR

        // -------------------------

        btnRetour = new JButton("Retour");

        btnRetour.setBounds(50, 720, 100, 40);

        add(btnRetour);

        btnRetour.addActionListener(this);


        // -------------------------

        // VALIDER PANIER

        // -------------------------

        btnValiderPanier = new JButton("Valider le panier");

        btnValiderPanier.setBounds(550, 20, 180, 40);

        add(btnValiderPanier);

        btnValiderPanier.addActionListener(this);


        setVisible(true);

    }


    @Override

    public void actionPerformed(ActionEvent e) {

        // Retour

        if (e.getSource() == btnRetour) {

            new Accueil();

            dispose();

        }


        // Supprimer matériel

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

                }

                else {

                    System.out.println(

                        "Matériel introuvable dans le panier."

                    );

                }

            }

            else {

                System.out.println(

                    "Veuillez saisir le nom du matériel."

                );

            }

        }


        // Supprimer aliment

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

                }

                else {

                    System.out.println(

                        "Aliment introuvable dans le panier."

                    );

                }

            }

            else {

                System.out.println(

                    "Veuillez saisir le nom de l'aliment."

                );

            }

        }


        // Supprimer médical

        else if (e.getSource() == btnSupprimerMedical) {

            String nom = txtNomMedical.getText();

            if (!nom.isEmpty()) {

                boolean resultat =

                        medicalController.supprimerPanierMedical(nom);

                if (resultat) {

                    System.out.println(

                        "Médical supprimé du panier : " + nom

                    );

                    new V_Panier();

                    dispose();

                }

                else {

                    System.out.println(

                        "Médical introuvable dans le panier."

                    );

                }

            }

            else {

                System.out.println(

                    "Veuillez saisir le nom du médical."

                );

            }

        }


        // Valider panier

        else if (e.getSource() == btnValiderPanier) {

            boolean resultat = Modele.validerPanier();

            if (resultat) {

                JOptionPane.showMessageDialog(

                    this,

                    "Panier validé !"

                );

                new V_Panier();

                dispose();

            }

            else {

                JOptionPane.showMessageDialog(

                    this,

                    "Erreur lors de la validation du panier."

                );

            }

        }

    }

}