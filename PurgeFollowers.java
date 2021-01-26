/**
 * <h1>Purge Followers</h1>
 * <p>After correctly predicting the ending of Game of Thrones a year back, 
 * you became an overnight celebrity and gained thousands of new followers on Instagram. 
 * It seemed nice at first, but now it’s getting a bit annoying. 
 * You receive hundreds of spammy messages a day from your “followers”, 
 * asking you to follow them back and like their posts. #follow4follow
 * 
 * You have decided to remove and block these people from your profile, 
 * but because there are so many of them, so this program will remove followers
 * with low profile automatically.</p>
 *  
 *
 * @author  Rakibul Hassan
 * @version 1.0
 * @since   04-28-2020
 */

import java.util.Scanner;
class Followers 
{
    Node head;
    Node tail;

    
    public Followers() 
    {
        head = null;
        tail = null;
    }

    //This is for the display of the output
    void display() 
    {
        Node current = head;
        //This loop will print the values
        while (current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public void addFollower(int data)
    {
    	Node temp = new Node(data);
    	
    	//This if-statement will point head and tail to a temporary node if the list is empty
    	if(head==null)
    	{
    		head=temp;
    		tail=temp;
    	}
    	//If the list is not empty, it will point at the tail
    	else
    	{
    		tail.next=temp;
    		tail=temp;
    	}
    }
    
    //This will remove the head value
    void frontRemove()
    {
    	Node temp=head;
    	head=head.next;
    	temp.next=null;
    }
    
    //This will remove the middle value
    void midRemove(Node n)
    {
    	//This if-statement will check is the value empty or not
    	if( n==null ) 
    	{
    		return;
    	}

    	Node temp=head;
    	
    	//This while loop will match temp to the value to be removed
    	while(temp.next != n)
    		temp=temp.next;
    	
    	temp.next=n.next;
    	n.next=null;

    }
    
    //This will remove the back value
    void backRemove()
    {
    	Node temp=head;
    	//This while loop will make temp reach the last value and then it will make temp the tail
    	while(temp.next != tail)
    	{
    		temp=temp.next;
    	}
    	
    	temp.next=null;
    	tail=temp;
    	
    }
    
    public void remove(int n) 
    {
		/*
		 * This for loop will basically check each value till it reaches 
		 * the number of followers to be removed. The while loop will check for
		 * the node to be removed. 
		 */
        for(int i=0; i<n; i++)
        {
        	//This node will be the starting point
        	Node s = head;
        	//This while loop will determine which node is needed to be deleted
        	while ( s.next != null && s.data >= s.next.data ) 
        	{
        		//This will point the starting point to the next value until it reaches the end
                s = s.next;
                continue;
            }
        	
        	//This if statement will remove the node which is needed to be deleted
        	//It will go from the head to tail and remove it accordingly
        	if ( s==head )
        	{
        		frontRemove();
        	}
        	else if ( s==tail || s==null )
        	{
        		backRemove();
        	}
        	else
        	{
        		midRemove(s);
        	}
        }
    }
}

class Node 
{
    int data;
    Node next;

    public Node(int data) 
    {
        this.data = data;
        next = null;
    }
}

//This is the driver for this program
public class PurgeFollowers  
{
	public static void main(String args[]) 
	{
        Scanner s = new Scanner(System.in);
        Followers f = new Followers();
        
        System.out.print("Enter number of followers: ");
        int n = s.nextInt();
        
        System.out.print("Enter number of followers to be removed: ");
        int k = s.nextInt();
                       
        System.out.print("Enter list of popularities: ");
        //This for loop will add follower according to the user
        for (int i = 0; i < n; i++)
        	f.addFollower(s.nextInt());
        f.remove(k);

        System.out.print("\nFinal List: ");
        f.display();
    }
}
