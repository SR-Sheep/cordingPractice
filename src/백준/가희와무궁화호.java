package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 가희와무궁화호 {
	//https://www.acmicpc.net/problem/24336

	static HashMap<String, Station> StationMap;

	static class Station {
		int overday;
		double departTime, arrvialTime;
		double location;

		public Station(double location) {
			this.location = location;
			this.overday=0;
			this.departTime=this.arrvialTime=0d;
		}

		public void setTime(double departTime, double arrvialTime) {
			this.departTime=departTime;
			this.arrvialTime=arrvialTime;
		}
		
		public void setOverday(int day) {
			this.overday = day;
		}

	}
	
	public static double getHour(String timeStr) {
		double time=-1;
		if (timeStr.charAt(0) != '-') {
			String[] tmp = timeStr.split(":");
			time = Double.parseDouble(tmp[0]) + Double.parseDouble(tmp[1]) / 60;
		}
		return time;
	}
	
	public static void setStationKm() {
		StationMap = new HashMap<>();
		
		String[] stationName = { "Seoul", "Yeongdeungpo", "Anyang", "Suwon", "Osan", "Seojeongri", "Pyeongtaek",
				"Seonghwan", "Cheonan", "Sojeongni", "Jeonui", "Jochiwon", "Bugang", "Sintanjin", "Daejeon", "Okcheon",
				"Iwon", "Jitan", "Simcheon", "Gakgye", "Yeongdong", "Hwanggan", "Chupungnyeong", "Gimcheon", "Gumi",
				"Sagok", "Yangmok", "Waegwan", "Sindong", "Daegu", "Dongdaegu", "Gyeongsan", "Namseonghyeon",
				"Cheongdo", "Sangdong", "Miryang", "Samnangjin", "Wondong", "Mulgeum", "Hwamyeong", "Gupo", "Sasang",
				"Busan" };
		double[] km = { 0, 9.1, 23.9, 41.5, 56.5, 66.5, 75, 84.4, 96.6, 107.4, 114.9, 129.3, 139.8, 151.9, 166.3, 182.5,
				190.8, 196.4, 200.8, 204.6, 211.6, 226.2, 234.7, 253.8, 276.7, 281.3, 289.5, 296, 305.9, 323.1, 326.3,
				338.6, 353.1, 361.8, 372.2, 381.6, 394.1, 403.2, 412.4, 421.8, 425.2, 430.3, 441.7 };

		for(int i=0;i<stationName.length;i++) {
			StationMap.put(stationName[i], new Station(km[i]));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//맵에 각 역 위치 설정
		setStationKm();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int stationNum = Integer.parseInt(st.nextToken()); //역 개수
		int questionNum = Integer.parseInt(st.nextToken());//질문 개수
		int day = 0; //경과 날짜
		double beforeArrTime=-1d; //이전 도착 시간
		for (int i = 0; i < stationNum; i++) {
			st = new StringTokenizer(br.readLine());
			String stationName = st.nextToken(); //역 이름
			double arrvialTime = getHour(st.nextToken()); //도착 시간
			double departTime = getHour(st.nextToken()); //출발 시간
			StationMap.get(stationName).setTime(departTime, arrvialTime); //해당 맵에 도착시간, 출발시간 설정
			//이전 도착시간보다 출발시간이 더 빠르면 다음날 출발
			if(beforeArrTime>departTime&&departTime>0) {
				day++;
			}
			//출발 날짜 설정
			StationMap.get(stationName).setOverday(day);
			beforeArrTime=arrvialTime; //이전 도착시간 설정
		}

		//질문 타임
		while(questionNum-->0) {
			st = new StringTokenizer(br.readLine());
			String start = st.nextToken(); //시작역
			String end = st.nextToken(); //도착역
			double km = StationMap.get(end).location - StationMap.get(start).location; //거리
			if(km<0)km*=-1; //음수면 양수로 변환
			double h = StationMap.get(end).arrvialTime -StationMap.get(start).departTime; //걸리는 시간
			int overday =StationMap.get(end).overday-StationMap.get(start).overday; //경과 일수
			h+=overday*24; //걸린 일수를 시간으로 변환
			bw.append(km/h+"\n"); //평균속도 계산
		}
		
		br.close();
		bw.close();
	}
}
