import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AbbreviationMarker02 {
	public void processMessage() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter abbreviation file name: ");
		String abbreviationFileName = scanner.nextLine();
		Set<String> abbreviations = new HashSet<>();
		try (BufferedReader abbrReader = new BufferedReader(new FileReader(abbreviationFileName))) {
			String line;
			while ((line = abbrReader.readLine()) != null) {
				abbreviations.add(line.trim().toLowerCase());
			}
		} catch (IOException e) {
			System.err.println("Error reading abbreviation file: " + e.getMessage());
			scanner.close();
			return ;
		}
		System.out.print("Enter message file name: ");
		String messageFileName = scanner.nextLine();
		System.out.print("Enter output file name: ");
		String outputFileName = scanner.nextLine();

		StringBuilder markedMessageBuilder = new StringBuilder();
		try (BufferedReader msgReader = new BufferedReader(new FileReader(messageFileName))) {
			String line;
			while ((line = msgReader.readLine()) != null) {
				String[] words = line.split("\\s+");
				for (String word : words) {
					String cleanWord = word.replaceAll("[.,!?]", "").toLowerCase();
					if (abbreviations.contains(cleanWord)) {
						markedMessageBuilder.append("<").append(cleanWord).append(">");
					} else {
						markedMessageBuilder.append(word);
					}
					markedMessageBuilder.append(" ");
				}
			}
			String markedMessage = markedMessageBuilder.toString().trim();
			System.out.println(markedMessage);

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
				writer.write(markedMessage);
			}
			System.out.println("Marked message save to: " + outputFileName);
		} catch (IOException e) {
			System.err.println("Error reading message file: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}
	public static void main(String[] args) {
		AbbreviationMarker02 marker = new AbbreviationMarker02();
		marker.processMessage();
	}
}
