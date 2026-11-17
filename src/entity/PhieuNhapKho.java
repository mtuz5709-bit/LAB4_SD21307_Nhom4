package entity;
import java.util.Date;
public class PhieuNhapKho {
    private int idPhieuNhap, idNguoiDung, idNhaCungCap;
    private Date ngayNhap;
    private double tongTienNhap;
    public PhieuNhapKho() {}
    public PhieuNhapKho(int idPhieuNhap, int idNguoiDung, int idNhaCungCap, Date ngayNhap, double tongTienNhap) {
        this.idPhieuNhap = idPhieuNhap; this.idNguoiDung = idNguoiDung; this.idNhaCungCap = idNhaCungCap; this.ngayNhap = ngayNhap; this.tongTienNhap = tongTienNhap;
    }
    public int getIdPhieuNhap() { return idPhieuNhap; } public void setIdPhieuNhap(int idPhieuNhap) { this.idPhieuNhap = idPhieuNhap; }
    public int getIdNguoiDung() { return idNguoiDung; } public void setIdNguoiDung(int idNguoiDung) { this.idNguoiDung = idNguoiDung; }
    public int getIdNhaCungCap() { return idNhaCungCap; } public void setIdNhaCungCap(int idNhaCungCap) { this.idNhaCungCap = idNhaCungCap; }
    public Date getNgayNhap() { return ngayNhap; } public void setNgayNhap(Date ngayNhap) { this.ngayNhap = ngayNhap; }
    public double getTongTienNhap() { return tongTienNhap; } public void setTongTienNhap(double tongTienNhap) { this.tongTienNhap = tongTienNhap; }
}