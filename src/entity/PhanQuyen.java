package entity;
public class PhanQuyen {
    private int idQuyen;
    private String maQuyen, tenHienThi, moTa;
    public PhanQuyen() {}
    public PhanQuyen(int idQuyen, String maQuyen, String tenHienThi, String moTa) {
        this.idQuyen = idQuyen; this.maQuyen = maQuyen; this.tenHienThi = tenHienThi; this.moTa = moTa;
    }
    // Getters & Setters
    public int getIdQuyen() { return idQuyen; }
    public void setIdQuyen(int idQuyen) { this.idQuyen = idQuyen; }
    public String getMaQuyen() { return maQuyen; }
    public void setMaQuyen(String maQuyen) { this.maQuyen = maQuyen; }
    public String getTenHienThi() { return tenHienThi; }
    public void setTenHienThi(String tenHienThi) { this.tenHienThi = tenHienThi; }
    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }
}