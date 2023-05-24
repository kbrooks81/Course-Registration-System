package crs;
import java.util.Scanner;

public class Login extends User{
	public static void askUser() {
		
	}
	
	public void firstName() {
		Scanner input = new Scanner(System.in);
		System.out.print("First Name: ");
		String firstName = input.nextLine();
		
	}

	public void lastName() {
		Scanner input = new Scanner(System.in);
		System.out.print("Last Name: ");
		String lastName = input.nextLine();
	}

	public void username() {
		Scanner input = new Scanner(System.in);
		System.out.print("Username: ");
		String username = input.nextLine();
	}

	public void password() {
		Scanner input = new Scanner(System.in);
		System.out.print("Password: ");
		String password = input.nextLine();
	}
}