import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import processing.core.PApplet;
import processing.core.PImage;



public class GameRenderer {
	
	PApplet p;
	
	float scale = 0.2f;
	
	float pad = 0.25f;
	
	float cameraOffset = 0; 
	
	public GameRenderer(PApplet p, int screenWidth, int screenHeight, GameMap map) {
		super();
		this.p = p;
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.map = map;
		
		background = p.loadImage("bg.png");
		
		List<String> images = new ArrayList<String>();
		images.add("p1r");
		images.add("p1l");
		images.add("p2r");
		images.add("p2l");
		images.add("p3r");
		images.add("p3l");
		for (String s : images) {
			imgs.put(s, p.loadImage(s + ".png"));
		}
		
	}

	int screenWidth;
	int screenHeight;
	
	GameMap map;
	
	PImage background;
	Map<String, PImage> imgs = new HashMap<String, PImage>();
	
	public void render(List<GameObject> gameObjects) {
		Point p = new Point(0, 0);
		for (GameObject obj : gameObjects) { 
			if (obj instanceof Player) {
				p = obj.getPosition();
			}
		}
		render(gameObjects, p);
	}
	
	public void render(List<GameObject> gameObjects, Point center) {
		p.image(background, 0, 0);

        Collections.sort(gameObjects, new Comparator<GameObject>(){
            public int compare(GameObject p1, GameObject p2) {
               return (p1.getY() < p2.getY() ? -1 : p1.getY() == p2.getY() ? 0 : 1);
            }
         });
		
		for (GameObject obj : gameObjects) { 
			Point pt = transform(new Point( obj.getX(), obj.getY()), center.x);
			p.image(imgs.get(obj.getImg()), pt.x - obj.getR(), pt.y - 180, obj.getR() * 2, 180);
			
		}
		
		p.stroke(153);
		p.rect(0, 0, map.getWidth() * scale, map.getHeight() * scale);
		for (GameObject obj : gameObjects) { 
			p.ellipse(obj.getX() * scale, obj.getY() * scale, 2 * obj.getR() * scale, 2 * obj.getR() * scale);
			
		}
	}
	
	public Point transform(Point p, float playerx) {
		
		if ((playerx - cameraOffset) > (1.0f - pad) * screenWidth) {
			cameraOffset = playerx - (1.0f - pad) * screenWidth;
			cameraOffset = Math.min(map.getWidth() - screenWidth, cameraOffset);
		} else if ((playerx - cameraOffset) < pad * screenWidth) {
			cameraOffset = playerx - pad * screenWidth;
			cameraOffset = Math.max(0, cameraOffset);
		} else {
			
		}
		
		float ny = (0.6f * screenHeight + 0.4f * screenHeight * p.y/(map.getHeight()));
		float nx = p.x - (cameraOffset);	
		
		return new Point (nx, ny);
	}
	
	
	
}
