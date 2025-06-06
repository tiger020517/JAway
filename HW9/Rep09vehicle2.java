import java.util.Scanner;

public class Rep09vehicle {
	public static void main(String[] args) {
		int cylinder;
		double lcapacity, tcapacity;
		Scanner input = new Scanner(System.in);
		while (true)
		{
			System.out.print("Enter number of cylinders (1~12): ");
			cylinder = input.nextInt();
			System.out.print("Enter load capacity (1.0~10.0): ");
			lcapacity = input.nextDouble();
			System.out.print("Enter towing capacity (1.0~20.0): ");
			tcapacity = input.nextDouble();
			System.out.println();
			if (cylinder >= 1 && cylinder <= 12 && lcapacity >= 1 && lcapacity <= 20 && tcapacity >= 1)
				break ;
		}
		System.out.println("All values are valid.");
		System.out.println("Cylinders: " + cylinder);
		System.out.println("Load capacity: " + lcapacity);
		System.out.println("Towing capacity: " + tcapacity);
		System.out.println("Program ended.");

	}
}
