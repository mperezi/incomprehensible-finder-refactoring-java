package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public AgeDifference find(FindCriteria findCriteria) {
		List<AgeDifference> differences = new ArrayList<AgeDifference>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				AgeDifference ageDiff = new AgeDifference();
				if (people.get(i).birthDate.getTime() < people.get(j).birthDate.getTime()) {
					ageDiff.oldestPerson = people.get(i);
					ageDiff.youngestPerson = people.get(j);
				} else {
					ageDiff.oldestPerson = people.get(j);
					ageDiff.youngestPerson = people.get(i);
				}
				ageDiff.timeDiffInMillis = ageDiff.youngestPerson.birthDate.getTime() - ageDiff.oldestPerson.birthDate.getTime();
				differences.add(ageDiff);
			}
		}

		if (differences.size() < 1) {
			return new AgeDifference();
		}

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
