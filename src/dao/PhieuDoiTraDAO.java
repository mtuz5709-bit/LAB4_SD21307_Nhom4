package dao;
import entity.PhieuDoiTra;
import util.JdbcUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhieuDoiTraDAO implements CrudDAO<PhieuDoiTra, Integer> {
    @Override public int create(PhieuDoiTra e) {
        try { return JdbcUtil.executeUpdate("INSERT INTO phieuDoiTra (id_don_hang, ly_do, trang_thai_doi) VALUES (?, ?, ?)", e.getIdDonHang(), e.getLyDo(), e.getTrangThaiDoi()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int update(PhieuDoiTra e) {
        try { return JdbcUtil.executeUpdate("UPDATE phieuDoiTra SET id_don_hang = ?, ly_do = ?, trang_thai_doi = ? WHERE id_phieu_doi_tra = ?", e.getIdDonHang(), e.getLyDo(), e.getTrangThaiDoi(), e.getIdPhieuDoiTra()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int delete(Integer id) {
        try { return JdbcUtil.executeUpdate("DELETE FROM phieuDoiTra WHERE id_phieu_doi_tra = ?", id); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public List<PhieuDoiTra> findAll() {
        List<PhieuDoiTra> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM phieuDoiTra");
            while(rs.next()) list.add(new PhieuDoiTra(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getString(4), rs.getInt(5)));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return list;
    }
    @Override public PhieuDoiTra findById(Integer id) {
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM phieuDoiTra WHERE id_phieu_doi_tra = ?", id);
            if(rs.next()) return new PhieuDoiTra(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getString(4), rs.getInt(5));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return null;
    }
}