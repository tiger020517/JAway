import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AbbreviationMarker01 {
	public void processMessage() {
		List<String> abbreviations = Arrays.asList("lol", "u", ":)", "iirc", "ttfn");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the message file name: ");
		String messageFileName = scanner.nextLine();
		try (BufferedReader reader = new BufferedReader(new FileReader(messageFileName))){
			StringBuilder messageBuilder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				messageBuilder.append(line).append(" ");
			}
			String message = messageBuilder.toString().trim();

			StringBuilder markedMessageBuilder = new StringBuilder();
			String[] words = message.split("\\s+");
			for (String word : words) {
				String cleanWord = word.replaceAll("[.,!?]", "").toLowerCase();
				if (abbreviations.contains(cleanWord)) {
					markedMessageBuilder.append("<").append(word).append(">");
				} else {
					markedMessageBuilder.append(word);
				}
				markedMessageBuilder.append(" ");
			}
			String markedMessage = markedMessageBuilder.toString().trim();
			System.out.println(markedMessage);
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}
	public static void main(String[] args) {
		AbbreviationMarker01 marker = new AbbreviationMarker01();
		marker.processMessage();
	}
}
