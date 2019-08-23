package com.example.demo.util;

import com.example.demo.Model.Weather;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 根据城市名/id查询天气
 * @author silk
 *
 */
public class WeatherReportByCity {
    /**
     * 根据城市名获取
     * @param cityName
     * @return
     */
    public static String excute(String cityName){
        String url=//此处以返回json格式数据示例,所以format=2,以根据城市名称为例,cityName传入中文
                "http://v.juhe.cn/weather/index?cityname="+cityName+"&key=ace6036859e68534b14b580db9321026";
        return PureNetUtil.get(url);//通过工具类获取返回数据
    }
    /**
     * 获取返回数据中的一个属性示例,此处以获取今日温度为例
     * "temperature": "8℃~20℃"     今日温度
     * @return
     */
    public  List<Weather> GetTodayTemperatureByCity(String city) {
        List<Weather> list = new ArrayList();
        String result=excute(city);
        System.out.println(result);
        if(result!=null){
            JSONObject obj=JSONObject.fromObject(result);
            /*获取返回状态码*/
            result=obj.getString("resultcode");

            if(result!=null&&result.equals("200")){
                result=obj.getString("result");
                obj=JSONObject.fromObject(result);
                //当前时间天气
                String sk=obj.getString("sk");
                JSONObject sk_now= JSONObject.fromObject(sk);
                Weather T1= new Weather();
                T1.setDate(sk_now.getString("time"));
                T1.setTemperature(sk_now.getString("temp"));
                T1.setWeather(sk_now.getString("wind_direction"));
                list.add(T1);
                //今天天气；
                String today = obj.getString("today");
                JSONObject today_obj = JSONObject.fromObject(today);
                Weather T2= new Weather();
                T2.setDate(today_obj.getString("date_y"));
                T2.setTemperature(today_obj.getString("temperature"));
                T2.setWeather(today_obj.getString("weather"));
                T2.setCity(today_obj.getString("city"));
                list.add(T2);
                //接下来的三天温度；

                String future=obj.getString("future");
                JSONObject future_obj = JSONObject.fromObject(future);
                Iterator iterator = future_obj.keys();
                List<Weather> temp = new ArrayList<>();
                temp.add(new Weather());
                temp.add(new Weather());
                temp.add(new Weather());
                temp.add(new Weather());
                temp.add(new Weather());
                for (int i=0; i<4; i++){
                    String key =  (String) iterator.next();
                    JSONObject day = future_obj.getJSONObject(key);
                    temp.get(i).setDate(day.getString("date"));
                    temp.get(i).setTemperature(day.getString("temperature"));
                    temp.get(i).setWeather(day.getString("weather"));
                    list.add(temp.get(i));
                }
//                list.remove(2);
            }
        }
        return list;
    }
//    public static void main(String[] args) {
//        System.out.println(GetTodayTemperatureByCity("武汉"));
//    }
}