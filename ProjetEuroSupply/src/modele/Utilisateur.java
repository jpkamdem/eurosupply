package modele;

public class Utilisateur {

    private int id;
    private String login;
    private String mdp;
    private String type;

    public Utilisateur() {
    }

    public Utilisateur(int id, String login, String mdp, String type) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}