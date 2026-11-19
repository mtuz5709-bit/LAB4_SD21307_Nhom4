import java.util.Scanner;
import dao.DanhMucDAO;
import dao.NguoiDungDAO;
import entity.DanhMuc;
import entity.NguoiDung;

public class TestPhanQuyen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");
        NguoiDungDAO userDAO = new NguoiDungDAO();
        DanhMucDAO categoryDAO = new DanhMucDAO();

        while (true) {
            System.out.println("\n========= MENU TEST LAB 4 =========");
            System.out.println("1. Test Đăng nhập & Phân quyền (findByEmail)");
            System.out.println("2. Xem danh sách danh mục vật tư");
            System.out.println("3. Thêm mới danh mục vật tư");
            System.out.println("4. Cập nhật danh mục vật tư");
            System.out.println("5. Xóa danh mục vật tư");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng (0-5): ");

            int chon = Integer.parseInt(sc.nextLine());
            if (chon == 0) {
                System.out.println("Đã thoát chương trình!");
                break;
            }

            switch (chon) {
                case 1:
                    System.out.print("Nhập email (VD: admin@gmail.com hoặc staff@gmail.com): ");
                    String email = sc.nextLine();
                    System.out.print("Nhập mật khẩu (VD: 123456): ");
                    String pass = sc.nextLine();
                    NguoiDung u = userDAO.findByEmail(email);
                    if (u != null && u.getMatKhau().equals(pass)) {
                        System.out.println("-> Đăng nhập thành công! Xin chào: " + u.getHoTen());
                        System.out.println("-> Quyền Quản lý (isRole): " + (u.isRole() ? "CÓ (Quản lý)" : "KHÔNG (Nhân viên)"));
                    } else {
                        System.out.println("-> Sai email hoặc mật khẩu!");
                    }
                    break;

                case 2:
                    System.out.println("--- DANH SÁCH DANH MỤC VẬT TƯ ĐIỆN ---");
                    for (DanhMuc dm : categoryDAO.findAll()) {
                        System.out.println("ID: " + dm.getIdDanhMuc() + " | Tên: " + dm.getTenDanhMuc() + " | Mô tả: " + dm.getMoTa());
                    }
                    break;

                case 3:
                    System.out.print("Nhập tên danh mục mới: ");
                    String tenMoi = sc.nextLine();
                    System.out.print("Nhập mô tả: ");
                    String moTaMoi = sc.nextLine();
                    int kqThem = categoryDAO.create(new DanhMuc(0, tenMoi, moTaMoi));
                    System.out.println(kqThem > 0 ? "-> Thêm mới thành công!" : "-> Thêm mới thất bại!");
                    break;

                case 4:
                    System.out.print("Nhập ID danh mục cần sửa: ");
                    int idSua = Integer.parseInt(sc.nextLine());
                    DanhMuc dmSua = categoryDAO.findById(idSua);
                    if (dmSua != null) {
                        System.out.print("Nhập tên mới (hiện tại: " + dmSua.getTenDanhMuc() + "): ");
                        dmSua.setTenDanhMuc(sc.nextLine());
                        System.out.print("Nhập mô tả mới (hiện tại: " + dmSua.getMoTa() + "): ");
                        dmSua.setMoTa(sc.nextLine());
                        categoryDAO.update(dmSua);
                        System.out.println("-> Cập nhật thành công!");
                    } else {
                        System.out.println("-> Không tìm thấy danh mục có ID = " + idSua);
                    }
                    break;

                case 5:
                    System.out.print("Nhập ID danh mục cần xóa: ");
                    int idXoa = Integer.parseInt(sc.nextLine());
                    if (categoryDAO.countVatTuInDanhMuc(idXoa) > 0) {
                        System.out.println("-> Danh mục đang chứa vật tư, không thể xóa!");
                    } else {
                        int kqXoa = categoryDAO.delete(idXoa);
                        System.out.println(kqXoa > 0 ? "-> Xóa thành công!" : "-> Không tìm thấy ID cần xóa!");
                    }
                    break;

                default:
                    System.out.println("Vui lòng chọn từ 0 đến 5!");
            }
        }
        sc.close();
    }
}
