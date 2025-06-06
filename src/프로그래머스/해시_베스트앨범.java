package 프로그래머스;

import java.util.*;
import java.util.Map.Entry;

public class 해시_베스트앨범 {
	/*
	genres[i]는 고유번호가 i인 노래의 장르입니다.
	plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
	genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
	장르 종류는 100개 미만입니다.
	장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
	모든 장르는 재생된 횟수가 다릅니다.
	 * 
	 */
			
			
    public static int[] solution(String[] genres, int[] plays) {
     	HashMap<String, List<int[]>> songMap = new HashMap<>();
     	HashMap<String, Integer> genreMap = new HashMap<>();
     	
     	for(int i=0;i<plays.length;i++) {
     		String genre=genres[i];
     		genreMap.put(genre, genreMap.getOrDefault(genre, 0)+plays[i]); //장르에 실행 횟수 누적
     		songMap.putIfAbsent(genre, new ArrayList<int[]>()); //songMap에 값 없으면 생성
     		songMap.get(genre).add(new int[] {i,plays[i]}); //songMap에 장르,[idx, 횟수] 넣기;
     	}
     	
     	List<Entry<String, Integer>> entryList= new ArrayList<>(genreMap.entrySet()); 
     	Collections.sort(entryList,(o1,o2)->o2.getValue().compareTo(o1.getValue())); //장르의 key, value 값에 따른 정렬
     	
     	List<Integer> answer = new ArrayList<Integer>();
     	for(Entry<String,Integer> entry:entryList) {
     		List<int[]> list = songMap.get(entry.getKey()); //각 장르의 list 불러오기
     		Collections.sort(list, (o1,o2)->o2[1]-o1[1]);  //list 내림차순 정렬
     		for(int i=0;i<2;i++) { //두개만 출력
     			if(i<list.size()) { //리스트 사이즈보다 작으면 넣기(1개일 경우 1개만 넣기)
     				answer.add(list.get(i)[0]); //idx 답에 넣기
     			}
     		}
     	}
         return answer.stream().mapToInt(Integer::intValue).toArray(); //array로 변환하여 리턴
    }
	
	
	public static void main(String[] args) {
		String[] g = {"classic", "pop", "classic", "classic", "pop"};
		int[] p= {500, 600, 150, 800, 2500};
		for(int i:solution(g, p)) System.out.print(i+" ");
				
	}

}
