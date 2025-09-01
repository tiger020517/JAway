import java.util.Scanner;

class Rep08DiscountPolicy3 extends Rep08DiscountPolicy1 {
	public int n;

	public Rep08DiscountPolicy3(int n) {
		this.n = n;
	}

	double computeDiscount(int count, double itemCost) {
		int freeItems = count / n;
		return ((count - freeItems) * itemCost);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cost;
		int quantity;
		int N;

		System.out.print("Enter the itemCost: ");
		cost = sc.nextInt();
		System.out.print("Enter item quantity: ");
		quantity = sc.nextInt();
		System.out.print("Enter the number N: ");
		N = sc.nextInt();
		Rep08DiscountPolicy3 obj = new Rep08DiscountPolicy3(N);
		System.out.println("[Result]");
		System.out.println("Total before discount: " + cost * quantity);
		System.out.println("Discount amount: " + ((quantity / N) * cost));
		System.out.println("Final price: " + obj.computeDiscount(quantity, cost));
	}
}
