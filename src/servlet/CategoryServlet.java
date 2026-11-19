package servlet;

import java.io.IOException;
import java.util.List;
import dao.DanhMucDAO;
import entity.DanhMuc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.AuthUtil;
import util.ParamUtil;

@WebServlet({
        "/manager/categories",
        "/manager/categories/add",
        "/manager/categories/edit",
        "/manager/categories/delete"
})
public class CategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DanhMucDAO categoryDAO = new DanhMucDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!AuthUtil.isAuthenticated(request)) {
            response.sendRedirect(request.getContextPath() + "/dang-nhap");
            return;
        }
        // Kiểm tra id trường hợp chỉnh sửa
        int id = ParamUtil.getInt(request, "id");
        if (id > 0) {
            DanhMuc category = categoryDAO.findById(id);
            request.setAttribute("category", category);
        }
        List<DanhMuc> list = categoryDAO.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/views/categories/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uriString = request.getRequestURI();
        if (uriString.contains("add")) {
            create(request);
        }
        if (uriString.contains("edit")) {
            update(request);
        }
        if (uriString.contains("delete")) {
            delete(request);
        }
        List<DanhMuc> list = categoryDAO.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/views/categories/list.jsp").forward(request, response);
    }

    // Xử lý thêm mới danh mục vật tư điện
    public void create(HttpServletRequest request) {
        String name = ParamUtil.getString(request, "name");
        String moTa = ParamUtil.getString(request, "moTa");
        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("error", "Tên danh mục không được để trống");
        } else {
            DanhMuc category = new DanhMuc(0, name.trim(), moTa != null ? moTa.trim() : "");
            int rs = categoryDAO.create(category);
            if (rs > 0) {
                request.setAttribute("message", "Thêm mới thành công");
            } else {
                request.setAttribute("error", "Thêm mới thất bại");
            }
        }
    }

    // Xử lý cập nhật danh mục vật tư điện
    public void update(HttpServletRequest request) {
        Integer id = ParamUtil.getInt(request, "id");
        String name = ParamUtil.getString(request, "name");
        String moTa = ParamUtil.getString(request, "moTa");
        DanhMuc category = categoryDAO.findById(id);
        if (category != null) {
            category.setTenDanhMuc(name);
            category.setMoTa(moTa);
            int rs = categoryDAO.update(category);
            if (rs > 0) {
                request.setAttribute("message", "Cập nhật thành công");
            } else {
                request.setAttribute("error", "Cập nhật thất bại");
            }
            request.setAttribute("category", category);
        } else {
            request.setAttribute("error", "Danh mục vật tư không tồn tại");
        }
    }

    // Xử lý xóa danh mục vật tư điện
    public void delete(HttpServletRequest request) {
        Integer id = ParamUtil.getInt(request, "id");
        if (id > 0) {
            int countVatTu = categoryDAO.countVatTuInDanhMuc(id);
            if (countVatTu > 0) {
                request.setAttribute("error", "Danh mục đang có vật tư điện, không thể xóa!");
            } else {
                categoryDAO.delete(id);
                request.setAttribute("message", "Xóa thành công");
                request.setAttribute("category", null);
            }
        } else {
            request.setAttribute("error", "Không tìm thấy danh mục vật tư");
        }
    }
}
