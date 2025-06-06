package 프로그래머스;

public class 탐욕법_조이스틱 {
    public static int solution(String name) {
    	/*
    	조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
    	ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

    	조이스틱을 각 방향으로 움직이면 아래와 같습니다.

    	▲ - 다음 알파벳
    	▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
    	◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
    	▶ - 커서를 오른쪽으로 이동
    	예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.

    	- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
    	- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
    	- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
    	따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
    	만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
    	
    	제한 사항
		name은 알파벳 대문자로만 이루어져 있습니다.
		name의 길이는 1 이상 20 이하입니다.
        */
        
        int count=0;
        int move=0;
        int streamA=0;
        int maxStreamA=0;
        int tmpIdx=0;
        int idx=0;
        int streamIdx=-1;
        final int INF = 987654321;
        
        for(char c:name.toCharArray()) {
        	//O 이상의 알파벳의 경우 아래 방향키로 이동시 덜 입력
        	if(c>='O') {
        		count+='Z'-c+1;
        	}else {
        		//나머지의 경우 위 방향키
        		count+=c-'A';
        	}
        	//A일 경우
        	if(c=='A') {
        		//A가 처음 등장 시 idx를 저장함
        		if(streamA==0) tmpIdx=idx;
        		//연속되는 A의 횟수 기록
        		streamA++;
        	}
        	//A가 아니거나 마지막 글자일 경우
        	if(c!='A'||idx==name.length()-1){
        		//연속되는 A의 최대치 보다 현재 기록된 연속되는 A 횟수가 크다면
        		if(maxStreamA<streamA) {
        			//연속하는 A의 최대치 변경
        			maxStreamA=streamA;
        			//연속하는 idx 기록
        			streamIdx=tmpIdx;
        		}
        		//연속하는 A 횟수, 인덱스 초기화
        		streamA=0;
        		tmpIdx=0;
        	}
        	//인덱스 증가
        	idx++;
        }
        //모두 A일 경우 0 리턴
        if(maxStreamA==name.length()) return 0;
        
        //좌우 방향키 최대치
        move=name.length()-1;
        
        int backmove;
        //연속하는 A의 idx값이 기록되지 않았다면 뒤로 가지 않음 
        if(streamIdx==-1) backmove=INF;
        //뒤로 되돌아 가기 : 연속하는 idx의 앞자리로 이동 후 다시 되돌아간 뒤
        //연속하는 A의 마지막 ~ name의 끝
        else backmove=(streamIdx-1)*2 + (name.length()-(streamIdx+maxStreamA));
        //좌우 방향키의 최대치보다 뒤로 되돌아 가는 방법이 적으면 뒤로 되돌아가기 선택
        move=move>backmove?backmove:move;
        //위아래 방향키 수 + 좌우 방향키 수 리턴
        return count+move;
    }
	
	public static void main(String[] args) {
		String[] names= {"BBBBAABBB","JEROEN","AAAABB","JAN"};
		for(String name : names) System.out.println(solution(name));
	}
}
