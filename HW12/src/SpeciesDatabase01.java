import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpeciesDatabase01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Species> species = new ArrayList<>();
		System.out.print("Enter the output file name: ");
		String outputFile = sc.nextLine();
		while (true)
		{
			System.out.print("Species name(exit to exit): ");
			String name = sc.nextLine();
			if (name.equals("exit"))
			{
				System.out.println(species.size() + " species written");
				break ;
			}
			System.out.print("Species population: ");
			int population = sc.nextInt();
			System.out.print("Species growthRate: ");
			double growthRate = sc.nextDouble();
			sc.nextLine();
			species.add(new Species(name, population, growthRate));
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
			for (Species s : species)
				bw.write(s.toString() + "\n");
		}
		catch (IOException e)
		{
			System.err.println("Could not open file " + outputFile);
		}
		System.out.println("Data successfully written to " + outputFile);
	}
}