import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

//Essa classe vai mandar mensagens;
public class Server {

    public static void main(String[] args) {
        new MulticastPublisher().run();
    }

}
