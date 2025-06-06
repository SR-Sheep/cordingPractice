package 프로그래머스;

import java.util.*;

public class 동적계획법_N으로표현 {
	/*
	아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.

	12 = 5 + 5 + (5 / 5) + (5 / 5)
	12 = 55 / 5 + 5 / 5
	12 = (55 + 5) / 5

	5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
	이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.

	제한사항
	N은 1 이상 9 이하입니다.
	number는 1 이상 32,000 이하입니다.
	수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
	최솟값이 8보다 크면 -1을 return 합니다.
	*/
	
	//다른 사람의 코드 내용을 분석함
    public static int solution1(int N, int number) {
    	int answer = -1;
        Set<Integer>[] setArr = new Set[9]; //배열에 set이 들어감, //0-8까지 생성
        int t = N;
        //배열의 첫번째에는 1번 사용 ... 8번째에는 8번 사용
        for(int i = 1; i < 9; i++) {
            setArr[i] = new HashSet<>();
            setArr[i].add(t); //1에는 N, 2에는 NN... 8에는 NNNNNNNN 넣기
            t = t * 10 + N;
        }
        
        for(int i = 1; i < 9; i++) {
            for(int j = 1; j < i; j++) {
                for(Integer a : setArr[j]) {
                    for(Integer b : setArr[i - j]) {
                    	//i + (i-j) = i 이므로 i idx 에 계산 값 저장
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
        	//적은 숫자부터 탐색, 답이 있으며 answer에 저장
            if(setArr[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
	
	
	//본인이 짠 코드, 테스트는 통과하지만 비효율적임
	static HashMap<Integer, Integer> Map;
	static final int INF = Integer.MAX_VALUE;
	//i와 j의 연산 결과 후, cnt가 작은 것을 map에 넣음
    public static void putMap(int i,int j,int cnt) {
    	//더하기 연산
		Map.put(i+j, Math.min(Map.getOrDefault(i+j, INF),cnt));
		//빼기 연산
		Map.put(i-j, Math.min(Map.getOrDefault(i-j, INF),cnt));
		//곱하기 연산
		Map.put(i*j, Math.min(Map.getOrDefault(i*j, INF),cnt));
		//j가 0이 아니면 나누기 연산
		if(j!=0) Map.put(i/j, Math.min(Map.getOrDefault(i/j, INF),cnt));
	}
    
    public static int cal(int number,int count) {
		//횟수가 8번 넘어가면 -1 리턴
    	if(count>8) return -1;
		//map에 원하는 숫자가 있으면 해당 count 리턴
    	if(Map.get(number)!=null) return Map.get(number);
		
    	int cnt;
		//map의 key
		List<Integer> keys = new ArrayList<Integer>();
		for(Integer key:Map.keySet())keys.add(key);
		
		//모든 key에 대해 +-*/ 실행
		for(Integer i:keys) {
			for(Integer j:keys) {
				cnt=Map.get(i)+Map.get(j); //i와 j의 모든 횟수
				if(cnt>8) continue;
				putMap(i,j,cnt);
			}//for end
		};
		return cal(number, ++count);
	}
    public static int solution(int N, int number) {
        int cal=0;
		Map=new HashMap<Integer, Integer>(); //맵생성(숫자, 횟수)
		//N, NN, NNN.. 식의 숫자 map에 넣기(8번까지)
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
