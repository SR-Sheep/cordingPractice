package 백준;

import java.io.*;
import java.util.*;


public class 졸업사진 {
	//https://www.acmicpc.net/problem/23348
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
			if(names.contains(name)) continue; //이름이 존재하면 컨티뉴
			names.add(name); //이름 추가
			String place=st.nextToken();
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			list.add(new Place(place, start, end)); //리스트에 클래스 형태로 저장
		} 
		br.close();
		//이름순 정렬
		Collections.sort(list,(x,y)->(x.place.compareTo(y.place)));
		
		//초기값 선언
		int max=0;
		String title="";
		int s=0;
		int e=0;
		//리스트 탐색
		for(Place p:list) {
			//시간 배열 생성, 이미 존재하면 해당 배열을 가져옴
			int[] time=map.getOrDefault(p.place, new int[50001]);
			//시작~끝까지 값 증가
			for(int j=p.start;j<p.end;j++) {
				time[j]++;
				//최대값보다 크면 해당 장소와 max값 업데이트
				if(max<time[j]) {
					title = p.place;
					max=time[j];
				}
			}
			map.put(p.place, time);
		}
		//답 장소의 시간 배열
		int[] tmp = map.get(title);

		boolean flag =false;
		for(int i=1;i<50001;i++) {
			//처음으로 max값을 만나면 s로 저장
			if(tmp[i]==max&&!flag) {
				s=i;
				flag=true;
			//처음으로 max보다 작은 값을 만나면 e로 저장 후 break;
			}else if(tmp[i]<max&&flag){
				e=i;
				flag=false;
				break;
			}
		}
		//끝을 만나지 못했으면 최대값인 50000으로 업데이트
		if(flag) e=50000;
		//출력
		System.out.println(title+" "+s+" "+e);
		
	}
}
