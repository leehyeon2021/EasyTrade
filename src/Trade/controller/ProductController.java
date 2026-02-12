package Trade.controller;

import Trade.model.dao.ProductDao;
import Trade.model.dto.ProductDto;

import java.util.ArrayList;

public class ProductController {
    private ProductController(){}
    private static final ProductController instance = new ProductController();
    public static ProductController getInstance(){ return instance; }

    private ProductDao pd = ProductDao.getInstance();

    // 1. 중고 물품 등록
    public boolean registProduct(String pname, String ppro, String pdes, int ppri, String ppw, String ppn){
        boolean result = pd.registProduct(pname,ppro,pdes,ppri,ppw,ppn);
        return result;
    }

    // 2. 전체 물품 목록 조회
    public ArrayList<ProductDto> findAll(){
        ArrayList<ProductDto> result = pd.findAll();
        return result;
    }

    // 3. 비밀번호 확인
    public boolean checkPassword(int pno, String ppw){
        boolean result = pd.checkPassword(pno,ppw);
        return result;
    }

    // 4. 물품 정보 수정
    public boolean updateProduct(int pno, String ppro, String pdes, int ppri, String ppn, String pout){
        boolean result = pd.updateProduct(pno,ppro,pdes,ppri,ppn,pout);
        return result;
    }

    // 5. 등록 물품 삭제
    public boolean deleteProduct(int pno){
        boolean result = pd.deleteProduct(pno);
        return result;
    }

}
