import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Cliente {
    static int PORT = 4000;

    public static void main (String args[]){
        try{

            MulticastSocket ms = new MulticastSocket();
            InetAddress ia = InetAddress.getByName("experiment.mcast.net");
            ms.joinGroup(ia);

            byte[] buffer = new byte[8192];

            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            String mensagem = null;
            boolean continuar = true;

            System.out.println("Digite o nome de Usuario: ");
            String nomeUsuario = teclado.readLine();

            RecebeMensagens recebeMensagens = new RecebeMensagens(ms);
            recebeMensagens.run();

            while (continuar){
                try{
                    mensagem = teclado.readLine();
                    System.out.println(mensagem);

                    if(mensagem.toUpperCase().equals("/LEAVE")) {
                        continuar = false;
                        recebeMensagens.interrupt();
                        ms.leaveGroup(ia);
                    }
                    else{
                        mensagem = nomeUsuario + ": " + mensagem;
                        buffer = mensagem.getBytes("UTF-8");
                        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, ia, PORT);
                        ms.send(dp);
                    }
                }
                catch (IOException e){
                    System.out.println("Erro ao ler Conteúdo Digitado");
                }
            }

            System.out.println("Fechando o programa");

        }catch(Exception e){
            e.printStackTrace();
            System.err.println(e);
        }

    }
}
