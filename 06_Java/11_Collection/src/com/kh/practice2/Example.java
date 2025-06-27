package com.kh.practice2;

import java.util.*;

public class Example {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, Member> members = new HashMap<>();
    static Map<String, Set<String>> bookRentals = new HashMap<>(); // 책 제목 -> 대여한 회원 이름 목록
    static List<Book> books = new ArrayList<>();
    static Member currentUser = null;

    public static void main(String[] args) {
        initializeBooks();

        while (true) {
            if (currentUser == null) {
                loginOrSignUp();
            } else {
                showMenu();
            }
        }
    }

    // 도서 초기화
    static void initializeBooks() {
    	 books.add(new Book("디스 이즈 이탈리아", false, 0));
         books.add(new Book("리얼 런던", true, 0));
         books.add(new Book("집에서 즐기는 스페인 요리 여행", false, 0));
         books.add(new Book("사퀴트리 샌드위치", false, 0));
         books.add(new Book("원피스 111", true, 15));
         books.add(new Book("귀멸의 칼날 23", false, 19));
         books.add(new Book("진격의 거인 Before the fall 16", false, 19));
    }

    // 로그인 또는 회원가입
    static void loginOrSignUp() {
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("나이: ");
        int age = Integer.parseInt(scanner.nextLine());

        if (members.containsKey(name)) {
            Member member = members.get(name);
            if (member.age == age) {
                System.out.println("로그인 성공!");
                currentUser = member;
            } else {
                System.out.println("이름과 나이가 일치하지 않습니다.");
            }
        } else {
            members.put(name, new Member(name, age));
            System.out.println("회원가입 성공!");
            currentUser = members.get(name);
        }
    }

    // 메뉴 출력
    static void showMenu() {
        System.out.println("\n==== 메뉴 ====");
        System.out.println("1. 마이페이지");
        System.out.println("2. 도서 대여하기");
        System.out.println("3. 로그아웃");
        System.out.println("4. 프로그램 종료");
        System.out.print("선택: ");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                showMyPage();
                break;
            case 2:
                rentBook();
                break;
            case 3:
                currentUser = null;
                break;
            case 4:
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
                break;
            default:
                System.out.println("잘못된 선택입니다.");
        }
    }

    // 마이페이지
    static void showMyPage() {
        System.out.println("== 마이페이지 ==");
        System.out.println("이름: " + currentUser.name);
        System.out.println("나이: " + currentUser.age);
        System.out.println("보유 쿠폰: " + currentUser.hasCoupon);
        System.out.println("대여한 책: " + currentUser.rentedBooks);
    }

    // 도서 대여
    static void rentBook() {
        if (currentUser.rentedBooks.size() >= 3) {
            System.out.println("더 이상 대여할 수 없습니다.");
            return;
        }

        System.out.println("== 도서 목록 ==");
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            System.out.println((i + 1) + ". " + b.title + " (나이 제한: " + b.ageLimit + "세)");
        }

        System.out.print("대여할 책 번호 선택: ");
        int bookNum = Integer.parseInt(scanner.nextLine()) - 1;

        if (bookNum < 0 || bookNum >= books.size()) {
            System.out.println("잘못된 선택입니다.");
            return;
        }

        Book selectedBook = books.get(bookNum);

        // 1. 이미 대여한 책인지 확인
        if (currentUser.rentedBooks.contains(selectedBook.title)) {
            System.out.println("이미 대여한 책입니다.");
            return;
        }

        // 2. 나이 제한 확인
        if (currentUser.age < selectedBook.ageLimit) {
            if (currentUser.hasCoupon) {
                System.out.println("쿠폰으로 나이 제한을 우회합니다.");
                currentUser.hasCoupon = false; // 쿠폰 사용
            } else {
                System.out.println("나이 제한으로 대여 불가능합니다.");
                return;
            }
        }

        // 3. 책당 최대 3명 대여 제한
        Set<String> renters = bookRentals.getOrDefault(selectedBook.title, new HashSet<>());
        if (renters.size() >= 3) {
            System.out.println("이 책은 이미 3명이 대여 중입니다.");
            return;
        }

        // 대여 성공
        currentUser.rentedBooks.add(selectedBook.title);
        renters.add(currentUser.name);
        bookRentals.put(selectedBook.title, renters);

        System.out.println("성공적으로 대여되었습니다.");
    }
}

// 회원 클래스
class Member {
    String name;
    int age;
    boolean hasCoupon;
    Set<String> rentedBooks = new HashSet<>();

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
        this.hasCoupon = true; // 초기 쿠폰 1개
    }
}

// 책 클래스
class Book {
    String title;
    boolean coupon;
    int ageLimit;

    public Book(String title, boolean coupon, int ageLimit) {
        this.title = title;
        this.coupon = coupon;
        this.ageLimit = ageLimit;
    }

}
