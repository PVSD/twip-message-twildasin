package com.company;
import java.util.*;

/**
 * Created by tw073 on 2/4/19.
 */
public class Message{

    public String numSend;
    public String txtMsg;
    public long time;

    public Message (String n, String t)
    {
        numSend = n;
        txtMsg = t;
        time = this.printTime();
    }

    public String toString()
    {
        return txtMsg;
    }

    private long printTime()
    {
        d = new Date();
        tstTime = d.toString();
        return Long.parseLong(tstTime.substring(11,13) + tstTime.substring(14,16) + tstTime.substring(17,19));
    }

    String tstTime;
    Date d = new Date();

}
