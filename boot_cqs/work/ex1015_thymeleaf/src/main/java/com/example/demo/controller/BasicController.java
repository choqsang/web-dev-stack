package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {

    @GetMapping("/book")
    public String getBook(Model model){
        model.addAttribute("title", "타임리프 with 부트");
        model.addAttribute("description", "타임리프 패턴");
        return "basic/book";
    }
    /* 타임리프는 html파일로 구동되며 별도 경로 설정 없이 templates 경로를 인식한다 */

}
