package com.company;

/**
 * Created by tw073 on 2/4/19.
 */
public class Message extends MessageList{

    public String numSend;
    public String txtMsg;
    public long time;

    public Message (String n, String t)
    {

    }

    public String toString()
    {
        return txtMsg;
    }

    public void printTime()
    {
        System.out.println(System.nanoTime());
    }


}
