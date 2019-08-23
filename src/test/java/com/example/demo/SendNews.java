package com.example.demo;


import com.example.demo.example.NewsPackage.entity.News;
import com.example.demo.example.NewsPackage.news.GetNews;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;


import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendNews {

    @Autowired
    private JavaMailSender javaMailSender;

    @Test
//    @Ignore
    public void contextLoads() throws Exception{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        // 发送方邮箱
        // 发送方邮箱
        helper.setFrom("...");
        // 接收方邮箱
        helper.setTo("...");
        helper.setTo("...");
        String[] cc={"..",".."};
        helper.setCc(cc);

        GetNews getNews = new GetNews();
        List<News> newsList=getNews.GetNewsByType("top");


        String s1;
        String s2="";

        s1="头条新闻列表："+"<br/>";

        for (int i=0;i<newsList.size();i++){
            s2="<tr>"+"<td>"+newsList.get(i).getTitle()+"</td>"
                    +"<td>"+newsList.get(i).getAuthor_name()+"</td>"
                    +"<td>"+newsList.get(i).getCategory()+"</td>"
                    +"<td>"+newsList.get(i).getUrl()+"</td>"
                    +"<td>"+newsList.get(i).getThumbnail_pic_s()+"</td>"
                    +"<td>"+newsList.get(i).getThumbnail_pic_s02()+"</td>"
                    +"<td>"+newsList.get(i).getDate()+"</td>"
                    +"</tr>"+s2;
        }


        helper.setSubject(""+new Date());
        // 内容
        helper.setText(s1+"<table border=\\\"5\\\" style=\\\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;>" +
                "<tr style=\\\"background-color: #428BCA; color:#ffffff\\\"><th>标题</th><th>作者</th><th>类型</th><th>URL</th><th>图片1</th><th>图片2</th><th>时间</th></tr>" +
                s2 +
                "</table>",true);
        javaMailSender.send(mimeMessage);

    }



}
