
package modelo;


public class auxiliargetset {
    private String doc;
    private String nom;

    public auxiliargetset(String doc, String nom) {
        this.doc = doc;
        this.nom = nom;
    }

    public auxiliargetset() {
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
