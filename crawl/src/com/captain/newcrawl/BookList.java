package com.captain.newcrawl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class BookList{
	public static ArrayList<Book> bookList = new ArrayList<Book>();
	
	 public synchronized static void addElem(Book b) {
		 if(bookList.size()<100){
			 
			 bookList.add(b);
		 }else{
			Collections.sort(bookList);
			bookList.remove(99);
			bookList.add(b);
		 }

	 }
	 
	 public synchronized static void getBookInfo(){
		 System.out.println(bookList.size());
		 WritableWorkbook book = null;
	        try {
	            // 打开文件
	            book = Workbook.createWorkbook(new File("D:/测试.xls"));
	            // 生成名为"book"的工作表，参数0表示这是第一页
	            WritableSheet sheet = book.createSheet("book", 0);
	            
	            String[] title = {"序号","书名","评分","评价人数","作者","出版社","出版日期","价格"};
	            
	            for(int i=0;i<title.length;i++){  
	                 // Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z  
	                 // 在Label对象的子对象中指明单元格的位置和内容  
	                 Label label = new Label(i,0,title[i]);
	                 // 将定义好的单元格添加到工作表中  
	                 sheet.addCell(label);  
	             }   
	            System.out.println("--------------");
	            for(int i=1;i<=100;i++){
	            	jxl.write.Number number0 = new jxl.write.Number(0,i,i);  
	            	
	            	Label label1 = new Label(1,i,bookList.get(i-1).getName());
	            	jxl.write.Number number2 = new jxl.write.Number(2,i,bookList.get(i-1).getScore());
	            	jxl.write.Number number3 = new jxl.write.Number(3,i,bookList.get(i-1).getEva_num());
	            	Label label4 = new Label(4,i,bookList.get(i-1).getAuthor());
	            	Label label5 = new Label(5,i,bookList.get(i-1).getPublisher());
	            	Label label6 = new Label(6,i,bookList.get(i-1).getDate());
	            	Label label7 = new Label(7,i,bookList.get(i-1).getPrice());
	            	
	            	sheet.addCell(number0);
	            	sheet.addCell(number2);
	            	sheet.addCell(number3);
	            	sheet.addCell(label1);
	            	sheet.addCell(label4);
	            	sheet.addCell(label5);
	            	sheet.addCell(label6);
	            	sheet.addCell(label7);
	            	
	            }
	            // 写入数据并关闭文件
	            book.write();
	        } catch (Exception e) {
	            System.out.println(e);
	        }finally{
	            if(book!=null){
	                try {
	                    book.close();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                } 
	            }
	        }
	 }


}
