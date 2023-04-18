package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/16953
public class AtoB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int answer =0;
		boolean isAnswer = false;
		//역으로 추적
		while(a<=b) {
			if(a==b) { //같으면 답
				isAnswer = true;
				answer++;
				break;
			}else if(b%2==0) { //2로 나눠지면 나누기
				b/=2;
				answer++;
			}else if(b%10==1) { //마지막 수가 1이면 마지막수 제외(/10)
				b/=10;
				answer++;
			}else {
				break;
			}
		}
		System.out.println(isAnswer?answer:-1); //답이 있으면 출력, 없으면 -1
		br.close();
	}
}
