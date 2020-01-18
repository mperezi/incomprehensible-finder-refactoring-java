package algorithm;

import java.time.Duration;
import java.time.LocalDate;

public class Person {
	private final String name;
	private final LocalDate birthDate;

	public Person(String name, LocalDate birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public boolean isOlderThan(Person other) {
		return birthDate.isBefore(other.birthDate);
	}

	public Duration ageDifferenceWith(Person other) {
		return Duration.between(birthDate.atStartOfDay(), other.birthDate.atStartOfDay());
	}
}

