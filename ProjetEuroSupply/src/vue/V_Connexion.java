package vue;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.C_Utilisateur;

public class V_Connexion extends JFrame implements ActionListener {

    private C_Utilisateur utilisateurController;

    private JLabel lblTitre;
    private JLabel lblLogin;
    private JLabel lblMdp;

    private JTextField txtLogin;
    private JPasswordField txtMdp;

    private JButton btnConnexion;


    public V_Connexion() {

        utilisateurController = new C_Utilisateur();

        setTitle("Connexion Food-Tech");

        setSize(500, 350);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);



        
        ImageIcon image = new ImageIcon("images/EuroSupply.png");

        Image imageRedimensionnee = image.getImage().getScaledInstance(
                200,
                70,
                Image.SCALE_SMOOTH
        );

        ImageIcon imageFinale = new ImageIcon(imageRedimensionnee);

        JLabel lblImage = new JLabel(imageFinale);
        lblImage.setBounds(150, 20, 200, 70);
        add(lblImage);


        // Login
        lblLogin = new JLabel("Login :");
        lblLogin.setBounds(80, 100, 100, 30);
        add(lblLogin);

        txtLogin = new JTextField();
        txtLogin.setBounds(180, 100, 200, 30);
        add(txtLogin);


        // Mot de passe
        lblMdp = new JLabel("Mot de passe :");
        lblMdp.setBounds(80, 150, 100, 30);
        add(lblMdp);

        txtMdp = new JPasswordField();
        txtMdp.setBounds(180, 150, 200, 30);
        add(txtMdp);


        // Bouton connexion
        btnConnexion = new JButton("Se connecter");
        btnConnexion.setBounds(180, 210, 150, 40);
        add(btnConnexion);
        btnConnexion.addActionListener(this);


        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnConnexion) {

            String login = txtLogin.getText();
            String mdp = new String(txtMdp.getPassword());

            boolean resultat =
                    utilisateurController.testConnexionFoodTech(
                            login,
                            mdp
                    );

            if (resultat) {

                System.out.println("Connexion réussie !");

                new Accueil();
                dispose();
            }
            else {

                System.out.println(
                    "Login, mot de passe ou type incorrect."
                );
            }
        }
    }
}