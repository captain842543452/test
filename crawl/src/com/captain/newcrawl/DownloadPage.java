package com.captain.newcrawl;

import java.io.IOException;  

import org.apache.http.HttpEntity;  
import org.apache.http.HttpResponse;  
import org.apache.http.client.ClientProtocolException;  
import org.apache.http.client.HttpClient;  
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.impl.client.DefaultHttpClient;  
import org.apache.http.util.EntityUtils;  
  
/** 
 *  
 * @author  captain
 * 
 */  
public class DownloadPage {  
  
    /** 
     * 根据URL抓取网页内容 
     *  
     * @param url 
     * @return 
     */  
    public static String getContentFormUrl(String url) {  
        /* 实例化一个HttpClient客户端 */  
        HttpClient client = new DefaultHttpClient();  
        HttpGet getHttp = new HttpGet(url);  
  
        String content = null;  
        
        getHttp.addHeader("Accept", "text/html");  
        getHttp.addHeader("Accept-Charset", "utf-8");  
        getHttp.addHeader("Accept-Encoding", "utf-8");  
        getHttp.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");  
        getHttp.addHeader("User-Agent",  
                "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0");
    	
        
        HttpResponse response;  
        try {  
            /* 获得信息载体 */  
            response = client.execute(getHttp);  
            HttpEntity entity = response.getEntity();  
            VisitedUrlQueue.addElem(url);  
  
            if (entity != null) {  
                /* 转化为文本信息 */  
                content = EntityUtils.toString(entity,"utf-8");  
  
                //System.out.println(content);
                /* 判断是否符合下载网页源代码到本地的条件 */  
                if (FunctionUtils.isCreateFile(url)  
                        && FunctionUtils.isHasGoalContent(content) != -1) {  
                    FunctionUtils.createFile(FunctionUtils.getGoalContent(content), url);  
                }  
            }  
  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            client.getConnectionManager().shutdown();  
        }  
        //System.out.println(content);
        return content;  
    }  
  
}  
