package com.imlc.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
	/*	String s = "0111001";
		for (int i = 0; i < 7; i++) {
			if(s.substring(i, i+1).equals("0")){
				System.out.println("is 0");
			}
			else {
				System.out.println("is 1");
			}
		}*/
		/*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式HH:mm:ss
		//df.format(new Date())
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		
		System.out.println(new Date());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2008-10-08 ");
		System.out.println(date);*/
		String string="yes";
				if(string=="ys"){
					System.out.println("haha");
				}
				else {
					System.out.println("fail");
				}
		
	}

}
/*<c:forEach var="functionPopedom" > 
<c:if test="${user.functionPopedom.substring(0, 1).equals("1")}">checked='checked'</c:if>
</c:forEach>
*/