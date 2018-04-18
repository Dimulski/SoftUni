package org.softuni.main.javache.http;

public interface HttpSessionStorage {

    void setSession(String sessionId, HttpSession session);

    HttpSession getSession(String sessionId);

    void removeSession(String sessionId);

}
