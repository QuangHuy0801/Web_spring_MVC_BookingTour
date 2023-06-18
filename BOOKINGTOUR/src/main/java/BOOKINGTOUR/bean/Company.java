package BOOKINGTOUR.bean;

public class Company {
		private String name;
		private String slogan;
		private String logo1;
		private String logo2;
		private String logo3;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSlogan() {
			return slogan;
		}
		public void setSlogan(String slogan) {
			this.slogan = slogan;
		}
		public String getLogo1() {
			return logo1;
		}
		public void setLogo1(String logo) {
			this.logo1 = logo;
		}
		public Company(String name, String slogan, String logo) {
			super();
			this.name = name;
			this.slogan = slogan;
			this.logo1 = logo;
		}
		public Company() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getLogo2() {
			return logo2;
		}
		public void setLogo2(String logo2) {
			this.logo2 = logo2;
		}
		public String getLogo3() {
			return logo3;
		}
		public void setLogo3(String logo3) {
			this.logo3 = logo3;
		}
		
		
}
