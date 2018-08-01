package com.connect.stock.spirit.event;

import org.springframework.context.ApplicationEvent;

public class SendMailEvent extends ApplicationEvent {

    private String from;
    private String[] to;
    private String title;
    private String context;

    public SendMailEvent(Object source, String from, String[] to, String title, String context) {
        super(source);
        this.from = from;
        this.to = to;
        this.title = title;
        this.context = context;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSTo() {
        String sto = "";
        for(String s:to)
            sto = sto+s+";";

        return sto;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
