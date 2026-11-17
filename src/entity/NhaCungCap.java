package entity;

public class NhaCungCap {
    private int idNhaCungCap;
    private String tenNhaCungCap;
    private String soDienThoai;
    private String diaChi;

    public NhaCungCap() {}
    public NhaCungCap(int idNhaCungCap, String tenNhaCungCap, String soDienThoai, String diaChi) {
        this.idNhaCungCap = idNhaCungCap; this.tenNhaCungCap = tenNhaCungCap; this.soDienThoai = soDienThoai; this.diaChi = diaChi;
    }
    public int getIdNhaCungCap() { return idNhaCungCap; }
    public void setIdNhaCungCap(int idNhaCungCap) { this.idNhaCungCap = idNhaCungCap; }
    public String getTenNhaCungCap() { return tenNhaCungCap; }
    public void setTenNhaCungCap(String tenNhaCungCap) { this.tenNhaCungCap = tenNhaCungCap; }
    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
}