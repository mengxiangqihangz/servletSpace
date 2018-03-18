package ex01.pyrmont.my;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import ex01.pyrmont.Request;
import ex01.pyrmont.Response;

public class HttpServer {
	
	public static void main(String[] args) {
		HttpServer server = new HttpServer();
		server.await();
	}
	
	
	public void await() {
		ServerSocket serverSocket = null;
		int port = 8080;
		try {
			serverSocket = new ServerSocket(port, 1,
					InetAddress.getByName("127.0.0.1"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		// Loop waiting for a request
		Socket socket = null;
		InputStream input = null;
		OutputStream output = null;
		while (true) {
			try {
				socket = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();

				byte[] by = new byte[10240];
				int num = input.read(by);
				System.out.println(new String(by));
				// Close the socket
				socket.close();

				// check if the previous URI is a shutdown command
//				shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}
}
