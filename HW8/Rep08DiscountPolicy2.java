import java.util.Scanner;

class Rep08DiscountPolicy2 extends Rep08DiscountPolicy1{
	private int minimum;
	private double percent;

	public Rep08DiscountPolicy2(int minimum, double percent) {
		this.minimum = minimum;
		this.percent = percent;
	}

	double computeDiscount(int count, double itemCost) {
		if (count > minimum) {
			return (itemCost * count * ((100 - percent) / 100));
		}
		else {
			return (itemCost * count);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int minimum;
		double itemCost;
		int quantity;
		double percent;

		System.out.print("Enter the minimum: ");
		minimum = sc.nextInt();
		System.out.print("Enter the itemCost: ");
		itemCost = sc.nextDouble();
		System.out.print("Enter the discount percent: ");
		percent = sc.nextDouble();
		System.out.print("Enter the quantity: ");
		quantity = sc.nextInt();
		Rep08DiscountPolicy2 obj = new Rep08DiscountPolicy2(minimum, percent);
		System.out.println(obj.computeDiscount(quantity, itemCost));

	}
}
