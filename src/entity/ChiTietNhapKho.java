package entity;
public class ChiTietNhapKho {
    private int idChiTietNhap, idPhieuNhap, idVatTu, soLuongNhap;
    private double giaNhap;
    public ChiTietNhapKho() {}
    public ChiTietNhapKho(int idChiTietNhap, int idPhieuNhap, int idVatTu, int soLuongNhap, double giaNhap) {
        this.idChiTietNhap = idChiTietNhap; this.idPhieuNhap = idPhieuNhap; this.idVatTu = idVatTu; this.soLuongNhap = soLuongNhap; this.giaNhap = giaNhap;
    }
    public int getIdChiTietNhap() { return idChiTietNhap; } public void setIdChiTietNhap(int idChiTietNhap) { this.idChiTietNhap = idChiTietNhap; }
    public int getIdPhieuNhap() { return idPhieuNhap; } public void setIdPhieuNhap(int idPhieuNhap) { this.idPhieuNhap = idPhieuNhap; }
    public int getIdVatTu() { return idVatTu; } public void setIdVatTu(int idVatTu) { this.idVatTu = idVatTu; }
    public int getSoLuongNhap() { return soLuongNhap; } public void setSoLuongNhap(int soLuongNhap) { this.soLuongNhap = soLuongNhap; }
    public double getGiaNhap() { return giaNhap; } public void setGiaNhap(double giaNhap) { this.giaNhap = giaNhap; }
}