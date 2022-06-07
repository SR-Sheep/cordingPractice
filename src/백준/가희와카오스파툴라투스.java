package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.StringTokenizer;

public class 가희와카오스파툴라투스 {
	//https://www.acmicpc.net/problem/25239
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//시간 입력
		String[] times = br.readLine().split(":");
		int h = Integer.parseInt(times[0]);
		int s = Integer.parseInt(times[1]);
		LocalTime time = LocalTime.of(h, s);
		
		//구간 입력
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] areas = new int[6];
		for(int i=0;i<6;i++) {
			areas[i]=Integer.parseInt(st.nextToken());
		}
		//행동 횟수
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			st.nextToken(); //입력 시간, 사실상 필요 없음
			String cmd = st.nextToken(); //행동
			//윗방향키 입력시, 파툴라투스 구역 제거
			if(cmd.charAt(0)=='^') {
				//시간이 짝수이고, 분이 00 이면 정각임으로 패쓰
				if(time.getHour()%2==0&&time.getMinute()==0) continue;
				//구역, 12시로 변환 후 6개 구역으로 나눔
				int idx = time.getHour()%12/2;
				//해당 구역 제거
				areas[idx]=0;
			}else {
				//돌릴 시간
				long num = Long.parseLong(cmd.replaceAll("[^0-9]", ""));
				//분일 경우, 분 추가
				if(cmd.contains("MIN")) {
					time = time.plusMinutes(num);
				//시간일 경우, 시 추가
				}else {
					time = time.plusHours(num);
				}
			}
		}
		//파툴라투스 체력 회복량
		int sum = 0;
		//남아있는 구간 더하기
		for(int area:areas) {
			sum+=area;
		}
		//100이 넘으면 100, 아닐 시 sum 출력
		System.out.println(sum>=100?100:sum);
		br.close();
	}
}
