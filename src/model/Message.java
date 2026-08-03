package model;

import service.MessageAnalyzer;

import java.time.LocalDateTime;

public class Message {
    private int id;
    private String contentMessage;
    private String sender;
    private LocalDateTime dateAndTime;
    private Classifications classification;
    private MessageAnalyzer messageAnalyzer;

    public Message() {}

    public Message(int id, String contentMessage, String sender, LocalDateTime dateAndTime, Classifications classification) {
        this.id = id;
        this.contentMessage = contentMessage;
        this.sender = sender;
        this.dateAndTime = dateAndTime;
        this.classification = classification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContentMessage() {
        return "    Mensagen: " + contentMessage + "\n";
    }

    public void setContentMessage(String contentMessage) {
        this.contentMessage = contentMessage;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Classifications getClassification() {
        return classification;
    }

    public void setClassification(Classifications classification) {
        this.classification = classification;
    }
}
