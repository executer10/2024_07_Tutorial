import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		Scanner scanner = new Scanner(System.in);
		String cmd = scanner.nextLine();
		int cmd2 = scanner.nextInt();
		System.out.println(cmd + cmd2);
		System.out.println("==프로그램 종료==");
		
		System.out.println("테스트");
		scanner.close();
	}
}
