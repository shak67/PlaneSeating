import java.util.Scanner;
class project1_problem_1{
public static void main(String[] args) {
    
    char [][] plane = new char [13][6]; // plane

    Initialize(plane);
    menue(plane);
    

    
}


static void menue(char [][]x) // class that shows the main menue
{
    Scanner input=new Scanner(System.in);
    System.out.println("Main Menue:");
    System.out.println("1-Show Seats");
    System.out.println("2-Choose Seats");
    System.out.println("0- exit program");
    int option= input.nextInt(); //user selection
    while (option <0 || option>2)// this is the validation loop if user inputs incorrect value
    {
        System.out.println("Error: invalid Input");
        System.out.println("Main Menue:");
        System.out.println("1-Show Seats");
        System.out.println("2-Choose Seats");
        System.out.println("0- exit program");
        option= input.nextInt(); 
    }

    switch (option) {  //switch staement that navigates the options and selects the methods.
        case 1: 
            ShowSeats(x);
            break;
        case 2:
            AssignSeat(x);
            break;
        case 0:
            System.out.println("End of program"); // terminates program
            break;
    
        default:
        menue(x); //the default option returns to menue
            break;
    }

}

static void Initialize(char [][]x) //initializes all seats in the plane to be empty
{
    for(int i=0; i<x.length;i++)
    {
        for(int y=0; y<x[0].length;y++)
        {
            x[i][y]= '*'; 
        }
    }   
}

static void ShowSeats(char [][]x)// method that shows seats
{
    
    System.out.println("        A B C D E F"); // displays  columns
    for(int i=0; i<x.length;i++)
    {
        System.out.print("\nRow "+ (i+1)+ "   ");
        for(int y=0; y<x[0].length;y++)
        {
            System.out.print(x[i][y]+ " "); 
        }
        System.out.println("\n");
    }

    menue(x); //call to menue

}

static void AssignSeat(char [][]x) //method that assigns seats
{
    char ticketType; // variable for seat class
    int row; //variable for seat row
    char seat; // variable for seat
    int column; //varable for seat column
    Scanner input=new Scanner(System.in);
    System.out.println("Enter Ticket Type: F/f (first class);  (B/b) (business class); E/e (economy class): ");
    ticketType=input.next().charAt(0);
    while(true) //loop keeps running until broken by user input for classes
    {
    if( ticketType == 'F' || ticketType == 'f' ) //first class
    {
        
        System.out.println("First class seats are from rows 1 and 2");
        System.out.println("Pick a row (between 1 and 2): ");
        row=input.nextInt();
        if (row <1 || row >2) //validates seats only for first class
        {
            continue;
        }
        break; //breaks out of while loop for seat class
        
    }
    else if( ticketType == 'B' || ticketType == 'b')
    {
        System.out.println("Buisness class seats are from rows 3 and 7");
        row=input.nextInt();
        if (row <3 || row >7) //validates seat for buisness class
        {
            continue;
        }
        break;//breaks out of while loop for seat class
    }
    else if( ticketType == 'E' || ticketType == 'e')
    {
        System.out.println("Economy class seats are from rows 8 and 13");
        row=input.nextInt();
        if (row <8 || row >13) //validates seat only in economy
        {
            continue;
        }
        break;//breaks out of while loop for seat class
    }
    else  //if user inputs in invalid input loop keeps running
    {
        System.out.println("Error try again: ");
        System.out.println("Enter Ticket Type: F/f (first class);  (B/b) (business class); E/e (economy class): ");
        ticketType=input.next().charAt(0);
        continue;
    }

    }
    System.out.println("Pick a seat (between A-F): ");
    seat=input.next().charAt(0);
    

    while(true) //loop keeps running until broken by valid seat input
    {
        if( seat == 'A' || seat == 'a' ) 
        {
            System.out.println("The seat chosen is "+ row + seat);
            column=0;
            break;
        }
        else if( seat == 'B' || seat =='b')
        {
            System.out.println("The seat chosen is "+ row + seat);
            column=1;
            break;
        }
        else if( seat == 'C' || seat =='c')
        {
            System.out.println("The seat chosen is "+ row + seat);
            column=2;
            break;
        }
        else if( seat == 'D' || seat =='d')
        {
            System.out.println("The seat chosen is "+ row + seat);
            column=3;
            break;
        }
        else if( seat == 'E' || seat =='e')
        {
            System.out.println("The seat chosen is "+ row + seat);
            column=4;
            break;
        }
        else if( seat == 'F' || seat =='f')
        {
            System.out.println("The seat chosen is "+ row + seat);
            column=5;
            break;
        }
        else  // if users input in anything else other than what seats are available loop keeps running
        {
            System.out.println("Error try again:");
            System.out.println("Pick a seat (between A-F): ");
            seat=input.next().charAt(0);
            continue;
        }
        
    }
    
    if (x[row-1][column]== 'X')  //this checks if seat is already filled if it is then it calls the menu
    {
        System.out.println("Seat is already taken Sorry");
        menue(x);
        System.out.println("\n\n");
    }
    else{ // if its not filled then it fills then it fills the seat and calls the showseat method
    x[row-1][column]= 'X';
    System.out.println("\n\n");
    ShowSeats(x);
    System.out.println("\n\n\n");
    }


    
}



}