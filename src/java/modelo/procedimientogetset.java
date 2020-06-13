
package modelo;

public class procedimientogetset {
    private String cod;
    private String ctr;
    private String des;
    private String nom;
    private String dur;

    public procedimientogetset(String cod, String ctr, String des, String nom, String dur) {
        this.cod = cod;
        this.ctr = ctr;
        this.des = des;
        this.nom = nom;
        this.dur = dur;
    }

    public procedimientogetset(String ctr, String des, String nom, String dur) {
        this.ctr = ctr;
        this.des = des;
        this.nom = nom;
        this.dur = dur;
    }
    
    

    public procedimientogetset(String cod) {
        this.cod = cod;
    }
    

    public procedimientogetset() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCtr() {
        return ctr;
    }

    public void setCtr(String ctr) {
        this.ctr = ctr;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDur() {
        return dur;
    }

    public void setDur(String dur) {
        this.dur = dur;
    }
    
    
    
}
