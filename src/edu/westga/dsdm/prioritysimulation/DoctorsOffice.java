package edu.westga.dsdm.prioritysimulation;

public class DoctorsOffice {
	private WaitingRoom room;
	private int score;

	/**
	 * Create a doctor's office, which needs a waiting room.
	 * 
	 * @param room a WaitingRoom
	 */
	public DoctorsOffice(WaitingRoom room) {
		if (room == null) {
			throw new IllegalArgumentException("room cannot be null.");
		}

		this.room = room;
		this.score = 0;
	}

	/**
	 * Returns the person with the top priority from the waiting room
	 * 
	 * @return the Person with the top priority in the waiting room
	 */
	public int requestNextPatient() {
		Person aPerson = room.getNextPerson();

		this.score += aPerson.getPriority();
		
		return aPerson.getPriority();
	}

	/**
	 * The doctor's office score
	 * 
	 * @return the score for this doctor's office
	 */
	public int getScore() {
		return this.score;
	}
}
