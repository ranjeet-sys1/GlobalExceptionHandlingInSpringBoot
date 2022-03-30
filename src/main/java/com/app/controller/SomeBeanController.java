package com.app.controller;

import com.app.model.SomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v2/")
public class SomeBeanController {
    @GetMapping("bean")
    public SomeBean getBean(){
        return new SomeBean("value1","value2","value3");
    }
    @GetMapping("bean-list")
    public List<SomeBean> getListOfBean(){
        return Arrays.asList(
                new SomeBean("value11","value12","value13"),
                new SomeBean("value21","value22","value23"),
                new SomeBean("value31","value32","value33"));
    }
}
