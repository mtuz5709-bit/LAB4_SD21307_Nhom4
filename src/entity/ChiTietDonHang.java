package entity;
public class ChiTietDonHang {
    private int idChiTiet, idDonHang, idVatTu, soLuongMua;
    private double giaLucMua;
    public ChiTietDonHang() {}
    public ChiTietDonHang(int idChiTiet, int idDonHang, int idVatTu, int soLuongMua, double giaLucMua) {
        this.idChiTiet = idChiTiet; this.idDonHang = idDonHang; this.idVatTu = idVatTu; this.soLuongMua = soLuongMua; this.giaLucMua = giaLucMua;
    }
    public int getIdChiTiet() { return idChiTiet; } public void setIdChiTiet(int idChiTiet) { this.idChiTiet = idChiTiet; }
    public int getIdDonHang() { return idDonHang; } public void setIdDonHang(int idDonHang) { this.idDonHang = idDonHang; }
    public int getIdVatTu() { return idVatTu; } public void setIdVatTu(int idVatTu) { this.idVatTu = idVatTu; }
    public int getSoLuongMua() { return soLuongMua; } public void setSoLuongMua(int soLuongMua) { this.soLuongMua = soLuongMua; }
    public double getGiaLucMua() { return giaLucMua; } public void setGiaLucMua(double giaLucMua) { this.giaLucMua = giaLucMua; }
}