package com.anshu.basic.mapping.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	static Boolean msg;
	public static Boolean checkNameLength(String name)
	{
		if(name.length()<15)
		{
			msg = true;
		}
		else
		{
			msg = false;
		}
		return msg;
	}

	public static Boolean validateString(String name)
	{
		String regex = "[a-zA-Z\\s]+";

		Pattern p = Pattern.compile(regex);
		if (name == null) {
			return false;
		}
		Matcher m = p.matcher(name);
		return m.matches();	
	
	}
	@SuppressWarnings("deprecation")
	public static Boolean checkDate(String targetDate,Date currentDate)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				
	
		Date newDate = new Date(formatter.format(currentDate));
		Date tDate = new Date(formatter.format(new Date(targetDate)));
		
		if(tDate.after(newDate)==false)
		{
			if (targetDate.trim().equals(""))
				return true;
			else
			{ 
				SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
				sdfrmt.setLenient(false);
				try{
					Date javaDate = sdfrmt.parse(targetDate);  
				}catch (ParseException e) { 
					return false;
				}
				return true;
			}
		}
		else	
			return false;
	
	}
	@SuppressWarnings("deprecation")
	public static Boolean checkDate1(String issueDate,String dobDate)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				
	
		Date oldDate = new Date(formatter.format(new Date(dobDate)));
		Date newDate = new Date(formatter.format(new Date(issueDate)));
		
		if(newDate.after(oldDate)==true)
			return true;
		else	
			return false;
	}
	public static boolean checkEmail(String email)
	{
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
            				"[a-zA-Z0-9_+&*-]+)*@" +
            				"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            				"A-Z]{2,7}$";                          
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();


	}
	public  static Boolean checkGender(String gender)
	{
		String regex = "Male|male|Female|female|Other";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(gender);
		Boolean result=true;
		if(m.matches()) {
			result= true;
		}
		else {
			result=false;
		}
		return result;
      
	}      
	public static Boolean checkMobileNumber(String s)
	{
		Pattern p = Pattern.compile("^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$");
		Matcher m = p.matcher(s);

		return m.matches();
	}
	
	public static boolean isValidAadharId(String aadharId)
	{
    String regex
        = "^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$";

    Pattern p = Pattern.compile(regex);
    if (aadharId == null) {
        return false;
    }
    Matcher m = p.matcher(aadharId);
    return m.matches();
	}
	
	public static Boolean checkStateName(String stateName)
	{
		Set<String> stateNameList=new LinkedHashSet<>();
		
		stateNameList=Set.of("andhra pradesh","arunachal pradesh","assam","bihar","chhattisgarh","goa","gujarat ","haryana","himachal pradesh","jharkhand ","karnataka","kerala",
				"madhya pradesh","maharashtra","manipur","meghalaya","mizoram","nagaland ","odisha","punjab","rajasthan","sikkim","tamil nadu","telangana","tripura","uttar pradesh","uttarakhand","west bengal",
				"andaman and nicobar","chandigarh","delhi","jammu and kashmir","lakshadweep","ladakh","puducherry");
		
		if(stateNameList.contains(stateName))
		return true;
		else
			return false;
	}

}
