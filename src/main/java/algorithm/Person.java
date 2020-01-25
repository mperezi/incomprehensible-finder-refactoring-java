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

	public static Person oldest(Person firstPerson, Person secondPerson) {
		return firstPerson.isOlderThan(secondPerson) ? firstPerson : secondPerson;
	}

	public static Person youngest(Person firstPerson, Person secondPerson) {
		return firstPerson.isOlderThan(secondPerson) ? secondPerson : firstPerson;
	}

	private boolean isOlderThan(Person other) {
		return birthDate.isBefore(other.birthDate);
	}

	public Duration ageDifferenceWith(Person other) {
		return Duration.between(birthDate.atStartOfDay(), other.birthDate.atStartOfDay()).abs();
	}
}

