package vue;

import modele.panier;

import java.awt.Color;

import java.awt.Font;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.C_Aliments;
import controller.C_Materiels;
import controller.C_Medical;

public class Accueil extends JFrame implements ActionListener {

    private JButton btnAliment;

    private JButton btnMateriel;

    private JButton btnMedical;

    private static panier panier = new panier();

    private JButton btnPanier;

    private JButton btnHistoComm;
    private C_Aliments alimentController;
    private C_Materiels materielController;
    private C_Medical medicalController;
    

    public static panier getPanier() {

        return panier;

    }

    public Accueil() {
    	alimentController = new C_Aliments();
    	materielController = new C_Materiels();
    	medicalController = new C_Medical();

        setTitle("Gestion du vaisseau spatial");

        setSize(800, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        // Positionnement manuel

        setLayout(null);

        // Couleur de fond

        getContentPane().setBackground(new Color(30, 40, 55));

        // Titre

        JLabel lblTitre = new JLabel("EUROSUPPLY");

        lblTitre.setBounds(250, 70, 300, 50);

        lblTitre.setHorizontalAlignment(JLabel.CENTER);

        lblTitre.setFont(new Font("Arial", Font.BOLD, 32));

        lblTitre.setForeground(Color.WHITE);

        add(lblTitre);

        // Sous-titre

        JLabel lblSousTitre = new JLabel("Gestion du vaisseau spatial");

        lblSousTitre.setBounds(250, 120, 300, 30);

        lblSousTitre.setHorizontalAlignment(JLabel.CENTER);

        lblSousTitre.setFont(new Font("Arial", Font.PLAIN, 16));

        lblSousTitre.setForeground(new Color(190, 200, 215));

        add(lblSousTitre);

        // Création des boutons

        btnAliment = new JButton("Aliments");

        btnMateriel = new JButton("Matériel");

        btnMedical = new JButton("Médical");

        btnPanier = new JButton("Panier");

        btnHistoComm = new JButton("Historique");

        // Style des boutons

        btnAliment.setFont(new Font("Arial", Font.BOLD, 16));

        btnMateriel.setFont(new Font("Arial", Font.BOLD, 16));

        btnMedical.setFont(new Font("Arial", Font.BOLD, 16));

        btnPanier.setFont(new Font("Arial", Font.BOLD, 16));

        btnHistoComm.setFont(new Font("Arial", Font.BOLD, 16));

        btnAliment.setForeground(Color.WHITE);

        btnMateriel.setForeground(Color.WHITE);

        btnMedical.setForeground(Color.WHITE);

        btnPanier.setForeground(Color.WHITE);

        btnHistoComm.setForeground(Color.WHITE);

        btnAliment.setBackground(new Color(52, 152, 219));

        btnMateriel.setBackground(new Color(46, 204, 113));

        btnMedical.setBackground(new Color(231, 76, 60));

        btnPanier.setBackground(new Color(230, 126, 34));

        btnHistoComm.setBackground(new Color(155, 89, 182));

        // Enlever la bordure

        btnAliment.setFocusPainted(false);

        btnMateriel.setFocusPainted(false);

        btnMedical.setFocusPainted(false);

        btnPanier.setFocusPainted(false);

        btnHistoComm.setFocusPainted(false);

        // Position des boutons

        btnAliment.setBounds(180, 210, 200, 70);

        btnMateriel.setBounds(420, 210, 200, 70);

        btnMedical.setBounds(300, 300, 200, 70);

        btnPanier.setBounds(180, 400, 200, 70);

        btnHistoComm.setBounds(420, 400, 200, 70);

        // Ajout des boutons

        add(btnAliment);

        add(btnMateriel);

        add(btnMedical);

        add(btnPanier);

        add(btnHistoComm);

        // Ajout des écouteurs

        btnAliment.addActionListener(this);

        btnMateriel.addActionListener(this);

        btnMedical.addActionListener(this);

        btnPanier.addActionListener(this);

        btnHistoComm.addActionListener(this);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAliment) {

            int quantitéTotale =
                    alimentController.getQuantiteTotaleAliments();

            if (quantitéTotale < 25) {

                JOptionPane.showMessageDialog(
                    this,
                    "ALERTE CRITIQUE !\n\n"
                    + "La quantité totale des aliments est de "
                    + quantitéTotale
                    + ".\n\n"
                    + "Le stock est très faible. "
                    + "Veuillez commander rapidement.",
                    "Stock critique",
                    JOptionPane.WARNING_MESSAGE
                );
            }
            else if (quantitéTotale >= 25
                    && quantitéTotale <= 500) {

                JOptionPane.showMessageDialog(
                    this,
                    "Attention !\n\n"
                    + "Il reste "
                    + quantitéTotale
                    + " produits alimentaires au total.\n\n"
                    + "Il ne reste pas beaucoup de produits, "
                    + "veuillez penser à commander.",
                    "Stock faible",
                    JOptionPane.WARNING_MESSAGE
                );
            }

            new V_Aliment();
            dispose();
        }

        else if (e.getSource() == btnMateriel) {

            int quantitéTotale =
                    materielController.getQuantiteTotaleMateriels();

            if (quantitéTotale < 200) {

                JOptionPane.showMessageDialog(
                    this,
                    "ALERTE CRITIQUE !\n\n"
                    + "La quantité totale des matériels est de "
                    + quantitéTotale
                    + ".\n\n"
                    + "Le stock est très faible. "
                    + "Veuillez commander rapidement.",
                    "Stock critique",
                    JOptionPane.WARNING_MESSAGE
                );
            }
            else if (quantitéTotale >= 200
                    && quantitéTotale <= 2000) {

                JOptionPane.showMessageDialog(
                    this,
                    "Attention !\n\n"
                    + "Il reste "
                    + quantitéTotale
                    + " matériels au total.\n\n"
                    + "Il ne reste pas beaucoup de produits, "
                    + "veuillez penser à commander.",
                    "Stock faible",
                    JOptionPane.WARNING_MESSAGE
                );
            }

            new V_Materiel();
            dispose();
        }

        else if (e.getSource() == btnMedical) {

            int quantitéTotale =
                    medicalController.getQuantiteTotaleMedicaux();

            if (quantitéTotale < 500) {

                JOptionPane.showMessageDialog(
                    this,
                    "ALERTE CRITIQUE !\n\n"
                    + "La quantité totale des médicaux est de "
                    + quantitéTotale
                    + ".\n\n"
                    + "Le stock est très faible. "
                    + "Veuillez commander rapidement.",
                    "Stock critique",
                    JOptionPane.WARNING_MESSAGE
                );
            }
            else if (quantitéTotale >= 25
                    && quantitéTotale <= 50) {

                JOptionPane.showMessageDialog(
                    this,
                    "Attention !\n\n"
                    + "Il reste "
                    + quantitéTotale
                    + " produits médicaux au total.\n\n"
                    + "Il ne reste pas beaucoup de produits, "
                    + "veuillez penser à commander.",
                    "Stock faible",
                    JOptionPane.WARNING_MESSAGE
                );
            }

            new V_Medical();
            dispose();
        }

        else if (e.getSource() == btnPanier) {

            new V_Panier();
            dispose();
        }

        else if (e.getSource() == btnHistoComm) {

            new V_Historique();
            dispose();
        }
    }

}