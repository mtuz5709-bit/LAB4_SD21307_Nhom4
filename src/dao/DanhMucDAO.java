package dao;
import entity.DanhMuc;
import util.JdbcUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DanhMucDAO implements CrudDAO<DanhMuc, Integer> {
    @Override public int create(DanhMuc e) {
        try { return JdbcUtil.executeUpdate("INSERT INTO danhMuc (ten_danh_muc, mo_ta) VALUES (?, ?)", e.getTenDanhMuc(), e.getMoTa()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int update(DanhMuc e) {
        try { return JdbcUtil.executeUpdate("UPDATE danhMuc SET ten_danh_muc = ?, mo_ta = ? WHERE id_danh_muc = ?", e.getTenDanhMuc(), e.getMoTa(), e.getIdDanhMuc()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int delete(Integer id) {
        try { return JdbcUtil.executeUpdate("DELETE FROM danhMuc WHERE id_danh_muc = ?", id); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public List<DanhMuc> findAll() {
        List<DanhMuc> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM danhMuc");
            while(rs.next()) list.add(new DanhMuc(rs.getInt(1), rs.getString(2), rs.getString(3)));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return list;
    }
    @Override public DanhMuc findById(Integer id) {
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM danhMuc WHERE id_danh_muc = ?", id);
            if(rs.next()) return new DanhMuc(rs.getInt(1), rs.getString(2), rs.getString(3));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return null;
    }

    // Đếm số lượng vật tư điện trong danh mục (kiểm tra khóa ngoại trước khi xóa - Lab 4 Bài 4)
    public int countVatTuInDanhMuc(int idDanhMuc) {
        int rs = 0;
        String sql = "SELECT COUNT(id_vat_tu) AS num_vattu FROM vatTu WHERE id_danh_muc = ?";
        try {
            ResultSet resultSet = JdbcUtil.executeQuery(sql, idDanhMuc);
            while (resultSet.next()) {
                rs = resultSet.getInt("num_vattu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}