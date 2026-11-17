package dao;
import entity.ChiTietNhapKho;
import util.JdbcUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChiTietNhapKhoDAO implements CrudDAO<ChiTietNhapKho, Integer> {
    @Override public int create(ChiTietNhapKho e) {
        try { return JdbcUtil.executeUpdate("INSERT INTO chiTietNhapKho (id_phieu_nhap, id_vat_tu, so_luong_nhap, gia_nhap) VALUES (?, ?, ?, ?)", e.getIdPhieuNhap(), e.getIdVatTu(), e.getSoLuongNhap(), e.getGiaNhap()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int update(ChiTietNhapKho e) {
        try { return JdbcUtil.executeUpdate("UPDATE chiTietNhapKho SET id_phieu_nhap = ?, id_vat_tu = ?, so_luong_nhap = ?, gia_nhap = ? WHERE id_chi_tiet_nhap = ?", e.getIdPhieuNhap(), e.getIdVatTu(), e.getSoLuongNhap(), e.getGiaNhap(), e.getIdChiTietNhap()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int delete(Integer id) {
        try { return JdbcUtil.executeUpdate("DELETE FROM chiTietNhapKho WHERE id_chi_tiet_nhap = ?", id); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public List<ChiTietNhapKho> findAll() {
        List<ChiTietNhapKho> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM chiTietNhapKho");
            while(rs.next()) list.add(new ChiTietNhapKho(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5)));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return list;
    }
    @Override public ChiTietNhapKho findById(Integer id) {
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM chiTietNhapKho WHERE id_chi_tiet_nhap = ?", id);
            if(rs.next()) return new ChiTietNhapKho(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return null;
    }
}