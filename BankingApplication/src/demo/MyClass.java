package demo;

import java.util.Scanner;

public class MyClass
{
	//
	double amount=100.00;
	int tran=1;
	Scanner sc=new Scanner(System.in);
	public static void main(String[] args) 
	{
		MyClass m1=new MyClass();
		m1.menu();
	}
	public void menu()
	{
		System.out.println("======menu=========");	
		System.out.println("1. Deposit");	
		System.out.println("2. Withdraw");
		System.out.println("3. Read Amount");
		System.out.println("Select one otion");
		
		int c=sc.nextInt();
		switch(c)
		{
		case 1:
			deposit();
			break;
		case 2:
			withdrawBalance();
			break;
		case 3:
			readBalance();
			break;
		default:
			System.out.println("you have selected wrong option please try again");
			break;
		}
		menu();
	}
	public void readBalance()
	{
		System.out.println("Total amount is: "+amount);
	}
	public void yesno()
	{
		System.out.println("Do you wish to continue");
		String ch=sc.next();
		if(ch.equalsIgnoreCase("yes"))
			menu();
		
	}
	public void withdrawBalance()
	{
		System.out.println("Enter amount");
		double amt=sc.nextDouble();
		double amt2=amt*0.0050;
		if(tran	>1)
			amt2=amt*0.0040;
		
		amt=amt-amt2;
		amount-=amt;
		System.out.println("Withdraw Successfull ");
		System.out.println("Additional charge: "+amt2);
		tran++;
	}
	public void deposit()
	{
		System.out.println("Enter amount");
		double amt=sc.nextDouble();
		double amt2=(amt/0.50);
		if(tran>1)
			amt2=amt*0.0020;
		
		amt=amt-amt2;
		amount+=amt;
		System.out.println("Deposit Successfull ");
		System.out.println("Additional charge: "+amt2);
		tran++;
	}
}
