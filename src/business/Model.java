package business;

import enums.EColor;
import enums.EFilter;
import gameStatesDefault.GameState;
import models.BoardPosition;
import models.NumberTile;
import utils.ArrayList;
import utils.Flow;

public enum Model {

	INSTANCE;

	public ArrayList<BoardPosition> filterBoardPositionsEmpty(EFilter eFilter,
			ArrayList<BoardPosition> list) {

		for (BoardPosition boardPosition : list.clone()) {

			if (boardPosition.getNumberTile() == null)
				if (eFilter.equals(EFilter.OUT))
					list.remove(boardPosition);

			if (boardPosition.getNumberTile() != null)
				if (eFilter.equals(EFilter.IN))
					list.remove(boardPosition);

		}

		return list;

	}

	public ArrayList<BoardPosition> getBoardPositions() {

		ArrayList<BoardPosition> list = new ArrayList<>();

		for (int row = 0; row < 5; row++) {

			ArrayList<BoardPosition> boardPositionRow = getListsManager().boardPositions
					.getValue(row);

			list.addAllLast(boardPositionRow);
			
			// remove correct tiles

			EColor eColorFirstNumberTile = boardPositionRow.getFirst().getNumberTile().getEColor();

			for (int position = 0; position < 16; position++) {

				BoardPosition boardPositionTemp = boardPositionRow.get(position);

				if (boardPositionTemp.getNumberTile() == null)
					break;

				NumberTile numberTileTemp = boardPositionTemp.getNumberTile();

				if (!numberTileTemp.getEColor().equals(eColorFirstNumberTile))
					break;

				if (numberTileTemp.getNumber() != position + 1)
					break;

				list.remove(boardPositionTemp);

			}

		}

		return list;

	}

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
