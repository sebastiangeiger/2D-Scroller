
public class GameObject {

	float x;
	float y;
	
	public float getVx() {
		return vx;
	}

	public void setVx(float vx) {
		this.vx = vx;
	}

	public float getVy() {
		return vy;
	}

	public void setVy(float vy) {
		this.vy = vy;
	}

	float vx;
	float vy;
	
	float r;
	
	String img;
	
		
	public GameObject (String img, float x, float y, float r) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.r = r;
		
		this.vx = 0;
		this.vy = 0;
	}
	
	public float getR() {
		return r;
	}

	public void setR(float r) {
		this.r = r;
	}

	
	
	public Point getTargetPoint() {
		return new Point(x + vx, y + vy);
	}
	
	
	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public float getX() {
		return x;
	}


	public void setX(float x) {
		this.x = x;
	}


	public float getY() {
		return y;
	}


	public void setY(float y) {
		this.y = y;
	}

	
	public void setPosition(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	
	public Point getPosition() {
		return new Point(this.x, this.y);
	}
	
}
