package entity;
public class ChiTietDoiTra {
    private int idChiTietDoi, idPhieuDoiTra, idVatTuThuVe, soLuongThuVe, idVatTuXuatBu, soLuongXuatBu;
    public ChiTietDoiTra() {}
    public ChiTietDoiTra(int idChiTietDoi, int idPhieuDoiTra, int idVatTuThuVe, int soLuongThuVe, int idVatTuXuatBu, int soLuongXuatBu) {
        this.idChiTietDoi = idChiTietDoi; this.idPhieuDoiTra = idPhieuDoiTra; this.idVatTuThuVe = idVatTuThuVe; this.soLuongThuVe = soLuongThuVe; this.idVatTuXuatBu = idVatTuXuatBu; this.soLuongXuatBu = soLuongXuatBu;
    }
    public int getIdChiTietDoi() { return idChiTietDoi; } public void setIdChiTietDoi(int idChiTietDoi) { this.idChiTietDoi = idChiTietDoi; }
    public int getIdPhieuDoiTra() { return idPhieuDoiTra; } public void setIdPhieuDoiTra(int idPhieuDoiTra) { this.idPhieuDoiTra = idPhieuDoiTra; }
    public int getIdVatTuThuVe() { return idVatTuThuVe; } public void setIdVatTuThuVe(int idVatTuThuVe) { this.idVatTuThuVe = idVatTuThuVe; }
    public int getSoLuongThuVe() { return soLuongThuVe; } public void setSoLuongThuVe(int soLuongThuVe) { this.soLuongThuVe = soLuongThuVe; }
    public int getIdVatTuXuatBu() { return idVatTuXuatBu; } public void setIdVatTuXuatBu(int idVatTuXuatBu) { this.idVatTuXuatBu = idVatTuXuatBu; }
    public int getSoLuongXuatBu() { return soLuongXuatBu; } public void setSoLuongXuatBu(int soLuongXuatBu) { this.soLuongXuatBu = soLuongXuatBu; }
}