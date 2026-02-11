package Trade.view;

import Trade.controller.ProductController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductView {
    private ProductView(){}
    private static final ProductView instance = new ProductView();
    public static ProductView getInstance(){ return instance; }

    private ProductController pc;
    Scanner scan = new Scanner(System.in);

    public void index(){
        if(pc==null){pc=ProductController.getInstance();}
        for(;;){
            try {
                System.out.println("======== 중고 물품 거래 플랫폼 ========");
                System.out.println("1. 중고 물품 등록\n2. 전체 물품 목록 조회\n3. 물품 정보 수정\n4. 등록 물품 삭제");
                System.out.print("> 선택: ");
                int ch = scan.nextInt();
                if (ch == 1) {}
                else if (ch == 2) {}
                else if (ch == 3) {}
                else if (ch == 4) {}
                else {}
            }catch (InputMismatchException e){
                System.out.println("[경고] 잘못된 입력 방식입니다. [재입력]");
                scan.nextLine();
            }catch (Exception e){
                System.out.println("[시스템오류] 관리자에게 문의하세요.");
            }

        }

    }//index end
}//class end
