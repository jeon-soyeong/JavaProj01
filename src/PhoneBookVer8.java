import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import ver08.PhoneInfo;
import ver08.MenuSelectException;
import ver08.Menuitem;
import ver08.PhoneBookManager;

/*
컬렉션 기반으로 변경후 인스턴스를 저장하기 위해 IO(입출력)을 적용하자.
ObjectInputStream, ObjectOutputStream 클래스를 기반으로 제작한다.
파일의 저장은 프로그램을 종료하는 시점에 이루어져야 하고, 
프로그램 시작 직후 전체정보를 조회하면 기존에 입력된 정보들이 출력되어야 한다.
 */
public class PhoneBookVer8 {

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
					bookManager.showFriendInfo();
					bookManager.dataAllShow();
					break;
				case Menuitem.프로그램종료 :
					bookManager.saveFriendInfo();
					System.out.println("프로그램 종료");
				return; 
				}
			}
			catch(MenuSelectException e) {
				System.out.println("예외발생 : 1~5사이의 숫자를 입력하세요.");
			}
			catch(InputMismatchException e) {
				System.out.println("예외발생 : 문자를 입력하셨습니다.");
				break;
			}
			catch(NullPointerException e) {
				System.out.println("예외발생 : null값입니다.");
			}
			catch(ClassNotFoundException e) {
				System.out.println("예외발생 : 클래스를 찾을 수 없습니다.");
			}
			catch(IOException e) {
				System.out.println("예외발생 :입출력 예외발생입니다.");
			}
			catch(Exception e) {
				
			}
			
		}
		
	}
}


