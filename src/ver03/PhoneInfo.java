package ver03;

public class PhoneInfo {
	
	//멤버변수
	String name;
	String phoneNumber;
	String birthday;
	
	//생성자
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	//생년월일은 필수사항이 아니므로 인자가 없는 경우 null로 초기화
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = null;
	}
	//정보출력용 메소드
	public void showPhoneInfo() {
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phoneNumber);
		if(birthday==null) {
			System.out.println("생년월일 입력되지 않음");
		}
		else {
			System.out.println("생년월일:"+birthday);
		}
	}
}
