
package modelo;


public class diagnosticogetset {
    private String cod;
    private String dpa;
    private String fec;
    private String des;

    public diagnosticogetset(String cod, String dpa, String fec, String des) {
        this.cod = cod;
        this.dpa = dpa;
        this.fec = fec;
        this.des = des;
    }

    public diagnosticogetset(String dpa, String fec, String des) {
        this.dpa = dpa;
        this.fec = fec;
        this.des = des;
    }
    
    

    public diagnosticogetset(String cod) {
        this.cod = cod;
    }
    
    

    public diagnosticogetset() {
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

    public String getFec() {
        return fec;
    }

    public void setFec(String fec) {
        this.fec = fec;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    
    
    
}

