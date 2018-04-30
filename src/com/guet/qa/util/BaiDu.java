package com.guet.qa.util;

import java.net.URLEncoder;

public class BaiDu {
	public static void main(String[] args) {  
	  String otherHost = "http://apis.baidu.com/apistore/idlocr/ocr";  
      // 本地图片路径  
      String filePath = "C:/Users/lenovo/Desktop/12.jpg";  
      filePath.substring(0);
      try {  
          byte[] imgData = FileUtil.readFileByBytes(filePath);  
          String imgStr = Base64Util.encode(imgData);  
          String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");  
          /** 
           * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。 
           */  
          String accessToken = new HttpUtil().getAuth("你的ak值", "你的secerct key值");  
          String result = HttpUtil.post(otherHost, accessToken, params);  
          System.out.println(result);  
      } catch (Exception e) {  
          e.printStackTrace();  
      }
}
}

