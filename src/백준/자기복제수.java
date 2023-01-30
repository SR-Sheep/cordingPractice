package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 자기복제수 {
	//https://www.acmicpc.net/problem/2028
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t=Integer.parseInt(br.readLine()); //테스트 개수
		for(int i=0;i<t;i++) {
			int num=Integer.parseInt(br.readLine());
			int zegob = num*num;
			boolean isSelfCopyNumber = false;
			//1자리
			if(num<10) {
				isSelfCopyNumber = zegob%10==num;
			//2자리
			}else if(num<100) {
				isSelfCopyNumber = zegob%100==num;
			//3자리
			}else if(num<1000){
				isSelfCopyNumber = zegob%1000==num;
			//4자리
			}else {
				isSelfCopyNumber = zegob%10000==num;
			}
			bw.append(isSelfCopyNumber?"YES\n":"NO\n"); //출력
		}
		bw.close();
		br.close();
	}
}
