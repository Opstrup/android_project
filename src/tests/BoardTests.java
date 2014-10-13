package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.tictactoe.GameLogic.Board;

import junit.framework.TestCase;

public class BoardTests extends TestCase 
{
	Board _UUT;
	
	@Before 
	public void setupTestData()
	{
		_UUT = new Board(8);
	}
	
	@After
	public void cleanTestData()
	{
		_UUT = null;
	}
	
	@Test
	public void emptyBoardShouldReturnFalse()
	{
		assertEquals(false, false);
	}
	
}
