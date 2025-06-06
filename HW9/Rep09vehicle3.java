import java.util.Scanner;

class CylinderException extends Exception {
	public CylinderException(String message) {
		super(message);
	}
}

class LoadException extends Exception {
	public LoadException(String message) {
		super(message);
	}
}

class TowingException extends Exception {
	public TowingException(String message) {
		super(message);
	}
}

public class Rep09vehicle2 {
	public static void main(String[] args) {
		int cylinder;
		double lcapacity, tcapacity;
		Scanner input = new Scanner(System.in);
		try
		{
			System.out.print("Enter number of cylinders (1~12): ");
			cylinder = input.nextInt();
			if (cylinder < 1 || cylinder > 12) {
				throw new CylinderException("Invalid: Cylinders must be between 1 and 12.");
			}
			System.out.print("Enter load capacity (1.0~10.0): ");

			lcapacity = input.nextDouble();
			if (lcapacity < 1 || lcapacity > 10) {
				throw new LoadException("Invalid: Load capacity must be between 1 and 10.");
			}
			System.out.print("Enter towing capacity (1.0~20.0): ");
			tcapacity = input.nextDouble();
			if (tcapacity < 1 || tcapacity > 20) {
				throw new TowingException("Invalid: Towing capacity must be between 1 and 20.");
			}
			System.out.println();

			System.out.println("All values are valid.");
			System.out.println("Cylinders: " + cylinder);
			System.out.println("Load capacity: " + lcapacity);
			System.out.println("Towing capacity: " + tcapacity);
		} catch (CylinderException | LoadException | TowingException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			System.out.println("Program ended");
		}
	}
}
