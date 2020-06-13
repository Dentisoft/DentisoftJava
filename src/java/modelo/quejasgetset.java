
package modelo;


public class quejasgetset {

    private String id;
    private String pac;
    private String odo;
    private String fec;
    private String des;
    private String res;

    public quejasgetset(String id, String pac, String odo, String fec, String des, String res) {
        this.id = id;
        this.pac = pac;
        this.odo = odo;
        this.fec = fec;
        this.des = des;
        this.res = res;
    }
    public quejasgetset(String id) {
        this.id = id;
    }
    

    public quejasgetset(String pac, String odo, String fec, String des, String res) {
        this.pac = pac;
        this.odo = odo;
        this.fec = fec;
        this.des = des;
        this.res = res;
    }

    public quejasgetset(String id, String res) {
        this.id = id;
        this.res = res;
    }
    
    

    

    public quejasgetset() {
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPac() {
        return pac;
    }

    public void setPac(String pac) {
        this.pac = pac;
    }

    public String getOdo() {
        return odo;
    }

    public void setOdo(String odo) {
        this.odo = odo;
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
