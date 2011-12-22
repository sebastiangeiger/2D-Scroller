import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import processing.core.PApplet;
import processing.core.PImage;


public class Game {
	
	GameMap map;
	
	List<Player> players = new ArrayList<Player>();
	List<Enemy> enemies = new ArrayList<Enemy>();
	
	
	public Game() {
		
		map = new GameMap(2000, 250);
		
		players.add(new Player("p1r", 100, 100, 20, 100));
		//players.add(new Player("p2r", 100, 200, 20, 100));
		
		enemies.add(new Enemy("p3l", 500, 150, 20, 100));
		enemies.add(new Enemy("p3l", 550, 50, 20, 100));
		enemies.add(new Enemy("p3l", 500, 100, 20, 100));
		enemies.add(new Enemy("p3l", 1500, 100, 20, 100));
		enemies.add(new Enemy("p3l", 2000, 100, 20, 100));
	}
	
	
	public GameMap getMap() {
		return map;
	}
	

	public void nextFrame() {
		
		// collision
		for (GameObject obj : getAllGameObjects()) { 
			Point p = obj.getTargetPoint();
			if (!blocking(obj, p)) {
				obj.setPosition(p);
			}
		}
	}
	
	public List<GameObject> getAllGameObjects() {
		List<GameObject> objects = new ArrayList<GameObject>();
		for (GameObject obj : players) {
			objects.add(obj);
		}
		for (GameObject obj : enemies) {
			objects.add(obj);
		}
		return objects;
	}
	
	private boolean blocking(GameObject obj, Point p2) {
		if (p2.x < 0 || p2.x >= map.getWidth() || p2.y < 0 || p2.y >= map.getHeight()) {
			return true;
		}

		for (GameObject obj2 : getAllGameObjects()) { 
			if(obj != obj2) {
				// TODO: need to loop over whole trajectory
				if (obj2.getPosition().distance(p2) < (obj.getR() + obj2.getR())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void p1Up(boolean active) {
		GameObject obj = players.get(0);
		obj.setVy((active) ? -5 : 0);
	}

	public void p1Down(boolean active) {
		GameObject obj = players.get(0);
		obj.setVy((active) ? 5 : 0);
	}
	public void p1Left(boolean active) {
		GameObject obj = players.get(0);
		obj.setVx((active) ? -5 : 0);
	}
	public void p1Right(boolean active) {
		GameObject obj = players.get(0);
		obj.setVx((active) ? 5 : 0);
	}
	public void p1A(boolean active) {
		
	}

	
}
