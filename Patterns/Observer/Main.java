package Patterns.Observer;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Channel channel = new Channel();
        Subscriber s1 = new Subscriber("Vijendra");
        Subscriber s2 = new Subscriber("Shimbhu");
    
        channel.addSubscriber(s1);
        channel.addSubscriber(s2);
        

        channel.addVideo("Title : How AI is changing the world...");
    }

}
