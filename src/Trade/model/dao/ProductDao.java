package Trade.model.dao;

import java.sql.*;

public class ProductDao {
    private ProductDao(){connect();}
    private static final ProductDao instance = new ProductDao();
    public static ProductDao getInstance(){ return instance; };

    private String url = "jdbc:mysql://localhost:3306/EasyTradeDb";
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

    public boolean upDate(String pname, String ppro, String pdes, int ppri, String ppw, String ppn){
        try {
            String sql = "insert into product(pname,ppro,pdes,ppri,ppw,ppn) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString( 1 , pname );            ps.setString( 2 , ppro );
            ps.setString( 3 , pdes );            ps.setInt( 4 , ppri );
            ps.setString( 5 , ppw );            ps.setString( 6 , ppn );
            int count = ps.executeUpdate();
            if( count == 1 ){ return true; }
            else{ return false; }
        }catch (SQLException e){ System.out.println("[시스템오류] SQL 문법 문제 발생: "+e); }
        return false;

    }

}
