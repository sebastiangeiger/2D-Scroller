
public class LivingGameObject extends GameObject {
	float energy;
	
	public LivingGameObject (String img, float x, float y, float r, float energy) {
		super(img, x, y, r);
		this.energy = energy;
	}
	
}
