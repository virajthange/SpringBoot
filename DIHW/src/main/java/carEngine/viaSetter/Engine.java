package carEngine.viaSetter;

public class Engine {
	int id;
	int speed;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	@Override
	public String toString() {
		return "Engine [id=" + id + ", speed=" + speed + "]";
	}
	

}
