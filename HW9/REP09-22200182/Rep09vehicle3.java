import java.util.Scanner;
import java.util.InputMismatchException;

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

class Vehicle {
	private int cylinder;
	private double lCapacity;
	private double tCapacity;

	public Vehicle(int cylinder, double lCapacity, double tCapacity)
		throws CylinderException, LoadException, TowingException {
			if (cylinder < 1 || cylinder > 12) {
				throw new CylinderException("Invalid: Cylinders must be between 1 and 12.");
			}
			if (lCapacity < 1 || lCapacity > 10.0) {
				throw new LoadException("Invalid: Load capacity must be between 1 and 10.");
			}
			if (tCapacity < 1 || tCapacity > 20.0) {
				throw new TowingException("Invalid: Towing capacity must be between 1 and 20.");
			}

			this.cylinder = cylinder;
			this.lCapacity = lCapacity;
			this.tCapacity = tCapacity;
		}
	}

public class Rep09vehicle3 {
	public static void main(String[] args) {
		int cylinder;
		double lcapacity, tcapacity;
		Scanner input = new Scanner(System.in);
		try
		{
			System.out.print("Enter number of cylinders (1~12): ");
			cylinder = input.nextInt();
			System.out.print("Enter load capacity (1.0~10.0): ");
			lcapacity = input.nextDouble();
			System.out.print("Enter towing capacity (1.0~20.0): ");
			tcapacity = input.nextDouble();
			System.out.println();

			Vehicle vehicle = new Vehicle(cylinder, lcapacity, tcapacity);
			System.out.println("All values are valid.");
			System.out.println("Cylinders: " + cylinder);
			System.out.println("Load capacity: " + lcapacity);
			System.out.println("Towing capacity: " + tcapacity);
		} catch (CylinderException | LoadException | TowingException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Invalid input format.");
		}
		finally {
			System.out.println("Program ended");
		}
	}
}
