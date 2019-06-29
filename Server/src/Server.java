import Package1.Minima;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    public static void main(String[] args) {
        try
        {  
            ServerSocket server=new ServerSocket(5000);

            while(true)
            {
                Socket sock=server.accept();
                System.out.println("Connection accepted");
                ObjectInputStream instream=new ObjectInputStream(sock.getInputStream());
                Minima mp=(Minima) instream.readObject();
                try 
                {   
                    PrintWriter fr = new PrintWriter(new BufferedWriter(new FileWriter("Bathmologia Foithtwn.txt", true)));
                    fr.write(mp.getMinima()+"\n");
                    fr.close();
                    System.out.println("H eggrafh egine:" +mp.getMinima());

                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    catch(Exception ex)
    {
        System.out.println("Error during I/O");
        ex.getMessage();
        ex.printStackTrace();
    }
    
}
}
