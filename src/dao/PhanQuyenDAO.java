package dao;
import entity.PhanQuyen;
import util.JdbcUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhanQuyenDAO implements CrudDAO<PhanQuyen, Integer> {
    @Override public int create(PhanQuyen e) {
        try { return JdbcUtil.executeUpdate("INSERT INTO phanQuyen (ma_quyen, ten_hien_thi, mo_ta) VALUES (?, ?, ?)", e.getMaQuyen(), e.getTenHienThi(), e.getMoTa()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int update(PhanQuyen e) {
        try { return JdbcUtil.executeUpdate("UPDATE phanQuyen SET ma_quyen = ?, ten_hien_thi = ?, mo_ta = ? WHERE id_quyen = ?", e.getMaQuyen(), e.getTenHienThi(), e.getMoTa(), e.getIdQuyen()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int delete(Integer id) {
        try { return JdbcUtil.executeUpdate("DELETE FROM phanQuyen WHERE id_quyen = ?", id); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public List<PhanQuyen> findAll() {
        List<PhanQuyen> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM phanQuyen");
            while(rs.next()) list.add(new PhanQuyen(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return list;
    }
    @Override public PhanQuyen findById(Integer id) {
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM phanQuyen WHERE id_quyen = ?", id);
            if(rs.next()) return new PhanQuyen(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return null;
    }
}