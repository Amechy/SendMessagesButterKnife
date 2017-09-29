package com.example.sendmessagebutterknife.POJO;

import java.io.Serializable;

/**
 * @author Alejandro Mechine
 * @version 1.0
 *
 * Clase que almacena el usuario y el mensaje introducidos por el usuario de la aplicación.
 */


public class Message implements Serializable {
    private String message;
    private String user;

    public Message(String message, String user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }



    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message1 = (Message) o;



        result=message.equals(message1.message) &&
                (user.equals(message1.user));

        return result;

    }

    @Override
    public int hashCode() {
        int result = message.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
