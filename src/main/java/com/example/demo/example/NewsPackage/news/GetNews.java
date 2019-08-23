package com.example.demo.example.NewsPackage.news;

import com.example.demo.example.NewsPackage.entity.News;
import com.example.demo.util.PureNetUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * 根据城市名/id查询天气
 * @author silk
 *
 */
public class GetNews {
    /**
     * 根据类型获取新闻
     * @param type
     * @return
     */
    public static String excute(String type){
        String url=//此处以返回json格式数据示例,所以format=2,以根据城市名称为例,cityName传入中文
                "http://zhouxunwang.cn/data/?id=75&type="+type+"&key=BuvGqtJuQo7+h5uM8Yg6RmfJPQTgsJeZ/px16A";
        return PureNetUtil.get(url);//通过工具类获取返回数据
    }

    public List<News> GetNewsByType(String type){
        List<News> newsList = new ArrayList<>();
        String result=excute(type);
//        System.out.println(result);
        if (result!=null){
            JSONObject object = JSONObject.fromObject(result);
            //获取返回的状态码
            result = object.getString("result");
            object = JSONObject.fromObject(result);
            String stat =object.getString("stat");
            if (stat.equals("1")){
                String data = object.getString("data");
                System.out.println(data);
                JSONArray object_news= JSONArray.fromObject(data);
                for (int i=0;i<object_news.size();i++){
                    JSONObject jsonObject =JSONObject.fromObject(object_news.getJSONObject(i));
                    News news = new News();
                   news.setAuthor_name(jsonObject.getString("author_name"));
                   news.setCategory(jsonObject.getString("category"));
                   news.setDate(jsonObject.getString("date"));
                   news.setThumbnail_pic_s(jsonObject.getString("thumbnail_pic_s"));
                   if (jsonObject.has("thumbnail_pic_s02")){
                       news.setThumbnail_pic_s02(jsonObject.getString("thumbnail_pic_s02"));
                   }
                   if (jsonObject.has("thumbnail_pic_s03")){
                       news.setThumbnail_pic_s03(jsonObject.getString("thumbnail_pic_s03"));
                   }

                   news.setTitle(jsonObject.getString("title"));
                   news.setUrl(jsonObject.getString("url"));
                   newsList.add(news);
                }

            }
        }
        return newsList;
    }

    public static void main(String[] args) {
//        System.out.println(excute("top"));
        GetNews getNews =new GetNews();
        System.out.println(getNews.GetNewsByType("top"));
    }
}

