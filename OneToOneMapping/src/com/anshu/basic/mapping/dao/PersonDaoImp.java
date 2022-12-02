package com.anshu.basic.mapping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.anshu.basic.mapping.model.AadharCard;
import com.anshu.basic.mapping.model.Person;

public class PersonDaoImp implements PersonDao {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager 		entityManager;
	private static EntityTransaction 	entityTransaction;
	
	static
	{
		entityManagerFactory=Persistence.createEntityManagerFactory("anshu1");
		entityManager		=entityManagerFactory.createEntityManager();
		entityTransaction	=entityManager.getTransaction();
	}

	@Override
	public String addPersonRecord(Person person) {
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
		entityManager.clear();
		return "\nRecord Added..";
		
	}

	@Override
	public String updateCompleteRecord(AadharCard aadharCard) {
		AadharCard aadharCard1=entityManager.find(AadharCard.class, aadharCard.getAadharId());
		entityTransaction.begin();
			aadharCard1.setPerson(aadharCard.getPerson());
		entityTransaction.commit();
		entityManager.clear();
		
		return "\nRecord Updated..";
		
	}
	@Override
	public String updatePersonName(Person person) {
		Person person1=entityManager.find(Person.class, person.getPersonMobNo());
		entityTransaction.begin();
			person1.setPersonName(person.getPersonName());
		entityTransaction.commit();
		entityManager.clear();
		
		return "\nRecord Updated..";
	}
	

	@Override
	public String updatePersonDob(Person person) {
		Person person1=entityManager.find(Person.class, person.getPersonMobNo());
		entityTransaction.begin();
			person1.setPersonDob(person.getPersonDob());
		entityTransaction.commit();
		entityManager.clear();
		
		return "\nRecord Updated..";
	}

	@Override
	public String updatePersonGender(Person person) {
		Person person1=entityManager.find(Person.class, person.getPersonMobNo());
		entityTransaction.begin();
			person1.setPersonGender(person.getPersonGender());
		entityTransaction.commit();
		entityManager.clear();
		
		return "\nRecord Updated..";
	}

	@Override
	public String updatePersonEmailId(Person person) {
		Person person1=entityManager.find(Person.class, person.getPersonMobNo());
		entityTransaction.begin();
			person1.setPersonEmailId(person.getPersonEmailId());
		entityTransaction.commit();
		entityManager.clear();
		
		return "\nRecord Updated..";
	}

	@Override
	public String updatePersonAddress(Person person) {
		Person person1=entityManager.find(Person.class, person.getPersonMobNo());
		entityTransaction.begin();
			person1.setPersonAddress(person.getPersonAddress());
		entityTransaction.commit();
		entityManager.clear();
		
		return "\nRecord Updated..";
	}

	@Override
	public String deletePersonRecordByMobNo(String personMobNo) {
		Person person=entityManager.find(Person.class, personMobNo);
		entityTransaction.begin();
		entityManager.remove(person);
		entityTransaction.commit();
		return "Record Deleted.....";
	}

	@Override
	public String deletePersonRecordByAadharId(String aadharId) {
		AadharCard aadharCard=entityManager.find(AadharCard.class, aadharId);
		entityTransaction.begin();
		entityManager.remove(aadharCard);
		entityTransaction.commit();
		return "Record Deleted.....";
	}

	@Override
	public Person findPersonRecordByMobNo(String personMobNo) {
		Person person=entityManager.find(Person.class, personMobNo);
		return person;
	}

	@Override
	public AadharCard findPersonRecordByAadharId(String aadharId) {
		AadharCard aadharCard=entityManager.find(AadharCard.class, aadharId);
		return aadharCard;
	}
	

	@Override
	public List<Person> findPersonRecordByName(String personName) {
		String jpql="select p from Person p where personName LIKE ?1";
		
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1, "%"+personName+"%");
		
		List<Person> res=query.getResultList();
		return res;
	}

	@Override
	public List<Person> findPersonRecordByState(String state) {
		String jpql="select p from Person p where personState=?1";
		
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1, state);
		
		List<Person> res=query.getResultList();
		return res;
	}

	@Override
	public List<Person> findAllPersonRecord() {
		String jpql="select p from Person p";
		Query query=entityManager.createQuery(jpql);
		List<Person> li=query.getResultList();
		return li;
	}

}
