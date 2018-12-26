package com.ssm.controller.test;

import com.ssm.domain.ColorEnum;
import com.ssm.domain.Test;
import com.ssm.domain.TestEnum;
import com.ssm.helper.EntityMappingMapUtil;
import com.ssm.service.TestEnumService;
import com.ssm.service.TestService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller("/")
public class TestController {

    @Autowired
    private TestService testService;
    @Autowired
    private TestEnumService testEnumService;
    @Autowired
    private com.ssm.aop.Test testAopBean;

    @RequestMapping("/aop")
    public String aop(){
        testAopBean.fa();
        return "fd";
    }

    @RequestMapping("/test")
    public String test(int id, Model model){
        Test test = new Test();
        test.setViewCount(2323);
        Map<String, Object> map = testService.getMap(id);
        map = EntityMappingMapUtil.convertBeanToMap(test);
        model.addAttribute("test",test);
        Map<String,Object> data = new HashMap<String, Object>();
        data.put("context",test.getContext());
        data.put("viewCount",test.getViewCount());
        List<Test> tests = testService.queryTestsByConditions(data);
        return "test/index";
    }

    @RequestMapping("/date")
    public String date(Date date,Model model){
        testService.getContent("");
        System.out.println(testService.getContent(""));
        Map<String, Object> datas = new HashMap<>();
        List<Test> lm = new ArrayList<>();
        for (int i=0;i<10;i++) {
            Test t = new Test();
            t.setContext("fasdf" + i);
            lm.add(t);
        }
        datas.put("Datas", lm);
        datas.put("age", 1);
        model.addAttribute("data", JSONObject.fromObject(datas));
        return "test/index";
    }

//    由@InitBinder表示的方法，可以对WebDataBinder对象进行初始化。WebDataBinder是DataBinder的子类，
// 用于完成由表单到JavaBean属性的绑定。@InitBinder方法不能有返回值，
// 它必须盛名为void。@InitBinder方法的参数通常是WebDataBinder，@InitBinder可以对WebDataBinder进行初始化。
    @InitBinder  //使用InitBinder来处理Date类型的参数
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
                true));
    }

    @RequestMapping("/wxpay")
    public String wxpay(){

        return  null;
    }

    @RequestMapping("/enum")
    @ResponseBody
    public String en(){
        TestEnum testEnum = new TestEnum();
        for (int i=0; i<10; i++){
            testEnum.setType(ColorEnum.K);
            testEnumService.add(testEnum);
        }
        testEnum = testEnumService.getById(11);
        System.out.println(ColorEnum.values());
        System.out.println(testEnum.getType().getItemValue());
        System.out.println(testEnum.getType().getItemLabel());
        return "22";
    }
}
