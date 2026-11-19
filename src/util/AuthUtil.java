package util;

import entity.NguoiDung;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class AuthUtil {
    public static final String SESSION_USER = "user";

    // Lưu thông tin user đăng nhập
    public static void setUser(HttpServletRequest request, NguoiDung user) {
        HttpSession session = request.getSession();
        session.setAttribute(SESSION_USER, user);
    }

    // Lấy thông tin user đăng nhập
    public static NguoiDung getUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) return null;
        return (NguoiDung) session.getAttribute(SESSION_USER);
    }

    // Đã login chưa?
    public static boolean isAuthenticated(HttpServletRequest request) {
        return getUser(request) != null;
    }

    // Kiểm tra quyền Quản lý (id_quyen == 1)
    public static boolean isManager(HttpServletRequest request) {
        NguoiDung u = getUser(request);
        return u != null ? u.isRole() : false;
    }

    // Xóa thông tin đăng nhập
    public static void clear(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(SESSION_USER);
    }
}
