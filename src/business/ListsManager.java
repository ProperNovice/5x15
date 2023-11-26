package business;

import models.BoardPosition;
import models.NumberTile;
import utils.ArrayList;
import utils.HashMap;
import utils.Interfaces.IImageViewAble;
import utils.ListImageViewAbles;
import utils.Vector2;

public enum ListsManager {

	INSTANCE;

	public final ArrayList<ListImageViewAbles<IImageViewAble>> lists = new ArrayList<ListImageViewAbles<IImageViewAble>>();
	public HashMap<Integer, ArrayList<BoardPosition>> boardPositions = new HashMap<>();
	public ArrayList<NumberTile> listNumberTiles = new ArrayList<>();

	public void instantiate() {

		Vector2 vector2 = Credentials.INSTANCE.cRowFirst.clone();

		// positions

		for (int row = 0; row < 5; row++) {

			ArrayList<BoardPosition> boardPosition = new ArrayList<>();

			for (int position = 0; position < 16; position++) {

				double x = vector2.x;
				x += position * (Credentials.INSTANCE.dNumberTile.x);
				x += position * (Credentials.INSTANCE.dGapBetweenComponents.x);

				boardPosition.addLast(new BoardPosition(new Vector2(x, vector2.y)));

			}

			this.boardPositions.put(row, boardPosition);

			vector2.y += Credentials.INSTANCE.dNumberTile.y;
			vector2.y += Credentials.INSTANCE.dGapBetweenComponents.y;

		}

	}

	public void saveListsOriginal() {

		for (ListImageViewAbles<IImageViewAble> list : this.lists)
			list.getArrayList().saveOriginal();

	}

	public void loadListsOriginal() {

		for (ListImageViewAbles<IImageViewAble> list : this.lists)
			list.getArrayList().clear();

		for (ListImageViewAbles<IImageViewAble> list : this.lists)
			list.getArrayList().loadOriginal();

	}

}
