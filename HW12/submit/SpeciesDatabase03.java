import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

public class SpeciesDatabase03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Species> species = new ArrayList<>();
		System.out.print("Enter the input file name: ");
		String inputFile = sc.nextLine();
		System.out.print("Enter the output file name: ");
		String outputFile = sc.nextLine();
		System.out.println();
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				String[] data = line.split(",");
				String[] tmp = data[0].split(" ");
				String name = tmp[1];
				tmp = data[1].split(" ");
				int population = Integer.parseInt(tmp[2]);
				//System.out.println("population = " + tmp[2]);
				tmp = data[2].split(" ");
				double growthRate = Double.parseDouble(tmp[3]);
				//System.out.println("species = " + tmp[3]);
				species.add(new Species(name, population, growthRate));
			}
		}
		catch (IOException e)
		{
			System.err.println("Could not open file " + inputFile);
		}

		species.sort(Comparator.comparing(Species::getName));
		System.out.println("Sorted species: ");
		for (Species s : species) {
			System.out.println(s.toString());
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
			for (Species s : species) {
				bw.write(s.toString() + "\n");
			}
		}
		catch(IOException e)
		{
			System.err.println("Could not write to file " + outputFile);
		}
		System.out.println("Data successfully written to " + outputFile);
	}
}
