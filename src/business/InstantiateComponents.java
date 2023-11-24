package business;

import enums.EColor;
import models.NumberTile;

public enum InstantiateComponents {

	INSTANCE;

	private InstantiateComponents() {

		numberTiles();

	}

	private void numberTiles() {

		for (EColor eColor : EColor.values())
			for (int counter = 1; counter <= 15; counter++)
				ListsManager.INSTANCE.listNumberTiles.addLast(new NumberTile(eColor, counter));

		ListsManager.INSTANCE.listNumberTiles.saveOriginal();

	}

}
