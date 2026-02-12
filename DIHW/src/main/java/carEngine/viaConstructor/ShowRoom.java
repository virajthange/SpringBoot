package carEngine.viaConstructor;

import java.util.List;
import java.util.Map;

public class ShowRoom {
	List<String> colorsAvailable;
	Car car;
	Engine engine;
	List<Object> objects;
	Map<Car, Engine> carSet;
	
	public ShowRoom(List<String> colorsAvailable, Car car, Engine engine, List<Object> objects,
			Map<Car, Engine> carSet) {
		this.colorsAvailable = colorsAvailable;
		this.car = car;
		this.engine = engine;
		this.objects = objects;
		this.carSet = carSet;
	}
	@Override
	public String toString() {
		return "ShowRoom [colorsAvailable=" + colorsAvailable + ", car=" + car + ", engine=" + engine + ", objects="
				+ objects + ", carSet=" + carSet + "]";
	}
	
	
	
}
