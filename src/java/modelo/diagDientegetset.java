
package modelo;



public class diagDientegetset {
    private String IdDiagDie;
    private String DiagId;
    private String DienCod;
    private String DiagDes;

    public diagDientegetset() {
    }

    public diagDientegetset(String IdDiagDie, String DiagId, String DienCod, String DiagDes) {
        this.IdDiagDie = IdDiagDie;
        this.DiagId = DiagId;
        this.DienCod = DienCod;
        this.DiagDes = DiagDes;
    }

    public diagDientegetset(String IdDiagDie) {
        this.IdDiagDie = IdDiagDie;
    }

    public String getIdDiagDie() {
        return IdDiagDie;
    }

    public void setIdDiagDie(String IdDiagDie) {
        this.IdDiagDie = IdDiagDie;
    }

    public String getDiagId() {
        return DiagId;
    }

    public void setDiagId(String DiagId) {
        this.DiagId = DiagId;
    }

    public String getDienCod() {
        return DienCod;
    }

    public void setDienCod(String DienCod) {
        this.DienCod = DienCod;
    }

    public String getDiagDes() {
        return DiagDes;
    }

    public void setDiagDes(String DiagDes) {
        this.DiagDes = DiagDes;
    }
    
    
}
