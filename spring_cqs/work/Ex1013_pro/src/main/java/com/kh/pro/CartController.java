package com.kh.pro;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CartDAO;
import vo.CartVO;

@Controller
public class CartController {

	CartDAO cart_dao;
	
	public void setCart_dao(CartDAO cart_dao) {
		this.cart_dao = cart_dao;
	}
	
	@RequestMapping("/cart_list.do")
	public String cartList(int m_idx, Model model) {
		List<CartVO> list = cart_dao.select(m_idx);
		model.addAttribute("list", list);
		int total = cart_dao.selectTotalAmount(m_idx);
		model.addAttribute("total", total);
		return "cart/cart_list";
	}
	
	@RequestMapping("/cart_insert.do")
	@ResponseBody
	public String cartInsert(CartVO vo) {
		CartVO resVo = cart_dao.selectOne(vo);
		String result = "no";
		if (resVo == null) {
			result = "yes";
			cart_dao.insert(vo);
		}
		String resStr = String.format("[{'result' : '%s'}]", result);
		
		return resStr;
	}
	
	@RequestMapping("/cart_delete.do")
	public String cartDel(int c_idx, Model model) {
		cart_dao.cartDelete(c_idx);
		int m_idx = 1;
		List<CartVO> list = cart_dao.select(m_idx);
		model.addAttribute("vo", list);
		int total = cart_dao.selectTotalAmount(m_idx);
		model.addAttribute("total", total);
		return "redirect:/cart_list.do?m_idx=" + m_idx;
	}

	@RequestMapping("/cart_update.do")
	public String cntModify(CartVO vo) {
		int m_idx = 1;
		vo.setM_idx(m_idx);
		cart_dao.cartUpdate(vo);
		return "redirect:/cart_list.do?m_idx=" + m_idx;
	}
}