package Trade.controller;

public class ProductController {

    private ProductController(){}
    private static final ProductController instance = new ProductController();
    public static ProductController getInstance(){ return instance; }


}
