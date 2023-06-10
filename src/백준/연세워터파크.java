package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/15678
public class 연세워터파크 {
	
	static int N,D;
	static long INF = Long.MIN_VALUE/3;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
        long[] dp = new long[N]; //누적 최적 합
        Deque<Integer> dq = new LinkedList<>(); //불필요한 dp 계산을 피하기 위한 idx dq
        st = new StringTokenizer(br.readLine());
        //최대값
        long max = INF;
        for (int i = 0; i < N; i++) {
        	//값
            long value = Long.parseLong(st.nextToken());
            //dq에 현재 idx 범위 내 idx가 있을 때까지
            while (!dq.isEmpty() && i - dq.peekFirst() > D) dq.poll(); //앞 idx 제거
            //dq 가 비어있으면 value, 아닌 경우 dp[dq의 최소 idx] 와 value 중 최대값 
            dp[i] = dq.isEmpty() ? value : Math.max(dp[dq.peekFirst()] + value, value);
            //최대값 갱신
            max = Math.max(max, dp[i]);
            //현재 dp 보다 작은 값의 idx 제거
            while (!dq.isEmpty() && dp[dq.peekLast()] < dp[i]) dq.pollLast(); //뒤 idx 제거
            dq.add(i);
        }
        //최대값 출력
        System.out.println(max);
		br.close();
	}
}
