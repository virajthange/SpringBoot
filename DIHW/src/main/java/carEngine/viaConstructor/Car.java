package carEngine.viaConstructor;

public class Car {
	int id;
	String brand;
	String color;
	public Car(int id, String brand, String color) {
		this.id = id;
		this.brand = brand;
		this.color = color;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", color=" + color + "]";
	}
}
