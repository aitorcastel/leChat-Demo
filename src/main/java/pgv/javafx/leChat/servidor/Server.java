package pgv.javafx.leChat.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	public static List<Client> clients;
	public static DataOutputStream dos;
	DataInputStream dis;

	Server() {

		System.out.println("Server");

		String name;
		Socket client;

		clients = new ArrayList<Client>();

		try {
			@SuppressWarnings("resource")
			ServerSocket servSock = new ServerSocket(5555);

			while (true) {
				client = servSock.accept();
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());

				name = dis.readUTF();
				Client user = new Client(name, dos, dis);
				System.out.println("Connected : " + name);
				clients.add(user);

				String enter_message = "{ \"name\" : \"" + "[i] Mensaje del servidor > " + "\", \"message\" : \"" + name
						+ " ha entrado en el chat :)" + "\"}";
				System.out.println(enter_message);
				List<Client> entry = Server.clients;
				for (Client cli : entry) {
					DataOutputStream edos = cli.getDos();
					edos.writeUTF(enter_message);
				}

				System.out.println("[i] Usuario : " + Server.clients.size());

			}
		} catch (IOException E) {
			E.printStackTrace();
		}
	}
}