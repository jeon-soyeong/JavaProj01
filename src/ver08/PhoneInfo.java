package ver08;

import java.io.Serializable;

/*
 -PhoneInfo 클래스에서 생일과 관련된 멤버변수와 코드를 삭제한다.
-다음 2개의 클래스를 추가한다.

-프로그램의 흐름을 담당하는  PhoneBookManager 클래스를 정의한다.
-나머지는 실행결과를 보고 확인하도록 한다.
 */
public class PhoneInfo implements Serializable {//일반
	
	//멤버변수
	String name;
	String phoneNumber;
	
	//생성자
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	//정보출력용 메소드
	public void showPhoneInfo() {
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phoneNumber);
	}
	
	@Override
		public String toString() {
			return String.format("%s, %s", name, phoneNumber);
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		PhoneInfo comparePhoneInfo = (PhoneInfo) obj;
		
		if(comparePhoneInfo.name.equals(this.name)){
			return true;
		}
		else {
			return false;
		}
	}
	
	
}

