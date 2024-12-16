package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SbbController {
    @GetMapping("/sbb")
    @ResponseBody
    public String sbb(){
        return "sbb";
    }
}
