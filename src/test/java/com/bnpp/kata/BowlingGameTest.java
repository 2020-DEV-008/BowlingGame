package com.bnpp.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

	BowlingGame game;

	@Before
	public void init() {
		game = new BowlingGame();
	}

	@Test
	public void newBowlingGameInstanceShouldNotBeNull() {
		assertNotNull(game);
	}

	@Test
	public void gameScoreShouldBeZeroBeforeGameStarts() {
		int gameScore = game.calculateGameScore();

		assertEquals(0, gameScore);
	}

	@Test
	public void gameScoreShouldBe0WhenNoPinDownForSingleRoll() {
		game.roll(0);
		int gameScore = game.calculateGameScore();

		assertEquals(0, gameScore);
	}

	@Test
	public void gameScoreShouldBe5When5PinsDownForSingleRoll() {
		game.roll(5);
		int gameScore = game.calculateGameScore();

		assertEquals(5, gameScore);
	}

	@Test
	public void gameScoreShouldBe60When3PinsDown20Times() {
		rollMany(20, 3);
		int gameScore = game.calculateGameScore();

		assertEquals(60, gameScore);
	}

	@Test
	public void gameScoreShouldGetAddedWith2ImmediateNextRollsForStrike() {
		game.roll(10);
		rollMany(2, 2);
		int gameScore = game.calculateGameScore();

		assertEquals(18, gameScore);
	}

	@Test
	public void allStrikeRollsIncludeExtra2AtLastFrame() {
		rollMany(12, 10);
		int gameScore = game.calculateGameScore();

		assertEquals(300, gameScore);
	}

	@Test
	public void callCalculateGameScore2Times() {
		rollMany(10, 1);
		game.calculateGameScore();
		int gameScore = game.calculateGameScore();

		assertEquals(10, gameScore);
	}

	@Test
	public void gameScoreShouldGetAddedWith1ImmediateNextRollForSpare() {
		rollMany(2, 5);
		rollMany(2, 2);
		int gameScore = game.calculateGameScore();
		assertEquals(16, gameScore);
	}

	@Test
	public void allRollsAreSpare() {
		rollMany(21, 5);

		int gameScore = game.calculateGameScore();

		assertEquals(150, gameScore);
	}

	@Test
	public void callRollUsingArray() {
		game.callRollUsingArrayOfPins(2, 2, 2);
		int gameScore = game.calculateGameScore();

		assertEquals(6, gameScore);
	}

	@Test
	public void callMainMethodWithArugumentsShouldBeAbleToCalculateGameScore() {
		String[] inputPins = { "10", "2", "2" };

		PrintStream actualStream = System.out;
		ByteArrayOutputStream outContent = setTemporaryPrintStreamToTest();

		BowlingGame.main(inputPins);

		System.setOut(actualStream);

		assertEquals("Total Game Score for given input is: 18", outContent.toString());
	}

	private ByteArrayOutputStream setTemporaryPrintStreamToTest() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		PrintStream testStream = new PrintStream(outContent);
		System.setOut(testStream);
		return outContent;
	}

	private void rollMany(final int numberOfRolls, final int numberOfPinsKnocked) {
		for (int rollCount = 0; rollCount < numberOfRolls; rollCount++) {
			game.roll(numberOfPinsKnocked);
		}
	}
}
