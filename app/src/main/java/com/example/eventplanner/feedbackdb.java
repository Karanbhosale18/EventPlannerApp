package com.example.eventplanner;

public class feedbackdb {
    String Name,Email,Subject,Message;

    public feedbackdb(String name, String email, String subject, String message) {
        Name = name;
        Email = email;
        Subject = subject;
        Message = message;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
