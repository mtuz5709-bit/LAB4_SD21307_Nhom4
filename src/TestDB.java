import util.JdbcUtil;
import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        System.out.println("Đang tiến hành kết nối đến SQL Server");
        try {
            // Gọi hàm kết nối từ JdbcUtil của bạn
            Connection conn = JdbcUtil.getConnection();

            if (conn != null) {
                System.out.println("Đã kết nối Database thành công");
            }
        } catch (Exception e) {
            System.out.println("KẾT NỐI THẤT BẠI");
            e.printStackTrace();
        }
    }
}