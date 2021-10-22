package ���α׷��ӽ�;

import java.util.*;

public class ������ȹ��_N����ǥ�� {
	/*
	�Ʒ��� ���� 5�� ��Ģ���길���� 12�� ǥ���� �� �ֽ��ϴ�.

	12 = 5 + 5 + (5 / 5) + (5 / 5)
	12 = 55 / 5 + 5 / 5
	12 = (55 + 5) / 5

	5�� ����� Ƚ���� ���� 6,5,4 �Դϴ�. �׸��� ���� ���� ���� ���� 4�Դϴ�.
	��ó�� ���� N�� number�� �־��� ��, N�� ��Ģ���길 ����ؼ� ǥ�� �� �� �ִ� ��� �� N ���Ƚ���� �ּڰ��� return �ϵ��� solution �Լ��� �ۼ��ϼ���.

	���ѻ���
	N�� 1 �̻� 9 �����Դϴ�.
	number�� 1 �̻� 32,000 �����Դϴ�.
	���Ŀ��� ��ȣ�� ��Ģ���길 �����ϸ� ������ ���꿡�� �������� �����մϴ�.
	�ּڰ��� 8���� ũ�� -1�� return �մϴ�.
	*/
	
	//�ٸ� ����� �ڵ� ������ �м���
    public static int solution1(int N, int number) {
    	int answer = -1;
        Set<Integer>[] setArr = new Set[9]; //�迭�� set�� ��, //0-8���� ����
        int t = N;
        //�迭�� ù��°���� 1�� ��� ... 8��°���� 8�� ���
        for(int i = 1; i < 9; i++) {
            setArr[i] = new HashSet<>();
            setArr[i].add(t); //1���� N, 2���� NN... 8���� NNNNNNNN �ֱ�
            t = t * 10 + N;
        }
        
        for(int i = 1; i < 9; i++) {
            for(int j = 1; j < i; j++) {
                for(Integer a : setArr[j]) {
                    for(Integer b : setArr[i - j]) {
                    	//i + (i-j) = i �̹Ƿ� i idx �� ��� �� ����
                        setArr[i].add(a + b);
                        setArr[i].add(a - b);
                        setArr[i].add(b - a);
                        setArr[i].add(a * b);
                        if(b != 0) {
                            setArr[i].add(a / b);
                        }
                        if(a != 0) {
                            setArr[i].add(b / a);
                        }
                    }
                }
            }
        }
        
        for(int i = 1; i < 9; i++) {
        	//���� ���ں��� Ž��, ���� ������ answer�� ����
            if(setArr[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
	
	
	//������ § �ڵ�, �׽�Ʈ�� ��������� ��ȿ������
	static HashMap<Integer, Integer> Map;
	static final int INF = Integer.MAX_VALUE;
	//i�� j�� ���� ��� ��, cnt�� ���� ���� map�� ����
    public static void putMap(int i,int j,int cnt) {
    	//���ϱ� ����
		Map.put(i+j, Math.min(Map.getOrDefault(i+j, INF),cnt));
		//���� ����
		Map.put(i-j, Math.min(Map.getOrDefault(i-j, INF),cnt));
		//���ϱ� ����
		Map.put(i*j, Math.min(Map.getOrDefault(i*j, INF),cnt));
		//j�� 0�� �ƴϸ� ������ ����
		if(j!=0) Map.put(i/j, Math.min(Map.getOrDefault(i/j, INF),cnt));
	}
    
    public static int cal(int number,int count) {
		//Ƚ���� 8�� �Ѿ�� -1 ����
    	if(count>8) return -1;
		//map�� ���ϴ� ���ڰ� ������ �ش� count ����
    	if(Map.get(number)!=null) return Map.get(number);
		
    	int cnt;
		//map�� key
		List<Integer> keys = new ArrayList<Integer>();
		for(Integer key:Map.keySet())keys.add(key);
		
		//��� key�� ���� +-*/ ����
		for(Integer i:keys) {
			for(Integer j:keys) {
				cnt=Map.get(i)+Map.get(j); //i�� j�� ��� Ƚ��
				if(cnt>8) continue;
				putMap(i,j,cnt);
			}//for end
		};
		return cal(number, ++count);
	}
    public static int solution(int N, int number) {
        int cal=0;
		Map=new HashMap<Integer, Integer>(); //�ʻ���(����, Ƚ��)
		//N, NN, NNN.. ���� ���� map�� �ֱ�(8������)
		for(int i=1;i<9;i++) {
			cal=cal*10+N; 
        	Map.put(cal, i);
		}
        return cal(number,1);
    }
    
    public static void main(String[] args) {
		int n= 5;
		int number = 12;
		System.out.println(solution1(n, number));
	}

}
