import java.util.Scanner;

public class Grain2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("[step2] Enter an integer value k (number of squares): ");
		int num = input.nextInt();
		int grains = (int)Math.pow(2, num) - 1;
		System.out.println("The number of grains placed on the board is " + grains);
	}
}
