package algorithm;

public final class AgeDifference implements Comparable<AgeDifference> {
	private final Person oldestPerson;
	private final Person youngestPerson;
	private final long timeDiffInMillis;

	public static final AgeDifference EMPTY_RESULT = new AgeDifference();

	private AgeDifference() {
		oldestPerson = null;
		youngestPerson = null;
		timeDiffInMillis = 0L;
	}

	public AgeDifference(Person oldestPerson, Person youngestPerson) {
		this.oldestPerson = oldestPerson;
		this.youngestPerson = youngestPerson;
		timeDiffInMillis =  oldestPerson.ageDiffInMillis(youngestPerson);
	}

	public Person getOldestPerson() {
		return oldestPerson;
	}

	public Person getYoungestPerson() {
		return youngestPerson;
	}

	@Override
	public int compareTo(AgeDifference other) {
		return timeDiffInMillis - other.timeDiffInMillis < 0L ? -1 : 1;
	}
}
