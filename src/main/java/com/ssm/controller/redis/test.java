package com.ssm.controller.redis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hy
 * @create 2018/12/27 0027
 * @description
 */
@Controller
@RequestMapping("/redis")
public class test {

    @RequestMapping("/test1")
    @ResponseBody
    public String test(){

        return "fasd";
    }
}
