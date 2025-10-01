package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.VisitDAO;
import util.PwdBcrypt;
import vo.VisitVO;

@Controller
public class VisitController {

	VisitDAO visit_dao;
	
	public VisitController(VisitDAO visit_dao) {
		this.visit_dao = visit_dao;
	}
	
	@RequestMapping(value={"/", "/list.do"})
	public String list(Model model) {
		List<VisitVO> list = visit_dao.selectList();
		model.addAttribute("list", list);
		return "visit_list";
	}
	
	@RequestMapping("/regi_form.do")
	public String regiForm() {
		return "regi_form";
	}
	
	@RequestMapping("/visit_insert.do")
	public String addList(VisitVO vo, HttpServletRequest request) {
//		PwdBcrypt pbc = new PwdBcrypt();
//		String encodePwd = pbc.encodingPwd(vo.getPwd());
//		vo.setPwd(encodePwd);
		vo.setIp(request.getRemoteAddr());
		int res = visit_dao.register(vo);
		return "redirect:/list.do";
	}
	
	@RequestMapping("/visit_del.do")
	public String delList(int idx) {
		int res = visit_dao.del(idx);
		return "redirect:/list.do";
	}
	
	@RequestMapping("/modify_form.do")
	public String modifyForm(Model model, int idx) {
		VisitVO vo = visit_dao.modify(idx);
		model.addAttribute("vo", vo);
		return "modify_form";
	}
	
	@RequestMapping("/visit_modify.do")
	public String modifyFin(VisitVO vo) {
//		PwdBcrypt pbc = new PwdBcrypt();
//		String encodePwd = pbc.encodingPwd(vo.getPwd());
//		vo.setPwd(encodePwd);
		int res = visit_dao.modifyFin(vo);
		return "redirect:/list.do";
	}
}
