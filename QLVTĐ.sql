USE QuanLyVatTuDien;
GO

-- 1. Bảng Phân Quyền
CREATE TABLE phanQuyen (
    id_quyen INT IDENTITY(1,1) PRIMARY KEY,
    ma_quyen VARCHAR(50) NOT NULL,
    ten_hien_thi NVARCHAR(100) NOT NULL,
    mo_ta NVARCHAR(255)
);

-- 2. Bảng Người Dùng
CREATE TABLE nguoiDung (
    id_nguoi_dung INT IDENTITY(1,1) PRIMARY KEY,
    id_quyen INT FOREIGN KEY REFERENCES phanQuyen(id_quyen),
    ho_ten NVARCHAR(100) NOT NULL,
    so_dien_thoai VARCHAR(20) NOT NULL,
    mat_khau VARCHAR(255) NOT NULL,
    email VARCHAR(100),
    ten_cong_ty NVARCHAR(255),
    ma_so_thue VARCHAR(50),
    dia_chi NVARCHAR(255)
);

-- 3. Bảng Danh Mục
CREATE TABLE danhMuc (
    id_danh_muc INT IDENTITY(1,1) PRIMARY KEY,
    ten_danh_muc NVARCHAR(100) NOT NULL,
    mo_ta NVARCHAR(255)
);

-- 4. Bảng Nhà Cung Cấp
CREATE TABLE nhaCungCap (
    id_nha_cung_cap INT IDENTITY(1,1) PRIMARY KEY,
    ten_nha_cung_cap NVARCHAR(200) NOT NULL,
    so_dien_thoai VARCHAR(20),
    dia_chi NVARCHAR(255)
);

-- 5. Bảng Vật Tư (Trung tâm)
CREATE TABLE vatTu (
    id_vat_tu INT IDENTITY(1,1) PRIMARY KEY,
    id_danh_muc INT FOREIGN KEY REFERENCES danhMuc(id_danh_muc),
    ten_vat_tu NVARCHAR(200) NOT NULL,
    ma_sku VARCHAR(50),
    don_vi_tinh NVARCHAR(50),
    quy_doi_chuan INT,
    gia_ban_le DECIMAL(18,2),
    gia_ban_si DECIMAL(18,2),
    so_luong_ton INT DEFAULT 0,
    gia_nhap_goc DECIMAL(18,2)
);

-- 6. Bảng Giỏ Hàng
CREATE TABLE gioHang (
    id_gio_hang INT IDENTITY(1,1) PRIMARY KEY,
    id_nguoi_dung INT FOREIGN KEY REFERENCES nguoiDung(id_nguoi_dung),
    id_vat_tu INT FOREIGN KEY REFERENCES vatTu(id_vat_tu),
    so_luong INT NOT NULL
);

-- 7. Bảng Đơn Hàng
CREATE TABLE donHang (
    id_don_hang INT IDENTITY(1,1) PRIMARY KEY,
    id_nguoi_dung INT FOREIGN KEY REFERENCES nguoiDung(id_nguoi_dung),
    ngay_tao DATETIME DEFAULT GETDATE(),
    tong_tien DECIMAL(18,2) DEFAULT 0,
    trang_thai INT DEFAULT 0,
    phuong_thuc_nhan INT,
    bien_so_xe VARCHAR(20)
);

-- 8. Bảng Chi Tiết Đơn Hàng
CREATE TABLE chiTietDonHang (
    id_chi_tiet INT IDENTITY(1,1) PRIMARY KEY,
    id_don_hang INT FOREIGN KEY REFERENCES donHang(id_don_hang),
    id_vat_tu INT FOREIGN KEY REFERENCES vatTu(id_vat_tu),
    so_luong_mua INT NOT NULL,
    gia_luc_mua DECIMAL(18,2) NOT NULL
);

-- 9. Bảng Phiếu Nhập Kho
CREATE TABLE phieuNhapKho (
    id_phieu_nhap INT IDENTITY(1,1) PRIMARY KEY,
    id_nguoi_dung INT FOREIGN KEY REFERENCES nguoiDung(id_nguoi_dung),
    id_nha_cung_cap INT FOREIGN KEY REFERENCES nhaCungCap(id_nha_cung_cap),
    ngay_nhap DATETIME DEFAULT GETDATE(),
    tong_tien_nhap DECIMAL(18,2) DEFAULT 0
);

-- 10. Bảng Chi Tiết Nhập Kho
CREATE TABLE chiTietNhapKho (
    id_chi_tiet_nhap INT IDENTITY(1,1) PRIMARY KEY,
    id_phieu_nhap INT FOREIGN KEY REFERENCES phieuNhapKho(id_phieu_nhap),
    id_vat_tu INT FOREIGN KEY REFERENCES vatTu(id_vat_tu),
    so_luong_nhap INT NOT NULL,
    gia_nhap DECIMAL(18,2) NOT NULL
);

-- 11. Bảng Phiếu Đổi Trả
CREATE TABLE phieuDoiTra (
    id_phieu_doi_tra INT IDENTITY(1,1) PRIMARY KEY,
    id_don_hang INT FOREIGN KEY REFERENCES donHang(id_don_hang),
    ngay_tao DATETIME DEFAULT GETDATE(),
    ly_do NVARCHAR(255),
    trang_thai_doi INT DEFAULT 0
);

-- 12. Bảng Chi Tiết Đổi Trả
CREATE TABLE chiTietDoiTra (
    id_chi_tiet_doi INT IDENTITY(1,1) PRIMARY KEY,
    id_phieu_doi_tra INT FOREIGN KEY REFERENCES phieuDoiTra(id_phieu_doi_tra),
    id_vat_tu_thu_ve INT FOREIGN KEY REFERENCES vatTu(id_vat_tu),
    so_luong_thu_ve INT NOT NULL,
    id_vat_tu_xuat_bu INT FOREIGN KEY REFERENCES vatTu(id_vat_tu),
    so_luong_xuat_bu INT NOT NULL
);