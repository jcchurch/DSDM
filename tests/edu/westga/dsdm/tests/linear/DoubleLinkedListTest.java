package edu.westga.dsdm.tests.linear;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.westga.dsdm.linear.DoubleLinkedList;

public class DoubleLinkedListTest {

	private DoubleLinkedList<Integer> oneElementList;
	private DoubleLinkedList<Integer> fiveElementList;

	@Before
	public void setUp() throws Exception {
		this.oneElementList = new DoubleLinkedList<Integer>();
		this.oneElementList.add(4);

	    this.fiveElementList = new DoubleLinkedList<Integer>();
	    this.fiveElementList.add(10);
	    this.fiveElementList.add(20);
	    this.fiveElementList.add(30);
	    this.fiveElementList.add(40);
	    this.fiveElementList.add(50);
	}

	@Test
	public void SizeOfOneElementListShouldBe1() {
		assertEquals(1, this.oneElementList.size());
	}

	@Test
	public void SizeOfFiveElementListShouldBe5() {
		assertEquals(5, this.fiveElementList.size());
	}
	
	@Test
	public void OnlyElementOfOneElementListShouldBe4() {
		assertEquals(4, (int) this.oneElementList.get(0));
	}
	
	@Test
	public void FirstElementOfFiveElementListShouldBe10() {
		assertEquals(10, (int) this.fiveElementList.get(0));
	}
	
	@Test
	public void ThirdElementOfFiveElementListShouldBe30() {
		assertEquals(30, (int) this.fiveElementList.get(2));
	}

	@Test
	public void LastElementOfFiveElementListShouldBe50() {
		assertEquals(50, (int) this.fiveElementList.get(4));
	}
	
	@Test
	public void AfterAddingElementToOneElementListSizeShouldBe2() {
		this.oneElementList.add(5);
		assertEquals(2, this.oneElementList.size());
	}
	
	@Test
	public void AfterInserting25Between20And30SizeShouldBe6() {
		this.fiveElementList.insert(2, 25);
		assertEquals(6, this.fiveElementList.size());
	}

	@Test
	public void AfterInserting25Between20And30SecondIndexShouldBe25() {
		this.fiveElementList.insert(2, 25);
		assertEquals(25, (int) this.fiveElementList.get(2));
	}

	@Test
	public void RemovingOnlyElementFromOneElementListShouldBeSizeZero() {
		this.oneElementList.remove(0);
		assertEquals(0, this.oneElementList.size());
	}
	
	@Test
	public void RemovingThirdElementFromFiveElementListShouldBeSizeFour() {
		this.fiveElementList.remove(2);
		assertEquals(4, this.fiveElementList.size());
	}
	
	@Test
	public void RemovingThirdElementFromFiveElementListAndGetThirdElementShouldBe40() {
		this.fiveElementList.remove(2);
		assertEquals(40, (int) this.fiveElementList.get(2));
	}

}
