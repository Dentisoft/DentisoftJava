
package modelo;


public class citagetset {
    private String cod;
    private String dpa;
    private String dod; 
    private String fec;
    private String hor;
    private String est;

    public citagetset(String cod, String dpa, String dod, String fec, String hor, String est) {
        this.cod = cod;
        this.dpa = dpa;
        this.dod = dod;
        this.fec = fec;
        this.hor = hor;
        this.est = est;
    }

    public citagetset(String dpa, String dod, String fec, String hor, String est) {
        this.dpa = dpa;
        this.dod = dod;
        this.fec = fec;
        this.hor = hor;
        this.est = est;
    }
    

    public citagetset() {
    }

    public citagetset(String cod, String dpa) {
        this.cod = cod;
        this.dpa = dpa;
    }
    

    public citagetset(String cod) {
        this.cod = cod;
    }
    

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }

   

    
    
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDpa() {
        return dpa;
    }

    public void setDpa(String dpa) {
        this.dpa = dpa;
    }

    public String getDod() {
        return dod;
    }

    public void setDod(String dod) {
        this.dod = dod;
    }

    public String getFec() {
        return fec;
    }

    public void setFec(String fec) {
        this.fec = fec;
    }

    public String getHor() {
        return hor;
    }

    public void setHor(String hor) {
        this.hor = hor;
    }
    
    
}
