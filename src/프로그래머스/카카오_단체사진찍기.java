package 프로그래머스;

import java.util.ArrayList;

public class 카카오_단체사진찍기 {
	/*
	가을을 맞아 카카오프렌즈는 단체로 소풍을 떠났다.
	즐거운 시간을 보내고 마지막에 단체사진을 찍기 위해 카메라 앞에 일렬로 나란히 섰다.
	그런데 각자가 원하는 배치가 모두 달라 어떤 순서로 설지 정하는데 시간이 오래 걸렸다.
	네오는 프로도와 나란히 서기를 원했고,
	튜브가 뿜은 불을 맞은 적이 있던 라이언은 튜브에게서 적어도 세 칸 이상 떨어져서 서기를 원했다.
	사진을 찍고 나서 돌아오는 길에, 무지는 모두가 원하는 조건을 만족하면서도 다르게 서는 방법이 있지 않았을까 생각해보게 되었다.
	각 프렌즈가 원하는 조건을 입력으로 받았을 때 모든 조건을 만족할 수 있도록 서는 경우의 수를 계산하는 프로그램을 작성해보자.

	입력 형식
	입력은 조건의 개수를 나타내는 정수 n과 n개의 원소로 구성된 문자열 배열 data로 주어진다.
	data의 원소는 각 프렌즈가 원하는 조건이 N~F=0과 같은 형태의 문자열로 구성되어 있다. 제한조건은 아래와 같다.

	1 <= n <= 100
	data의 원소는 다섯 글자로 구성된 문자열이다. 각 원소의 조건은 다음과 같다.
	첫 번째 글자와 세 번째 글자는 다음 8개 중 하나이다.
	{A, C, F, J, M, N, R, T} 각각 어피치, 콘, 프로도, 제이지, 무지, 네오, 라이언, 튜브를 의미한다.
	첫 번째 글자는 조건을 제시한 프렌즈, 세 번째 글자는 상대방이다. 첫 번째 글자와 세 번째 글자는 항상 다르다.
	두 번째 글자는 항상 ~이다.
	네 번째 글자는 다음 3개 중 하나이다. {=, <, >} 각각 같음, 미만, 초과를 의미한다.
	다섯 번째 글자는 0 이상 6 이하의 정수의 문자형이며, 조건에 제시되는 간격을 의미한다. 이때 간격은 두 프렌즈 사이에 있는 다른 프렌즈의 수이다.
	*/
	static boolean[] Visited;
	static int N, Answer;
	static ArrayList<int[]> Conditions;
	
	public static void isOk(String s) {
		boolean pass=true;
		for(int[] condition:Conditions) {
			if(!pass) break;
			int a=condition[0]; //수 1
			int b=condition[1]; //수 2
			int sign = condition[2]; //기호
			int num = condition[3]; //거리
			
			int aIdx=-1, bIdx=-1;
			for(int i=0;i<8;i++) {
				if(a==s.charAt(i)-'0') aIdx=i; //수 1의 idx
				else if(b==s.charAt(i)-'0') bIdx=i; //수 2의 idx
			}
			int interval =Math.abs(aIdx-bIdx)-1; //수 1과 2의 거리
			//=
			if(sign==61) {
				if(interval!=num) pass=false; //거리가 num과 같지 않으면 false 리턴
			//<	
			}else if(sign==60) {
				if(interval>=num) pass=false; //거리가 num 이상이면 false 리턴
			//>	
			}else if(sign==62) {
				if(interval<=num) pass=false; //거리가 num 이하이면 false 리턴
			}
		}
		if(pass) Answer++; //통과시 답 증가
	}
	
	//수열 생성
	public static void permutation(String s) {
		//수열의 길이가 8
		if(s.length()==8) {
			isOk(s);
			return;
		} 
		for(int i=0;i<8;i++) {
			if(!Visited[i]) {
				Visited[i]=true;
				permutation(s+i);
				Visited[i]=false;
			}
		}
		return;
	}
	
    public static int solution(int n, String[] data) {
    	char[] friends= {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    	Visited=new boolean[8];
    	Answer=0;
    	Conditions=new ArrayList<>();
        for(String d:data) {
        	int a=-1,b=-1;
        	int sign=d.charAt(3)+0; //부호
        	int num=d.charAt(4)-'0'; //숫자
        	//프랜드 배열 탐색하여 숫자로 변환
        	for(int i=0;i<8;i++) {
        		char friend =friends[i];
        		if(friend==d.charAt(0)) a=i; //첫번째 친구
        		else if(friend==d.charAt(2)) b=i; //두번째 친구
        	}
        	Conditions.add(new int[] {a,b,sign,num}); //변환하여 번호1, 번호2, 부호, 숫자 입력
        }
        permutation("");
        return Answer;
    }
	public static void main(String[] args) {
		int n=2;
		String[] data = {"N~F=0", "R~T>2"};
//		String[] data = {"M~C<2", "C~M>1"};
		System.out.println(solution(n, data));
	}

}
