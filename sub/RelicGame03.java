import java.util.Scanner;

public class RelicGame03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] rps = new int[7];
		int[] rpoidx =  {0, 1, 2, 3, 4, 5, 6};

		System.out.print("Enter 7 relic powers: ");
		for (int i = 0; i < rps.length; i++) {
			rps[i] = sc.nextInt();
			rpoidx[i] = i;
		}
		for (int i = 0; i < rps.length; i++) {
			for (int j = i + 1; j < rps.length; j++) {
				if (rps[i] < rps[j]) {
					int temp = rps[i];
					rps[i] = rps[j];
					rps[j] = temp;
					temp = rpoidx[i];
					rpoidx[i] = rpoidx[j];
					rpoidx[j] = temp;
				}
			}
		}
		System.out.print("Sorted relics: ");
		for (int i = 0; i < rps.length; i++) {
			System.out.print(rps[i] + " ");
		}
		System.out.println();
		System.out.print("Guess the original index of the strongest relic: ");
		int ans = sc.nextInt();
		if (ans == rpoidx[0])
			System.out.println("Correct! You know the relics well");
		else
			System.out.println("Incorrect. The strongest relic was originally at position " + rpoidx[0]);
	}
}
