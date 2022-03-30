package com.app.controller;

import com.app.model.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/v3/")
public class DynamicFilteringPropertyController {
    //filter filed2 , filed3
    @GetMapping("bean")
    public MappingJacksonValue getBean(){
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        return  getFilterProperty(someBean, "filed1", "filed2");

    }
    @GetMapping("bean-list")
    public MappingJacksonValue getListOfBean(){
        List<SomeBean> list = Arrays.asList(
                new SomeBean("value11", "value12", "value13"),
                new SomeBean("value21", "value22", "value23"),
                new SomeBean("value31", "value32", "value33"));
        return  getFilterProperty(list, "filed2", "filed3");
    }
    public MappingJacksonValue getFilterProperty(List<SomeBean> list,String... filterProperty){
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept(filterProperty);
        FilterProvider filterprovider=new SimpleFilterProvider().addFilter("someBeanFilter",filter);
        MappingJacksonValue mappedToBean=new MappingJacksonValue(list);
        mappedToBean.setFilters(filterprovider);
        return mappedToBean;
        
    }
    public MappingJacksonValue getFilterProperty(SomeBean someBean,String... filterProperty){
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept(filterProperty);
        FilterProvider filterprovider=new SimpleFilterProvider().addFilter("someBeanFilter",filter);
        MappingJacksonValue mappedToBean=new MappingJacksonValue(someBean);
        mappedToBean.setFilters(filterprovider);
        return mappedToBean;

    }
}
