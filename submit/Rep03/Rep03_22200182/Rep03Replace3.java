import java.util.Scanner;

public class Rep03Replace3 {
	public static void main(String[] args) {
		String	t1;
		String	t2;
		int[]	ti1 = new int[3];
		int[]	ti2 = new int[3];
		int[]	tio =  new int[3];
		Scanner sc = new Scanner(System.in);

		System.out.print("첫번째 시간을 입력하세요 (HH:MM:SS): ");
		t1 = sc.nextLine();
		System.out.print("두번째 시간을 입력하세요 (HH:MM:SS): ");
		t2 = sc.nextLine();
		for (int i = 0; i < 3; i++)
			ti1[i] = Integer.parseInt(t1.substring(i * 3, i * 3 + 2));
		for (int i = 0; i < 3; i++)
			ti2[i] = Integer.parseInt(t2.substring(i * 3, i * 3 + 2));
		tio[0] = ti2[0] - ti1[0];
		tio[1] = ti2[1] - ti1[1];
		if (ti1[1] > ti2[1])
		{
			tio[0] -= 1;
			tio[1] += 60;
		}
		tio[2] = ti2[2] - ti1[2];
		if (ti1[2] > ti2[2])
		{
			tio[1] -= 1;
			tio[2] += 60;
		}
		if ((ti1[0] > 23 || ti2[0] > 23) || (ti1[0] < 0 || ti2[0] < 0))
			System.out.println("시(hour)는 0~23 사이여야 합니다.");
		else if ((ti1[1] > 59 || ti2[1] > 59) || (ti1[1] < 0 || ti2[1] < 0))
			System.out.println("분(minuite)은 0~59 사이여야 합니다.");
		else if ((ti1[2] > 59 || ti2[2] > 59) || (ti1[2] < 0 || ti2[2] < 0))
			System.out.println("초(second)는 0~59 사이여야 합니다.");
		else {
			if (tio[0] < 0 || tio[1] < 0 || tio[2] < 0)
				System.out.println("두 번째 시간이 첫 번째 시간보다 이전입니다.");
			else
				System.out.println("경과된 시간은 " + tio[0] + "시 " + tio[1] + "분 " + tio[2] + " 초입니다.");
		}
	}
}
