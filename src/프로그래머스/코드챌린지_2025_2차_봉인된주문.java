import  java.utils.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/389481?language=java
public class 코드챌린지_2025_2차_봉인된주문 {
    //숫자를 단어로 변경
    public static String nToMagic(long n){
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        long x = n;
        while(x>0){
            //알파벳 순번 (a는 1부터 시작함을 보정)
            long temp = (x-1) % 26;
            //나머지 연산을 사용함으로 맨 뒤에서 부터 계산, 스택 사용
            st.push((char)((int)('a') + temp ));
            //다음 자리수 계산을 위한 x 업데이트
            x = (x-1)/26;
        }
        //스택에 쌓인 값 재조합 후 출력
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }
    //단어를 숫자로 변경하여 출력
    public static long magicToN(String magic){
        long n = 0;
        int length = magic.length();
        //26을 곱해서 순차적으로 증가
        long x = 1;
        //맨 끝에서 부터 시작, x는 26의 (0,1...)승씩 증가
        for(int i=length -1;i>=0;i--){
            long temp = (long)(magic.charAt(i) - 'a' + 1);
            n+= temp*x;
            x*=26;
        }
        return n;
    }


    public static String solution(long n, String[] bans) {
        long[] arr = new long[bans.length];
        //금지 단어 순서대로 정렬
        for(int i=0;i<bans.length;i++){
            arr[i]= magicToN(bans[i]);
        }
        Arrays.sort(arr);
        //정렬 단어가 현재 순번보다 작으면 1 증가, 아닌 경우 종료
        for(long x:arr){
            if(x<=n) n++;
            else break;
        }
        //현재 순번을 단어로 변경하여 출력
        return nToMagic(n);
    }



    public static void main(String[] args) {
        long n = 30;
        String[] bans = {"d", "e", "bb", "aa", "ae"};
        System.out.println(solution(n,bans));

    }
}