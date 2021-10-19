package 프로그래머스;

public class 탐욕법_조이스틱 {
    public static int solution(String name) {
        char a = 'A';
        char z = 'Z';
        char o = 'O';
        char tmp = (char)(a+25); //13번 누름
        char tmp2 = (char)(a+12); //12번 누름 M
        char tmp3 = (char)(z-12); //13번 누름 N 
        int i=(o-a);
        //N 이상은 뒤로 가는게 더 좋음
        
        
        int answer = 0;
        int count=0;
        int move=0;
        int streamA=0;
        int maxStreamA=0;
        int tmpIdx=0;
        int idx=0;
        int streamIdx=0;
        final int INF = 987654321;
        
        for(char c:name.toCharArray()) {
        	if(c>='O') {
        		count+='Z'-c+1;
        	}else {
        		count+=c-'A';
        	}
        	
        	if(c=='A') {
        		if(streamA==0) tmpIdx=idx;
        		streamA++;
        	}
        	
        	if(c!='A'||idx==name.length()-1){
        		if(maxStreamA<streamA) {
        			maxStreamA=streamA;
        			streamIdx=tmpIdx;
        		}
        		streamA=0;
        		tmpIdx=0;
        	}
        	idx++;
        }
        
        if(maxStreamA==name.length()) return 0;
        
        move=name.length()-1;
        
        
        int backmove;
        if(streamIdx==0) backmove=INF;
        else backmove=(streamIdx-1)*2 + (name.length()-(streamIdx+maxStreamA));
        
        move=move>backmove?backmove:move;
        answer+=count+move;
        
        return answer;
    }
	
	public static void main(String[] args) {
//		String name = "BBBBAABBB"; //7+8= 15 
		String name = "JEROEN"; //7+8= 15 
		System.out.println(solution(name));
	}
}
