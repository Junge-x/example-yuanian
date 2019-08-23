package com.example.demo.example.Translate.Service;

import com.example.demo.util.PureNetUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@Service
public class GetTranslate {

    public  String excute(String Word){
        String url="http://www.webxml.com.cn/WebServices/TranslatorWebService.asmx/getEnCnTwoWayTranslator?Word="
                +Word;
        return PureNetUtil.get(url);
    }
    /**
     * 将xml字符串解析成map
     * @param xml
     * @return
     */
    public  Map<String,Object> readStringXml(String xml){
        Document document = null;
        Map<String,Object> map= new HashMap();
        try {
            //将字符串转化为xml；
            document = DocumentHelper.parseText(xml);
            //获得根元素；
            Element root = document.getRootElement();
            System.out.println("跟节点名称："+root.getName());

           List<Element> nodes=root.elements();
           for(int i=0;i<nodes.size();i++){
               if (i==0){
                   map.put("original",nodes.get(i).getStringValue());
               }else if (i==1){
                   map.put("translation",nodes.get(i).getStringValue());
               }
           }
        }catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }





}
