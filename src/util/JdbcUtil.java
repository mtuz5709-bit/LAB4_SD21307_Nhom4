package util;

import java.sql.*;

public class JdbcUtil {
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    // Tên database QuanLyVatTuDien của bạn
    static String dburl = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyVatTuDien;encrypt=false";
    static String username = "sa";
    static String password = "097a8z50"; // Nhớ đổi mật khẩu này cho khớp với SQL Server máy bạn nhé

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dburl, username, password);
    }

    public static PreparedStatement createPreStmt(String sql, Object... values) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement stmt = null;
        if (sql.trim().startsWith("{")) {
            stmt = connection.prepareCall(sql);
        } else {
            stmt = connection.prepareStatement(sql);
        }
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null) {
                stmt.setNull(i + 1, Types.NULL);
            } else {
                stmt.setObject(i + 1, values[i]);
            }
        }
        return stmt;
    }

    public static int executeUpdate(String sql, Object... values) throws SQLException {
        PreparedStatement stmt = JdbcUtil.createPreStmt(sql, values);
        return stmt.executeUpdate();
    }

    public static ResultSet executeQuery(String sql, Object... values) throws SQLException {
        PreparedStatement stmt = JdbcUtil.createPreStmt(sql, values);
        return stmt.executeQuery();
    }
}