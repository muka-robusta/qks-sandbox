package com.onetwostory.socket;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/chat/{username}")
@ApplicationScoped
public class ChatSocket {

    private static final Logger LOGGER = Logger.getLogger(ChatSocket.class);
    private final ConcurrentHashMap<String, Session> sessionMap = new ConcurrentHashMap<>();

    @OnOpen
    public void connectionOpened(final Session session, @PathParam("username") String username) {
        sessionMap.put(username, session);
        sendMessage(String.format("User %s is connected", username));
    }

    @OnMessage
    public void onMessage(String message, @PathParam("username") String username) {
        sendMessage(String.format("%s: %s", username, message));
    }

    @OnClose
    public void onClose(Session _session, @PathParam("username") String username) {
        sessionMap.remove(username);
        sendMessage(String.format("%s is disconnected", username));
    }

    @OnError
    public void onError(Session _session, @PathParam("username") String username, Throwable throwable) {
        sessionMap.remove(username);
        throwable.printStackTrace();
        sendMessage(String.format("user %s has an exception: %s", username, throwable.getMessage()));
    }

    public void sendMessage(String message) {
        sessionMap.values().forEach(it -> it.getAsyncRemote().sendObject(message, sendResult -> {
                if (sendResult.getException() != null) {
                    LOGGER.error(sendResult.getException().getStackTrace());
                }
        }));

    }

}
