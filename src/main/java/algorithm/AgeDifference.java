package algorithm;

import java.time.Duration;

public final class AgeDifference implements Comparable<AgeDifference> {
	private final Person oldestPerson;
	private final Person youngestPerson;
	private final Duration ageDifference;

	public AgeDifference(Person oldestPerson, Person youngestPerson) {
		this.oldestPerson = oldestPerson;
		this.youngestPerson = youngestPerson;
		ageDifference = oldestPerson.ageDifferenceWith(youngestPerson);
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
