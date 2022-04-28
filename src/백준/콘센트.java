package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 콘센트 {
	//https://www.acmicpc.net/problem/23843
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());//전자기기 수
		int consentNum=Integer.parseInt(st.nextToken());//콘센트 수
		int answer = 0;//답
		st=new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y)->(y-x)); //우선순위 큐, 큰수가 먼저 출력
		//콘센트가 1개면 모든 수 더한 뒤 리턴
		if(consentNum==1) {
			for(int i=0;i<n;i++) {
				answer+=Integer.parseInt(st.nextToken());
			}
			bw.append(answer+"\n");
			br.close();
			bw.close();
			return;
		}
		//콘센트가 2 이상이면 pq에 전자기기 넣기
		for(int i=0;i<n;i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		//최대값, 합계, 횟수
		int max = -1; //현재 충전중인 기기의 시간 최대값
		int sum = 0; //나머지 기기 충전 시간의 합
		int count = 0; //사용하는 콘센트 개수
		while(!pq.isEmpty()) {
			int curr = pq.poll();
			//횟수가 0이라면 최대값 설정, 콘센트 1개 할당 후 컨티뉴
			if(count==0) {
				max=curr;
				count++;
				continue;
			}
			//횟수가 0이 아니라면
			//현재 콘센트 충전 시간을 sum에 더함
			sum+=curr;
			//최대값과 sum이 같다면 해당 기기들을 콘센트 1개에 할당
			if(sum==max) {
				sum=0;
				count++;
			}
			
			//사용하는 콘센트 수가 콘센트 수 이상이라면(모든 콘센트를 사용한다면)
			//최대 사용시간 만큼 답에 더하고 초기화
			if(count>=consentNum) {
				count=0; //카운트 0으로 초기화
				answer+=max; //답에 최대값 더하기
				max=0; //max 초기화
			}
		}
		//모든 큐를 마치고 남은 max만큼 답에 추가
		answer+=max;
		//출력
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
