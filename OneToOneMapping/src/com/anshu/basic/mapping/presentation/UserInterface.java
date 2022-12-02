package com.anshu.basic.mapping.presentation;

public interface UserInterface {
	
	public void addPersonRecord();
	
	public void updateCompleteRecord();
	public void updatePersonName();
	public void updatePersonDob();
	public void updatePersonGender();
	public void updatePersonEmailId();
	public void updatePersonAddress();
	
	public void removPersonRecordByMobNo();
	public void removePersonRecordByAadharNo();
	
	public void findPersonRecordByMobNo();
	public void findPersonRecordByAadharId();
	public void findPersonRecordByName();
	public void findPersonRecordByState();
	
	public void findAllPersonRecord();

}
