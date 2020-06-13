
package modelo;


public class tratamientogetset {
    private String cod;
    private String cdi;
    private String dur;
    private String des;
    private String nom;

    public tratamientogetset(String cod, String cdi, String dur, String des, String nom) {
        this.cod = cod;
        this.cdi = cdi;
        this.dur = dur;
        this.des = des;
        this.nom = nom;
    }

    public tratamientogetset(String cdi, String dur, String des, String nom) {
        this.cdi = cdi;
        this.dur = dur;
        this.des = des;
        this.nom = nom;
    }
    

    public tratamientogetset(String cod) {
        this.cod = cod;
    }
    

    public tratamientogetset() {
    }
    

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCdi() {
        return cdi;
    }

    public void setCdi(String cdi) {
        this.cdi = cdi;
    }

    public String getDur() {
        return dur;
    }

    public void setDur(String dur) {
        this.dur = dur;
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
    
    
}
