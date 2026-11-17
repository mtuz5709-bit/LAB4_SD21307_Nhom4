package dao;
import entity.PhieuNhapKho;
import util.JdbcUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhieuNhapKhoDAO implements CrudDAO<PhieuNhapKho, Integer> {
    @Override public int create(PhieuNhapKho e) {
        try { return JdbcUtil.executeUpdate("INSERT INTO phieuNhapKho (id_nguoi_dung, id_nha_cung_cap, tong_tien_nhap) VALUES (?, ?, ?)", e.getIdNguoiDung(), e.getIdNhaCungCap(), e.getTongTienNhap()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int update(PhieuNhapKho e) {
        try { return JdbcUtil.executeUpdate("UPDATE phieuNhapKho SET id_nguoi_dung = ?, id_nha_cung_cap = ?, tong_tien_nhap = ? WHERE id_phieu_nhap = ?", e.getIdNguoiDung(), e.getIdNhaCungCap(), e.getTongTienNhap(), e.getIdPhieuNhap()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int delete(Integer id) {
        try { return JdbcUtil.executeUpdate("DELETE FROM phieuNhapKho WHERE id_phieu_nhap = ?", id); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public List<PhieuNhapKho> findAll() {
        List<PhieuNhapKho> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM phieuNhapKho");
            while(rs.next()) list.add(new PhieuNhapKho(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getDouble(5)));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return list;
    }
    @Override public PhieuNhapKho findById(Integer id) {
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM phieuNhapKho WHERE id_phieu_nhap = ?", id);
            if(rs.next()) return new PhieuNhapKho(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getDouble(5));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return null;
    }
}