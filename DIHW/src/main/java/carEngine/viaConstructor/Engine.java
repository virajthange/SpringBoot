package carEngine.viaConstructor;

public class Engine {
	int id;
	int speed;
	public Engine(int id, int speed) {
		super();
		this.id = id;
		this.speed = speed;
	}
	@Override
	public String toString() {
		return "Engine [id=" + id + ", speed=" + speed + "]";
	}
}
