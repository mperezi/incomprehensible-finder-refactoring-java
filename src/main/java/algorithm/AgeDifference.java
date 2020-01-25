package algorithm;

import java.time.Duration;

public final class AgeDifference implements Comparable<AgeDifference> {
	private final Person oldestPerson;
	private final Person youngestPerson;
	private final Duration ageDifference;

	public AgeDifference(Person firstPerson, Person secondPerson) {
		oldestPerson = Person.oldest(firstPerson, secondPerson);
		youngestPerson = Person.youngest(firstPerson, secondPerson);
		ageDifference = firstPerson.ageDifferenceWith(secondPerson);
	}

	public Person getOldestPerson() {
		return oldestPerson;
	}

	public Person getYoungestPerson() {
		return youngestPerson;
	}

	@Override
	public int compareTo(AgeDifference other) {
		return ageDifference.compareTo(other.ageDifference);
	}
}
