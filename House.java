/**
 * <h1>House</h1>
 * This program implements an application that prints a house diagram depending of the users input
 * of the size, border and fill character of the house. It also demonstrates the size when it grows
 * and shrinks as well as the area and perimeter of the house. 
 * Default size, border and fill of the House diagram looks like this
 *
 *          *
 *         * *
 *        * + *
 *       * + + *
 *      * * + * *
 *        * + *
 *        * * *
 *
 * @author  Rakibul Hassan
 * @version 2.0
 * @since   2020-02-07
 */

package cw;
public class House 
{
	private int size;
	private char border;
	private char fill;
	
	public House()
	{
		size=3;
		size='*';
		size='+';
	}
	
	//This is the constructors of House.
	public House(int size, char border, char fill) 
	{
		//This if statement is to make sure that size does not go under limit.
		if (size < 3)
		{
            System.out.println( size + " is an invalid size. Setting size to 3");
            size = 3;		//This will set the size to default to 3.
		}
		//This if statement is to make sure that size does not go over limit.
		if (size >30)		//This will set the size to default to 30.
		{
            System.out.println( size + " is an invalid size. Setting size to 30");
            size = 30;
		}
		
		this.size = size;
		this.border = border;
		this.fill = fill;
	}
	
	// This method is to check that the input is ASCII or not.
	public boolean isASCIILetter() 
	{
		return (border >= 33 && border <= 126 && fill >= 33 && fill <= 126);
	}

	//This is the getter of Size.
	public int getSize() 
	{		
		return size;
	}

	//This is the setter of Size.
	public void setSize(int size) 
	{
		this.size = size;
	}

	//This is the getter of Border.
	public char getBorder() 
	{
		return border;
	}

	//This is the setter of Border.
	public void setBorder(char border)
	{
		this.border = border;
		if (!isASCIILetter())	//This if statement checks that the input is ASCII or not.
		{
			//next line will run if it is NOT (!) ASCII.
            System.out.println( border + " is an Invalid Character. Setting border to *");
            border = '*';		//This will set the border to default to '*'.
		}
		this.border = border;	//This prints the updated border after the if statement.
	}

	//This is getter of Fill.
	public char getFill() 
	{
		return fill;
	}

	//This is the setter of Fill.
	public void setFill(char fill) 
	{
		this.fill = fill;
		if (!isASCIILetter())	//This if statement checks that the input is ASCII or not.
		{
			//next line will run if it is NOT (!) ASCII.
            System.out.println( fill + " is an Invalid Character. Setting fill to +");
			fill = '+';		//This will set the fill to default to '+'.
		}
		this.fill = fill;	//This prints the updated border after the if statement.
	}


	//This method will return the area of the house.
	public double Area()
	{
		return ((Math.sqrt(3)/4)*((size+2)*(size+2))) + (size*size);
	}
	
	//This method will return the perimeter of the house.
	public int Perimeter()
	{
		return (2*(size+2)) + (3*size) + 2;
	}
	
	//This method is to shrink the house.
	public int Shrink()
	{
		size--;		//This will decrement the size.
		//This if statement is to make sure that size does not go under limit.
		if (size < 3)
		{
            System.out.println( size + " is an invalid size. Setting size to 3");
            size = 3;		//This will set the size to default to 3.
		}
		//This if statement is to make sure that size does not go over limit.
		if (size > 30)
		{
            System.out.println( size + " is an invalid size. Setting size to 30");
            size = 30;		//This will set the size to default to 30.
		}
		return size;		//This will return the size after checking the statements.
	}
	
	//This method is for the growth of the house.
	public int Grow()
	{
		size++;		//This will increment the size.
		//This if statement is to make sure that size does not go under limit.
		if (size < 3)
		{
            System.out.println( size + " is an invalid size. Setting size to 3");
            size = 3;		//This will set the size to default to 3.
		}
		//This if statement is to make sure that size does not go over limit.
		if (size > 30)
		{
            System.out.println( size + " is an invalid size. Setting size to 30");
            size = 30;		//This will set the size to default to 30.
		}
		return size;		//This will return the size after checking the statements.
	}
	
	//This method is for the main drawing of the house.
	public void Draw()
	{
		/* MAIN LOOP LOGIC
         The main idea is to run two nested loops, where the first loop will be for the triangle on the top, and the
         bottom one is for the square. On the first nested loop, the outer loop will print the border input which will control
         how many lines are being printed and the inner loop will control how fill inputs which
         are printed on each line. The border characters will be different from the fill character which the 
         if statement inside the nested loops going to differentiate.
     */
		
		int i,j,k;
		//This nested loop is to build the upper triangle of the house.
		for (i=1; i<=(size+2); i++)		//i-loop will run a total of size times, corresponding to the number of rows being printed.

        {
                for(j=1; j<=(size+2)-i ; j++)	//j-loop will run as same as i-loop, but only print spaces.
                {
                        System.out.print(" ");
                }
                //This k-loop will run i number of times, depending on which iteration the outer loop is in.
                for (k=0; k<i; k++)
                {
                	//This if statement is to for the border of the triangle.
                    if((i == size+2) && k == 1 || (k == size))	//When we are at the row (size+2) and first column or vertical line (k==1) or we are at the last column/vertical line (k==size)
                        System.out.print( border + " ");		//This will print just the border input with a space.
                    else if ( k >= 1 && k < (i-1) && i <= (size+2) )	//if it is anything other then first and last column, it will still print the character.
                            System.out.print( fill + " ");
                    else		//which will just print the border
                            System.out.print( border + " ");
                }
        System.out.println();	//This print statement is for the new line between the triangle and square.
        }


		//This nested loop is to build the lower square of the house.
        for (i = 2; i <= size; i++) 	//i-loop will run a total of size times, corresponding to the number of rows being printed.
        { 
            System.out.print(" ");
            for (j = 1; j <= size; j++)		//j-loop will run size number of times, corresponding to the number of column being printed.
            {
            	 //This if statement will print the fill of the square.
                 if(i >= 1 && (j > 1 && j < size) && (i != size))  //This if statement just makes sure the fill character is printed within the boundaries.
                      System.out.print( " " + fill );
                 else
                     System.out.print(" " + border);
             }
            System.out.println();
        }
	}
	
	// This method is printing out the summary which will call all the other methods.
	public void Summary()
	{
		System.out.println("Base Width = " + size + " units.");		//This will state the current size.
		System.out.println("Perimeter of house = " + Perimeter()+" units.");	//This will call the perimeter.
		System.out.println("Area of house = " + Area() + " units.");	//This will call the area.
		System.out.println("House looks like:");
		Draw();		//This will call the draw method with the updated size, border and fill.
	}
	





    public static void main(String[] args) {
        // TODO Auto-generated method stub
         // create some Houses
          House h1=new House (-5,'*','+');
          House h2 =  new House ( 7, '^','+' );
          House h3= new House ( 12, 'W', 'o' );
          House h4 = new House( 50 , '$' , '-');
          
          // display original Houses

          System.out.println ( "h1 has size = " + h1.getSize() + " units.");
          h1.Draw();
          System.out.println ( "h2 has size = " + h2.getSize() + " units.");
          h2.Draw();
          System.out.println ( "h3 has size = " + h3.getSize() + " units.");
          h3.Draw();
          System.out.println ( "h4 has size = " + h4.getSize() + " units.");
          h4.Draw();
          System.out.println ();

          h1.Shrink(); // demonstrate shrink
          h2.Shrink();
          h3.Grow(); // and grow
          h4.Grow();
          System.out.println ( "h1 now has size = " + h1.getSize() + " units.");
          System.out.println ( "h2 now has size = " + h2.getSize() + " units.");
          System.out.println ( "h3 now has size = " + h3.getSize() + " units.");
          System.out.println ( "h4 now has size = " + h4.getSize() + " units.");

          // demonstrate perimeter
          System.out.println ( "h2 has perimeter = " + h2.Perimeter() + " units."); 
          System.out.println ( "h3 has perimeter = " + h3.Perimeter() + " units."); 
          // and area
          System.out.println ( "h2 has area = " + h2.Area() + " square units."); 
          System.out.println ( "h3 has area = " + h3.Area() + " square units."); 

          h1.Draw();
          h1.Grow();               // show that fill character
          System.out.println ( "h1 grows:");   // appears only when size
          h1.Draw();               // is at least 3
          h1.Grow();
          System.out.println ( "... and grows:");
          h1.Draw();
          System.out.println ();

          h1 = h2; // demonstrate the default overload of the
          // assignment operator
          System.out.println ( "h1 now has size = " + h1.getSize() + " units.");
          h1.Draw(); 

          // demonstrate the changing of border and fill characters
          h2.setBorder('@');
          h2.setFill('-');
          System.out.println ( "h2 now looks like:");
          h2.Draw();
          System.out.println ( );
          h2.setBorder((char)200);  // illegal border
          h2.setFill((char) 212);  // illegal fill
          System.out.println ( "h2 now looks like:");
          h2.Draw();
          System.out.println ();

          System.out.println ( "Here is a summary on h3:"); // demonstrate summary
          h3.Summary();
    }
}
