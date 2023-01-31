package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임 {
	//https://www.acmicpc.net/problem/1072
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long x=Long.parseLong(st.nextToken()); //게임 횟수
		long y=Long.parseLong(st.nextToken()); //이긴 횟수
        long z = (y*100)/(x); //승률
        if(z==100||z==99) System.out.println(-1); //100이나 99면 변동 없음으로 -1
        else{
            long answer = 0;
            //이분탐색
            long left = 0;
            long right = Long.MAX_VALUE/2;
            long tmp = -1;
            while(answer!=1&&left+1<right) {
            	tmp = (left+right)/2;
            	long next = ((tmp+y)*100)/(x+tmp);
            	//확률이 같으면, 왼쪽 증가
            	if(next==z) {
            		left = tmp;
        		//확률이 다르면, 오른쪽 감소
            	}else {
            		answer = right =tmp;
            	}
            }
            //출력
            System.out.println(answer);
        }
        br.close();
	}
}
