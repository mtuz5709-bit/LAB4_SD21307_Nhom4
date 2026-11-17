package dao;
import entity.DonHang;
import util.JdbcUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonHangDAO implements CrudDAO<DonHang, Integer> {
    @Override public int create(DonHang e) {
        try { return JdbcUtil.executeUpdate("INSERT INTO donHang (id_nguoi_dung, tong_tien, trang_thai, phuong_thuc_nhan, bien_so_xe) VALUES (?, ?, ?, ?, ?)", e.getIdNguoiDung(), e.getTongTien(), e.getTrangThai(), e.getPhuongThucNhan(), e.getBienSoXe()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int update(DonHang e) {
        try { return JdbcUtil.executeUpdate("UPDATE donHang SET id_nguoi_dung = ?, tong_tien = ?, trang_thai = ?, phuong_thuc_nhan = ?, bien_so_xe = ? WHERE id_don_hang = ?", e.getIdNguoiDung(), e.getTongTien(), e.getTrangThai(), e.getPhuongThucNhan(), e.getBienSoXe(), e.getIdDonHang()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int delete(Integer id) {
        try { return JdbcUtil.executeUpdate("DELETE FROM donHang WHERE id_don_hang = ?", id); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public List<DonHang> findAll() {
        List<DonHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM donHang");
            while(rs.next()) list.add(new DonHang(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6), rs.getString(7)));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return list;
    }
    @Override public DonHang findById(Integer id) {
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM donHang WHERE id_don_hang = ?", id);
            if(rs.next()) return new DonHang(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return null;
    }
}