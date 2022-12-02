package com.anshu.basic.mapping.dao;

import java.util.List;

import com.anshu.basic.mapping.model.AadharCard;
import com.anshu.basic.mapping.model.Person;

public interface PersonDao {
	public String addPersonRecord(Person person);
	
	public String updateCompleteRecord(AadharCard aadharCard);
	public String updatePersonName(Person person);
	public String updatePersonDob(Person person);
	public String updatePersonGender(Person person);
	public String updatePersonEmailId(Person person);
	public String updatePersonAddress(Person person);
	
	public String deletePersonRecordByMobNo(String personMobNo);
	public String deletePersonRecordByAadharId(String aadharId);
	
	public Person findPersonRecordByMobNo(String personMobNo);
	public AadharCard findPersonRecordByAadharId(String aadharId);
	public List<Person> findPersonRecordByName(String personName);
	public List<Person> findPersonRecordByState(String state);
	
	public List<Person> findAllPersonRecord();

}
