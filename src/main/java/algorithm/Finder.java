package algorithm;

import java.util.*;

public class Finder {
	private final List<Person> people;
	private List<AgeDifference> ageDifferences;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Optional<AgeDifference> find(SearchCriteria searchCriteria) {
		if (people.size() < 2) {
			return Optional.empty();
		}

		calculateAgeDifferences();
		return findByCriteria(searchCriteria);
	}

	private void calculateAgeDifferences() {
		ageDifferences = new ArrayList<>();
		int numberOfPeople = people.size();

		for (int i = 0; i < numberOfPeople - 1; i++) {
			for (int j = i + 1; j < numberOfPeople; j++) {
				AgeDifference ageDifference = calculateAgeDifference(people.get(i), people.get(j));
				ageDifferences.add(ageDifference);
			}
		}
	}

	private AgeDifference calculateAgeDifference(Person firstPerson, Person secondPerson) {
		return new AgeDifference(oldestPerson(firstPerson, secondPerson),
		                         youngestPerson(firstPerson, secondPerson));
	}

	private Person oldestPerson(Person firstPerson, Person secondPerson) {
		return firstPerson.isOlderThan(secondPerson) ? firstPerson : secondPerson;
	}

	private Person youngestPerson(Person firstPerson, Person secondPerson) {
		return firstPerson.isOlderThan(secondPerson) ? secondPerson : firstPerson;
	}

	private Optional<AgeDifference> findByCriteria(SearchCriteria searchCriteria) {
		Collections.sort(ageDifferences);
		switch (searchCriteria) {
			case ClosestTwoPeople:
				return Optional.of(ageDifferences.get(0));
			case FurthestTwoPeople:
				return Optional.of(ageDifferences.get(ageDifferences.size() - 1));
		}
		return Optional.empty();
	}
}
