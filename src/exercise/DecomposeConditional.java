package exercise;

import java.util.Date;

public class DecomposeConditional {

	class Stadium {
		private final Date SUMMER_START = new Date(1500);
		private final Date SUMMER_END = new Date(2500);
		public double summerRate;
		public double winterRate;
		public double winterServiceCharge;

		public Stadium(double summer, double winter, double service) {
			this.summerRate = summer;
			this.winterRate = winter;
			this.winterServiceCharge = service;
		}

		// refactor -> decompose conditional
		public double getTicketPrice(Date date, int quantity) {
			if (isSummer(date)) {
				return summerCharge(quantity);
			}
			return winterChange(quantity);
		}

		private double winterChange(int quantity) {
			return quantity * winterRate + winterServiceCharge;
		}

		private double summerCharge(int quantity) {
			return quantity * summerRate;
		}

		private boolean isSummer(Date date) {
			return !(date.before(SUMMER_START) || date.after(SUMMER_END));
		}
	}

	public void test() {
		Stadium s = new Stadium(100, 90, 25);
		System.out.println(s.getTicketPrice(new Date(1000), 10));
		System.out.println(s.getTicketPrice(new Date(2000), 10));
		System.out.println(s.getTicketPrice(new Date(3000), 10));
	}

	public static void main(String[] args) {
		new DecomposeConditional().test();
	}

}
