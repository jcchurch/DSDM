package edu.westga.dsdm.prioritysimulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PersonFactory {
	private int priorityIndex;
	private String priorityStream;
	private String fileName;
	private final int DESIRED_STREAM_LENGTH;
	private int reminingPersonCount;

	/**
	 * Builds a factory for producing people based on a priority stream
	 * 
	 * @precondition filename is not null
	 * @postcondition the factory is created with this.DESIRED_STREAM_LENGTH people.
	 * 
	 * @param fileName the filename of numbers
	 */
	public PersonFactory(String fileName) {
		if (fileName == null) {
			throw new IllegalArgumentException("fileName cannot be null");
		}

		this.DESIRED_STREAM_LENGTH = 1000;

		this.fileName = fileName;
		this.priorityIndex = 0;
		this.priorityStream = null;
		this.reminingPersonCount = DESIRED_STREAM_LENGTH;
	}

	/**
	 * Builds the priority stream from the file.
	 */
	public void buildPriorityStream() {
		if (this.priorityStream != null) {
			throw new IllegalStateException("Priority Stream is already built.");
		}

		Scanner scan = null;

		try {
			scan = new Scanner(new File(this.fileName));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(
					"fileName cannot be found to build the priority stream.");
		}

		if (!scan.hasNextLine()) {
			scan.close();
			throw new IllegalStateException("File contains no data.");
		}

		String line = scan.nextLine();
		if (line.length() < this.DESIRED_STREAM_LENGTH) {
			scan.close();
			throw new IllegalStateException("File is too short. Character count: "+line.length());
		}
		
		this.priorityStream = line.substring(0, this.DESIRED_STREAM_LENGTH);
		scan.close();
	}

	/**
	 * Returns the remaining number of people in the stream.
	 * 
	 * @return the remaining people in the stream
	 */
	public int getRemainingPersonCount() {
		return this.reminingPersonCount;
	}

	/**
	 * Returns the next person in the stream.
	 * 
	 * @precondition the stream is not empty (this.getRemainingPersonCount() > 0)
	 * @postcondition the person is returned and the number of remaining people decrease by 1
	 * 
	 * @return the next person in the stream
	 */
	public Person getNextPerson() {

		if (this.priorityIndex >= this.DESIRED_STREAM_LENGTH) {
			throw new IllegalStateException(
					"Cannot return any new people. Stream exhausted.");
		}

		this.priorityIndex += 1;
		this.reminingPersonCount -= 1;

		char ch = this.priorityStream.charAt(priorityIndex - 1);
		int priority = Integer.parseInt("" + ch);
		return new Person(priority);
	}
}
