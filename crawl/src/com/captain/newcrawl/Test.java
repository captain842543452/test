package com.captain.newcrawl;

import java.sql.SQLException;  

import com.captain.newcrawl.UrlDataHanding;  
import com.captain.newcrawl .UrlQueue;  
/** 
 * @author captain
 * 
 */  
public class Test {  
    public static void main(String[] args) throws SQLException {  
        String url = "https://book.douban.com";  
        
        String url1 = "https://book.douban.com/tag/互联网?start=20&amp;type=T";  
        String url2 = "https://book.douban.com/tag/算法?start=20&amp;type=T";  
  
        UrlQueue.addElem(url);  
//        UrlQueue.addElem(url1);  
//        UrlQueue.addElem(url2);  
//        UrlQueue.addElem(url3);  
  
        UrlDataHanding[] url_Handings = new UrlDataHanding[10];  
  
        for (int i = 0; i < UrlQueue.size(); i++) {  
            url_Handings[i] = new UrlDataHanding();  
            new Thread(url_Handings[i]).start();  
            try {
            	Thread.sleep(100);
            } catch (InterruptedException e) {
            	// TODO Auto-generated catch block
            	e.printStackTrace();
            }
        } 
       
        

    }  
}
