package dao;
import entity.VatTu;
import util.JdbcUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VatTuDAO implements CrudDAO<VatTu, Integer> {
    @Override public int create(VatTu e) {
        try { return JdbcUtil.executeUpdate("INSERT INTO vatTu (id_danh_muc, ten_vat_tu, ma_sku, don_vi_tinh, quy_doi_chuan, gia_ban_le, gia_ban_si, so_luong_ton, gia_nhap_goc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", e.getIdDanhMuc(), e.getTenVatTu(), e.getMaSku(), e.getDonViTinh(), e.getQuyDoiChuan(), e.getGiaBanLe(), e.getGiaBanSi(), e.getSoLuongTon(), e.getGiaNhapGoc()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int update(VatTu e) {
        try { return JdbcUtil.executeUpdate("UPDATE vatTu SET id_danh_muc = ?, ten_vat_tu = ?, ma_sku = ?, don_vi_tinh = ?, quy_doi_chuan = ?, gia_ban_le = ?, gia_ban_si = ?, so_luong_ton = ?, gia_nhap_goc = ? WHERE id_vat_tu = ?", e.getIdDanhMuc(), e.getTenVatTu(), e.getMaSku(), e.getDonViTinh(), e.getQuyDoiChuan(), e.getGiaBanLe(), e.getGiaBanSi(), e.getSoLuongTon(), e.getGiaNhapGoc(), e.getIdVatTu()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int delete(Integer id) {
        try { return JdbcUtil.executeUpdate("DELETE FROM vatTu WHERE id_vat_tu = ?", id); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public List<VatTu> findAll() {
        List<VatTu> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM vatTu");
            while(rs.next()) list.add(new VatTu(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDouble(7), rs.getDouble(8), rs.getInt(9), rs.getDouble(10)));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return list;
    }
    @Override public VatTu findById(Integer id) {
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM vatTu WHERE id_vat_tu = ?", id);
            if(rs.next()) return new VatTu(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDouble(7), rs.getDouble(8), rs.getInt(9), rs.getDouble(10));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return null;
    }
}