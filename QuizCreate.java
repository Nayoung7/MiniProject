package ��������λ��;

import java.io.File;
import java.io.FileWriter;

public class QuizCreate {
	
	public void createText(String txt) {
		  //Thread Ŭ������ �� ù ���� �κ�
		   	String start = " \r\n"
		   			+ "package ��������λ��;\r\n"
		   			+ "\r\n"
		   			+ "class QuizRun \r\n"
		   			+ "{\r\n"
		   			+ "	public int test()\r\n"
		   			+ "	{\r\n"
		   			+ "\r\n"
		   			+ "int sum = 0;"
		   			+ "		try{";
	         
	        
	        //Thread Ŭ���� ������ �κ�
	        String end= "}catch(Exception e){\r\n"
	        		+ "		}\r\n"
	        		+ "return sum;"
	        		+ "	}\r\n"
	        		+ "\r\n"
	        		+ "}";
	        
	        //Thread Ŭ���� ������ ������ ��ġ
	        String fileName = "C:\\Users\\smhrd\\Desktop\\JavaStudy\\��������λ��\\src\\��������λ��\\QuizRun.java" ;
	         
	         
	        try{
	             
	            // ���� ��ü ����
	            File file = new File(fileName) ;
	             
	            // true ������ ������ ���� ���뿡 �̾ �ۼ�
	            FileWriter fw = new FileWriter(file, true) ;
	             
	            // ���Ͼȿ� ���ڿ� ����
	            //���Ͼȿ� ���ڿ��� �ۼ��ϴµ�
	            //Ŭ���� ���Ľİ� ������ �Է��� ������ ������� �س���
	            fw.write(start+txt+end);
	            fw.flush();
	 
	            // ��ü �ݱ�
	            fw.close();
	             
	             
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	      
	 
	    }

}
