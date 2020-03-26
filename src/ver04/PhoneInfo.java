package ver04;

/*
 -PhoneInfo 클래스에서 생일과 관련된 멤버변수와 코드를 삭제한다.
-다음 2개의 클래스를 추가한다.

-프로그램의 흐름을 담당하는  PhoneBookManager 클래스를 정의한다.
-나머지는 실행결과를 보고 확인하도록 한다.
 */
public class PhoneInfo {//일반
	
	//멤버변수
	public String name;
	public String phoneNumber;
	
	//생성자
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	//정보출력용 메소드
	public void showPhoneInfo() {
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phoneNumber);
	}
}

