import java.util.Scanner;

public class Rep02Replace3
{
	public static void	main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		int hidx;

		while (true) {
			System.out.println("Enter a line of text.");
			str = sc.nextLine();
			if (str.equals("quit")) return ;
			hidx = (str.toLowerCase()).indexOf("hate");
			if (hidx == -1) {
				System.out.println("You entered: " + str);
			} else {
				str = str.substring(0, hidx) + "love" + str.substring(hidx + 4);
				System.out.println("I have rephrased that line to read:");
				System.out.println(str);
			}
		}
	}
}
