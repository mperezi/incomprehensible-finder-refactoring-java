package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import algorithm.AgeDifference;
import algorithm.SearchCriteria;
import algorithm.Finder;
import algorithm.Person;

public class FinderTests {
	Person sue;
	Person greg;
	Person sarah;
	Person mike;


	@Before
	public void setup() {
		sue = new Person("Sue", new Date(50, 0, 1));
		greg = new Person("Greg", new Date(52, 5, 1));
		sarah = new Person("Sarah", new Date(82, 0, 1));
		mike = new Person("Mike", new Date(79, 0, 1));
	}

	@Test
	public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Person> list = new ArrayList<Person>();
		Finder finder = new Finder(list);

		AgeDifference result = finder.find(SearchCriteria.ClosestTwoPeople);
		assertEquals(AgeDifference.EMPTY_RESULT, result);
	}

	@Test
	public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);

		Finder finder = new Finder(list);

		AgeDifference result = finder.find(SearchCriteria.ClosestTwoPeople);

		assertEquals(AgeDifference.EMPTY_RESULT, result);
	}

	@Test
	public void Returns_Closest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(greg);
		Finder finder = new Finder(list);

		AgeDifference result = finder.find(SearchCriteria.ClosestTwoPeople);

		assertEquals(sue, result.getOldestPerson());
		assertEquals(greg, result.getYoungestPerson());
	}

	@Test
	public void Returns_Furthest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		AgeDifference result = finder.find(SearchCriteria.FurthestTwoPeople);

		assertEquals(greg, result.getOldestPerson());
		assertEquals(mike, result.getYoungestPerson());
	}

	@Test
	public void Returns_Furthest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);
		Finder finder = new Finder(list);

		AgeDifference result = finder.find(SearchCriteria.FurthestTwoPeople);

		assertEquals(sue, result.getOldestPerson());
		assertEquals(sarah, result.getYoungestPerson());
	}

	@Test
	public void Returns_Closest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		AgeDifference result = finder.find(SearchCriteria.ClosestTwoPeople);

		assertEquals(sue, result.getOldestPerson());
		assertEquals(greg, result.getYoungestPerson());
	}

}
