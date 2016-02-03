

public class Coin extends Item{

	private Assets asset;
	private Animation animate;
	private GameEngine.AudioClip pickup;
	
	public Coin(GameEngine engine, float x, float y) {
		super(x, y, DEFAULT_ITEM_WIDTH, DEFAULT_ITEM_HEIGHT);
		
		asset = new Assets(engine);
		animate = new Animation(2, asset.getCoin(), engine);
		pickup = engine.loadAudio("res/coin.wav");
	}
	
	//------
	
	public void update(MainGame engine, Player player, double dt) {
		animate.update(engine);
		if((x <= player.x + DEFAULT_ITEM_WIDTH && x >= player.x - DEFAULT_ITEM_WIDTH) 
				&& (y <= player.y + DEFAULT_ITEM_HEIGHT && y >= player.y - DEFAULT_ITEM_HEIGHT)) {
			setExists(false);
			
			engine.playAudio(pickup);
			HUD.coins++;
			
			//coin get picked up
		}
	}
	
	public void draw(GameEngine engine) {
		engine.saveCurrentTransform();
		engine.translate(x, y);
		engine.drawImage(animate.getLoopFrame(), 0, 0, width, height);
		engine.restoreLastTransform();
	}

}