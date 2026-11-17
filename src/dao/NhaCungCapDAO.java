package dao;
import entity.NhaCungCap;
import util.JdbcUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAO implements CrudDAO<NhaCungCap, Integer> {
    @Override public int create(NhaCungCap e) {
        try { return JdbcUtil.executeUpdate("INSERT INTO nhaCungCap (ten_nha_cung_cap, so_dien_thoai, dia_chi) VALUES (?, ?, ?)", e.getTenNhaCungCap(), e.getSoDienThoai(), e.getDiaChi()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int update(NhaCungCap e) {
        try { return JdbcUtil.executeUpdate("UPDATE nhaCungCap SET ten_nha_cung_cap = ?, so_dien_thoai = ?, dia_chi = ? WHERE id_nha_cung_cap = ?", e.getTenNhaCungCap(), e.getSoDienThoai(), e.getDiaChi(), e.getIdNhaCungCap()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int delete(Integer id) {
        try { return JdbcUtil.executeUpdate("DELETE FROM nhaCungCap WHERE id_nha_cung_cap = ?", id); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public List<NhaCungCap> findAll() {
        List<NhaCungCap> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM nhaCungCap");
            while(rs.next()) list.add(new NhaCungCap(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return list;
    }
    @Override public NhaCungCap findById(Integer id) {
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM nhaCungCap WHERE id_nha_cung_cap = ?", id);
            if(rs.next()) return new NhaCungCap(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return null;
    }
}