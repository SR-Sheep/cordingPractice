package 프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 카카오_신고결과받기 {
	//https://programmers.co.kr/learn/courses/30/lessons/92334
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] reports = new int[id_list.length];
        List<Integer>[] offenders = new List[id_list.length];
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<id_list.length;i++) {
        	map.put(id_list[i], i);
        	offenders[i]=new ArrayList<Integer>();
        }
        Set<String> reportSet = new HashSet<String>();
        //중복 제거
        for(String r:report) {
        	reportSet.add(r);
        }
        for(String r:reportSet) {
        	String[] tmp = r.split(" ");
        	int rep = map.get(tmp[0]);
        	int off = map.get(tmp[1]);
        	offenders[rep].add(off); //신고자 -> 용의자 추가
        	reports[off]++;//용의자 증가
        }
        for(int i=0;i<id_list.length;i++) {
        	int count = 0;
        	for(int off:offenders[i]) {
        		if(reports[off]>=k) {
        			count++;
        		}
        	}
        	answer[i]=count;
        }
        return answer;
    }
	
	public static void main(String[] args) {
//		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] id_list = {"con", "ryan"};
//		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k = 2;
		for(int i:solution(id_list, report, k)) {
			System.out.print(i+" ");
		}
		
	}
}
