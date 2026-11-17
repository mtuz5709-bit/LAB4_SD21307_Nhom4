package dao;
import entity.ChiTietDonHang;
import util.JdbcUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChiTietDonHangDAO implements CrudDAO<ChiTietDonHang, Integer> {
    @Override public int create(ChiTietDonHang e) {
        try { return JdbcUtil.executeUpdate("INSERT INTO chiTietDonHang (id_don_hang, id_vat_tu, so_luong_mua, gia_luc_mua) VALUES (?, ?, ?, ?)", e.getIdDonHang(), e.getIdVatTu(), e.getSoLuongMua(), e.getGiaLucMua()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int update(ChiTietDonHang e) {
        try { return JdbcUtil.executeUpdate("UPDATE chiTietDonHang SET id_don_hang = ?, id_vat_tu = ?, so_luong_mua = ?, gia_luc_mua = ? WHERE id_chi_tiet = ?", e.getIdDonHang(), e.getIdVatTu(), e.getSoLuongMua(), e.getGiaLucMua(), e.getIdChiTiet()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int delete(Integer id) {
        try { return JdbcUtil.executeUpdate("DELETE FROM chiTietDonHang WHERE id_chi_tiet = ?", id); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public List<ChiTietDonHang> findAll() {
        List<ChiTietDonHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM chiTietDonHang");
            while(rs.next()) list.add(new ChiTietDonHang(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5)));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return list;
    }
    @Override public ChiTietDonHang findById(Integer id) {
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM chiTietDonHang WHERE id_chi_tiet = ?", id);
            if(rs.next()) return new ChiTietDonHang(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return null;
    }
}