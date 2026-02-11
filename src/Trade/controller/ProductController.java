package Trade.controller;

import Trade.model.dao.ProductDao;

public class ProductController {
    private ProductController(){}
    private static final ProductController instance = new ProductController();
    public static ProductController getInstance(){ return instance; }

    private ProductDao pd;

    public boolean upDate(String pname, String ppro, String pdes, int ppri, String ppw, String ppn){
        if(pd==null){pd=ProductDao.getInstance();}
        boolean result = pd.upDate(pname,ppro,pdes,ppri,ppw,ppn);
        return result;
    }


}
