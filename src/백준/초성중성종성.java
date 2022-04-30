package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 초성중성종성 {
	//한글코드의 값 = ((초성 * 21) + 중성) * 28 + 종성 + 0xAC00
	//*0xAC00 = '가'
	//초성 = ((x - 0xAC00) / 28) / 21 + 0x1100 (초성 ㄱ)
	//중성 = ((x - 0xAC00) / 28) % 21 + 0x1161 (중성 ㅏ)
	//종성 = (x - 0xAC00) % 28 + 0x11A8-1 (종성 ㄱ -1 ',' 없는 경우로 인해 -1)
	static char[] Cho = {'ㄱ','ㄲ','ㄴ','ㄷ','ㄸ','ㄹ','ㅁ','ㅂ','ㅃ','ㅅ','ㅆ','ㅇ','ㅈ','ㅉ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};
	static char[] Jung = {'ㅏ','ㅐ','ㅑ','ㅒ','ㅓ','ㅔ','ㅕ','ㅖ','ㅗ','ㅘ','ㅙ','ㅚ','ㅛ','ㅜ','ㅝ','ㅞ','ㅟ','ㅠ','ㅡ','ㅢ','ㅣ'};
	static char[] Jong = {' ','ㄱ','ㄲ','ㄳ','ㄴ','ㄵ','ㄶ','ㄷ','ㄹ','ㄺ','ㄻ','ㄼ','ㄽ','ㄾ','ㄿ','ㅀ','ㅁ','ㅂ','ㅄ','ㅅ','ㅆ','ㅇ','ㅈ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char c = s.charAt(0);
		char def = '가';
		int cho,jung,jong;
		cho = ((c - def) / 28)/21;
		jung = ((c - def) / 28)%21;
		jong = ((c - def) % 28);
		System.out.println(Cho[cho]);
		System.out.println(Jung[jung]);
		System.out.println(Jong[jong]);
		br.close();
	}
}
