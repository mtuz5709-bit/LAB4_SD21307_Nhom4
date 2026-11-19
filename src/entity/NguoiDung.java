package entity;

public class NguoiDung {
    private int idNguoiDung;
    private int idQuyen;
    private String hoTen;
    private String soDienThoai;
    private String matKhau;
    private String email;
    private String tenCongTy;
    private String maSoThue;
    private String diaChi;

    public NguoiDung() {
    }

    public NguoiDung(int idNguoiDung, int idQuyen, String hoTen, String soDienThoai, String matKhau, String email, String tenCongTy, String maSoThue, String diaChi) {
        this.idNguoiDung = idNguoiDung;
        this.idQuyen = idQuyen;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.matKhau = matKhau;
        this.email = email;
        this.tenCongTy = tenCongTy;
        this.maSoThue = maSoThue;
        this.diaChi = diaChi;
    }

    public int getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(int idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public int getIdQuyen() {
        return idQuyen;
    }

    public void setIdQuyen(int idQuyen) {
        this.idQuyen = idQuyen;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    // Kiểm tra quyền quản lý (id_quyen == 1 là Quản lý) - theo chuẩn Slide Bài 4 (u.isRole())
    public boolean isRole() {
        return this.idQuyen == 1;
    }
}