package 백준;

import java.io.*;
import java.util.*;


public class 졸업사진 {
	//https://www.acmicpc.net/problem/23349
	static class Place{
		private String place;
		private int start, end;
		
		public Place(String place, int start,int end) {
			this.place = place;
			this.start = start;
			this.end=end;
		}
	}
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<String> names = new ArrayList<>();
		HashMap<String, int[]> map = new HashMap<>();
		List<Place> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name=st.nextToken();
			if(names.contains(name)) continue; //같은 이름이면 컨티뉴
			names.add(name); //이름 추가
			String place=st.nextToken();
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			list.add(new Place(place, start, end)); //위치와 시작,끝 저장
		} 
		br.close();
		//위치 알파벳순으로 정렬
		Collections.sort(list,(x,y)->(x.place.compareTo(y.place)));
		
		//겹치는 시간대 최대값
		int max=0;
		String title="";
		int s=0;
		int e=0;
		//����Ʈ Ž��
		for(Place p:list) {
			//해당 위치의 시간대 가져오기
			int[] time=map.getOrDefault(p.place, new int[50001]);
			//시작~끝 시간
			for(int j=p.start;j<p.end;j++) {
				//겹치는 시간대 증가
				time[j]++;
				//최대값 갱신시 기록
				if(max<time[j]) {
					title = p.place;
					max=time[j];
				}
			}
			//시간대 업데이트
			map.put(p.place, time);
		}
		//최대값을 가진 장소의 시간대
		int[] tmp = map.get(title);

		boolean flag =false;
		//모든 시간대 탐색
		for(int i=1;i<50001;i++) {
			//시작점
			if(tmp[i]==max&&!flag) {
				s=i;
				flag=true;
			//끝점 탐색
			}else if(tmp[i]<max&&flag){
				e=i;
				flag=false;
				break;
			}
		}
		//끝점을 찾지 못하면 50000으로 변경Ʈ
		if(flag) e=50000;
		//출력
		System.out.println(title+" "+s+" "+e);
		
	}
}
