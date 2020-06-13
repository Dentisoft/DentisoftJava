
package modelo;

public class usuariogetset {
    private String doc;       
    private String nom;
    private String cla;
    private String rol;
    private String sex;
    private String est;
    private String ema;
    private String tel;
    private String fot;

    public usuariogetset(String doc, String nom, String cla, String rol, String sex , String est, String ema, String tel, String fot) {
        this.doc = doc;
        this.nom = nom;
        this.cla = cla;
        this.rol = rol;
        this.sex = sex;
        this.est = est;
        this.ema = ema;
        this.tel = tel;
        this.fot = fot;
    }

    public usuariogetset(String doc, String nom, String cla, String rol, String sex, String est, String ema, String tel) {
        this.doc = doc;
        this.nom = nom;
        this.cla = cla;
        this.rol = rol;
        this.sex = sex;
        this.est = est;
        this.ema = ema;
        this.tel = tel;
    }

    public usuariogetset(String doc) {
        this.doc = doc;
    }

    
    public usuariogetset() {
    }

    public usuariogetset(String nom, String cla) {
        this.nom = nom;
        this.cla = cla;
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
    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
        public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }
    public String getEma() {
        return ema;
    }

    public void setEma(String ema) {
        this.ema = ema;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFot() {
        return fot;
    }

    public void setFot(String fot) {
        this.fot = fot;
    }
    
    
    
}
