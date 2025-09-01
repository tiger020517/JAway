import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

public class AbbreviationMarker03 {
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
			return;
		}
		System.out.print("Enter message file name: ");
		String messageFileName = scanner.nextLine();
		System.out.print("Enter output file name: ");
		String outputFileName = scanner.nextLine();

		List<String> allMarkedLines = new ArrayList<>();
		try (BufferedReader msgReader = new BufferedReader(new FileReader(messageFileName))) {
			String line;
			int lineNumber = 1;

			while ((line = msgReader.readLine()) != null) {
				int foundCount = 0;
				StringBuilder markedLineBuilder = new StringBuilder();
				Pattern tokenPattern = Pattern.compile("(\\S+)");
				int lastEnd = 0;
				Matcher matcher = tokenPattern.matcher(line);
				while (matcher.find()) {
					if (matcher.start() > lastEnd) {
						markedLineBuilder.append(line.substring(lastEnd, matcher.start()));
					}

					String currentToken = matcher.group(1);
					String cleanTokenForCheck = currentToken.toLowerCase();
					if (Pattern.matches(".*\\w+.*", currentToken)) {
						cleanTokenForCheck = currentToken.replaceAll("[.,!?;:]", "").toLowerCase();
					}
					if (abbreviations.contains(cleanTokenForCheck)) {
						markedLineBuilder.append("<").append(currentToken).append(">");
						foundCount++;
					} else {
						markedLineBuilder.append(currentToken);
					}
					lastEnd = matcher.end();
				}

				if (lastEnd < line.length()) {
					markedLineBuilder.append(line.substring(lastEnd));
				}

				String markedLine = markedLineBuilder.toString();
				allMarkedLines.add(markedLine);

				System.out.println("Line " + lineNumber + ": " + foundCount + " abbreviation(s) found.");
				System.out.println(markedLine.trim());
				lineNumber++;
			}

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
				for (String markedLine : allMarkedLines) {
					writer.write(markedLine.trim());
					writer.newLine();
				}
			}
			System.out.println("Marked message saved to: " + outputFileName);

		} catch (IOException e) {
			System.err.println("Error processing message file: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}
	public static void main(String[] args) {
		AbbreviationMarker03 marker = new AbbreviationMarker03();
		marker.processMessage();
	}
}
