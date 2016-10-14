package com.captain.newcrawl;

/** 
 * @author captain
 * 
 */  
public class HrefOfPage {  
    /** 
     * 获得页面源代码中超链接 
     */  
    public static void getHrefOfContent(String content,String url) { 
//    	<li class="subject-item">
//		<span class="rating_nums">8.8</span>
//    	<div class="pub"> [美] 凯文·凯利 / 东西文库 / 新星出版社 / 2010-12 / 88.00元 </div>
//    	<span class="pl"> (10872人评价) </span>
//    	<a href="https://book.douban.com/subject/6709783/" title="浪潮之巅" onclick="moreurl(this,{i:'1',subject_id:'6709783',from:'book_subject_search'})"> 浪潮之巅 </a>
//    	
//    	<span class="next">
//    	<link rel="next" href="/tag/互联网?start=180&type=T">
//    	<a href="/tag/互联网?start=180&type=T">后页></a>
//    	</span>
    	
    	
    	if(url.contains("/tag/互联网")||url.contains("/tag/算法")||url.contains("/tag/编程")){
    		System.out.println("开始");  
    		System.out.println(url);
    		//System.out.println(content);
    		String[] contents = content.split("<li class=\"subject-item\">"); 
    		
    		for (int i = 1; i < contents.length; i++) {  
    			int endHref = contents[i].indexOf("</li>");  
    			
    			String con = contents[i].substring(0, endHref); 
    			//System.out.println(i);
    			FunctionUtils.ContentHandle(con);
    			
    		} 
    		//没有下一页了，停止抓取
    		if(!content.contains("<link rel=\"next\" href=\"")){
    			BookList.getBookInfo();
    			return;
    		}
    		String aHref = content.split("<link rel=\"next\" href=\"")[1];
    		
    		int endHref = aHref.indexOf("\"");
    		aHref = FunctionUtils.getHrefOfInOut(aHref.substring(  
					0, endHref));
    		if (!UrlQueue.isContains(aHref)&& !VisitedUrlQueue.isContains(aHref)) {  
				UrlQueue.addElem(aHref);  
				System.out.println(aHref);
			}
    		System.out.println(UrlQueue.size() + "--抓取到的连接数");  
    		System.out.println(VisitedUrlQueue.size() + "--已处理的页面数");  
    		
    	}else{
    		System.out.println("开始"); 
    		System.out.println(url);
    		//System.out.println(content);
    		String[] contents = content.split("href=\"");  
    		
    		for (int i = 1; i < contents.length; i++) {  
    			int endHref = contents[i].indexOf("\"");  
    			
    			String aHref = FunctionUtils.getHrefOfInOut(contents[i].substring(  
    					0, endHref));  
    			if (aHref != null) {  
    				//String href = FunctionUtils.getHrefOfInOut(aHref);  
    				
    				if (!UrlQueue.isContains(aHref)  
    						&& (aHref.endsWith("互联网")||aHref.endsWith("编程")||aHref.endsWith("算法"))
    						&& !VisitedUrlQueue.isContains(aHref)) {  
    					UrlQueue.addElem(aHref);  
    					System.out.println(aHref);
    				}
    				
    			}  
    		}  
    		
    		System.out.println(UrlQueue.size() + "--抓取到的连接数");  
    		System.out.println(VisitedUrlQueue.size() + "--已处理的页面数");  
    	}
  
    }  
  
} 
