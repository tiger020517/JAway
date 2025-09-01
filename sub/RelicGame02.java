import java.util.Scanner;
public class RelicGame02 {
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
		for (int i = 0; i < rps.length; i++) {
			System.out.println(rps[i] + " (from " + rpoidx[i] + ")");
		}
	}
}
