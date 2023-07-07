package de.aittr.iocdemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Profile("test")
@Component
public class TestDeliveryService implements DeliveryService{

    public void deliveryMessage(){
        System.out.println("DeliveryService Work ");
        System.out.println("fake connection");
    }
}
