package models;

import business.Credentials;
import utils.Flow;
import utils.Interfaces.ISelectCoordinatesAble;
import utils.Vector2;

public class BoardPosition implements ISelectCoordinatesAble {

	private Vector2 vector2 = null;
	private NumberTile numberTile = null;

	public BoardPosition(Vector2 vector2) {
		this.vector2 = vector2;
	}

	public void setNumberTileRelocate(NumberTile numberTile) {

		this.numberTile = numberTile;
		this.numberTile.getImageView().relocateCenter(this.vector2);

	}

	public NumberTile getNumberTile() {
		return this.numberTile;
	}

	public NumberTile removeNumberTile() {

		NumberTile numberTile = this.numberTile;
		this.numberTile = null;

		return numberTile;

	}

	@Override
	public Vector2 getCoordinatesCenter() {
		return this.vector2;
	}

	@Override
	public void handleMousePressedPrimary() {
		Flow.INSTANCE.getGameStateCurrent().handlePositionPressed(this);
	}

	@Override
	public double getSelectDimension() {
		return Credentials.INSTANCE.dNumberTile.x / 2;
	}

}
