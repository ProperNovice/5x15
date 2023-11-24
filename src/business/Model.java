package business;

import gameStatesDefault.GameState;
import utils.ArrayList;
import utils.Flow;

public enum Model {

	INSTANCE;

	protected ArrayList<Class<? extends GameState>> getFlow() {
		return Flow.INSTANCE.getFlow();
	}

	protected ListsManager getListsManager() {
		return ListsManager.INSTANCE;
	}

}
