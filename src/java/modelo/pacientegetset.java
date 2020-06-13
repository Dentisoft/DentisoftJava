
package modelo;

public class pacientegetset {
    private String doc;
    private String nom;
    private String eda;

    public pacientegetset(String doc, String nom, String eda) {
        this.doc = doc;
        this.nom = nom;
        this.eda = eda;
    }

    public pacientegetset() {
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

    public String getEda() {
        return eda;
    }

    public void setEda(String eda) {
        this.eda = eda;
    }

    
}
