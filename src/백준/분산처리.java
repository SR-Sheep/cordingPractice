package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 분산처리 {
	//https://www.acmicpc.net/problem/1009
	//분산 처리
	public static int distributeRemiander(int a, int b) {
		int result = -1;
		//짝수
		if(b%2==0) {
			result = distributeRemiander(a, b/2);
			return (result*result)%10;
		//1인 경우
		}else if(b==1){
			return a%10;
		//홀수	
		}else {
			result = distributeRemiander(a, (b-1)/2);
			return (result*result*a)%10;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(n-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			int result = distributeRemiander(a, b); //결과 
			bw.append((result==0?10:result)+"\n"); //0이면 10번째 컴퓨터에서 종료
		}
		br.close();
		bw.close();
	}
}
