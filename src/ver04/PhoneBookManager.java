package ver04;

import java.util.Scanner;

import ver04.PhoneInfo;

/*
멤버메소드명 
메뉴출력 : printMenu()
입력 : dataInput()
검색 : dataSearch()
삭제 : dataDelete()
주소록전체출력 : dataAllShow() 
 */
public class PhoneBookManager {

	Scanner scan = new Scanner(System.in);
	PhoneInfo[] plist = new PhoneInfo[100];
	int plistNum = 0;
	
	public void printMenu() {
		System.out.println("선택하세요..");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
		return;
	}
	
	public void dataInput() {
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1.일반, 2.동창, 3.회사");
		System.out.print("선택>>");
		int inputSelectNum = scan.nextInt();
		System.out.println();
		
		if(inputSelectNum==1) {
			System.out.print("이름:");
			String inputName =scan.next();
			
			System.out.print("전화번호:");
			String inputPhoneNum =scan.next();
			
			plist[plistNum] = new PhoneInfo (inputName, inputPhoneNum);
			plistNum++;
		}
		else if(inputSelectNum==2) {
			System.out.print("이름:");
			String inputName =scan.next();
			
			System.out.print("전화번호:");
			String inputPhoneNum =scan.next();
			
			System.out.print("전공:");
			String inputMajor =scan.next();
			
			System.out.print("학년:");
			int inputGrade =scan.nextInt();
			
			plist[plistNum] = new PhoneSchoolInfo (inputName, inputPhoneNum, inputMajor, inputGrade);
			plistNum++;
		}
		else if(inputSelectNum==3) {
			System.out.print("이름:");
			String inputName =scan.next();
			
			System.out.print("전화번호:");
			String inputPhoneNum =scan.next();
			
			System.out.print("회사명:");
			String inputComName =scan.next();
			plist[plistNum] = new PhoneCompanyInfo(inputName, inputPhoneNum,inputComName);
			plistNum++;
		}
		System.out.println("데이터 입력이 완료되었습니다.");
		System.out.println();
	}

	public void dataSearch() {
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름:");
		String searchName = scan.next();
		
		for(int i=0; i<plistNum; i++) {
			if(searchName.compareTo(plist[i].name)==0) {
				System.out.println();
				plist[i].showPhoneInfo();
			}
		}
		System.out.println("데이터 검색이 완료되었습니다.");
		System.out.println();
	}	
	
	public void dataDelete() {
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.print("이름:");
		String deleteName = scan.nextLine();
		
		int deleteIndex = -1;
		for(int i=0; i<plistNum; i++) {
			if(deleteName.compareTo(plist[i].name)==0) {
				plist[i] = null;
				deleteIndex = i;
			}
		}
		if(deleteIndex==-1) {
			System.out.println("삭제할 데이터가 없습니다.");
		}
		else {
			for(int i= deleteIndex; i<plistNum; i++) {
				plist[i] =  plist[i+1];
			}
		}
		System.out.println("데이터 삭제가 완료되었습니다.");
		System.out.println();
	}
	
	public void dataAllShow() {
		for(int i = 0; i<plistNum; i++) {
			plist[i].showPhoneInfo();
			System.out.println();
		}
	}
}
