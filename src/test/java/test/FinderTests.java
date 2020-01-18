package test;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

import algorithm.AgeDifference;
import algorithm.SearchCriteria;
import algorithm.Finder;
import algorithm.Person;

import static org.junit.Assert.*;

public class FinderTests {
	Person sue;
	Person greg;
	Person sarah;
	Person mike;

	@Before
	public void setup() {
		sue = new Person("Sue", LocalDate.of(1950, Month.JANUARY, 1));
		greg = new Person("Greg", LocalDate.of(1952, Month.JUNE, 1));
		sarah = new Person("Sarah", LocalDate.of(1982, Month.JANUARY, 1));
		mike = new Person("Mike", LocalDate.of(1979, Month.JANUARY, 1));
	}

	@Test
	public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Person> list = Collections.emptyList();
		Finder finder = new Finder(list);

		Optional<AgeDifference> result = finder.find(SearchCriteria.ClosestTwoPeople);
		assertFalse(result.isPresent());
	}

	@Test
	public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> list = Collections.singletonList(sue);

		Finder finder = new Finder(list);

		Optional<AgeDifference> result = finder.find(SearchCriteria.ClosestTwoPeople);

		assertFalse(result.isPresent());
	}

	@Test
	public void Returns_Closest_Two_For_Two_People() {
		List<Person> list = Arrays.asList(sue, greg);
		Finder finder = new Finder(list);

		Optional<AgeDifference> result = finder.find(SearchCriteria.ClosestTwoPeople);

		assertTrue(result.isPresent());
		assertEquals(sue, result.get().getOldestPerson());
		assertEquals(greg, result.get().getYoungestPerson());
	}

	@Test
	public void Returns_Furthest_Two_For_Two_People() {
		List<Person> list = Arrays.asList(mike, greg);

		Finder finder = new Finder(list);

		Optional<AgeDifference> result = finder.find(SearchCriteria.FurthestTwoPeople);

		assertTrue(result.isPresent());
		assertEquals(greg, result.get().getOldestPerson());
		assertEquals(mike, result.get().getYoungestPerson());
	}

	@Test
	public void Returns_Furthest_Two_For_Four_People() {
		List<Person> list = Arrays.asList(sue, sarah, mike, greg);
		Finder finder = new Finder(list);

		Optional<AgeDifference> result = finder.find(SearchCriteria.FurthestTwoPeople);

		assertTrue(result.isPresent());
		assertEquals(sue, result.get().getOldestPerson());
		assertEquals(sarah, result.get().getYoungestPerson());
	}

	@Test
	public void Returns_Closest_Two_For_Four_People() {
		List<Person> list = Arrays.asList(sue, sarah, mike, greg);

		Finder finder = new Finder(list);

		Optional<AgeDifference> result = finder.find(SearchCriteria.ClosestTwoPeople);

		assertTrue(result.isPresent());
		assertEquals(sue, result.get().getOldestPerson());
		assertEquals(greg, result.get().getYoungestPerson());
	}

}
