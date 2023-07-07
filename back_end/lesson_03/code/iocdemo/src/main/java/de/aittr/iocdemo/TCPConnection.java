package de.aittr.iocdemo;

import org.springframework.stereotype.Component;

@Component
public class TCPConnection implements Connection{


    public  void init(){
        System.out.println("Init TCP connection");
    }

    public  void send(){
        System.out.println("sending............");
    }

    public void close(){
        System.out.println("close tsp connection");
    }

}
