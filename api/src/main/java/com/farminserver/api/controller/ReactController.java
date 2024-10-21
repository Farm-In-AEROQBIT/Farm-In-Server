package com.farminserver.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReactController {

    @RequestMapping(value = { "/" }) // 경로에 .(점)이 없는 요청을 모두 처리
    public String forward() {
        return "forward:/index.html"; // React의 index.html 파일을 서빙
    }
}