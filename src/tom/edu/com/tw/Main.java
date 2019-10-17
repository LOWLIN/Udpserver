package tom.edu.com.tw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            final int PORT = 8000;
            DatagramSocket ds = new DatagramSocket();
            InetAddress address = InetAddress.getByName("10.2.8.178");
            String str;
            do {
                BufferedReader keyin;
                keyin = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("請輸入字串：");
                str = keyin.readLine();
                DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), address, PORT);
                ds.send(dp);
            } while (!str.equals(""));
            System.out.println("結束！");
            ds.close();
        }
        catch (Exception e)
        {
            System.out.println("UdpClient fails.");
        }

    }
}
