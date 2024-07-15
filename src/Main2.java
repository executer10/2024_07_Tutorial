import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("==프로그램 시작==");
		
		Scanner scnner = new Scanner(System.in);
		while(true) {
			System.out.printf("명령어 : ");
			String cmd = scnner.nextLine();
			
			if(cmd.equals("exit")) {
				break;
			}
		}
		scnner.close();
		
		System.out.println("==프로그램 끝==");
		
	}
}
