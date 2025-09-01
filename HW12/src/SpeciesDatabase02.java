import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpeciesDatabase02 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Species> species = new ArrayList<Species>();
		System.out.print("Enter the input file name: ");
		String inFile = sc.nextLine();
		try (BufferedReader br = new BufferedReader(new FileReader(inFile))) {
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				System.out.println(line);
			}
		}
		catch (IOException e)
		{
			System.err.println("Could not open file " + inFile);
		}
	}
}
