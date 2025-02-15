package exercise;

public class ExtractSubClass {
	// refactor -> extract subclass PartsItem & LaborItem from JobItem
	class JobItem {
		private int quantity;
		private int unitPrice;

		protected JobItem(int quantity, int unitPrice) {
			this.quantity = quantity;
			this.unitPrice = unitPrice;
		}

		public int getTotalPrice() {
			return quantity * getUnitPrice();
		}

		public int getQuantity() {
			return quantity;
		}

		public int getUnitPrice() {
			return unitPrice;
		}
	}

	class LaborItem extends JobItem {
		protected Employee employee;

		public LaborItem(int quantity, Employee employee) {
			super(quantity, 0);
			this.employee = employee;
		}

		@Override
		public int getUnitPrice() {
			return employee.getRate();
		}

		public Employee getEmployee() {
			return employee;
		}
	}

	class PartsItem extends JobItem {
		public PartsItem(int quantity, int unitPrice) {
		    super(quantity, unitPrice);
		}
	}

	class Employee {
		private int rate;

		public Employee(int rate) {
			this.rate = rate;
		}

		public int getRate() {
			return rate;
		}
	}

	public void action() {
		Employee kent = new Employee(50);
		JobItem j1 = new LaborItem(5, kent);
		JobItem j2 = new PartsItem(10, 15);
		int total = j1.getTotalPrice() + j2.getTotalPrice();
		System.out.println(total);
	}

	public static void main(String[] args) {
		new ExtractSubClass().action();
	}
}