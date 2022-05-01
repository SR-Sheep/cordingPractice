package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 카카오_주차요금계산 {
	//https://programmers.co.kr/learn/courses/30/lessons/92341
    public static int[] solution(int[] fees, String[] records) {
        int defalutTime=fees[0];
        int defalutFee=fees[1];
        int perTime=fees[2];
        int perFee=fees[3];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> cars = new ArrayList<Integer>();
        HashMap<Integer, Integer> parkingTime = new HashMap<>();
        
        for(String record:records) {
        	String[] r = record.split(" ");
        	String[] time = r[0].split(":");
        	int Min = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
        	int car = Integer.parseInt(r[1]);
        	char check = r[2].charAt(0);
        	if(check=='I') {
        		map.put(car, Min);
        		if(!cars.contains(car)) {
        			cars.add(car);
        		}
        	}else {
        		int parkingMin = Min - map.get(car);
        		parkingTime.put(car, parkingTime.getOrDefault(car, 0)+parkingMin);
        		map.remove(car);
        	}
        }
        //아직 출차 되지 않은 차
        for(Integer key:map.keySet()) {
        	int parkingMin = (23*60+59) - map.get(key);
    		parkingTime.put(key, parkingTime.getOrDefault(key, 0)+parkingMin);
        }
        
        Collections.sort(cars); //정렬
        int[] answer = new int[cars.size()];
        for(int i=0;i<cars.size();i++) {
        	int car = cars.get(i);
        	int time = parkingTime.get(car) - defalutTime;
        	if(time<0) time = 0;
        	time/=perTime;
        	if(time%perTime!=0) {
        		time++;
        	}
        	answer[i]=defalutFee + (time*perFee);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] record = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
				"07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		for(int i:solution(fees, record)) {
			System.out.println(i);
		}
	}
}
