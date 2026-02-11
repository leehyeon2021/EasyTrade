package Trade.model.dao;

import java.sql.*;

public class ProductDao {
    private ProductDao(){}
    private static final ProductDao instance = new ProductDao();
    public static ProductDao getInstance(){ return instance; };

    // ======= 데이터베이스 연동 =======
    // 1. 연동한 db서버의 정보
    private String url = "jdbc:mysql://localhost:3306/EasyTradeDb";
    private String user = "root";   private String password = "1234";
    // 2. 연동 인터페이스 변수 선언
    private Connection conn; //선언 만! (아래 메소드 들에서 사용 많이 함.)
    // 3. 연동 함수 선언
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 라이브러리 객체 메모리 할당/불러오기
            conn = DriverManager.getConnection( url , user , password ); // mysql 구현체로 db 연동 후 연동 인터페이스에 반환.
        }catch (Exception e){ System.out.println("[경고] 데이터베이스 연동 실패: 관리자에게 문의"); }

    }
}
