package gameStates;

import business.Model;
import gameStatesDefault.GameState;

public class JUnit extends GameState {

	@Override
	public void execute() {

		Model.INSTANCE.setUpBoard();

		getFlow().addFirst(SelectNumberTileToMove.class);
		proceedToNextGameState();

	}

}
