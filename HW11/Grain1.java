import java.util.Scanner;

public class Grain1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("[step1] Enter an integer value k (number of squares): ");
		int num = input.nextInt();
		int grains = 0;
		for (int i = 0; i < num; i++) {
			int grain = 1;
			for (int j = 0; j < i; j++)
				grain *= 2;
			grains += grain;
		}
		System.out.println("The number of grains placed on the board is " + grains);
	}
}