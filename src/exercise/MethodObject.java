package exercise;

public class MethodObject {

	class Account {
		private int delta() {
			return 10;
		}

		// refactor -> replace this gamma method with method object (make a class for
		// the gamma logic)
		public int gamma(int inputVal, int quantity, int yearToDate) {
			return new Gamma(this, inputVal, quantity, yearToDate).compute();
		}
	}

	class Gamma {
		private final Account account;
		private int inputVal;
		private int quantity;
		private int yearToDate;
		private int importantValue1;
		private int importantValue2;
		private int importantValue3;

		public Gamma(Account account, int inputVal, int quantity, int yearToDate) {
			this.account = account;
			this.inputVal = inputVal;
			this.quantity = quantity;
			this.yearToDate = yearToDate;
		}

		public int compute() {
			calculateImportantValues();
			return this.importantValue3 - 2 * this.importantValue1;
		}

		private void calculateImportantValues() {
			this.importantValue1 = (inputVal * quantity) + account.delta();
			this.importantValue2 = (inputVal * yearToDate) + 100;
			applyAdjustment();
			this.importantValue3 = this.importantValue2 * 7;
		}

		private void applyAdjustment() {
			if ((yearToDate - this.importantValue1) > 100) {
				this.importantValue2 -= 20;
			}
		}
	}

	private void test() {
		Account account = new Account();
		System.out.println(account.gamma(15, 10, 2010));
	}

	public static void main(String[] args) {
		MethodObject p = new MethodObject();
		p.test();
	}

}
