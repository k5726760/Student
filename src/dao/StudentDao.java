package dao;

import java.util.Scanner;

import dto.StudentDto;

//Data Access Object
public class StudentDao {
	
	Scanner sc=new Scanner(System.in);
	
	private StudentDto students[] = {};
	
	private int cnt;
	
		
	public StudentDao() {
		students=new StudentDto[10];
		cnt=0;		
	}
	
	public void insert() {
		int target=-1;//빈 배열 확인	
		
		for (int i = 0; i < students.length; i++) { //배열 확인
			if(students[i]==null||students[i].getName().equals("")) { //공백이거나 비어있으면 그 자리 기억후 탈출
				target=i;
				break;			
			}			
		}	
		if(target==-1) {//빈공간일경우
			if(cnt>=students.length) { //배열이 꽉차있으면
				System.out.println("학생을 더이상 추가 할 수 없습니다!!");
				return;
			}
			target=cnt;  //아닌경우 맨 뒤로		
		}
		
		System.out.println("학생정보 추가>>");	
		System.out.print("이름 = ");
		String name=sc.next();	
		System.out.print("나이 = ");
		int age=sc.nextInt();	
		System.out.print("키 = ");
		double height=sc.nextDouble();	
		System.out.print("국어 = ");
		int kor=sc.nextInt();
		System.out.print("영어 = ");
		int eng=sc.nextInt();
		System.out.print("수학 = ");
		int math=sc.nextInt();
		
		students[target]=new StudentDto(name, age, height, kor, eng, math);
		System.out.println(name+" 학생 정보가 새로 추가되었습니다");
		
		if (target == cnt) {
            cnt++;
        }
		
	}
	
	public void delete() { //이름->"" 나이->0
		System.out.print("정보를 삭제할 학생이름을 입력하세요");
		String name=sc.next();
		
		boolean namecase=false;
		
		for (StudentDto dto : students) {		
			if(dto !=null && dto.getName().equals(name)) {
				dto.setName("");
				dto.setAge(0);
				dto.setHeight(0);
				dto.setKor(0);
				dto.setEng(0);
				dto.setMath(0);
				
				System.out.println(name+"학생정보를 삭제했습니다");
				
				namecase=true;
				break;
			}
			
		}
		if (!namecase) {
	        System.out.println("학생 정보가 없습니다");
	    }
		
	}
	
	public void select() { //이름->출력
		System.out.print("조회할 학생이름을 입력하세요");
		String name=sc.next();
		boolean isselect=false;
		
		for (StudentDto dto : students) {
			if(dto !=null && dto.getName().equals(name)) { //
				System.out.println(dto.toString());
				
				isselect=true;
				break;
			}		
		}
		if (!isselect) {
	        System.out.println("학생 정보가 없습니다");
	    }
	}
	
	public void update() { // 수정:국,영,수
		System.out.print("정보를 수정할 학생을 입력하세요");
		String name=sc.next();
		int upcase;
				
		boolean isupdate=false;
		for (StudentDto dto : students) {
			if(dto !=null && dto.getName().equals(name)) {
				System.out.print("수정할 정보를 선택하세요(1:키, 2:성적, 3:전부 수정)");
				upcase=sc.nextInt();
					switch(upcase) {
					case 1:{
						System.out.print("수정할 키 = ");
						double height=sc.nextDouble();
						dto.setHeight(height);
						
						System.out.println(name+" 학생의 키를 수정했습니다.");
						
						isupdate=true;
						break;
					}
					case 2:{
					System.out.print("국어 = ");
					int kor=sc.nextInt();
					
					System.out.print("영어 = ");
					int eng=sc.nextInt();
					
					System.out.print("수학 = ");
					int math=sc.nextInt();
					
					dto.setKor(kor);
					dto.setEng(eng);
					dto.setMath(math);
					System.out.println(name+" 학생의 성적을 수정했습니다.");
					
					isupdate=true;
					break;
					}
					case 3:{
					System.out.print("수정할 키 = ");
					double height=sc.nextDouble();
					dto.setHeight(height);
					
					System.out.print("정정할 국어 성적 = ");
					int kor=sc.nextInt();
					
					System.out.print("정정할 영어 성적 = ");
					int eng=sc.nextInt();
					
					System.out.print("정정할 수학 성적 = ");
					int math=sc.nextInt();
					
					dto.setKor(kor);
					dto.setEng(eng);
					dto.setMath(math);
					
					System.out.println(name+"학생의 전체정보를 수정했습니다.");
					isupdate=true;
					break;
						
					}
				}
					if (isupdate) {
		                break; 
		            }
			}
			
		}
		if (!isupdate) {
	        System.out.println("입력하신 이름의 학생정보가 없습니다");
	    }
			
		
		
	}
	
	public void sbjrank() {
	    System.out.print("1등을 조회하고싶은 과목 입력하세요(1.국어,2.영어,3.수학): ");
	    String sbj = sc.next();
	    
	    String subjectName = "";  //과목명 선언&초기화
	    int maxScore = -1; //최고점 선언& 초기화
	    int topStudentIndex = -1; //최고점 학생명 선언& 초기화
	    
	    // 1. 조회과목 설정 
	    if (sbj.equals("국어") || sbj.equals("1")) subjectName = "국어";
	    else if (sbj.equals("영어") || sbj.equals("2")) subjectName = "영어";
	    else if (sbj.equals("수학") || sbj.equals("3")) subjectName = "수학";
	    else {
	        System.out.println("해당 과목은 개설되어있지 않습니다. 다른 과목을 입력해주세요");
	        return; 
	    }
	    
	    // 2.  null 체크와 최고점 학생 탐색
	    for (int i = 0; i < students.length; i++) {
	        if (students[i] != null) {
	            // 선택된 과목에 따라 점수를 유동적으로 가져옴
	            int currentScore = 0;
	            if (subjectName.equals("국어")) currentScore = students[i].getKor();
	            else if (subjectName.equals("영어")) currentScore = students[i].getEng();
	            else if (subjectName.equals("수학")) currentScore = students[i].getMath();
	            
	            if (currentScore >= maxScore) {
	                maxScore = currentScore;
	                topStudentIndex = i;
	            }
	        }
	    }
	 
	    // 3. 최종 결과 출력 
	    if (topStudentIndex != -1) {
	        String topclass = students[topStudentIndex].getName();
	        System.out.println(subjectName + " 1등 : " + topclass + ", 점수 :  " + maxScore + "점");
	    } else {
	        System.out.println("학생데이터가 없습니다");
	    }
	}
	
	public void totalrank() {
		int sum[]=new int[students.length];
		int topclass=0;
		for(int i=0;i<students.length;i++) {
			if(students[i]!=null) {
				sum[i]=students[i].getKor()+students[i].getEng()+students[i].getMath();
			}
			else sum[i]=0;
		}
		
		int maxsum=sum[0];
		for(int i=1;i<sum.length;i++) {
			if(sum[i]>=maxsum) {
				maxsum=sum[i];
				topclass=i;
			}
		}
		if(students[topclass]!=null) {
		String topstudent=students[topclass].getName();
		System.out.println("전체 1등 : "+topstudent+", 총합 :  "+maxsum+"점");
		}
		else System.out.println("학생데이터가 없습니다");
		
	}
	
				
	
	public void allprint() {
		for (StudentDto dto : students) {
			if(dto !=null && !dto.getName().equals("")) {
				System.out.println(dto.toString());
			}
			
		}
		
	}

}
