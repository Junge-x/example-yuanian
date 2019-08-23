package com.example.demo.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 天气种类及标识列表接口调用JAVA示例
 * @author silk
 */
public class GetWeatherSignAndTypeList {
    //接口地址,因为只需要传入一个固定的key为参数,所以设为常量
    private static final String URL= "http://v.juhe.cn/weather/uni?key=ace6036859e68534b14b580db9321026";
    /**
     * 通过工具类获取数据
     * @return
     */
    public static String excute(){
        return PureNetUtil.get(URL);//调用工具类获取接口数据
    }
    /**
     * 利用遍历数组的方式获取
     * @param wid天气对应id
     * @return 天气名称
     */
    public static String getWeatherByWid(String wid) {
        String result=excute();//获取接口数据
        System.out.println(result);
        if(result!=null){
            JSONObject obj=JSONObject.fromObject(result);
            result=obj.getString("resultcode");
            /*获取返回状态码*/
            if(result!=null&&result.equals("200")){
                /*获取数组数据*/
                result=obj.getString("result");
                JSONArray arr=JSONArray.fromObject(result);
                for(Object o:arr){//遍历数组
                    obj=JSONObject.fromObject(o.toString());
                    //如果遍历到需要的数据后直接返回结果,根据key(wid)得到value判断是否等于传入参数
                    if(obj.getString("wid").equals(wid)){
                        result=obj.getString("weather");
                        return result;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(getWeatherByWid("101"));
    }
}