package dao;
import entity.NguoiDung;
import util.JdbcUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO implements CrudDAO<NguoiDung, Integer> {
    @Override public int create(NguoiDung e) {
        try { return JdbcUtil.executeUpdate("INSERT INTO nguoiDung (id_quyen, ho_ten, so_dien_thoai, mat_khau, email, ten_cong_ty, ma_so_thue, dia_chi) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", e.getIdQuyen(), e.getHoTen(), e.getSoDienThoai(), e.getMatKhau(), e.getEmail(), e.getTenCongTy(), e.getMaSoThue(), e.getDiaChi()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int update(NguoiDung e) {
        try { return JdbcUtil.executeUpdate("UPDATE nguoiDung SET id_quyen = ?, ho_ten = ?, so_dien_thoai = ?, mat_khau = ?, email = ?, ten_cong_ty = ?, ma_so_thue = ?, dia_chi = ? WHERE id_nguoi_dung = ?", e.getIdQuyen(), e.getHoTen(), e.getSoDienThoai(), e.getMatKhau(), e.getEmail(), e.getTenCongTy(), e.getMaSoThue(), e.getDiaChi(), e.getIdNguoiDung()); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public int delete(Integer id) {
        try { return JdbcUtil.executeUpdate("DELETE FROM nguoiDung WHERE id_nguoi_dung = ?", id); }
        catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    @Override public List<NguoiDung> findAll() {
        List<NguoiDung> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM nguoiDung");
            while(rs.next()) list.add(new NguoiDung(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return list;
    }
    @Override public NguoiDung findById(Integer id) {
        try {
            ResultSet rs = JdbcUtil.executeQuery("SELECT * FROM nguoiDung WHERE id_nguoi_dung = ?", id);
            if(rs.next()) return new NguoiDung(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
        } catch(SQLException e) { throw new RuntimeException(e); }
        return null;
    }
}