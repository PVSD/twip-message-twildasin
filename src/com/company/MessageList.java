package com.company;
import java.util.*;

/**
 * Created by tw073 on 2/4/19.
 */
public class MessageList {

    List masterList = new ArrayList<Message>();
    String thisName;

    public MessageList (String n)
    {
        thisName = n;
    }

    public void add (Message m)
    {
        masterList.add(m);
        System.out.println(this.toString());
        /*String tpart;;
        tpart = Long.toString(m.time);
        System.out.println(tpart.substring(0,2) + ":" + tpart.substring(2,4) + ":" + tpart.substring(4,6) + "\t" + m.numSend + ":\t" + m.txtMsg);*/
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("\n\n\n\n\n\n\n\n\n----------\t" + thisName + "\t----------");
        Message tst;
        String tpart;
        for(int i = 0; i < masterList.size(); i++)
        {
            tst = (Message) masterList.get(i);

            tpart = Long.toString(tst.time);
            sb.append("\n" + tpart.substring(0,2) + ":" + tpart.substring(2,4) + ":" + tpart.substring(4,6) + "\t" + tst.numSend + ":\t" + tst.txtMsg);
        }
        return sb.toString();
    }
}
