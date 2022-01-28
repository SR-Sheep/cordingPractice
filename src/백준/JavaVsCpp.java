package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaVsCpp {
	//https://www.acmicpc.net/problem/3613
	public static String tranferLang(String s) {
		//첫째열 대문자, 마지막 _ 이면 에러
		if(s.charAt(0)<'a'||s.charAt(s.length()-1)=='_') return "Error!";
		//스트링빌더
		StringBuilder sb = new StringBuilder();
		boolean isJava=false, isCpp = false;
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			//대문자가 있으면 자바
			if(c<'_') {
				isJava=true;
				sb.append('_').append((char)(c-'A'+'a'));
			}else {
				//언더바가 있으면 C++
				if(c=='_') {
					isCpp=true;
					//다음문자가 소문자가 아니면 에러
					c=s.charAt(++i);
					if(c<'a') {
						return "Error!";
					}
					c = (char)(c - 'a'+'A');
				}
				sb.append(c);
			}
			//자바면서 동시에 C++이면 에러
			if(isJava&&isCpp) {
				return "Error!";
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		System.out.println(tranferLang(s));
		br.close();
	}
}
