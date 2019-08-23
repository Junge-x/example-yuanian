package com.example.demo;


import com.example.demo.Model.Weather;
import com.example.demo.util.WeatherReportByCity;

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
public class DemoApplicationTests {

	@Autowired
	private JavaMailSender javaMailSender;

	@Test
//    @Ignore
	public void contextLoads() throws Exception{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		// 发送方邮箱
		helper.setFrom("...");
		// 接收方邮箱
		helper.setTo("...");
		helper.setTo("...");
		String[] cc={"..",".."};
		helper.setCc(cc);
		WeatherReportByCity weatherReportByCity = new WeatherReportByCity();
		List<Weather> list = weatherReportByCity.GetTodayTemperatureByCity("武汉");


		String s;
		String s1;
		String s2="";
		Weather weather=list.get(0);
		s=list.get(1).getCity()+"  当前时间天气为："+"<br/>"
				+"当前时间："+weather.getDate()+"   "
				+"当前天气:"+weather.getWeather()+"   "
				+"当前温度:"+weather.getTemperature()+"度"+"<br/>";
		s1="今天和未来三天天气情况："+"<br/>";
//		for (int i=1;i<5;i++){
//			s2="日期："+list.get(i).getDate()+"   "
//			+"天气："+list.get(i).getWeather()+"   "
//			+"温度："+list.get(i).getTemperature()+"   "
//			+"\n"+s2;
//		}
        for (int i=4;i>1;i--){
            s2="<tr>"+"<td>"+list.get(i).getDate()+"</td>"
                    +"<td>"+list.get(i).getWeather()+"</td>"
                    +"<td>"+list.get(i).getTemperature()+"</td>"
                    +"</tr>"+s2;
        }

		String text=s+s1+s2;
		helper.setSubject("春蕾学员培训-天气预报 + 谢云洁  "+new Date());
		// 内容
        helper.setText(s+s1+"<table border=\\\"5\\\" style=\\\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;>" +
                "<tr style=\\\"background-color: #428BCA; color:#ffffff\\\"><th>日期</th><th>天气</th><th>温度</th></tr>" +
                s2 +
                "</table>",true);
		javaMailSender.send(mimeMessage);

	}



}
