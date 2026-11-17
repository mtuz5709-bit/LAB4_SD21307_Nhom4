package entity;
public class GioHang {
    private int idGioHang, idNguoiDung, idVatTu, soLuong;
    public GioHang() {}
    public GioHang(int idGioHang, int idNguoiDung, int idVatTu, int soLuong) {
        this.idGioHang = idGioHang; this.idNguoiDung = idNguoiDung; this.idVatTu = idVatTu; this.soLuong = soLuong;
    }
    public int getIdGioHang() { return idGioHang; }
    public void setIdGioHang(int idGioHang) { this.idGioHang = idGioHang; }
    public int getIdNguoiDung() { return idNguoiDung; }
    public void setIdNguoiDung(int idNguoiDung) { this.idNguoiDung = idNguoiDung; }
    public int getIdVatTu() { return idVatTu; }
    public void setIdVatTu(int idVatTu) { this.idVatTu = idVatTu; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
}