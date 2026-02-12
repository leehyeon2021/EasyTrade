package Trade.view;

import Trade.controller.ProductController;
import Trade.model.dto.ProductDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductView {
    private ProductView(){}
    private static final ProductView instance = new ProductView();
    public static ProductView getInstance(){ return instance; }

    private ProductController pc = ProductController.getInstance();
    Scanner scan = new Scanner(System.in);

    public void index(){
        for(;;){
            try {
                System.out.println("\n======== \uD83D\uDED2 중고 물품 거래 플랫폼 \uD83D\uDED2 ========");
                System.out.println("1. ➕ 중고 물품 등록\n2. \uD83D\uDCCB 전체 물품 목록 조회\n3. \uD83D\uDCDD 물품 정보 수정\n4. \uD83D\uDDD1\uFE0F 등록 물품 삭제");
                System.out.print("> 선택: ");                int ch = scan.nextInt();
                if (ch == 1) {registProduct();}
                else if (ch == 2) {findAll();}
                else if (ch == 3) {updateProduct();}
                else if (ch == 4) {deleteProduct();}
                else {System.out.println("[경고] 잘못된 번호입니다.");}
            }catch (InputMismatchException e){
                System.out.println("[경고] 잘못된 입력 방식입니다. [재입력]");
                scan.nextLine();
            }catch (Exception e){
                System.out.println("[시스템오류] 관리자에게 문의하세요.");
            }
        }
    }//index end

    // 1. 중고 물품 등록
    public void registProduct(){
        try {
            scan.nextLine();
            System.out.println("\n===== ➕ 중고 물품 등록 ➕ ========================================");
            System.out.print("1. 닉네임: ");     String pname = scan.nextLine();
            System.out.print("2. 물품명: ");     String ppro = scan.nextLine();
            System.out.print("3. 물품 설명: ");   String pdes = scan.nextLine();
            System.out.print("4. 물품 가격: ");   int ppri = scan.nextInt();
            scan.nextLine();
            System.out.print("5. 비밀번호: ");    String ppw = scan.nextLine();
            System.out.print("6. 연락처: ");     String ppn = scan.nextLine();
            boolean result = pc.registProduct(pname,ppro,pdes,ppri,ppw,ppn);
            if(result){System.out.println("[안내] 등록이 완료되었습니다. 이용해주셔서 감사합니다.");}
        }catch (InputMismatchException e){
            System.out.println("[경고] 잘못된 입력 방식입니다. [재입력]");
            return;
        }catch (Exception e){
            System.out.println("[시스템오류] 관리자에게 문의하세요.");
        }
    }

    // 2. 전체 물품 목록 조회
    public void findAll(){
        ArrayList<ProductDto> p = pc.findAll();
        System.out.println("\n----- \uD83D\uDCCB 전체 물품 목록 \uD83D\uDCCB -----------------------------------------");
        System.out.println("번호  |  물품명  |  가격  |  닉네임  |  등록일  |  판매여부  |  연락처 출력");
        for(ProductDto list : p) {
            System.out.printf("%d  |  %s  |  %d  |  %s  |  %s  |  %s  |  %s\n",
                    list.getPno(),list.getPpro(),list.getPpri(),list.getPname(),list.getPdate(),list.getPout(),list.getPpn());
        }
    }

    // 3. 물품 정보 수정
    public void updateProduct(){
        System.out.println("\n===== \uD83D\uDCDD 물품 정보 수정 \uD83D\uDCDD ========================================");
        findAll();
        System.out.print("> 수정할 항목 번호 입력: ");        int pno = scan.nextInt();
        scan.nextLine();
        System.out.print("> 비밀번호 입력: ");        String ppw = scan.nextLine();
        boolean checkPassword = pc.checkPassword(pno,ppw);
        if(checkPassword){
            System.out.println("[비밀번호 입력 성공] 수정 정보를 입력하세요.");
            System.out.print("* 수정할 물품명: ");            String ppro = scan.nextLine();
            System.out.print("* 수정할 물품 설명: ");            String pdes = scan.nextLine();
            System.out.print("* 수정할 가격: ");            int ppri = scan.nextInt();
            scan.nextLine();
            System.out.print("* 수정할 연락처: ");            String ppn = scan.nextLine();
            System.out.print("* 수정할 판매여부 상태 ( 판매 중 / 판매 완료 ): ");            String pout = scan.nextLine();
            boolean result = pc.updateProduct(pno,ppro,pdes,ppri,ppn,pout);
            if(result){
                System.out.println("[안내] 수정이 완료되었습니다.");
            }else{
                System.out.println("[경고] 시스템 오류가 발생하였습니다. 관리자에게 문의하십시오.");
            }
        }else{
            System.out.println("[경고] 비밀번호가 다릅니다.");
            return;
        }
    }

    // 4. 등록 물품 삭제
    public void deleteProduct(){
        System.out.println("\n===== \uFE0F 등록 물품 삭제 \uFE0F ========================================");
        findAll();
        System.out.print("> 삭제할 항목 번호 입력: ");        int pno = scan.nextInt();
        scan.nextLine();
        System.out.print("> 비밀번호 입력: ");        String ppw = scan.nextLine();
        boolean checkPassword = pc.checkPassword(pno,ppw);
        if(checkPassword){
            System.out.println("* 정말로 삭제하시겠습니까? 영구 삭제되어 복구할 수 없습니다.");
            System.out.print("> 예(1) 아니오(2) 번호 선택: ");            int ch = scan.nextInt();
            if(ch==1){
                pc.deleteProduct(pno);
                System.out.println("[안내] 삭제가 완료되었습니다. 이용해주셔서 감사합니다.");
            } else if (ch==2) {
                System.out.println("[안내] 삭제가 취소되었습니다. 메인 메뉴로 돌아갑니다.");
                return;
            }
        }else{
            System.out.println("[경고] 비밀번호가 다릅니다.");
            return;
        }
    }



}//class end
