package com.imlc.demo.test;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "0111001";
		for (int i = 0; i < 7; i++) {
			if(s.substring(i, i+1).equals("0")){
				System.out.println("is 0");
			}
			else {
				System.out.println("is 1");
			}
		}
	
		
	}

}
/*<c:forEach var="functionPopedom" > 
<c:if test="${user.functionPopedom.substring(0, 1).equals("1")}">checked='checked'</c:if>
</c:forEach>
*/