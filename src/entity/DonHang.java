package entity;
import java.util.Date;
public class DonHang {
    private int idDonHang, idNguoiDung, trangThai, phuongThucNhan;
    private Date ngayTao;
    private double tongTien;
    private String bienSoXe;
    public DonHang() {}
    public DonHang(int idDonHang, int idNguoiDung, Date ngayTao, double tongTien, int trangThai, int phuongThucNhan, String bienSoXe) {
        this.idDonHang = idDonHang; this.idNguoiDung = idNguoiDung; this.ngayTao = ngayTao; this.tongTien = tongTien; this.trangThai = trangThai; this.phuongThucNhan = phuongThucNhan; this.bienSoXe = bienSoXe;
    }
    // Getters & Setters
    public int getIdDonHang() { return idDonHang; } public void setIdDonHang(int idDonHang) { this.idDonHang = idDonHang; }
    public int getIdNguoiDung() { return idNguoiDung; } public void setIdNguoiDung(int idNguoiDung) { this.idNguoiDung = idNguoiDung; }
    public Date getNgayTao() { return ngayTao; } public void setNgayTao(Date ngayTao) { this.ngayTao = ngayTao; }
    public double getTongTien() { return tongTien; } public void setTongTien(double tongTien) { this.tongTien = tongTien; }
    public int getTrangThai() { return trangThai; } public void setTrangThai(int trangThai) { this.trangThai = trangThai; }
    public int getPhuongThucNhan() { return phuongThucNhan; } public void setPhuongThucNhan(int phuongThucNhan) { this.phuongThucNhan = phuongThucNhan; }
    public String getBienSoXe() { return bienSoXe; } public void setBienSoXe(String bienSoXe) { this.bienSoXe = bienSoXe; }
}