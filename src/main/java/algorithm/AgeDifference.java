package algorithm;

public final class AgeDifference {
	private final Person oldestPerson;
	private final Person youngestPerson;
	private final long timeDiffInMillis;

	public static final AgeDifference EMPTY_RESULT = new AgeDifference(null, null, 0L);

	public AgeDifference(Person oldestPerson, Person youngestPerson, long timeDiffInMillis) {
		this.oldestPerson = oldestPerson;
		this.youngestPerson = youngestPerson;
		this.timeDiffInMillis = timeDiffInMillis;
	}

	public Person getOldestPerson() {
		return oldestPerson;
	}

	public Person getYoungestPerson() {
		return youngestPerson;
	}

	public long getTimeDiffInMillis() {
		return timeDiffInMillis;
	}
}
