package models;

import business.Credentials;
import enums.EColor;
import utils.Flow;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;
import utils.Logger;

public class NumberTile implements IImageViewAble {

	private EColor eColor = null;
	private int number;

	public NumberTile(EColor eColor, int number) {

		this.eColor = eColor;
		this.number = number;

		// create image view

		String filePath = "numberTiles/";
		filePath += this.eColor.toString().toLowerCase();
		filePath += "/";
		filePath += this.number;
		filePath += ".png";

		new ImageView(filePath, this);
		getImageView().setDimensions(Credentials.INSTANCE.dNumberTile);

	}

	@Override
	public void handleMousePressedPrimary() {

		Logger.INSTANCE.log("/*");
		Logger.INSTANCE.log(this.getClass().getSimpleName());
		Logger.INSTANCE.log(this.eColor + " - " + this.number);
		Logger.INSTANCE.log("*/");

		Flow.INSTANCE.getGameStateCurrent().handleNumberTilePressed(this);

	}

	public EColor getEColor() {
		return this.eColor;
	}

	public int getNumber() {
		return this.number;
	}

}
