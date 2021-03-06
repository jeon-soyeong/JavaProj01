package ver07;

import ver07.PhoneInfo;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

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
			e.printStackTrace();
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

		System.out.println("데이터 삭제를 시작합니다.");
		System.out.print("이름:");
		String deleteName = scan.next();

		Iterator<PhoneInfo> itr = hashSet.iterator();
		while (itr.hasNext()) {

			if (deleteName.equals(itr.next().name)) {
				itr.remove();
				System.out.println("데이터 삭제가 완료되었습니다.");
			} else {
				System.out.println("삭제할 데이터가 없습니다.");
			}
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
}