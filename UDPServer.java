import java.awt.Dimension;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.crypto.Data;
  
public class UDPServer
{
    public static void main(String[] args) throws IOException
    {
        // Step 1 : Create a socket to listen at port 7501
        DatagramSocket UDPServerSocket = new DatagramSocket(7501);
        System.out.println("UDP Server up and listening");

        // Create a JFrame and a JLabel to display the received message
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        frame.getContentPane().add(label).setSize(800,800);
        label.setPreferredSize(new Dimension(800, 800));
        frame.pack();
        frame.setVisible(true);


        byte[] receive = new byte[1024];
        DatagramPacket DataPacketReceive = null;
        
        while (true) {

            // DatagramPacket to receive the data.
            DataPacketReceive = new DatagramPacket(receive, receive.length);

            // Receive the data in byte buffer.
            UDPServerSocket.receive(DataPacketReceive);
            String sentence = new String(DataPacketReceive.getData(), 0, DataPacketReceive.getLength());

            // Set the label text to the received message
            label.setText(sentence);

        }
    }
}