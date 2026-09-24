
package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.C_Historique;

import modele.Aliments;
import modele.Materiel;
import modele.Medical;

public class V_Historique extends JFrame implements ActionListener {

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

    private JButton btnRetour;

    private C_Historique historiqueController;


    public V_Historique() {

        historiqueController = new C_Historique();

        setTitle("Historique des commandes");

        setSize(800, 800);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);


        // -------------------------
        // TITRE
        // -------------------------

        lblTitre = new JLabel("Historique des commandes");

        lblTitre.setBounds(300, 20, 250, 30);

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

            "Quantité commandée",

            "Date de commande"

        };


        DefaultTableModel modeleAliments =

                new DefaultTableModel(

                    colonnesAliments,

                    0

                );


        ArrayList<Aliments> lesAliments =

                historiqueController.afficherHistoriqueAliments();


        for (Aliments aliment : lesAliments) {

            Object[] ligne = {

                aliment.getIdAliment(),

                aliment.getNom(),

                aliment.getQuantité(),

                aliment.getDate_P()

            };

            modeleAliments.addRow(ligne);

        }


        tableauAliments =

                new JTable(modeleAliments);


        scrollAliments =

                new JScrollPane(tableauAliments);


        scrollAliments.setBounds(

            50,

            100,

            700,

            150

        );


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

            "Quantité commandée"

        };


        DefaultTableModel modeleMateriels =

                new DefaultTableModel(

                    colonnesMateriels,

                    0

                );


        ArrayList<Materiel> lesMateriels =

                historiqueController.afficherHistoriqueMateriels();


        for (Materiel materiel : lesMateriels) {

            Object[] ligne = {

                materiel.idMateriel(),

                materiel.getNom(),

                materiel.getQuantité()

            };

            modeleMateriels.addRow(ligne);

        }


        tableauMateriels =

                new JTable(modeleMateriels);


        scrollMateriels =

                new JScrollPane(tableauMateriels);


        scrollMateriels.setBounds(

            50,

            300,

            700,

            150

        );


        add(scrollMateriels);


        // -------------------------
        // MEDICAUX
        // -------------------------

        lblMedicaux = new JLabel("Médicaux");

        lblMedicaux.setBounds(50, 470, 150, 30);

        add(lblMedicaux);


        String[] colonnesMedicaux = {

            "ID",

            "Nom",

            "Quantité commandée",

            "Date de commande"

        };


        DefaultTableModel modeleMedicaux =

                new DefaultTableModel(

                    colonnesMedicaux,

                    0

                );


        ArrayList<Medical> lesMedicaux =

                historiqueController.afficherHistoriqueMedicaux();


        for (Medical medical : lesMedicaux) {

            Object[] ligne = {

                medical.getIdMedical(),

                medical.getNom(),

                medical.getQuantité(),

                medical.getDatePeremption()

            };

            modeleMedicaux.addRow(ligne);

        }


        tableauMedicaux =

                new JTable(modeleMedicaux);


        scrollMedicaux =

                new JScrollPane(tableauMedicaux);


        scrollMedicaux.setBounds(

            50,

            500,

            700,

            150

        );


        add(scrollMedicaux);


        // -------------------------
        // RETOUR
        // -------------------------

        btnRetour = new JButton("Retour");

        btnRetour.setBounds(50, 680, 100, 40);

        add(btnRetour);

        btnRetour.addActionListener(this);


        setVisible(true);

    }


    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnRetour) {

            new Accueil();

            dispose();

        }

    }

}


