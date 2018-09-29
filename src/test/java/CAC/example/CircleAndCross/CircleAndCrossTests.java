package CAC.example.CircleAndCross;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertThat;

public class CircleAndCrossTests {
	private Game game;

	@Before
	public void setGame (){
		game = new Game();
	}

	@Test
	public void gameExist() {
			assertNotNull(game);
		}

	@Test(expected = RuntimeException.class)
	public void whenMoveOuterBoundThenException() {
		game.placeMark(5,-1);
		game.placeMark(-2,4);
	}

	@Test(expected = RuntimeException.class)
	public void whenFildIsOccupiedThenException() {
		game.placeMark(2,2);
		game.placeMark(2,2);
	}

	@Test
	public void whenIsNewGameNextPlayerIsX() {
		Character player = game.getNextPlayer();
		assertThat('X' , is(equalTo(player)));
	}
	@Test
	public void secondMoveIsForPlayerO() {
		game.placeMark(1,1);
		Character player = game.getNextPlayer();
		assertThat('O' , is(equalTo(player)));
	}
	@Test
	public void secondMoveIsForPlayerOAndMarkIsO() {
		game.placeMark(1,1);
		game.placeMark(2,2);
		Character xSign = game.getMarkSightAt(1,1);
		Character oSign = game.getMarkSightAt(2,2);

		assertThat('X',is(equalTo(xSign)));
		assertThat('O',is(equalTo(oSign)));
	}

	@Test
	public void threeSignInRowAtRowWin() {
		game.getMarkSightAt(1,2);//X
		game.getMarkSightAt(1,1);//O
		game.getMarkSightAt(2,2);//X
		game.getMarkSightAt(3,1);//O
		game.getMarkSightAt(3,2);//X

		String Winner = game.getWinner();
		assertThat(Winner, is(equalTo("The winner is X")));

	}
}

