package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public AgeDifference find(FindCriteria findCriteria) {
		if (people.size() < 2) {
			return AgeDifference.EMPTY_RESULT;
		}

		List<AgeDifference> ageDifferences = calculateAgeDifferences();
		return findByCriteria(findCriteria, ageDifferences);
	}

	private List<AgeDifference> calculateAgeDifferences() {
		List<AgeDifference> differences = new ArrayList<AgeDifference>();
		int numberOfPeople = people.size();

		for (int i = 0; i < numberOfPeople - 1; i++) {
			for (int j = i + 1; j < numberOfPeople; j++) {
				AgeDifference ageDifference = calculateAgeDifference(people.get(i), people.get(j));
				differences.add(ageDifference);
			}
		}

		return differences;
	}

	private AgeDifference calculateAgeDifference(Person firstPerson, Person secondPerson) {
		return new AgeDifference(oldestPerson(firstPerson, secondPerson),
		                         youngestPerson(firstPerson, secondPerson),
		                         firstPerson.ageDiffInMillis(secondPerson));
	}

	private Person oldestPerson(Person firstPerson, Person secondPerson) {
		return firstPerson.isOlderThan(secondPerson) ? firstPerson : secondPerson;
	}

	private Person youngestPerson(Person firstPerson, Person secondPerson) {
		return firstPerson.isOlderThan(secondPerson) ? secondPerson : firstPerson;
	}

	private AgeDifference findByCriteria(FindCriteria findCriteria, List<AgeDifference> differences) {
		AgeDifference answer = differences.get(0);
		for (AgeDifference result : differences) {
			switch (findCriteria) {
				case ClosestTwoPeople:
					if (result.getTimeDiffInMillis() < answer.getTimeDiffInMillis()) {
						answer = result;
					}
					break;

				case FurthestTwoPeople:
					if (result.getTimeDiffInMillis() > answer.getTimeDiffInMillis()) {
						answer = result;
					}
					break;
			}
		}
		return answer;
	}
}
