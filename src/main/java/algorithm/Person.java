package algorithm;

import java.util.Date;

public class Person {
	private final String name;
	private final Date birthDate;

	public Person(String name, Date birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public boolean isOlderThan(Person other) {
		return birthDate.getTime() < other.getBirthDate().getTime();
	}

	public long ageDiffInMillis(Person other) {
		return Math.abs(birthDate.getTime() - other.getBirthDate().getTime());
	}
}

