package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import dao.BookDAO;
import vo.Book;

public class BookController {
	
	private BookDAO dao = BookDAO.getInstance();
	ArrayList<Book> list = new ArrayList<>();
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws Exception {
		return list;
	}
	
	// 2. 책 등록
	public boolean registerBook(String title, String author, int accessAge) {
		
		// 기존 제목, 저자, 제한 나이까지 동일한 책이 있으면 안되게!
		
		return false;
	}
	
	// 3. 책 삭제
	public boolean sellBook(int bookNo) {

		// 빌려있는 책은 삭제 못하게!
		
		return false;
	}
	
}
