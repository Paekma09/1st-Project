package com.boot.chatt;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Service;

@Service
@ServerEndpoint(value = "/views")
public class WebSocketChatt {
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	
	@OnMessage
	public void onMessage(String msg, Session session) throws Exception{
		System.out.println("receive message : "+msg);
		for(Session s : clients) {
			System.out.println("send data : "+msg);
			s.getBasicRemote().sendText(msg);
		}
	}
	
	@OnOpen
	public void onOpen(Session s) {
		System.out.println("open session : "+s.toString());
		if( !clients.contains(s) ) {
			clients.add(s);
			System.out.println("session open : "+s);
		}else {
			System.out.println("이미 연결된 session 입니다!!!");
		}
	}
	
	@OnClose
	public void onClose(Session s) {
		System.out.println("session close : "+s);
		clients.remove(s);
	}
}
