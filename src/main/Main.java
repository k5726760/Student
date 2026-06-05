package main;

import java.util.Scanner;

import dao.StudentDao;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		//학생정보 관리 클래스
		StudentDao dao=new StudentDao();
		
		//menu
		while(true) {
			System.out.println("============학생정보관리 프로그램==========");
			System.out.println("1. 학생정보 추가");
			System.out.println("2. 학생정보 삭제");
			System.out.println("3. 학생정보 조회");
			System.out.println("4. 학생정보 수정");
			System.out.println("5. 모든학생 조회");  //확인용
			System.out.println("6. 과목1등조회");   //선택과제1
			System.out.println("7. 점수의 총점과 평균"); //선택과제2
			
			
			
			System.out.print("작업 >> ");
			int work=sc.nextInt();
			
			switch (work) {
				case 1:
					dao.insert();
					break;
				case 2:
					dao.delete();
					break;
				case 3:
					dao.select();
					break;
				case 4:
					dao.update();
					break;
				case 5:
					dao.allprint();
					break;
				case 6:
					dao.sbjrank();
					break;
				case 7:
					dao.totalrank();
					break;
			
			}
			
			
			
		}

	}

}
