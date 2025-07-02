package config;

public interface ServerInfo {
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/erp";
	String USER = "root";
	String PASSWORD = "qwer1234";
}

// 환경설정 데이터의 경우 properties 파일로 따로 만들어 관리하기도 한다!
