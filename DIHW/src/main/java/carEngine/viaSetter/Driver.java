package carEngine.viaSetter;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("carEngConfig.xml");
		
		Car car = (Car) context.getBean("carBean");
		System.out.println(car);

		Engine engine = (Engine) context.getBean("engineBean");
		System.out.println(engine);
		
		ShowRoom showroom = (ShowRoom) context.getBean("showroomBean");
		System.out.println(showroom);
		
	}
}
