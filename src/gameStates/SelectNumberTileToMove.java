package gameStates;

import business.Model;
import gameStatesDefault.GameState;
import models.BoardPosition;
import utils.ArrayList;

public class SelectNumberTileToMove extends GameState {

	@Override
	public void execute() {

		ArrayList<BoardPosition> list = Model.INSTANCE.getBoardPositions();

	}

}
