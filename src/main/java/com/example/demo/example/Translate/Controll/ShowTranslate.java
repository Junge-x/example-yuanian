package com.example.demo.example.Translate.Controll;

import com.example.demo.example.Translate.Service.GetTranslate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class ShowTranslate {
    @Autowired
    private GetTranslate getTranslate;

    @GetMapping("translate")
    public Map<String,Object> getData(String Word){
        Map map= new HashMap();
        System.out.println(Word);

        String xml = getTranslate.excute(Word);

        map=getTranslate.readStringXml(xml);

        return map;
    }
}
