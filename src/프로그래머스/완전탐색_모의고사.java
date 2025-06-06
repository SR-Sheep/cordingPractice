package 프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 완전탐색_모의고사 {
	private static class Student{
		private int[] patten;
		private int score;
		
		public Student(int[] patten) {
			this.patten=patten;
			this.score=0;
		}
		
		public int[] getPatten() {
			return this.patten;
		}
		
		public void rightAnswer() {
			this.score++;
		}
		
		public int getScore() {
			return score;
		}
		
	}
	public static int[] solution(int[] answers) {
		int bestScore=0;
		List<Student> list = new ArrayList<>();
		list.add(new Student(new int[] {1,2,3,4,5}));
		list.add(new Student(new int[] { 2, 1, 2, 3, 2, 4, 2, 5}));
		list.add(new Student(new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}));
		
		for(Student student:list) {
			int[] patten = student.getPatten();
			for(int i=0;i<answers.length;i++) {
				int pattenIdx=i%patten.length;
				if(answers[i]==patten[pattenIdx]) student.rightAnswer();
			}
			bestScore=bestScore>student.getScore()?bestScore:student.getScore();
		}
		
		List<Integer> answerList = new ArrayList<>();
		for(int i=0;i<3;i++) {
			if(bestScore==list.get(i).getScore()) answerList.add(i+1);
		}
		
		int[] answer = new int[answerList.size()];
		for(int i=0;i<answerList.size();i++) {
			System.out.println(answerList.get(i));
			answer[i]=answerList.get(i);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int[] answer = {1,3,2,4,2};
		System.out.println(solution(answer));
	}

}
