package edu.westga.dsdm.prioritysimulation;

public class Simulation {
	private DoctorsOffice office;
	private WaitingRoom room;
	private PersonFactory factory;
	private int desiredIterations;
	private int walkinLimit;

	/**
	 * Builds the simulation
	 * 
	 * @precondition desiredIterations > 0 and walkinLimit > 0
	 * 
	 * @param desiredIterations the desired number of people who the doctor wishes to see
	 * @param walkinLimit the limit of people who can get into the waiting room
	 */
	public Simulation(int desiredIterations, int walkinLimit) {
		if (desiredIterations < 1) {
			throw new IllegalArgumentException("desired iterations must be postitive.");
		}
		
		if (walkinLimit < 1) {
			throw new IllegalArgumentException("Walkin Limit must be postitive.");
		}
		
		this.walkinLimit = walkinLimit;
		this.desiredIterations = desiredIterations;

		this.factory = new PersonFactory(
				"./src/edu/westga/dsdm/prioritysimulation/resource/digitsOfPi.txt");
		this.room = new WaitingRoom(this.factory, walkinLimit);
		this.office = new DoctorsOffice(room);
	}

	/**
	 * Conducts 1 full simulation of the factory to waiting room to doctor's office pipeline
	 */
	public void begin() {
		
		System.out.println("Every half-second, "+this.walkinLimit+" will walk in the door.");
		
        for (int i = 0; i < this.desiredIterations; i++) {
        	int patientScore = this.office.requestNextPatient();
        	System.out.println("The doctor will see you now, patient with priority "+patientScore+".");
        	this.sleep(500);
        }
        
        System.out.println("Final Score: "+this.getScore());
	}

	/**
	 * Returns this doctor's score at the end of the simulation
	 * 
	 * @return the doctor's score
	 */
	public int getScore() {
		return this.office.getScore();
	}

	private void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (Exception e) {
		}
	}
}
