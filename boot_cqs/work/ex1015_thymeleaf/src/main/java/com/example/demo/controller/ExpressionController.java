package com.example.demo.controller;

import com.example.demo.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class ExpressionController {

    private final List<Member> members =
            List.of(new Member("hong","hong@a.com",50),
                    new Member("kim","kim@a.com",40));

    @GetMapping("/object")
    public String getMember(Model model){
        Date date = Calendar.getInstance().getTime();
        model.addAttribute("money", 210000000);
        model.addAttribute("member", members);
        model.addAttribute("date", date);
        return "express/object";
    }

    @GetMapping("/link")
    public String getLink(Model model){
        model.addAttribute("id", 1);
        return "express/link";
    }

    @GetMapping("/member")
    public String getIdParam(Model model, Integer id){
    // 회원정보1 에서는 파라미터가 null이기때문에,
    // 1과 2를 모두 처리하기 위해서 int가 아닌 Integer로 받는다

        if(id != null){ // id가 있을 경우,
            model.addAttribute("p_mem", members.get(id));
        } else { // parameter로 받은 값이 없다면
            model.addAttribute("p_mem", members.get(0));
        }
        return "express/member_fin";
    }
    
    // path 방식 처리를 위해 매핑 추가 - parameter에 @PathVariable 어노테이션 필수
    @GetMapping("/member/{id}")
    public String getIdParam2(Model model, @PathVariable Integer id){
        if(id != null){
            model.addAttribute("p_mem", members.get(id));
        } else {
            model.addAttribute("p_mem", members.get(0));
        }
        return "express/member_fin";
    }

}
