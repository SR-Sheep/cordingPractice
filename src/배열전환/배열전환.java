package 배열전환;

public class 배열전환 {
	public static void main(String[] args) {
		String s = "[93, 30, 55]";
		s=s.replace("[", "{").replace("]", "}");
		System.out.println(s);
	}
}
