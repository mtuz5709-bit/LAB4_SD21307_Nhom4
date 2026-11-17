package entity;
import java.util.Date;
public class PhieuDoiTra {
    private int idPhieuDoiTra, idDonHang, trangThaiDoi;
    private Date ngayTao;
    private String lyDo;
    public PhieuDoiTra() {}
    public PhieuDoiTra(int idPhieuDoiTra, int idDonHang, Date ngayTao, String lyDo, int trangThaiDoi) {
        this.idPhieuDoiTra = idPhieuDoiTra; this.idDonHang = idDonHang; this.ngayTao = ngayTao; this.lyDo = lyDo; this.trangThaiDoi = trangThaiDoi;
    }
    public int getIdPhieuDoiTra() { return idPhieuDoiTra; } public void setIdPhieuDoiTra(int idPhieuDoiTra) { this.idPhieuDoiTra = idPhieuDoiTra; }
    public int getIdDonHang() { return idDonHang; } public void setIdDonHang(int idDonHang) { this.idDonHang = idDonHang; }
    public Date getNgayTao() { return ngayTao; } public void setNgayTao(Date ngayTao) { this.ngayTao = ngayTao; }
    public String getLyDo() { return lyDo; } public void setLyDo(String lyDo) { this.lyDo = lyDo; }
    public int getTrangThaiDoi() { return trangThaiDoi; } public void setTrangThaiDoi(int trangThaiDoi) { this.trangThaiDoi = trangThaiDoi; }
}