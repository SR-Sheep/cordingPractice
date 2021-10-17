package ���α׷��ӽ�;

import java.util.*;
import java.util.Map.Entry;

public class �ؽ�_����Ʈ�ٹ� {
	/*
	genres[i]�� ������ȣ�� i�� �뷡�� �帣�Դϴ�.
	plays[i]�� ������ȣ�� i�� �뷡�� ����� Ƚ���Դϴ�.
	genres�� plays�� ���̴� ������, �̴� 1 �̻� 10,000 �����Դϴ�.
	�帣 ������ 100�� �̸��Դϴ�.
	�帣�� ���� ���� �ϳ����, �ϳ��� � �����մϴ�.
	��� �帣�� ����� Ƚ���� �ٸ��ϴ�.
	 * 
	 */
			
			
    public static int[] solution(String[] genres, int[] plays) {
     	HashMap<String, List<int[]>> songMap = new HashMap<>();
     	HashMap<String, Integer> genreMap = new HashMap<>();
     	
     	for(int i=0;i<plays.length;i++) {
     		String genre=genres[i];
     		genreMap.put(genre, genreMap.getOrDefault(genre, 0)+plays[i]); //�帣�� ���� Ƚ�� ����
     		songMap.putIfAbsent(genre, new ArrayList<int[]>()); //songMap�� �� ������ ����
     		songMap.get(genre).add(new int[] {i,plays[i]}); //songMap�� �帣,[idx, Ƚ��] �ֱ�;
     	}
     	
     	List<Entry<String, Integer>> entryList= new ArrayList<>(genreMap.entrySet()); 
     	Collections.sort(entryList,(o1,o2)->o2.getValue().compareTo(o1.getValue())); //�帣�� key, value ���� ���� ����
     	
     	List<Integer> answer = new ArrayList<Integer>();
     	for(Entry<String,Integer> entry:entryList) {
     		List<int[]> list = songMap.get(entry.getKey()); //�� �帣�� list �ҷ�����
     		Collections.sort(list, (o1,o2)->o2[1]-o1[1]);  //list �������� ����
     		for(int i=0;i<2;i++) { //�ΰ��� ���
     			if(i<list.size()) { //����Ʈ ������� ������ �ֱ�(1���� ��� 1���� �ֱ�)
     				answer.add(list.get(i)[0]); //idx �信 �ֱ�
     			}
     		}
     	}
         return answer.stream().mapToInt(Integer::intValue).toArray(); //array�� ��ȯ�Ͽ� ����
    }
	
	
	public static void main(String[] args) {
		String[] g = {"classic", "pop", "classic", "classic", "pop"};
		int[] p= {500, 600, 150, 800, 2500};
		for(int i:solution(g, p)) System.out.print(i+" ");
				
	}

}
