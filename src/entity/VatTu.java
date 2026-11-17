package entity;

public class VatTu {
    private int idVatTu;
    private int idDanhMuc;
    private String tenVatTu;
    private String maSku;
    private String donViTinh;
    private int quyDoiChuan;
    private double giaBanLe;
    private double giaBanSi;
    private int soLuongTon;
    private double giaNhapGoc;

    public VatTu() {
    }

    public VatTu(int idVatTu, int idDanhMuc, String tenVatTu, String maSku, String donViTinh, int quyDoiChuan, double giaBanLe, double giaBanSi, int soLuongTon, double giaNhapGoc) {
        this.idVatTu = idVatTu;
        this.idDanhMuc = idDanhMuc;
        this.tenVatTu = tenVatTu;
        this.maSku = maSku;
        this.donViTinh = donViTinh;
        this.quyDoiChuan = quyDoiChuan;
        this.giaBanLe = giaBanLe;
        this.giaBanSi = giaBanSi;
        this.soLuongTon = soLuongTon;
        this.giaNhapGoc = giaNhapGoc;
    }

    public int getIdVatTu() { return idVatTu; }
    public void setIdVatTu(int idVatTu) { this.idVatTu = idVatTu; }

    public int getIdDanhMuc() { return idDanhMuc; }
    public void setIdDanhMuc(int idDanhMuc) { this.idDanhMuc = idDanhMuc; }

    public String getTenVatTu() { return tenVatTu; }
    public void setTenVatTu(String tenVatTu) { this.tenVatTu = tenVatTu; }

    public String getMaSku() { return maSku; }
    public void setMaSku(String maSku) { this.maSku = maSku; }

    public String getDonViTinh() { return donViTinh; }
    public void setDonViTinh(String donViTinh) { this.donViTinh = donViTinh; }

    public int getQuyDoiChuan() { return quyDoiChuan; }
    public void setQuyDoiChuan(int quyDoiChuan) { this.quyDoiChuan = quyDoiChuan; }

    public double getGiaBanLe() { return giaBanLe; }
    public void setGiaBanLe(double giaBanLe) { this.giaBanLe = giaBanLe; }

    public double getGiaBanSi() { return giaBanSi; }
    public void setGiaBanSi(double giaBanSi) { this.giaBanSi = giaBanSi; }

    public int getSoLuongTon() { return soLuongTon; }
    public void setSoLuongTon(int soLuongTon) { this.soLuongTon = soLuongTon; }

    public double getGiaNhapGoc() { return giaNhapGoc; }
    public void setGiaNhapGoc(double giaNhapGoc) { this.giaNhapGoc = giaNhapGoc; }
}