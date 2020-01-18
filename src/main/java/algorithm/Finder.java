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
			return new AgeDifference();
		}

		List<AgeDifference> ageDifferences = calculateAgeDifferences();
		return findByCriteria(findCriteria, ageDifferences);
	}

	private List<AgeDifference> calculateAgeDifferences() {
		List<AgeDifference> differences = new ArrayList<AgeDifference>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				AgeDifference ageDifference = calculateAgeDifference(people.get(i), people.get(j));
				differences.add(ageDifference);
			}
		}

		return differences;
	}

	private AgeDifference calculateAgeDifference(Person firstPerson, Person secondPerson) {
		AgeDifference ageDiff = new AgeDifference();
		if (firstPerson.isOlderThan(secondPerson)) {
			ageDiff.oldestPerson = firstPerson;
			ageDiff.youngestPerson = secondPerson;
		} else {
			ageDiff.oldestPerson = secondPerson;
			ageDiff.youngestPerson = firstPerson;
		}
		ageDiff.timeDiffInMillis = firstPerson.ageDiffInMillis(secondPerson);
		return ageDiff;
	}

	private AgeDifference findByCriteria(FindCriteria findCriteria, List<AgeDifference> differences) {
		AgeDifference answer = differences.get(0);
		for (AgeDifference result : differences) {
			switch (findCriteria) {
				case ClosestTwoPeople:
					if (result.timeDiffInMillis < answer.timeDiffInMillis) {
						answer = result;
					}
					break;

				case FurthestTwoPeople:
					if (result.timeDiffInMillis > answer.timeDiffInMillis) {
						answer = result;
					}
					break;
			}
		}
		return answer;
	}
}
