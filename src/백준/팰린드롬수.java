package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class �Ӹ���Ҽ� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		while(!s.equals("0")) {
			boolean isPalindrome = true;
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)!=s.charAt(s.length()-1-i)) {
					isPalindrome=false;
					break;
				}
			}
			bw.append(isPalindrome?"yes\n":"no\n");
			s=br.readLine();
		}
		br.close();
		bw.close();
	}
}
