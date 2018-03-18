package com.zzl.control;

import java.net.URI;
import java.net.URISyntaxException;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ServerHandshake;

public class WebSocketUtils extends WebSocketClient {  
  
        public WebSocketUtils( URI serverUri , Draft draft ) {  
                super( serverUri, draft );  
        }  
  
        public WebSocketUtils( URI serverURI ) {  
                super( serverURI );  
        }  
  
        @Override  
        public void onOpen( ServerHandshake handshakedata ) {  
           System.out.println( "����--opened connection" );  
        }  
  
        @Override  
        public void onMessage( String message ) {  
           System.out.println( "����--received: " + message );  
        }  
  
        @Override  
        public void onFragment( Framedata fragment ) {  
           System.out.println( "Ƭ��--received fragment: " + new String( fragment.getPayloadData().array() ) );  
        }  
  
        @Override  
        public void onClose( int code, String reason, boolean remote ) {  
           System.out.println( "����--Connection closed by " + ( remote ? "remote peer" : "us" ) );  
        }  
  
        @Override  
        public void onError( Exception ex ) {  
           ex.printStackTrace();  
           
        }  
  
//       public static void main(String[] args) {
//    	    try {
//           	WebSocketUtils c = new WebSocketUtils( new URI( "ws://tourace-api.iriding.cc/socket.io/?transport=websocket" ), new Draft_17() );   
//   			c.connectBlocking();
//   			c.send("����--handshake");  
//   			} catch (InterruptedException e) {
//   			e.printStackTrace();
//   			} catch (URISyntaxException e) {
//   			e.printStackTrace();
//   			} 
//       } 
}  