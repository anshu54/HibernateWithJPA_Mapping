package com.anshu.basic.mapping.presentation;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		UserInterfaceImp userInterfaceImp=new UserInterfaceImp();
		Integer choice=null;
		Integer option=null;
		do
		{
			System.out.println("\n***********************************");
			System.out.println("     Person Information    ");
			System.out.println("***********************************");
		
			System.out.println("1. Add 	Person Record.    ");
			System.out.println("2. Update Person Record.  ");
			System.out.println("3. Delete Person Record.  ");
			System.out.println("4. Find Person Record.    ");
			System.out.println("5. Find All Person Record.");
			System.out.println("6. Exit.");
		
			System.out.print("\nEnter your Choice : ");
			choice=scanner.nextInt();
			System.out.println("--------------------");
		
		switch(choice)
		{
			case 1:
				userInterfaceImp.addPersonRecord();
				break;
			case 2:
				do {
					System.out.println("\n*******************************");
					System.out.println("    Update Person Record :    ");
					System.out.println("********************************");
					
					System.out.println("1. Update Complete Record.   ");
					System.out.println("2. Update Person Name.        ");
					System.out.println("3. Update Person DateOfBirth. ");
					System.out.println("4. Update Person Gender. ");
					System.out.println("5. Update Person Email Id. ");
					System.out.println("6. Update Person Address. ");
					System.out.println("7. Exit ");
				
					System.out.print("Enter any option :");
					option=scanner.nextInt();
					System.out.println("-----------------");
					switch(option)
					{
						case 1:
							userInterfaceImp.updateCompleteRecord();
							break;
						case 2:
							userInterfaceImp.updatePersonName();
							break;
						case 3:
							userInterfaceImp.updatePersonDob();
							break;
						case 4:
							userInterfaceImp.updatePersonGender();
							break;
						case 5:
							userInterfaceImp.updatePersonEmailId();
							break;
						case 6:
							userInterfaceImp.updatePersonAddress();
							break;
						case 7:
							System.out.println("\nExit.");
							break;
						default:
							System.out.println("Invalid Number.");
					}
				}while(option!=7);
					
				break;
			case 3:
				do {
					System.out.println("\n*******************************");
					System.out.println("    Delete Person Record :    ");
					System.out.println("********************************");
					
					System.out.println("1. Delete Record By Person Mobile Number.   ");
					System.out.println("2. Delete Record By Aadhar Id              ");
					System.out.println("3. Exit ");
				
					System.out.print("Enter any option :");
					option=scanner.nextInt();
					System.out.println("-----------------");
					switch(option)
					{
						case 1:
							userInterfaceImp.removPersonRecordByMobNo();
							break;
						case 2:
							userInterfaceImp.removePersonRecordByAadharNo();
							break;
						case 3:
							System.out.println("\nExit.");
							break;
						default:
							System.out.println("Invalid Number.");
					}
				}while(choice!=3);
				break;
			case 4:
				do {
					System.out.println("\n*******************************");
					System.out.println("    Find Person Record :    ");
					System.out.println("********************************");
					
					System.out.println("1. Find Record By Person Mobile Number.   ");
					System.out.println("2. Find Record By Aadhar Id              ");
					System.out.println("3. Find Record By Person Name             ");
					System.out.println("4. Find Record By State Name             ");
					System.out.println("5. Exit ");
				
					System.out.print("Enter any option :");
					option=scanner.nextInt();
					System.out.println("-----------------");
					switch(option)
					{
						case 1:
							userInterfaceImp.findPersonRecordByMobNo();
							break;
						case 2:
							userInterfaceImp.findPersonRecordByAadharId();
							break;
						case 3:
							userInterfaceImp.findPersonRecordByName();
							break;
						case 4:
							userInterfaceImp.findPersonRecordByState();
							break;
						case 5:
							System.out.println("\nExit.");
							break;
						default:
							System.out.println("Invalid Number.");
					}
				}while(option!=5);
				break;
			case 5:
				userInterfaceImp.findAllPersonRecord();
				break;
			case 6:
				System.out.println("User does not want to continue... ");
				break;
			default:
				System.out.println("Invalid Number...");
		}
	}while(choice!=6);
		scanner.close();


	}

}
