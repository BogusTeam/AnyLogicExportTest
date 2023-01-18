package com.pr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller

public class FrontController {

    @GetMapping(value = "/set_term/{quantity}")
    public String setTerminals(@PathVariable("quantity") Long quantity){
        return "k";
    }

    @GetMapping(value = "/set_vis/{quantity}")
    public String setVisitors(@PathVariable("quantity") Long quantity){
        return "k";
    }

    @GetMapping(value = "/start")
    public int start() {
        return 1;
    }

    @GetMapping(value = "/get")
    public List<DtoDB> getData(){
        return List.of(new DtoDB(1,2,10L,10L,5));
    }

    @GetMapping(value = "/get_ids")
    public List<Long> getIds(){
        return List.of(2L);
    }

    @GetMapping(value = "/get/{id}")
    public List<DtoDB> getDataById(){
        return List.of();
    }
}
