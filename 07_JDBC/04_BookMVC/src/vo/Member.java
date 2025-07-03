package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member { // --> member_info
	private String id; // primary key
	private String name; 
	private String pwd; 
	private int age;
}


		//1. 전체 책 조회 - 로그인 X
		// 4. 회원 가입 - 로그인 X
		// 5. 로그인 - 로그인 X
		
		// 관리자 로그인 필요 (id : admin / pwd : 1234)
		// 2. 책 신규 등록 - 로그인 O
		// 3. 책 삭제 - 로그인 O
		// 5. 로그아웃 - 로그인 O

		// 일반회원 로그인 필요
		// 5. 로그아웃 - 로그인 O
		// 6. 회원 탈퇴 - 로그인 O
		// 7. 책 대여 - 로그인 O
		// 8. 내가 대여한 책 조회 - 로그인 O
		// 9. 대여 취소 - 로그인 O