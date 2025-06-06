package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 카카오_셔틀버스 {
	
	//https://programmers.co.kr/learn/courses/30/lessons/17678
	
    public static int bus(int n, int t){
        return 9*60+(n-1)*t; 
    }
    
    public static String solution(int n, int t, int m, String[] timetable) {
        int answer=-1;
        List<Integer> list = new ArrayList<>(); //시간을 저장할 리스트 생성
        for(String time:timetable){
            String[] hs = time.split(":");
            int dep = Integer.parseInt(hs[0])*60+Integer.parseInt(hs[1]);
            list.add(dep); //초로 변환 후 리스트에 넣기
        }
        Collections.sort(list); //빠른 순 정렬
        for(int i=1;i<n;i++){
            int busTime = bus(i,t); //버스가 오는 시간
            for(int j=0;j<m;j++){
            	//버스 시간보다 먼저 온 크루가 있으면 탑승
                if(busTime<list.get(0)) break;
                list.remove(0);
            }
        }
        //마지막 버스 시간
        int lastBusTime = bus(n,t);
        int count = 0;
        //범위 내 승객 수 세기
        for(int time:list){
            if(time<=lastBusTime){
                count++;
            }else{
                break;
            }
        }
        //자리가 남으면 마지막 버스시간에 탑승
        if(m>count) answer = lastBusTime;
        //자리가 안남으면 마지막 승객보다 1분 먼저 탑승
        else answer = list.get(m-1)-1;
        //00:00 형식으로 리턴
        return String.format("%02d:%02d",answer/60,answer%60);
    }
    public static void main(String[] args) {
		int n=2, t=10, m=2;
		String[] timetable = {"09:10", "09:09", "08:00"};
		System.out.println(solution(n, t, m, timetable));
	}
}
