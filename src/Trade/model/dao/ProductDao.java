package Trade.model.dao;

import Trade.model.dto.ProductDto;

import java.sql.*;
import java.util.ArrayList;

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

    // 1. 중고 물품 등록
    public boolean registProduct(String pname, String ppro, String pdes, int ppri, String ppw, String ppn){
        try {
            String sql = "insert into product(pname,ppro,pdes,ppri,ppw,ppn,pout) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString( 1 , pname );            ps.setString( 2 , ppro );
            ps.setString( 3 , pdes );            ps.setInt( 4 , ppri );
            ps.setString( 5 , ppw );            ps.setString( 6 , ppn );
            ps.setString(7,"판매 중");
            int count = ps.executeUpdate();
            if( count == 1 ){ return true; }
            else{ return false; }
        }catch (SQLException e){ System.out.println("[시스템오류] SQL 문법 문제 발생: "+e); }
        return false;
    }

    // 2. 전체 물품 목록 조회
    public ArrayList<ProductDto> findAll(){
        ArrayList<ProductDto> productDtos = new ArrayList<>();
        try {
            String sql = "SELECT*FROM product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int pno = rs.getInt("pno");
                String ppro = rs.getString("ppro");
                int ppri = rs.getInt("ppri");
                String pname = rs.getString("pname");
                String pdate = rs.getString("pdate");
                String pout = rs.getString("pout");
                String ppn = rs.getString("ppn");
                ProductDto productDto = new ProductDto(pno,pname,ppro,null,ppri,null,ppn,pdate,pout);
                productDtos.add(productDto);
            }
        } catch (SQLException e) {System.out.println("[시스템오류] SQL 문법 문제 발생: "+e);}
        return productDtos;
    }

    // 3. 비밀번호 확인
    public boolean checkPassword(int pno, String ppw){
        try {
            String sql = "SELECT*FROM product where pno = ? AND ppw = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pno);
            ps.setString(2, ppw);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {return true;}
            else {return false;}
        }catch (SQLException e){System.out.println("[시스템오류] SQL 문법 문제 발생: "+e);}
        return false;
    }

    // 4. 물품 정보 수정
    public boolean updateProduct(int pno, String ppro, String pdes, int ppri, String ppn, String pout) {
        String sql = "UPDATE product SET ppro = ?, pdes = ?, ppri = ?, ppn = ?, pout = ? WHERE pno = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ppro);
            ps.setString(2, pdes);
            ps.setInt(3, ppri);
            ps.setString(4, ppn);
            ps.setString(5, pout);
            ps.setInt(6, pno);
            int count = ps.executeUpdate();
            if(count == 1){return true;}
            else{return false;}
        } catch (SQLException e) {
            System.out.println("[시스템오류] SQL 문법 문제 발생: " + e);
        }
        return false;
    }

    // 5. 등록 물품 삭제
    public boolean deleteProduct(int pno){
        try {
            String sql = "DELETE FROM product WHERE pno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,pno);
            int count = ps.executeUpdate();
            if(count==1){return true;}
            else{return false;}
        } catch (SQLException e) {System.out.println("[시스템오류] SQL 문법 문제 발생: "+e);}
        return false;
    }
}
