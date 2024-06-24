import java.util.Vector;
public class GameFrame extends MyFrame {
	public void run() {
		GameWorld.player=new Player(100,300,1,0);
		addKeyListener(GameWorld.player);
		GameWorld.playerBullets=new Vector<PlayerBullet>();
		GameWorld.enemies=new Vector<Enemy>();
		GameWorld.enemies.add(new EnemyBase(100,50,1,0));
		while(true) {
			clear();
			GameWorld.player.draw(this);
			GameWorld.player.move();
			movePlayerBullets();
			moveEnemies();
			for (int i=0 ; i<GameWorld.enemies.size();i++) {
				Enemy e=GameWorld.enemies.get(i);
				if (Math.abs(e.x-GameWorld.player.x)<=30 &&
					Math.abs(e.y-GameWorld.player.y)<=30) {
						System.out.println("やられた!");
				}
			}
			
			
     		sleep(0.03);
		}
	} 
public void movePlayerBullets() {
	int i=0;
	while (i<GameWorld.playerBullets.size()) {
		PlayerBullet b=GameWorld.playerBullets.remove(i);
		b.draw(this);
		b.move();
		if (b.y<0) {
			GameWorld.playerBullets.remove(i);
		} else {
			i++;
		}
	}
}
public void moveEnemies() {
	for(int i=0 ; i<GameWorld.enemies.size(); i++) {
		Enemy e=GameWorld.enemies.get(i);
		e.draw(this);
		e.move();
	}
}
}