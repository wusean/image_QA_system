package com.guet.qa.util;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.ocr.AipOcr;


/**
 * @author sean
 * @version 2018年4月29日13:18:37
 */
public class AipImageClassifyUtil {
	//设置APPID/AK/SK
    public static final String APP_ID = "11156994";
    public static final String API_KEY = "EpsB0HbMnFoMuCeYnEeiSkLh";
    public static final String SECRET_KEY = "Wp7z1VOvNw5TPg2N060XmCGhZ2k77EBS";
    
    public AipImageClassify GetClient(){
    	// 初始化一个AipOcr
    	AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
        // 设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        return client;
    }
}
