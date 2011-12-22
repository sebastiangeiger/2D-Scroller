import processing.core.*;

public class FightGame extends PApplet {

	int NUM = 10;
	int SCREEN_WIDTH = 800;
	int SCREEN_HEIGHT = 500;

	int PAD = 20;
	int NUM_ENEMIES = 3;
	int NUM_PLAYERS = 2;
	int MAX_VELOCITY = 5;
	
	Game myGame = new Game();
	GameRenderer renderer = new GameRenderer(this, SCREEN_WIDTH, SCREEN_HEIGHT, myGame.getMap());

	public void setup() {
		size(SCREEN_WIDTH, SCREEN_HEIGHT);

	}
	
	public void draw() {
		  background(255);
		  renderer.render(myGame.getAllGameObjects());
		  myGame.nextFrame();
	}
	



	public void keyPressed() {
		switch(key) {
		case('w'):
			myGame.p1Up(true);
		break;
		case('s'):
			myGame.p1Down(true);
		break;
		case('a'):
			myGame.p1Left(true);
		break;
		case('d'):
			myGame.p1Right(true);
		break;
		case('h'):

		break;
		}
	}

	public void keyReleased() {
		switch(key) {
		case('w'):
			myGame.p1Up(false);
		break;
		case('s'):
			myGame.p1Down(false);
		break;
		case('a'):
			myGame.p1Left(false);
		break;
		case('d'):
			myGame.p1Right(false);
		break;
		case('h'):

		break;
		}
	}


//interface Drawable {
// void draw(); 
// void nextFrame();
//}

//class Agent implements Drawable {
//	public int x;
//	public int y;
//	int vx=0;
//	int vy=0;
//	int ax=0;
//	int ay=0;
//
//	PImage imgl;
//	PImage imgr;
//
//	int energy=100;
//
//	public Agent(PImage imgl, PImage imgr, int x, int y) {
//		this.x = x;     
//		this.y = y;  
//		this.imgl = imgl;
//		this.imgr = imgr;
//	}
//	public void draw(){
//		Point p = new Point(x, y);
//		p = p.transform();
//		if (vx > 0)
//			image(imgr, p.x-50, p.y-180, 100, 180);
//		else   
//			image(imgl, p.x-50, p.y-180, 100, 180);
//
//		text(energy, p.x-50, p.y-180); 
//	} 
//	public void nextFrame(){
//		x = max(0,min(MAP_WIDTH,x+vx));
//		y = max(0,min(MAP_HEIGHT,y+vy));
//		int new_vx = vx+ax;
//		int vx_dir = 0;
//		if(new_vx!=0)
//			vx_dir = new_vx / abs(new_vx);
//		int new_vy = vy+ay;
//		int vy_dir = 0;
//		if(new_vy != 0) 
//			vy_dir = new_vy / abs(new_vy);
//		vx = vx_dir * min(MAX_VELOCITY, abs(new_vx));
//		vy = vy_dir * min(MAX_VELOCITY, abs(new_vy));
//	}
//	void accelerateX(int ax) {
//		this.vx = 10*ax;
//	}
//	void accelerateY(int ay) {
//		this.vy = 10*ay;
//	}
//
//}


}