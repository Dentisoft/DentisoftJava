
package modelo;

public class dientegetset {
     private String cod;
    private String nom;
    private String ima;
    private String est;
    private String tip;

    public dientegetset(String cod, String nom, String ima, String est, String tip) {
        this.cod = cod;
        this.nom = nom;
        this.ima = ima;
        this.est = est;
        this.tip = tip;
    }

    public dientegetset() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIma() {
        return ima;
    }

    public void setIma(String ima) {
        this.ima = ima;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

   
}