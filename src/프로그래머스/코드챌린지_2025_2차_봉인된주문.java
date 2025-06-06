import  java.utils.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/389481?language=java
public class �ڵ�ç����_2025_2��_���ε��ֹ� {
    //���ڸ� �ܾ�� ����
    public static String nToMagic(long n){
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        long x = n;
        while(x>0){
            //���ĺ� ���� (a�� 1���� �������� ����)
            long temp = (x-1) % 26;
            //������ ������ ��������� �� �ڿ��� ���� ���, ���� ���
            st.push((char)((int)('a') + temp ));
            //���� �ڸ��� ����� ���� x ������Ʈ
            x = (x-1)/26;
        }
        //���ÿ� ���� �� ������ �� ���
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }
    //�ܾ ���ڷ� �����Ͽ� ���
    public static long magicToN(String magic){
        long n = 0;
        int length = magic.length();
        //26�� ���ؼ� ���������� ����
        long x = 1;
        //�� ������ ���� ����, x�� 26�� (0,1...)�¾� ����
        for(int i=length -1;i>=0;i--){
            long temp = (long)(magic.charAt(i) - 'a' + 1);
            n+= temp*x;
            x*=26;
        }
        return n;
    }


    public static String solution(long n, String[] bans) {
        long[] arr = new long[bans.length];
        //���� �ܾ� ������� ����
        for(int i=0;i<bans.length;i++){
            arr[i]= magicToN(bans[i]);
        }
        Arrays.sort(arr);
        //���� �ܾ ���� �������� ������ 1 ����, �ƴ� ��� ����
        for(long x:arr){
            if(x<=n) n++;
            else break;
        }
        //���� ������ �ܾ�� �����Ͽ� ���
        return nToMagic(n);
    }



    public static void main(String[] args) {
        long n = 30;
        String[] bans = {"d", "e", "bb", "aa", "ae"};
        System.out.println(solution(n,bans));

    }
}