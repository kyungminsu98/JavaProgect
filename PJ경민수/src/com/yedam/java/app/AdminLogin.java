package com.yedam.java.app;

import java.util.Scanner;

import com.yedam.java.book.Book;
import com.yedam.java.book.BookDAO;

public class AdminLogin {
    // 필드
    private Scanner sc = null;
    private BookDAO bookDAO;
    // 생성자
    public AdminLogin() {
        sc = new Scanner(System.in);
        bookDAO = BookDAO.getInstance();
    }
    BookApp bookApp = new BookApp();
    public void run() {
        while (true) {
            // 메뉴 출력
            adminmenuPrint();
            // 메뉴 선택
            int menu = selectMenu();
            if(menu == 1) { //전체 도서 조회
            	bookApp.selectBookAll();
            }else if (menu == 2) {//단건 도서 조회
            	bookApp.selectBookOne();
            }else if (menu == 3) {//도서 등록
            	addBook();
            }else if (menu == 4) {//도서 수정
            	updateBook();
            }else if (menu == 5) {//도서 삭제
            	deleteBookIsbn();
            }else if (menu == 6) {//도서 대여 내역

            }else if (menu == 7) {//문의확인

            }else if (menu == 8) {//로그아웃
                logout();
                break;
            } else {
                showError();
            }
        }
    }

    private void logout() {
        System.out.println("|로그아웃|");
    }
    private void adminmenuPrint() {
        String menu = "";
        menu += "1.전체조회 ";
        menu += "2.개별조회 ";
        menu += "3.도서등록 ";
        menu += "4.도서수정 ";
        menu += "5.도서삭제 ";
        menu += "6.도서 대여 내역 ";
        menu += "7.문의확인 ";
        menu += "8.로그아웃 ";
        System.out.println("=================================");
        System.out.println(menu);
        System.out.println("====================================");
    }
    private int selectMenu() {
        System.out.print("선택 > ");
        return inputNumber();
    }
    private int inputNumber() {
        int num = 0;
        try {
            num = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자로 입력해주시기 바랍니다.");
        }
        return num;
    }
    private void showError() {
        System.out.println("숫자로 입력해주시기 바랍니다.");
        System.out.println("메뉴에서 선택해주시기 바랍니다.");
    }
    private void addBook() {
        System.out.println("도서 정보를 입력하세요.");
        // 시퀀스
        String isbn = generateISBN();
        System.out.print("도서 제목: ");
        String title = sc.nextLine();
        System.out.print("저자: ");
        String author = sc.nextLine();
        System.out.print("내용: ");
        String content = sc.nextLine();
        System.out.print("재고: ");
        int stock = Integer.parseInt(sc.nextLine());

        Book newBook = new Book(isbn, title, author, content, stock);

        // BookDAO를 사용하여 도서 등록
        if (bookDAO.insertBookInfo(newBook) > 0) {
        	generateISBN();
            System.out.println("도서가 등록되었습니다.");
        } else {
            System.out.println("도서 등록에 실패하였습니다.");
        }
    }
    private String generateISBN() {
        // 시퀀스를 사용하여 ISBN 생성
        String query = "SELECT '978' || LPAD(book_seq.NEXTVAL, 10, '1') AS new_isbn FROM dual";
        // 여기서 '978'은 일반적인 ISBN 접두어입니다.
        // LPAD 함수는 시퀀스 값을 왼쪽으로 0으로 채워서 총 10자리로 만듭니다.

        // 시퀀스 값을 가져와서 ISBN 생성
        // 여기서는 데이터베이스와의 연동을 가정하고 실제로 데이터베이스에서 값을 가져오는 코드를 작성해야 합니다.
        String generatedIsbn = "9780000000000"; // 실제로는 데이터베이스에서 가져온 값을 사용해야 합니다.

        return generatedIsbn;
    }
    public void deleteBookIsbn() {
        System.out.println("도서 정보를 삭제합니다.");
        System.out.print("삭제할 도서의 ISBN을 입력하세요: ");
        String isbn = sc.nextLine();

        BookDAO bookDAO = BookDAO.getInstance();
        int result = bookDAO.deleteBookInfo(isbn);
        if (result > 0) {
            System.out.println("도서가 성공적으로 삭제되었습니다.");
        } else {
            System.out.println("도서 삭제에 실패하였습니다.");
        }
    }
    public void updateBook() {
    	System.out.println("도서 정보를 수정합니다.");
        System.out.print("수정할 도서의 ISBN을 입력하세요: ");
        String isbn = sc.nextLine();
        
        BookDAO bookDAO = BookDAO.getInstance();
        Book book = bookDAO.selectBookInfo(isbn, "", ""); 
        if (book == null) {
            System.out.println("해당 도서를 찾을 수 없습니다.");
            return;
        }
        System.out.println("현재 도서 정보:");
        System.out.println(book);
        System.out.println("수정할 내용을 입력하세요.");
        System.out.print("도서 제목: ");
        String title = sc.nextLine();
        if (!title.isEmpty()) {
            book.setTitle(title);
        }
        System.out.print("저자: ");
        String author = sc.nextLine();
        if (!author.isEmpty()) {
            book.setAuthor(author);
        }
        System.out.print("내용: ");
        String content = sc.nextLine();
        if (!content.isEmpty()) {
            book.setContent(content);
        }
        System.out.print("재고: ");
        String stockStr = sc.nextLine();
        if (!stockStr.isEmpty()) {
            try {
                int stock = Integer.parseInt(stockStr);
                book.setStock(stock);
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                return;
            }
        }
        int result = bookDAO.updateBookInfo(book);
        if (result > 0) {
            System.out.println("도서 정보가 수정되었습니다.");
            System.out.println("변경된 도서 정보:");
            System.out.println(bookDAO.selectBookInfo(isbn, "", ""));
        } else {
            System.out.println("도서 정보 수정에 실패하였습니다.");
        }
    }
}