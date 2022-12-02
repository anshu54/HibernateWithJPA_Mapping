package com.anshu.basic.mapping.presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.anshu.basic.mapping.dao.PersonDaoImp;
import com.anshu.basic.mapping.model.AadharCard;
import com.anshu.basic.mapping.model.Person;
import com.anshu.basic.mapping.validation.Validation;

public class UserInterfaceImp implements UserInterface {
	
	private Scanner scanner=new Scanner(System.in);
	private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM/dd/yyyy");
	private PersonDaoImp personDaoImp=new PersonDaoImp();
	private String personMobNo;
	private String personName;
	private Date personDob;
	private String personGender;
	private String personAddress;
	private String personEmailId;
	private String personState;
	private String aadharId;
	private  Date issueDate;
	private String dob;
	private String issuedDate;
	private String houseNo;
	private String houseName;
	private String pinCode;
	
	private static String website;
	private static String helpLineNumber;
	private static String aadharEmail;

	private Boolean checkingName;
	private Boolean checkingGender;
	private Boolean checkingEmail;
	private Boolean checkingDateOfBirth;
	private Boolean checkingAadharId;
	private Boolean checkingIssueDate;
	private Boolean checkingMobNo;
	private Boolean checkingState;
	
	static
	{
		website="www.uidai.gov.in";
		helpLineNumber="1947";
		aadharEmail="help@uidai.gov.in";
	}
	

	@Override
	public void addPersonRecord() {
		AadharCard aadharCard=new AadharCard();
		Person person=new Person();
		checkingName=true;
		checkingGender=true;
		checkingEmail=true;
		checkingDateOfBirth=true;
		checkingAadharId=true;
		checkingIssueDate=true;
		checkingMobNo=true;
		checkingState=true;
		while(checkingMobNo)
		{
			System.out.print("\nEnter Person Mobile Number :");
			personMobNo=scanner.nextLine();
			if(!personMobNo.startsWith("+91"))
			{
				personMobNo="+91"+personMobNo;
			}
			if(Validation.checkMobileNumber(personMobNo))
			{
				Person person1=personDaoImp.findPersonRecordByMobNo(personMobNo);
				if(person1==null)
				{
					person.setPersonMobNo(personMobNo);
					checkingMobNo=false;
					while(checkingName)
					{
						System.out.print("Enter Person Name :");
						personName=scanner.nextLine();
						if(Validation.checkNameLength(personName))
						{
							if(Validation.validateString(personName))
							{
								person.setPersonName(personName);
								checkingName=false;
								while(checkingDateOfBirth)
								{
									System.out.print("Enter Person Date Of Birth :");
									dob=scanner.nextLine();
									if(Validation.checkDate(dob,new Date())) 
									{
										try 
										{
											personDob=simpleDateFormat.parse(dob);
										} catch (ParseException e) {
											System.out.println(e);
											}
											person.setPersonDob(personDob);
											checkingDateOfBirth=false;
											while(checkingGender)
											{
												System.out.print("Enter Person Gender :");
												personGender=scanner.nextLine();
												if(Validation.checkGender(personGender))
												{
													person.setPersonGender(personGender);
													checkingGender=false;
													while(checkingEmail)
													{
														System.out.print("Enter Person Email Id :");
														personEmailId=scanner.nextLine();
														if(Validation.checkEmail(personEmailId))
														{
															person.setPersonEmailId(personEmailId);
															checkingEmail=false;
															System.out.println("Enter Person City :");
															personAddress=scanner.nextLine();
															person.setPersonAddress(personAddress);
															while(checkingAadharId)
															{
																System.out.print("Enter Aadhar Id :");
																aadharId=scanner.nextLine();
																if(Validation.isValidAadharId(aadharId))
																{
																	AadharCard aadharCard1=personDaoImp.findPersonRecordByAadharId(aadharId);
																	if(aadharCard1==null)
																	{
																		aadharCard.setAadharId(aadharId);
																		checkingAadharId=false;
																		while(checkingState)
																		{
																			System.out.print("Enter the State :");
																			personState=scanner.nextLine().toUpperCase();
																			if(Validation.checkStateName(personState))
																			{
																				person.setPersonState(personState);
																				checkingState=false;
																				aadharCard.setWebsite(website);
																				aadharCard.setHelpLineNumber(helpLineNumber);
																				aadharCard.setAadharEmail(aadharEmail);
																				while(checkingIssueDate)
																				{
																					System.out.print("Enter Aadhar Issue Date :");
																					issuedDate=scanner.nextLine();
																					if(Validation.checkDate1(issuedDate,dob))
																					{
																						try 
																						{
																							issueDate=simpleDateFormat.parse(issuedDate);
																						} catch (ParseException e) {
																							System.out.println(e);
																							}
																						aadharCard.setIssueDate(issueDate);
																						checkingIssueDate=false;
																						person.setAadharCard(aadharCard);
																						aadharCard.setPerson(person);
																						System.out.println("\n"+personDaoImp.addPersonRecord(person)+"\n");
																					
																					}
																					else
																						System.out.println("\nInvalid date format...\n");
																				}
																			}
																			else
																				System.out.println("\nInvalid State Name..\n");
																			
																		}
																		}
																		else
																			System.out.println("\n***This Aadhar Number already Exist..\n");
																	}
																	else
																		System.out.println("\nInvalid Aadhar Id....\n");
																}	
															}
															else
																System.out.println("\nInvalid Email...\n");
														}
													}
													else
														System.out.println("\nInvalid Gender.\n");
												}
											}
											else
												System.out.println("\nInvalid date format...\n");
										}
									}
									else
										System.out.println("\nPerson name must be letters...\n");
								}
								else
									System.out.println("\nPerson name length must be less then 15 ...\n");
							}	
						}
						else
							System.out.println("\n Mobile Number Already Exist...\n");
					}
				else
					System.out.println("\nInvalid Mobile Number..\n");
				}	
	}

	@Override
	public void updateCompleteRecord() {
		checkingName=true;
		checkingGender=true;
		checkingEmail=true;
		checkingDateOfBirth=true;
		checkingName=true;
		checkingAadharId=true;
		while(checkingAadharId)
		{
			System.out.print("Enter Aadhar Id :");
			aadharId=scanner.nextLine();
			if(Validation.isValidAadharId(aadharId))
			{
				AadharCard aadharCard=personDaoImp.findPersonRecordByAadharId(aadharId);
				Person person=aadharCard.getPerson();
				if(aadharCard!=null)
				{
					while(checkingName)
					{
						System.out.print("Enter Person Name :");
						personName=scanner.nextLine();
						if(Validation.checkNameLength(personName))
						{
							if(Validation.validateString(personName))
							{
								person.setPersonName(personName);
								checkingName=false;
								while(checkingDateOfBirth)
								{
									System.out.print("Enter Person Date Of Birth :");
									dob=scanner.nextLine();
									if(Validation.checkDate(dob,new Date())) 
									{
										try 
										{
											personDob=simpleDateFormat.parse(dob);
										} catch (ParseException e) {
											System.out.println(e);
										}
										person.setPersonDob(personDob);
										checkingDateOfBirth=false;
										while(checkingGender)
										{
											System.out.print("Enter Person Gender :");
											personGender=scanner.nextLine();
											if(Validation.checkGender(personGender))
											{
												person.setPersonGender(personGender);
												checkingGender=false;
												while(checkingEmail)
												{
													System.out.print("Enter Person Email Id :");
													personEmailId=scanner.nextLine();
													if(Validation.checkEmail(personEmailId))
													{
														person.setPersonEmailId(personEmailId);
														checkingEmail=false;
														System.out.print("Enter Person City :");
														personAddress=scanner.nextLine();
														//person.setPersonAddress(personAddress);
														System.out.print("Enter the State :");
														personState=scanner.nextLine();
														person.setPersonState(personState);
														aadharCard.setPerson(person);
														System.out.println("\n"+personDaoImp.updateCompleteRecord(aadharCard));
														checkingAadharId=false;
												
													}
													else
														System.out.println("\n**Invalid Email...\n");
												}
											}
											else
												System.out.println("\n**Invalid Gender...\n");	
										}
									}
									else
										System.out.println("\n**Invalid date format...\n");
								}
							}
							else
								System.out.println("\n**Person name must be letters...\n");
						}
						else
							System.out.println("\n**Person name length must be less then 15...\n");
					}			
				} else
					System.out.println("\n **Record Not Found**\n");
				}
				else
					System.out.println("\nInvalid Aadhar Id....\n");
			}	
	}

	@Override
	public void updatePersonName() {
		checkingName=true;
		checkingAadharId=true;
		while(checkingAadharId)
		{
			System.out.print("Enter Aadhar Id :");
			aadharId=scanner.nextLine();
			if(Validation.isValidAadharId(aadharId))
			{
				AadharCard aadharCard=personDaoImp.findPersonRecordByAadharId(aadharId);
				Person person=aadharCard.getPerson();
				if(aadharCard!=null)
				{
					while(checkingName)
					{
						System.out.print("Enter Person Name :");
						personName=scanner.nextLine();
						if(Validation.checkNameLength(personName))
						{
							if(Validation.validateString(personName))
							{
								person.setPersonName(personName);
								System.out.println("\n"+personDaoImp.updatePersonName(person));
								checkingName=false;
								checkingAadharId=false;
							}
							else
								System.out.println("\n**Person name must be letters...\n");
						}
						else
							System.out.println("\n**Person name length must be less then 15...\n");
					}			
				}
				else
					System.out.println("\n **Record Not Found**\n");
			}
			else
				System.out.println("\nInvalid Aadhar Id....\n");
		}
	}

	@Override
	public void updatePersonDob() {
		checkingDateOfBirth=true;
		checkingAadharId=true;
		while(checkingAadharId)
		{
			System.out.print("Enter Aadhar Id :");
			aadharId=scanner.nextLine();
			if(Validation.isValidAadharId(aadharId))
			{
				AadharCard aadharCard=personDaoImp.findPersonRecordByAadharId(aadharId);
				Person person=aadharCard.getPerson();
				if(aadharCard!=null)
				{
					while(checkingDateOfBirth)
					{
						System.out.print("Enter Person Date Of Birth :");
						dob=scanner.nextLine();
						if(Validation.checkDate(dob,new Date())) 
						{
							try 
							{
								personDob=simpleDateFormat.parse(dob);
							} catch (ParseException e) {
								System.out.println(e);
								}
								person.setPersonDob(personDob);
								System.out.println("\n"+personDaoImp.updatePersonDob(person));
								checkingDateOfBirth=false;
								checkingAadharId=false;
						}
						else
							System.out.println("\n**Invalid date format...\n");	
					}
				}
				else
					System.out.println("\n **Record Not Found**\n");
			}
			else
				System.out.println("\nInvalid Aadhar Id....\n");
		}
	}

	@Override
	public void updatePersonGender() {
		checkingGender=true;
		checkingAadharId=true;
		while(checkingAadharId)
		{
			System.out.print("Enter Aadhar Id :");
			aadharId=scanner.nextLine();
			if(Validation.isValidAadharId(aadharId))
			{
				AadharCard aadharCard=personDaoImp.findPersonRecordByAadharId(aadharId);
				Person person=aadharCard.getPerson();
				if(aadharCard!=null)
				{
					while(checkingGender)
					{
						System.out.print("Enter Person Gender :");
						personGender=scanner.nextLine();
						if(Validation.checkGender(personGender))
						{
							person.setPersonGender(personGender);
							System.out.println("\n"+personDaoImp.updatePersonGender(person));
							checkingGender=false;
							checkingAadharId=false;
						}
						else
							System.out.println("\n**Invalid Gender...\n");
					}
				}
				else
					System.out.println("\n **Record Not Found**\n");
			}
			else
				System.out.println("\nInvalid Aadhar Id....\n");
		}	
	}

	@Override
	public void updatePersonEmailId() {
		checkingEmail=true;
		checkingAadharId=true;
		while(checkingAadharId)
		{
			System.out.print("Enter Aadhar Id :");
			aadharId=scanner.nextLine();
			if(Validation.isValidAadharId(aadharId))
			{
				AadharCard aadharCard=personDaoImp.findPersonRecordByAadharId(aadharId);
				Person person=aadharCard.getPerson();
				if(aadharCard!=null)
				{
					while(checkingEmail)
					{
						System.out.print("Enter Person Email Id :");
						personEmailId=scanner.nextLine();
						if(Validation.checkEmail(personEmailId))
						{
							person.setPersonEmailId(personEmailId);
							System.out.println("\n"+personDaoImp.updatePersonEmailId(person));
							checkingEmail=false;
							checkingAadharId=false;
						}
						else
							System.out.println("**Invalid Email...");
					}
				}
				else
					System.out.println("\n **Record Not Found**\n");
			}
			else
				System.out.println("\nInvalid Aadhar Id....\n");
		}	
	}

	@Override
	public void updatePersonAddress() {
		checkingAadharId=true;
		while(checkingAadharId)
		{
			System.out.print("Enter Aadhar Id :");
			aadharId=scanner.nextLine();
			if(Validation.isValidAadharId(aadharId))
			{
				AadharCard aadharCard=personDaoImp.findPersonRecordByAadharId(aadharId);
				Person person=aadharCard.getPerson();
				if(aadharCard!=null)
				{
					System.out.print("Enter Person Address :");
					personAddress=scanner.nextLine();
					//person.setPersonAddress(personAddress);
					System.out.println("\n"+personDaoImp.updatePersonAddress(person));
					checkingAadharId=false;
					
				}
				else
					System.out.println("\n **Record Not Found**\n");
			}
			else
				System.out.println("\nInvalid Aadhar Id....\n");
		}	
		
	}

	@Override
	public void removPersonRecordByMobNo() {
		System.out.print("\nEnter Person Mobile Number :");
		personMobNo=scanner.nextLine();
		Person pObj=personDaoImp.findPersonRecordByMobNo(personMobNo);
		if(pObj!=null)
		{
			System.out.println("\n"+personDaoImp.deletePersonRecordByMobNo(personMobNo)+"\n");
		}
		else
		{
			System.out.println("\n Record Not Found..");
		}
	}
	
	@Override
	public void removePersonRecordByAadharNo() {
		System.out.print("\nEnter Person Aadhar Id :");
		aadharId=scanner.nextLine();
		AadharCard aadharCard=personDaoImp.findPersonRecordByAadharId(aadharId);
		if(aadharCard!=null)
		{
			System.out.println("\n"+personDaoImp.deletePersonRecordByAadharId(aadharId));
		}
		else
		{
			System.out.println("\n Record Not Found..");
		}
		
	}

	@Override
	public void findPersonRecordByMobNo() {
		checkingMobNo=true;
		while(checkingMobNo)
		{
			System.out.print("\nEnter Person Mobile Number :");
			personMobNo=scanner.nextLine();
			if(!personMobNo.startsWith("+91"))
			{
				personMobNo="+91"+personMobNo;
			}
			if(Validation.checkMobileNumber(personMobNo))
			{
				Person person=personDaoImp.findPersonRecordByMobNo(personMobNo);
				checkingMobNo=false;
				if(person!=null)
				{
					System.out.println("\n********************************************************");
					System.out.println("Person Mobile No	 : "+person.getPersonMobNo());
					System.out.println("Person Name		: "+person.getPersonName());
					System.out.println("Person DateOfBirth	 : "+person.getPersonDob());
					System.out.println("Person Gender	 	 : "+person.getPersonGender());
					System.out.println("Person Email Id		 : "+person.getPersonEmailId());
					System.out.println("Person Address		 : "+person.getPersonAddress());
					System.out.println("Person State		 : "+person.getPersonState());
					System.out.println("Person Aadhar Id	 : "+person.getAadharCard().getAadharId());
					System.out.println("Aadhar Website	 	 : "+person.getAadharCard().getWebsite());
					System.out.println("Aadhar HelpLine No	 : "+person.getAadharCard().getHelpLineNumber());
					System.out.println("Aadhar Email	 	 : "+person.getAadharCard().getAadharEmail());
					System.out.println("Aadhar Issue Date	 : "+person.getAadharCard().getIssueDate());
					System.out.println("********************************************************");
				}
				else
					System.out.println("\nRecord Not Found");
			}
			else
				System.out.println("\nInvalid Mobile Number..\n");
			}	
	}

	@Override
	public void findPersonRecordByAadharId() {
		checkingAadharId=true;
		while(checkingAadharId)
		{
			System.out.print("Enter Aadhar Id :");
			aadharId=scanner.nextLine();
			if(Validation.isValidAadharId(aadharId))
			{
				AadharCard aadharCard=personDaoImp.findPersonRecordByAadharId(aadharId);
				checkingAadharId=false;
				if(aadharCard!=null)
				{
					System.out.println("\n********************************************************");
					System.out.println("Person Mobile No	 : "+aadharCard.getPerson().getPersonMobNo());
					System.out.println("Person Name		: "+aadharCard.getPerson().getPersonName());
					System.out.println("Person DateOfBirth	 : "+aadharCard.getPerson().getPersonDob());
					System.out.println("Person Gender	 	 : "+aadharCard.getPerson().getPersonGender());
					System.out.println("Person Email Id		 : "+aadharCard.getPerson().getPersonEmailId());
					System.out.println("Person Address		 : "+aadharCard.getPerson().getPersonAddress());
					System.out.println("Person State		 : "+aadharCard.getPerson().getPersonState());
					System.out.println("Person Aadhar Id	 : "+aadharCard.getAadharId());
					System.out.println("Aadhar Website	 	 : "+aadharCard.getWebsite());
					System.out.println("Aadhar HelpLine No	 : "+aadharCard.getHelpLineNumber());
					System.out.println("Aadhar Email	 	 : "+aadharCard.getAadharEmail());
					System.out.println("Aadhar Issue Date	 : "+aadharCard.getIssueDate());
					System.out.println("********************************************************");
				}
				else
					System.out.println("\nRecord Not Found");
			}
			else
				System.out.println("\nInvalid Aadhar Id....\n");
		}	
	}
	
	@Override
	public void findPersonRecordByName() {
		checkingName=true;
		while(checkingName)
		{
			System.out.print("Enter Person Name :");
			personName=scanner.nextLine();
			if(Validation.checkNameLength(personName))
			{
				if(Validation.validateString(personName))
				{
					List<Person> li=personDaoImp.findPersonRecordByName(personName);
					checkingName=false;
					if(li.size()!=0) {
						Iterator<Person> itr=li.iterator();
						while(itr.hasNext())
						{
							Person person=itr.next();
							System.out.println("\n********************************************************");
							System.out.println("Person Mobile No	 : "+person.getPersonMobNo());
							System.out.println("Person Name		: "+person.getPersonName());
							System.out.println("Person DateOfBirth	 : "+person.getPersonDob());
							System.out.println("Person Gender	 	 : "+person.getPersonGender());
							System.out.println("Person Email Id		 : "+person.getPersonEmailId());
							System.out.println("Person Address		 : "+person.getPersonAddress());
							System.out.println("Person State		 : "+person.getPersonState());
							System.out.println("Person Aadhar Id	 : "+person.getAadharCard().getAadharId());
							System.out.println("Aadhar Website	 	 : "+person.getAadharCard().getWebsite());
							System.out.println("Aadhar HelpLine No	 : "+person.getAadharCard().getHelpLineNumber());
							System.out.println("Aadhar Email	 	 : "+person.getAadharCard().getAadharEmail());
							System.out.println("Aadhar Issue Date	 : "+person.getAadharCard().getIssueDate());
							System.out.println("********************************************************");
						}
					}
					else
						System.out.println("\nRecord Not Found");
				}
				else
					System.out.println("\n**Person name must be letters...\n");
			}
			else
				System.out.println("\n**Person name length must be less then 15...\n");
		}		
	}

	@Override
	public void findPersonRecordByState() {
		System.out.print("\nEnter State Name :");
		personState=scanner.nextLine();
		List<Person> li=personDaoImp.findPersonRecordByState(personState.toUpperCase());
		if(li.size()!=0) 
		{
			for(Person p:li)
			{
				System.out.println("\n********************************************************");
				System.out.println("Person Mobile No	 : "+p.getPersonMobNo());
				System.out.println("Person Name		: "+p.getPersonName());
				System.out.println("Person DateOfBirth	 : "+p.getPersonDob());
				System.out.println("Person Gender	 	 : "+p.getPersonGender());
				System.out.println("Person Email Id		 : "+p.getPersonEmailId());
				System.out.println("Person Address		 : "+p.getPersonAddress());
				System.out.println("Person State		 : "+p.getPersonState());
				System.out.println("Person Aadhar Id	 : "+p.getAadharCard().getAadharId());
				System.out.println("Aadhar Website	 	 : "+p.getAadharCard().getWebsite());
				System.out.println("Aadhar HelpLine No	 : "+p.getAadharCard().getHelpLineNumber());
				System.out.println("Aadhar Email	 	 : "+p.getAadharCard().getAadharEmail());
				System.out.println("Aadhar Issue Date	 : "+p.getAadharCard().getIssueDate());
				System.out.println("********************************************************");
			}
			
		}
		else
		{
			System.out.println("\nRecord Not Found");
		}
		
	}

	@Override
	public void findAllPersonRecord() {
		List<Person> li=personDaoImp.findAllPersonRecord();
		Iterator<Person> itr=li.iterator();
		System.out.println("\n*****************************************************************************************************************");
		System.out.println("personMobNo\tpersonName\tpersonDob\tGender\tpersonEmailId\t\tAddress\t\tState\t\tAadharId"
				+ "\tAadharWebsite\tHelpLineNo\tAadharEmail\t\tIssueDate");
		System.out.println("*****************************************************************************************************************");
		while(itr.hasNext()) {
			Person p=itr.next();
			System.out.println(p.getPersonMobNo()+"\t"+p.getPersonName()+"\t"+ p.getPersonDob()+"\t"+p.getPersonGender()+"\t"+p.getPersonEmailId()+"\t\t"+p.getPersonAddress()+"\t\t"+
					p.getPersonState()+"\t"+p.getAadharCard().getAadharId()+"\t"+p.getAadharCard().getWebsite()+"\t"+p.getAadharCard().getHelpLineNumber()+
					"\t"+p.getAadharCard().getAadharEmail()+"\t"+p.getAadharCard().getIssueDate());
		}
		System.out.println("******************************************************************************************************************");

	}

}
