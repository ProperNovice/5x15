package business;

import gameStatesDefault.GameState;
import models.BoardPosition;
import models.NumberTile;
import utils.ArrayList;
import utils.Flow;

public enum Model {

	INSTANCE;

	public void setUpBoard() {

		getListsManager().listNumberTiles.loadOriginal();

		ArrayList<BoardPosition> listBoardPositions = new ArrayList<>();

		for (int counter = 0; counter < 5; counter++) {

			ArrayList<BoardPosition> boardPositionTemp = getListsManager().boardPositions
					.getValue(counter).clone();

			boardPositionTemp.removeFirst();
			listBoardPositions.addAllLast(boardPositionTemp);

		}

		while (!getListsManager().listNumberTiles.isEmpty()) {

			BoardPosition boardPosition = listBoardPositions.removeRandom();
			NumberTile numberTile = getListsManager().listNumberTiles.removeRandom();
			boardPosition.setNumberTileRelocate(numberTile);

		}

	}

	protected ArrayList<Class<? extends GameState>> getFlow() {
		return Flow.INSTANCE.getFlow();
	}

	protected ListsManager getListsManager() {
		return ListsManager.INSTANCE;
	}

}
