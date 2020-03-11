package com.itcast.websorcket;


import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/webSocket/{name}")
public class TestWebSocket {

    @OnOpen
    public void onOpen(Session session, @PathParam("name") String name) throws IOException {
        System.out.println("连接已建立！");
        session.getBasicRemote().sendText(name+",欢迎登录");
    }

    @OnMessage
    public void onMessage(Session session,String message) throws IOException{
        System.out.println("接受消息--->"+message);
        session.getBasicRemote().sendText("你发送的是："+message);
    }

    @OnClose
    public void onClose(){
        System.out.println("连接已关闭！");
    }


}
