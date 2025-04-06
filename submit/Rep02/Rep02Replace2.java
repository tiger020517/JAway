import java.util.Scanner;
public class Rep02Replace2
{
	public static void	main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String str;
		int wc;
		int	sidx;
		int	i;

		System.out.println("Enter a line of text.");
		str = sc.nextLine();
		wc = 1;
		sidx = (str.toLowerCase()).indexOf("hate");
		if (sidx == -1)
		{
			System.out.println("You don't hate anything good.");
			return ;
		}
		i = -1;
		while (++i < sidx)
		{
			if (str.charAt(i) == ' ')
				wc++;
		}
		System.out.println("First occurrence of \"hate\" is at index: " + wc);
	}
}
