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
                System.out.println("======== \uD83D\uDED2 중고 물품 거래 플랫폼 \uD83D\uDED2 ========");
                System.out.println("1. ➕ 중고 물품 등록\n2. \uD83D\uDCCB 전체 물품 목록 조회\n3. \uD83D\uDCDD 물품 정보 수정\n4. \uD83D\uDDD1\uFE0F 등록 물품 삭제");
                System.out.print("> 선택: ");
                int ch = scan.nextInt();
                if (ch == 1) {upDate();}
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

    public void upDate(){
        if(pc==null){pc=ProductController.getInstance();}
        try {
            scan.nextLine();
            System.out.println("\n======== ➕ 중고 물품 등록 ➕ ========");
            System.out.print("1. 닉네임: ");     String pname = scan.nextLine();
            System.out.print("2. 물품명: ");     String ppro = scan.nextLine();
            System.out.print("3. 물품 설명: ");   String pdes = scan.nextLine();
            System.out.print("4. 물품 가격: ");   int ppri = scan.nextInt();
            scan.nextLine();
            System.out.print("5. 비밀번호: ");    String ppw = scan.nextLine();
            System.out.print("6. 연락처: ");     String ppn = scan.nextLine();
            boolean result = pc.upDate(pname,ppro,pdes,ppri,ppw,ppn);
        }catch (InputMismatchException e){
            System.out.println("[경고] 잘못된 입력 방식입니다. [재입력]");
            return;
        }catch (Exception e){
            System.out.println("[시스템오류] 관리자에게 문의하세요.");
        }

    }



}//class end
