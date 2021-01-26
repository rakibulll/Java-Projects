/**
 * <h1>Avengers</h1>
 * This code shows how many avengers needed to fight
 * enemies in different time. With criteria like 
 * home many enemies one avenger can fight alone and
 * how long it takes to fight one enemy
 * 
 *
 * @author  Rakibul Hassan
 * @version 1.0
 * @since   03-16-2020
 */

import java.util.ArrayList;
import java.util.Scanner;


class Process
{
	//This ArrayList is to add list of enemies
	ArrayList<Integer> current;
	private int capacity;

	public Process(int capacity) 
	{
		this.capacity = capacity;
		current = new ArrayList<Integer>();
	}

	//This method will add enemies to the ArrayList
	public void addEnemy(int timestamp) 
	{
		//checks for values inside the ArrayList
		if (current.isEmpty()) 
		{
			//If arraylist is empty, adds a timestamps to start a fight
			current.add(timestamp);
			return;
		}
		
		/* MAIN LOOP LOGIC
		 * This loop checks if there are any slot available in the older
		 * timestamps to add new one by adding 1000 to the older one 
		 * and comparing with the current one.
		 */
		for(int i = 0; i < current.size(); i++)
		{
			//This statement checks if there is any empty slop or not
			if (current.get(i) + 1000 < timestamp) 
			{
				//substitute that timestamp with a new timestamp
				current.set(i, timestamp);
				return;
			}
		}

		//This adds timestamps older fights are not over
		current.add(timestamp);
		return;
	}
		
	//This method is to find out how many avengers are needed
	public int AvengersNeeded() 
	{
		/*
		 * The ArrayList's size displays the max number of enemies 
		 * at each timestamps. So, (current.size()/(double)capacity) will return 
		 * minimum avengers needed by dividing the total size of the array
		 * by the capacity of each avengers(K)
		 */
		return (int) Math.ceil(current.size()/(double)capacity);
	}
}



public class Avengers 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner s = new Scanner (System.in);
		
		System.out.print("Enter the number of enemies (N): ");
		int n = s.nextInt();
		
		System.out.print("Enter fighting capacity of each avenger (K): ");
		int K = s.nextInt();
		
		Process enemies = new Process(K);
		
		System.out.println("Enter time of arrival for each enemy");
		
		// this for loop adds each timestamps in the addEnemy method
		for(int i=0; i<n; i++) 
		{
			enemies.addEnemy(s.nextInt());
		}
		
		System.out.println(enemies.AvengersNeeded() + " avenger(s) are needed to fight off the army");
		
	}
}






