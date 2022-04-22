package 백준;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class 큰수A더하기B {
	
	//https://www.acmicpc.net/problem/10757
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		//1) 배열형태 계산
		
		StringBuilder aSb = new StringBuilder(a);
		StringBuilder bSb = new StringBuilder(b);
		StringBuilder sb = new StringBuilder();
		
		int length = Math.max(a.length(), b.length());
		int[] aArr = new int[length+1];
		int[] bArr = new int[length+1]; 
		
		//숫자 뒤집기(1의자리 숫자부터 계산)
		aSb.reverse();
		bSb.reverse();
		
		//배열 형태로 숫자 넣기
		int idx=0;
		for(char c:aSb.toString().toCharArray()) {
			aArr[idx++] = c-'0';
		}
		idx=0;
		for(char c:bSb.toString().toCharArray()) {
			bArr[idx++] = c-'0';
		}
		
		
		int sum = -1;
		//1의 자리부터 계산
		for(int i=0;i<length;i++) {
			sum = aArr[i]+bArr[i]; //두 숫자의 합
			if(sum>9) aArr[i+1]++; //10이 넘어가면 다음 자릿수+1
			aArr[i]=sum%10; //합의 일의 자리는 aArr에 저장
		}
		
		//출력을 위해 스트링 빌더 맨 앞에 삽입
		for(int i=0;i<length;i++) {
			sb.insert(0, aArr[i]);
		}
		//마지막 자리수가 0이 아니면 넣기
		if(aArr[length]!=0) sb.insert(0, aArr[length]);
		//출력
		bw.write(sb.toString()+"\n");
		
		//2) BigInteger 사용
		BigInteger bigA = new BigInteger(a);
		BigInteger bigB = new BigInteger(b);
		System.out.println(bigA.add(bigB));
		
		br.close();
		bw.close();
	}
}

