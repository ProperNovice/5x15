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

		ArrayList<BoardPosition> listBoardPositionsFirst = new ArrayList<>();
		ArrayList<BoardPosition> listBoardPositionsNonFirst = new ArrayList<>();

		for (int counter = 0; counter < 5; counter++) {

			ArrayList<BoardPosition> boardPositionTemp = getListsManager().boardPositions
					.getValue(counter).clone();

			listBoardPositionsFirst.addLast(boardPositionTemp.removeFirst());
			listBoardPositionsNonFirst.addAllLast(boardPositionTemp);

		}

		while (!getListsManager().listNumberTiles.isEmpty()) {

			ArrayList<BoardPosition> list = null;

			NumberTile numberTile = getListsManager().listNumberTiles.removeRandom();

			if (numberTile.getNumber() == 1)
				list = listBoardPositionsFirst;
			else
				list = listBoardPositionsNonFirst;

			list.removeRandom().setNumberTileRelocate(numberTile);

		}

		// replace aces

	}

	protected ArrayList<Class<? extends GameState>> getFlow() {
		return Flow.INSTANCE.getFlow();
	}

	protected ListsManager getListsManager() {
		return ListsManager.INSTANCE;
	}

}
