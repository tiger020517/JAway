import java.util.Scanner;

public class Grain3 {
	static int getTotalGrains(int k, int grains) {
		if (k <= 0)
			return 1;
		return (2 * getTotalGrains(k - 1, grains));
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("[step3] Enter an integer value k (number of squares): ");
		int num = input.nextInt();
		int grains = 0;
		grains = getTotalGrains(num, grains) - 1;
		System.out.println("The number of grains placed on the board is " + grains);
	}
}
