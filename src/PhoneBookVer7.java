import java.util.InputMismatchException;
import java.util.Scanner;

import ver07.PhoneInfo;
import ver07.MenuSelectException;
import ver07.Menuitem;
import ver07.PhoneBookManager;

/*
객체배열을 이용해서, 프로그램 사용자가 입력하는 정보가 최대 100개까지 유지되도록 프로그램을 변경하시오.
그리고 다음과 같은 기능을 추가로 삽입한다.
-저장 : 이름, 전화번호, 생년월일 정보를 대상으로 저장의 과정을 진행한다.
-검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 출력한다.
-삭제 : 이름을 기준으로 데이터를 찾아서 삭제의 과정을 진행한다. 단 배열의 중간에 저장된 데이터를 삭제할경우 해당 요소의 뒤에 저장된 요소들을 한칸씩 앞으로 이동시키는 형태로 삭제를 진행한다.
[1,2,3,4,5] 좌측배열에서 인덱스 3을 지웠다면 [1,2,4,5] 처럼 되어야 한다.
 
끝으로 저장, 검색, 삭제의 기능을 담당하는 PhoneBookManager클래스를 정의해서 프로그램을 완성하자.


 */
public class PhoneBookVer7 {

	public static void main(String[] args) {


		Scanner scan = new Scanner(System.in);
		
		
		PhoneBookManager bookManager =  new PhoneBookManager();
		
		while(true){
			
			try {
				bookManager.printMenu();
				
				System.out.print("선택:");
				int choice =  scan.nextInt();
				System.out.println();
				
				if(!(choice==1 || choice==2 || choice==3 || choice==4 || choice==5)) {
					MenuSelectException mex = new MenuSelectException();
					throw mex;
				}
			
				switch(choice) {
				case Menuitem.데이터입력 :
					bookManager.dataInput();
					break;
				case Menuitem.데이터검색 : 
					bookManager.dataSearch();
					break;
				case Menuitem.데이터삭제 : 
					bookManager.dataDelete();
					break;
				case Menuitem.주소록출력 :
					bookManager.dataAllShow();
					break;
				case Menuitem.프로그램종료 :
					System.out.println("프로그램 종료");
				return; 
				}
			}
			catch(MenuSelectException e) {
				e.printStackTrace();
			}
			catch(InputMismatchException e) {
				e.printStackTrace();
				break;
			}
			catch(NullPointerException e) {
				e.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}


