package com.company;
import java.util.*;

/**
 * Created by tw073 on 2/4/19.
 */
public class MessageList {

    List <Message> masterList  = new ArrayList();
    String thisName;

    public MessageList (String n)
    {
        thisName = n;
    }

    public void add (Message m)
    {
        masterList.add(m);
        System.out.println(this.toString());

    }

    public void addSort (Message m)
    {
        Message temp;
        Message before;
        for(int i = 0; i < masterList.size(); i++)
        {
            temp = masterList.get(i);
            if(i == 0 && m.time < temp.time)
            {
                masterList.add(0, m);
                break;
            }
            else if (i > 0)
            {
                before = masterList.get(i-1);
                if(m.time > before.time && m.time <= temp.time)
                {
                    masterList.add(i, m);
                    break;
                }
                else if (i == masterList.size() - 1 && m.time > temp.time)
                {
                    masterList.add(m);
                }
            }
        }
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

    public int size()
    {
        return masterList.size();
    }
}
