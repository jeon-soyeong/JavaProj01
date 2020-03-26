package ver04;

class PhoneCompanyInfo extends PhoneInfo {//회사
	String companyName;

	public PhoneCompanyInfo(String name, String phoneNumber, String companyName) {
		super(name, phoneNumber);
		this.companyName = companyName;
	}

	@Override
	public void showPhoneInfo() {
		System.out.println("==회사친구정보==");
		super.showPhoneInfo();
		System.out.println("회사명:"+companyName);
	}
	
}