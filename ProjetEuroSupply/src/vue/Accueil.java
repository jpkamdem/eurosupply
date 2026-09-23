
package vue;

import modele.panier;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Accueil extends JFrame implements ActionListener {

    private JButton btnAliment;
    private JButton btnMateriel;
    private static panier panier = new panier();
    private JButton btnPanier;

    public static panier getPanier() {
        return panier;
    }

    public Accueil() {

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
        btnPanier = new JButton("Panier");

        // Style des boutons
        btnAliment.setFont(new Font("Arial", Font.BOLD, 16));
        btnMateriel.setFont(new Font("Arial", Font.BOLD, 16));
        btnPanier.setFont(new Font("Arial", Font.BOLD, 16));

        btnAliment.setForeground(Color.WHITE);
        btnMateriel.setForeground(Color.WHITE);
        btnPanier.setForeground(Color.WHITE);

        btnAliment.setBackground(new Color(52, 152, 219));
        btnMateriel.setBackground(new Color(46, 204, 113));
        btnPanier.setBackground(new Color(230, 126, 34));

        // Enlever la bordure
        btnAliment.setFocusPainted(false);
        btnMateriel.setFocusPainted(false);
        btnPanier.setFocusPainted(false);

        // Position des boutons
        btnAliment.setBounds(180, 230, 200, 70);
        btnMateriel.setBounds(420, 230, 200, 70);
        btnPanier.setBounds(300, 340, 200, 70);

        // Ajout des boutons
        add(btnAliment);
        add(btnMateriel);
        add(btnPanier);

        // Ajout des écouteurs
        btnAliment.addActionListener(this);
        btnMateriel.addActionListener(this);
        btnPanier.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAliment) {

            new V_Aliment();
            dispose();

        }
        else if (e.getSource() == btnMateriel) {

            new V_Materiel();
            dispose();

        }
        else if (e.getSource() == btnPanier) {

            new V_Panier();
            dispose();
        }
    }
}

