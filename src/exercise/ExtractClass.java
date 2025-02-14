package exercise;

public class ExtractClass {
	// refactor -> extract class TelephoneNumber from class Person
	class Person {
		private String name;
		private TelephoneNumber telephoneNumber;
		
        public Person(String name, TelephoneNumber telephoneNumber) {
            this.name = name;
            this.telephoneNumber = telephoneNumber;
        }
        
		public String getName() {
			return name;
		}

		public String getFullTelephoneNumber() {
			return telephoneNumber.getTelephoneNumber();
		}

		public String getOfficeAreaCode() {
			return telephoneNumber.getOfficeAreaCode();
		}

		public void setOfficeAreaCode(String arg) {
			telephoneNumber.setOfficeAreaCode(arg);
		}

		public String getOfficeNumber() {
			return telephoneNumber.getOfficeNumber();
		}

		public void setOfficeNumber(String arg) {
			telephoneNumber.setOfficeNumber(arg);
		}
	}
	
	class TelephoneNumber {
		private String officeAreaCode;
		private String officeNumber;
		
        public TelephoneNumber(String officeAreaCode, String officeNumber) {
            this.officeAreaCode = officeAreaCode;
            this.officeNumber = officeNumber;
        }
        
		public String getTelephoneNumber() {
			return ("(" + officeAreaCode + ") " + officeNumber);
		}
		
		public String getOfficeAreaCode() {
			return officeAreaCode;
		}

		public void setOfficeAreaCode(String arg) {
			officeAreaCode = arg;
		}

		public String getOfficeNumber() {
			return officeNumber;
		}

		public void setOfficeNumber(String arg) {
			officeNumber = arg;
		}
	}
}