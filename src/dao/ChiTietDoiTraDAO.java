package dao;
import entity.ChiTietDoiTra;
import util.JdbcUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChiTietDoiTraDAO implements CrudDAO<ChiTietDoiTra, Integer> {
    @Override public int create(ChiTietDoiTra e) {
        try { return JdbcUtil.executeUpdate("INSERT INTO chiTietDoiTra (id_phieu_doi_tra, id_vat_tu_thu_ve, so_luong_thu_ve, id_vat_tu_xuat_bu, so_luong_xuat_bu) VALUES (?, ?, ?, ?, ?)", e.getIdPhieuDoiTra(), e.getIdVatTuThuVe(), e.getSoLuongThuVe(), e.getIdVatTuXuatBu(), e.getSoLuongXuatBu()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int update(ChiTietDoiTra e) {
        try { return JdbcUtil.executeUpdate("UPDATE chiTietDoiTra SET id_phieu_doi_tra = ?, id_vat_tu_thu_ve = ?, so_luong_thu_ve = ?, id_vat_tu_xuat_bu = ?, so_luong_xuat_bu = ? WHERE id_chi_tiet_doi = ?", e.getIdPhieuDoiTra(), e.getIdVatTuThuVe(), e.getSoLuongThuVe(), e.getIdVatTuXuatBu(), e.getSoLuongXuatBu(), e.getIdChiTietDoi()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int delete(Integer id) {
        try { return JdbcUtil.executeUpdate("DELETE FROM chiTietDoiTra WHERE id_chi_tiet_doi = ?", id); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public List<ChiTietDoiTra> findAll() {
        List<ChiTietDoiTra> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM chiTietDoiTra");
            while(rs.next()) list.add(new ChiTietDoiTra(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return list;
    }
    @Override public ChiTietDoiTra findById(Integer id) {
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM chiTietDoiTra WHERE id_chi_tiet_doi = ?", id);
            if(rs.next()) return new ChiTietDoiTra(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return null;
    }
}