package dao;
import entity.GioHang;
import util.JdbcUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GioHangDAO implements CrudDAO<GioHang, Integer> {
    @Override public int create(GioHang e) {
        try { return JdbcUtil.executeUpdate("INSERT INTO gioHang (id_nguoi_dung, id_vat_tu, so_luong) VALUES (?, ?, ?)", e.getIdNguoiDung(), e.getIdVatTu(), e.getSoLuong()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int update(GioHang e) {
        try { return JdbcUtil.executeUpdate("UPDATE gioHang SET id_nguoi_dung = ?, id_vat_tu = ?, so_luong = ? WHERE id_gio_hang = ?", e.getIdNguoiDung(), e.getIdVatTu(), e.getSoLuong(), e.getIdGioHang()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int delete(Integer id) {
        try { return JdbcUtil.executeUpdate("DELETE FROM gioHang WHERE id_gio_hang = ?", id); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public List<GioHang> findAll() {
        List<GioHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM gioHang");
            while(rs.next()) list.add(new GioHang(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return list;
    }
    @Override public GioHang findById(Integer id) {
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM gioHang WHERE id_gio_hang = ?", id);
            if(rs.next()) return new GioHang(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return null;
    }
}