package com.captain.newcrawl;

import java.util.HashSet;  

/** 
 * 已访问url队列 
 *  
 * @author captain
 *  
 */  
public class VisitedUrlQueue {  
    public static HashSet<String> visitedUrlQueue = new HashSet<String>();  
  
    public synchronized static void addElem(String url) {  
        visitedUrlQueue.add(url);  
    }  
  
    public synchronized static boolean isContains(String url) {  
        return visitedUrlQueue.contains(url);  
    }  
  
    public synchronized static int size() {  
        return visitedUrlQueue.size();  
    }  
} 
