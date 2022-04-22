package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 잃어버린괄호 {
	
	//https://www.acmicpc.net/problem/1541
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//기호 기준으로 token, 해당 토큰도 포함
		StringTokenizer st=new StringTokenizer(br.readLine(),"+-",true);
		//맨 처음 숫자
		int sum = Integer.parseInt(st.nextToken());
		char c =' ';
		int num = 0;
		boolean allPlus = true;
		
		while(st.hasMoreTokens()) {
			//부호
			c = st.nextToken().charAt(0);
			//숫자
			num = Integer.parseInt(st.nextToken());
			//모두 플러스인 경우
			if(allPlus) { 
				//부호가 +면 더하기
				if(c=='+') {
					sum+=num;
				//부호가 -면 빼고 표시하기	
				}else {
					//모두 플러스 false
					allPlus = false;
					//숫자 빼기
					sum-=num;
				}
			//마이너스 등장 이후 모든 값을 뺄 수 있음
			}else {
				sum-=num;
			}
		}
		//출력
		bw.append(sum+"\n");
		br.close();
		bw.close();
	}
}
