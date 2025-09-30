package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDAO;
import util.PwdBcrypt;
import vo.MemberVO;

@Controller
public class MemberController {

	MemberDAO member_dao;
	
	public void setMember_dao(MemberDAO member_dao) {
		this.member_dao = member_dao;
	}
	
	@RequestMapping("/list.do")
	public String list(Model model, HttpSession session) {
		List<MemberVO> list = member_dao.selectList();
		model.addAttribute("list", list); // 바인딩
		session.setAttribute("login_name" , session.getAttribute("login_name"));
		return "member/member_list"; // 포워딩
	}
	
	@RequestMapping("/regi_form.do")
	public String regiform() {
		return "member/regi_form";
	}

	@RequestMapping("/member_insert.do")
	public String register(MemberVO vo) {
		// member_insert.do?name1=a&id=a&pwd=11..
		// @RequestParam("name1") 쓰는 이유 : 파라미터로 넘겨지는 값이 변수이름과 다를 경우 매칭시키기 위해
		
		PwdBcrypt pbc = new PwdBcrypt();
		String encodePwd = pbc.encodingPwd(vo.getPwd());
		vo.setPwd(encodePwd);
		
		int res = member_dao.register(vo);
		return "redirect:/list.do";
	}
	
	@RequestMapping("/modify.do")
	public String modifyform(Model model, int idx) {
		MemberVO vo = member_dao.selectOne(idx);
		model.addAttribute("vo", vo);
		return "member/modify_form";
	}
	
	@RequestMapping("/modify_fin.do")
	public String modify(MemberVO vo) {
		PwdBcrypt pbc = new PwdBcrypt();
		String encodePwd = pbc.encodingPwd(vo.getPwd());
		vo.setPwd(encodePwd);
		
		int res = member_dao.modify(vo);
		return "redirect:/list.do";
	}
	
//	@RequestMapping("/del.do")
//	public String del(int idx) {
//		int res = member_dao.del(idx);
//		return "redirect:/list.do";
//	}
	
	@RequestMapping("/del.do")
	@ResponseBody
	public String member_del(int idx) {
		int res = member_dao.memberDel(idx);
		String result = "no";
		if( res == 1 ) {
			// 삭제 성공 시,
			result = "yes";
		}
		return result;
	}
	
}
