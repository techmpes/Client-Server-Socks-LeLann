import Package1.Minima;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class Main3 {

    public static void main(String[] args) {
        
    try
    {   
        ServerSocket server=new ServerSocket(5003);
        Socket sock1=server.accept();
        System.out.println("Connection accepted");
        ObjectOutputStream output1=new ObjectOutputStream(sock1.getOutputStream());
        ObjectInputStream instream1=new ObjectInputStream(sock1.getInputStream());
        Socket sock;
        sock=new Socket("localhost",5004);
        ObjectOutputStream output=new ObjectOutputStream(sock.getOutputStream());
        ObjectInputStream instream=new ObjectInputStream(sock.getInputStream());
    
        while(true){
            try{
                Minima mp;
                while ((mp=(Minima) instream1.readObject()) != null)
                {
                    Scanner input=new Scanner(System.in);
                    System.out.println("Thes na kaneis kamia eggrafh? NAI/OXI");
                    String epilogh=input.nextLine();
                    if(epilogh.equals("NAI"))
                    {
                        System.out.println("Dwse eggrafh se morfh: AM,Onomatepwnuma,Bathmologia: ");
                        String eggrafh=input.nextLine();
                        Socket sock2=new Socket("localhost",5000);
                        ObjectOutputStream output2=new ObjectOutputStream(sock2.getOutputStream());
                        ObjectInputStream instream2=new ObjectInputStream(sock2.getInputStream());
                        mp=new Minima(eggrafh);
                        output2.writeObject(mp);
                        output2.flush();
                    }
                    output.writeObject(mp);
                    output.flush();
                } 
            }catch (Exception ex){
                System.out.print("Lost a connection. \n");
            } 
        }
    }
    catch(IOException ex)
    {
        System.out.println("Conection Refused"+ex.toString());
    }}
      
}
