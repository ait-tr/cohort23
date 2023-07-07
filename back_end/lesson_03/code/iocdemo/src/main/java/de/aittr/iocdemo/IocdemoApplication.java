package de.aittr.iocdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IocdemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(IocdemoApplication.class, args);

		/*
		Connection connection = new TCPConnection();
		DeliveryService internetDeliveryService=new InternetDeliveryService(connection);
		//DeliveryService internetDeliveryService=new TestDeliveryService();
		Messenger messenger = new Messenger(internetDeliveryService);
		messenger.sendMessage("hello");
		*/
		Messenger messenger = context.getBean(Messenger.class);
		messenger.sendMessage("hello");
	}

}
