package Trade.model.dao;

import java.sql.*;

public class ProductDao {
    private ProductDao(){connect();}
    private static final ProductDao instance = new ProductDao();
    public static ProductDao getInstance(){ return instance; };

    private String url = "jdbc:mysql://localhost:3306/crawlerDB";
    private String user = "root";    private String password = "1234";
    private Connection conn;
    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("[준비] 데이터베이스 연동 성공");
        } catch (Exception e) {
            System.out.println("[경고] 연동 실패 원인: " + e.getMessage());
        }
    }

}
