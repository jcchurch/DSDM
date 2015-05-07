package edu.westga.dsdm.prioritysimulation;

public class WaitingRoom {
	private PriorityQueueHeap<Person> aPriorityQueue;
	private PersonFactory factory;
	private final int WALK_INS;

	/**
	 * Builds a waiting room for people who wait to see a doctor.
	 * 
	 * @param factory the factory of people
	 * @param walkinLimit the limit of people who can get from the factory to the waiting room
	 */
	public WaitingRoom(PersonFactory factory, int walkinLimit) {
		if (factory == null) {
			throw new IllegalArgumentException("factory cannot be null");
		}

		if (walkinLimit <= 0) {
			throw new IllegalArgumentException(
					"Walkin Limit must be a positive value.");
		}

		this.WALK_INS = walkinLimit;
		this.aPriorityQueue = new PriorityQueueHeap<Person>();
		this.factory = factory;

		this.factory.buildPriorityStream();
	}

	/**
	 * Returns the person with the highest priority in the waiting room while
	 * this.WALK_INS also walk in the door.
	 * 
	 * @precondition this.factory.getRemainingPeople() > 0
	 * @postcondition the factory is changed to reflect that this.WALK_INS
	 *                people have left the factory and entered the waiting room.
	 *                Also, 1 person leaves the waiting room (which is returned).
	 * 
	 * @return the person with the highest priority in the waiting room
	 */
	public Person getNextPerson() {

		int letInTheDoor = this.WALK_INS;

		while (letInTheDoor > 0 && this.factory.getRemainingPersonCount() > 0) {
			this.aPriorityQueue.insert(this.factory.getNextPerson());
			letInTheDoor -= 1;
		}

		return this.aPriorityQueue.remove();
	}

}
