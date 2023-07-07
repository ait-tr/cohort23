package de.aittr.iocdemo;

import org.springframework.stereotype.Component;

@Component
public class Messenger {
    private DeliveryService service;

    public Messenger(DeliveryService service) {
        this.service = service;
    }

    public void sendMessage(String msg){
        System.out.println("Send new message: "+ msg);
        System.out.println("start sending");
        //InternetDeliveryService service = new InternetDeliveryService();
        service.deliveryMessage();
        System.out.println("finish sending");
    }

}
