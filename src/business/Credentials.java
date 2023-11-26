package business;

import utils.Enums.RearrangeTypeEnum;
import utils.Vector2;

public enum Credentials {

	INSTANCE;

	public String primaryStageTitle = "5x15", numbersImageViewColor = "black";
	public boolean colliderVisibility = true;
	public double stagePixesOnTheLeft = 180, gapBetweenBorders = 25, textHeight = 50,
			selectEventHandlerAbleDimension = 100, animationStep = 4, cameraViewSpots = 1;
	public Vector2 dFrame, dGapBetweenComponents, dCameraView, dGapBetweenComponentsLineCast;
	public Vector2 cTextPanel, cImageViewClone;
	public RearrangeTypeEnum rearrangeTypeEnumText = RearrangeTypeEnum.LINEAR;

	public Vector2 dNumberTile;
	public Vector2 cRowFirst;

	private Credentials() {

		double x = 0, y = 0;

		// frame

		this.dFrame = new Vector2(2560 - 4 - 636, 1368);

		// gaps

		this.dGapBetweenComponents = new Vector2(4, 4);
		this.dGapBetweenComponentsLineCast = this.dGapBetweenComponents;

		// camera view

		this.dCameraView = new Vector2(1, 1);

		// c text panel

		x = 0;
		y = 0;

		this.cTextPanel = new Vector2(x, y);

		// c image view indicator

		x = this.gapBetweenBorders;
		y = this.gapBetweenBorders;
		this.cImageViewClone = new Vector2(x, y);

		// d number tile

		x = this.dFrame.x;
		x -= 2 * this.gapBetweenBorders;
		x -= 15 * this.dGapBetweenComponents.x;
		x /= 16;
		this.dNumberTile = new Vector2(x, x);

		// d frame

		y = 2 * this.gapBetweenBorders;
		y += 5 * this.dNumberTile.y;
		y += 4 * this.dGapBetweenComponents.y;
		this.dFrame.y = y;

		// c row first

		x = this.gapBetweenBorders;
		x += this.dNumberTile.x / 2;
		y = this.gapBetweenBorders;
		y += this.dNumberTile.y / 2;
		this.cRowFirst = new Vector2(x, y);

	}

}
