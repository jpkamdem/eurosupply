package vue;
import modele.panier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


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

        // Création des boutons
        btnAliment = new JButton("Aliments");
        btnMateriel = new JButton("Matériel");
        btnPanier = new JButton("Panier");
        btnPanier = new JButton("Panier");
        

        // Position des boutons
        btnAliment.setBounds(250, 250, 120, 50);
        btnMateriel.setBounds(430, 250, 120, 50);
        btnPanier.setBounds(340, 320, 120, 50);

        add(btnPanier);

       

        // On utilise le positionnement manuel
        setLayout(null);

        // Ajout des boutons à la fenêtre
        add(btnAliment);
        add(btnMateriel);

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

        } else if (e.getSource() == btnMateriel) {

            new V_Materiel();
            dispose();
        }
        else if (e.getSource() == btnPanier) {

            new V_Panier();
            dispose();
        }
    }
}