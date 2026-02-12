package carEngine.viaSetter;

import java.util.List;
import java.util.Map;

public class ShowRoom {
	List<String> colorsAvailable;
	Car car;
	Engine engine;
	List<Object> objects;
	Map<Car, Engine> carSet;
	
	public List<String> getColorsAvailable() {
		return colorsAvailable;
	}
	public void setColorsAvailable(List<String> colorsAvailable) {
		this.colorsAvailable = colorsAvailable;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public List<Object> getObjects() {
		return objects;
	}
	public void setObjects(List<Object> objects) {
		this.objects = objects;
	}
	public Map<Car, Engine> getCarSet() {
		return carSet;
	}
	public void setCarSet(Map<Car, Engine> carSet) {
		this.carSet = carSet;
	}
	@Override
	public String toString() {
		return "showRoom [colorsAvailable=" + colorsAvailable + ", car=" + car + ", engine=" + engine + ", objects="
				+ objects + ", carSet=" + carSet + "]";
	}
}
