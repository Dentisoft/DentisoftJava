
package modelo;


public class facturagetset {
    private String cod;
    private String cpr;
    private String fec;
    private String val;
    private String des;

    public facturagetset(String cod, String cpr, String fec, String val, String des) {
        this.cod = cod;
        this.cpr = cpr;
        this.fec = fec;
        this.val = val;
        this.des = des;
    }

    public facturagetset(String cpr, String fec, String val, String des) {
        this.cpr = cpr;
        this.fec = fec;
        this.val = val;
        this.des = des;
    }
    
    

    public facturagetset(String cod) {
        this.cod = cod;
    }
    

    public facturagetset() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getFec() {
        return fec;
    }

    public void setFec(String fec) {
        this.fec = fec;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    
    
    
}
