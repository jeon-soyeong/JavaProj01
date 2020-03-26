package ver04;

class PhoneSchoolInfo extends PhoneInfo{//동창
	
	String major;
	int grade;

	public PhoneSchoolInfo(String name, String phoneNumber, String major, int grade) {
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}

	@Override
	public void showPhoneInfo() {
		System.out.println("==동창정보==");
		super.showPhoneInfo();
		System.out.println("전공:"+ major);
		System.out.println("학년:"+ grade);
	}
}