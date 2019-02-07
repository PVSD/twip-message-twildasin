package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to TextMessenger 5.0\nAt any point, you will be asked to enter your name/number, and then next the message you want to send.");
        System.out.println("When asked for name/number you can type a \"keyword\" to make the messenger perform a different function.\nHere are the list of keywords:");
        System.out.println("\n-CreateConversation\t\tCreates a new conversation");
        System.out.println("-DeleteMessage\t\t\t\tDeletes a message from CURRENT conversation (user inputs the time)");
        System.out.println("-SwitchConversation\t\tChanges the conversation the user to messaging in");
        System.out.println("-MoveMessage\t\t\t\tMoves the message (given sent time) from current conversation to another existing one");
        System.out.println("-PrintConversation\t\t\tPrints the entire conversation");
        System.out.println("-Exit\t\t\tEnds the program");
        System.out.println("\t***Please type keywords verbatim***");



        System.out.println("\n\nTo start, you must make a conversation, please enter the name of the conversation:");
        Scanner kbin = new Scanner(System.in);
        String convoName = kbin.nextLine();
        MessageList first = new MessageList(convoName);
        List<MessageList> convos = new ArrayList();
        convos.add(first);

        String input;
        int pos = 0;
        String sender;
        String msg;
        MessageList temp;
        String keyIn;
        boolean firstTime = true;
        boolean moreThanOneCon = false;
        while(true)
        {
            temp = (MessageList) convos.get(pos);
            System.out.println("\nEnter the name/number of the sender");
            input = kbin.nextLine();
            if(input.equalsIgnoreCase("Exit"))
            {
                System.out.println("Exiting...");
                break;
            }
            else if(input.equalsIgnoreCase("CreateConversation"))
            {
                System.out.println("Please enter the name of the new Conversation: ");
                keyIn = kbin.nextLine();
                convos.add(new MessageList(keyIn));
                pos = convos.size() - 1;
                System.out.println(keyIn + " conversation successfully created. " + keyIn + " conversation selected.");
                moreThanOneCon = true;
            }
            else if(input.equalsIgnoreCase("DeleteMessage") && !firstTime)
            {
                System.out.println(temp);
                System.out.println("\nPlease enter the time of the message from the conversation \"" + temp.thisName + "\" that you wish to be deleted. Example: \"02:12:34\"");
                keyIn = kbin.nextLine();
                Message subTemp;
                boolean foundPos = false;
                while (!foundPos)
                {
                    if(keyIn.equalsIgnoreCase("Exit"))
                        break;
                    else
                    {

                        keyIn = keyIn.replaceAll(":", "");
                        System.out.println(keyIn);
                        for (int i = 0; i < temp.size(); i++)
                        {
                            subTemp = (Message) temp.masterList.get(i);
                            System.out.println("Long  " + subTemp.time);
                            if(Long.parseLong(keyIn) == subTemp.time)
                            {
                                temp.masterList.remove(i);
                                foundPos = true;
                            }
                        }
                        if(!foundPos)
                        {
                            System.out.println("No message matching that time found. Please enter \"Exit\" or input another time");
                            keyIn = kbin.nextLine();
                        }
                    }
                }
                System.out.println(temp + "\nMessage successfully deleted.");

            }
            else if(input.equalsIgnoreCase("SwitchConversation") && !firstTime && moreThanOneCon)
            {

                System.out.println(temp);
                System.out.println("\nPlease enter the name of of the conversation you would like to switch to");
                keyIn = kbin.nextLine();
                MessageList subTemp;
                boolean foundPos = false;
                while (!foundPos)
                {
                    if(keyIn.equalsIgnoreCase("Exit"))
                        break;
                    else
                    {

                        System.out.println(keyIn);
                        for (int i = 0; i < convos.size(); i++)
                        {
                            subTemp = convos.get(i);
                            System.out.println(subTemp.thisName);
                            if(subTemp.thisName.equalsIgnoreCase(keyIn))
                            {
                                pos = i;
                                foundPos = true;
                            }
                        }
                        if(!foundPos)
                        {
                            System.out.println("No conversation matching that name found. Please enter \"Exit\" or input another name");
                            keyIn = kbin.nextLine();
                        }
                    }
                }
                System.out.println(temp + "\n\nSuccessfully switched to " + keyIn + " conversation.");
            }
            else if(input.equalsIgnoreCase("MoveMessage") && !firstTime)
            {

            }
            else if(input.equalsIgnoreCase("PrintConversation"))
            {

            }
            else
            {
                sender = input;
                System.out.println("Enter the message:");
                msg = kbin.nextLine();
                temp.add(new Message(sender, msg));
            }
            firstTime = false;
        }





        /*MessageList myList = new MessageList("The GC");
        myList.add(new Message("Joe","Hello"));
        myList.add(new Message("John", "Hey"));*/
        //System.out.println(myList);
    }
}
