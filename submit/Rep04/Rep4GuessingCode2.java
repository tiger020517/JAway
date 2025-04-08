import java.util.Scanner;

public class Rep4GuessingCode2 {
	public static void main(String[] args) {
		String guess;
		String answer = "53840";
		int[] out = new int[] {0, 0};
		Scanner input = new Scanner(System.in);
		int	flag = 5;

		System.out.println("비밀 코드 추측 게임에 오신 것을 환영합니다!");
		do {
			System.out.print("5자리 숫자를 입력하세요: ");
			guess = input.nextLine();
			if (guess.length() == 5) {
				for (int i = 0; i < 5; i++) {
					if (Character.isDigit(guess.charAt(i)))
						flag--;
				}
			}
			if (flag > 0)
			{
				System.out.println("오류: 5자리 숫자만 입력 가능합니다.");
				flag = 5;
			}
		} while (flag > 0);
		for (int i = 0; i < 5; i++) {
			if (guess.charAt(i) == answer.charAt(i)) {
				System.out.println(i + "번쨰는 맞다!");
				out[0] += 1;
				out[1] += Integer.parseInt(guess.substring(i, i + 1));
			}
		}
		System.out.println("추측 결과: 일치하는 자리 수 = " + out[0] +", 합 = " + out[1]);
	}
}
