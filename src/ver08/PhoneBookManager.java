package ver08;

import ver08.PhoneInfo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


/*
컬렉션 기반으로 변경후 인스턴스를 저장하기 위해 IO(입출력)을 적용하자.
ObjectInputStream, ObjectOutputStream 클래스를 기반으로 제작한다.
파일의 저장은 프로그램을 종료하는 시점에 이루어져야 하고, 
프로그램 시작 직후 전체정보를 조회하면 기존에 입력된 정보들이 출력되어야 한다.
 */
public class PhoneBookManager {

	Scanner scan = new Scanner(System.in);
	HashSet<PhoneInfo> hashSet = new HashSet<PhoneInfo>();

	int plistNum = 0;

	public void printMenu() throws MenuSelectException, InputMismatchException, NullPointerException {
		System.out.println("선택하세요..");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
		return;
	}

	public void dataInput() throws InputMismatchException, NullPointerException {

		try {
			System.out.println("데이터 입력을 시작합니다.");
			System.out.println("1.일반, 2.동창, 3.회사");
			System.out.print("선택>>");
			int inputSelectNum = scan.nextInt();
			System.out.println();

			if (!(inputSelectNum == 1 || inputSelectNum == 2 || inputSelectNum == 3)) {
				MenuSelectException mex = new MenuSelectException();
				throw mex;
			}

			if (inputSelectNum == SubMenuitem.일반) {
				System.out.print("이름:");
				String inputName = scan.next();

				System.out.print("전화번호:");
				String inputPhoneNum = scan.next();

				PhoneInfo phoneInfo = new PhoneInfo(inputName, inputPhoneNum);

				boolean flag = hashSet.add(phoneInfo);// 실패하면 false
				if (flag == false) {
					System.out.println("이미 존재하는 사람입니다.");
					System.out.println("덮어쓰시겠습니까? 1.(네), 2.(아니오)");

					int inputOver = scan.nextInt();
					if (inputOver == 1) {
						hashSet.remove(phoneInfo);
						hashSet.add(phoneInfo);
					}
				} else {
					hashSet.add(phoneInfo);
				}
			}

			else if (inputSelectNum == SubMenuitem.학교동창) {
				System.out.print("이름:");
				String inputName = scan.next();

				System.out.print("전화번호:");
				String inputPhoneNum = scan.next();

				System.out.print("전공:");
				String inputMajor = scan.next();

				System.out.print("학년:");
				int inputGrade = scan.nextInt();

				PhoneInfo phoneInfo = new PhoneSchoolInfo(inputName, inputPhoneNum, inputMajor, inputGrade);

				boolean flag = hashSet.add(phoneInfo);// 실패하면 false
				if (flag == false) {
					System.out.println("이미 존재하는 사람입니다.");
					System.out.println("덮어쓰시겠습니까? 1.(네), 2.(아니오)");

					int inputOver = scan.nextInt();
					if (inputOver == 1) {
						hashSet.remove(phoneInfo);
						hashSet.add(phoneInfo);
					}
				} else {
					hashSet.add(phoneInfo);
				}
			}

			else if (inputSelectNum == SubMenuitem.회사동료) {
				System.out.print("이름:");
				String inputName = scan.next();

				System.out.print("전화번호:");
				String inputPhoneNum = scan.next();

				System.out.print("회사명:");
				String inputComName = scan.next();

				PhoneInfo phoneInfo = new PhoneCompanyInfo(inputName, inputPhoneNum, inputComName);

				boolean flag = hashSet.add(phoneInfo);// 실패하면 false
				if (flag == false) {
					System.out.println("이미 존재하는 사람입니다.");
					System.out.println("덮어쓰시겠습니까? 1.(네), 2.(아니오)");

					int inputOver = scan.nextInt();
					if (inputOver == 1) {
						hashSet.remove(phoneInfo);
						hashSet.add(phoneInfo);
					}
				} else {
					hashSet.add(phoneInfo);
				}
			}
		} catch (MenuSelectException e) {
			System.out.println("예외발생 : 1~5사이의 숫자를 입력하세요.");
		}
	}

	public void dataSearch() throws InputMismatchException, NullPointerException {

		boolean searchTrue = false;

		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름:");
		String searchName = scan.next();

		Iterator<PhoneInfo> itr = hashSet.iterator();
		while (itr.hasNext()) {
			PhoneInfo object = itr.next();
			if (object.name.contains(searchName)) {
				searchTrue = true;
				System.out.println(searchName + "님의 데이터를 찾았습니다.");
				object.showPhoneInfo();
			} else {
				searchTrue = false;
			}
		}
		if (searchTrue == false) {
			System.out.println("찾는 데이터가 없습니다.");
		}
		System.out.println();
	}

	public void dataDelete() throws InputMismatchException, NullPointerException {
		
		boolean deleteTrue = false;
		
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.print("이름:");
		String deleteName = scan.next();

		Iterator<PhoneInfo> itr = hashSet.iterator();
		while (itr.hasNext()) {
			if (deleteName.equals(itr.next().name)) {
				deleteTrue = true;
				itr.remove();
				System.out.println("데이터 삭제가 완료되었습니다.");
			} else {
				deleteTrue = false;
			}
		}
		if (deleteTrue == false) {
			System.out.println("삭제할 데이터가 없습니다.");
		}
		System.out.println();
	}

	public void dataAllShow() {

		Iterator<PhoneInfo> itr = hashSet.iterator();
		while (itr.hasNext()) {
			itr.next().showPhoneInfo();
		}
		System.out.println();
	}
	
	public void saveFriendInfo() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/ver08/PhoneBook.obj"));
			
			Iterator<PhoneInfo> itr = hashSet.iterator();
			while (itr.hasNext()) {
				out.writeObject(itr.next());
			}
		}
		catch (Exception e) {
			System.out.println("예외발생");
		}
	}
	
	public void showFriendInfo() throws ClassNotFoundException, IOException {

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/ver08/PhoneBook.obj"));
			
			while(true) {
				//저장된 파일에서 정보 1개 읽어오기
				try {
					PhoneInfo phoneInfo = (PhoneInfo)in.readObject();
					//만약 읽어올 정보(객체)가 더이상 없다면 루프 탈출
					if(phoneInfo==null) 
						break;
					//읽어온 객체를 통해 정보출력
					phoneInfo.showPhoneInfo();
				} catch (IOException e) {

				}
			}
	}
}
	
	
