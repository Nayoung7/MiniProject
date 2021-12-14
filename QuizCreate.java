package 스인재살인사건;

import java.io.File;
import java.io.FileWriter;

public class QuizCreate {
	
	public void createText(String txt) {
		  //Thread 클래스가 될 첫 시작 부분
		   	String start = " \r\n"
		   			+ "package 스인재살인사건;\r\n"
		   			+ "\r\n"
		   			+ "class QuizRun \r\n"
		   			+ "{\r\n"
		   			+ "	public int test()\r\n"
		   			+ "	{\r\n"
		   			+ "\r\n"
		   			+ "int sum = 0;"
		   			+ "		try{";
	         
	        
	        //Thread 클래스 마지막 부분
	        String end= "}catch(Exception e){\r\n"
	        		+ "		}\r\n"
	        		+ "return sum;"
	        		+ "	}\r\n"
	        		+ "\r\n"
	        		+ "}";
	        
	        //Thread 클래스 파일이 생성될 위치
	        String fileName = "C:\\Users\\smhrd\\Desktop\\JavaStudy\\스인재살인사건\\src\\스인재살인사건\\QuizRun.java" ;
	         
	         
	        try{
	             
	            // 파일 객체 생성
	            File file = new File(fileName) ;
	             
	            // true 지정시 파일의 기존 내용에 이어서 작성
	            FileWriter fw = new FileWriter(file, true) ;
	             
	            // 파일안에 문자열 쓰기
	            //파일안에 문자열을 작성하는데
	            //클래스 형식식과 전에서 입력한 내용이 담겨지게 해놓음
	            fw.write(start+txt+end);
	            fw.flush();
	 
	            // 객체 닫기
	            fw.close();
	             
	             
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	      
	 
	    }

}
