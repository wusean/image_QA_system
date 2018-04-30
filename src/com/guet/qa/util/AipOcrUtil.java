package com.guet.qa.util;

import com.baidu.aip.ocr.AipOcr;



/**
 * ocr服务接口
 * @author sean
 * @version 1.0 2018年4月26日16:51:56
 *
 */

public class AipOcrUtil {
	//设置APPID/AK/SK
    public static final String APP_ID = "11156994";
    public static final String API_KEY = "EpsB0HbMnFoMuCeYnEeiSkLh";
    public static final String SECRET_KEY = "Wp7z1VOvNw5TPg2N060XmCGhZ2k77EBS";
    
    public AipOcr GetClient(){
    	// 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        return client;
    }
}
