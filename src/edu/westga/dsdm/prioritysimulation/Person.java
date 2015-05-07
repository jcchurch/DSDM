package edu.westga.dsdm.prioritysimulation;

public class Person implements Comparable<Person> {
	private int priority;

	/**
	 * Builds a person with a given priority.
	 * 
	 * @precondition priority >= 0 and priority <= 9
	 * @postcondition the Person is created
	 * 
	 * @param priority a priority score for this person (9: max, 0:min)
	 */
	public Person(int priority) {
		if (priority < 0 || priority > 9) {
			throw new IllegalArgumentException("Priority must be from 0 to 9");
		}

		this.priority = priority;
	}

	/**
	 * The person's priority score.
	 * 
	 * @return this Person's priority
	 */
	public int getPriority() {
		return this.priority;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Person b) {
		if (b == null) {
			throw new IllegalArgumentException(
					"Person cannot be null in compareTo.");
		}

		return this.getPriority() - b.getPriority();
	}
}
