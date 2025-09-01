import java.util.Scanner;

public class RelicGame01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] rps = new int[7];
		int	max;
		int	max_idx;

		System.out.print("Enter 7 relic powers: ");
		for (int i = 0; i < rps.length; i++) {
			rps[i] = sc.nextInt();
		}
		max = rps[0];
		max_idx = 0;
		for (int i = 0; i < rps.length; i++) {
			if (rps[i] > max) {
				max = rps[i];
				max_idx = i;
			}
		}
		System.out.println("Strongest relic power: " + max);
		System.out.println("Original index: " + max_idx);
	}
}
