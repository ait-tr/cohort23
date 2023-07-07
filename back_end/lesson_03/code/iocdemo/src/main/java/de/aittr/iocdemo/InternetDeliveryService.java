package de.aittr.iocdemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Profile("prod")
@Component
public class InternetDeliveryService implements DeliveryService {
    private Connection connection;

    public InternetDeliveryService(Connection connection) {
        this.connection = connection;
    }

    public void deliveryMessage(){
        //TCPConnection connection = new TCPConnection();


        System.out.println("Internet delivery");
        connection.init();
        connection.send();
        connection.close();
        System.out.println("delivered");

    }

}
