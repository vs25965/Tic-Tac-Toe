import java.util.Scanner;


public  class tictac {

 
    char board[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    char number = '1'; 
    
    public static void main(String[] args) {
        
    tictac db = new tictac();
     
       outer: for (int i = 1; i <=9; i++) {

            db.displayboard();
            db.choose(1);
            db.win();
            if (db.win() == 1)
            {
              break outer;
            }
            db.choose(0);
            if (db.win() == 1)
            {
              break outer;
            }
            if (i==9 && db.win() == 3)
             {
                System.out.println("\n\tNo winner - tie!\n\t***END OF GAME***");
                break outer;
            } 
            
          }
          
          
            
    }
         


    public void displayboard (){
    
        System.out.println("\n\t    *TTT Board *");
        System.out.println("\t___________________");
        System.out.print("\t|                 |");
        System.out.print("\n\t|  " + board[1] + "  |  " + board[2] + "  |  " + board[3] + "  |\n");
        System.out.print("\t|_________________|");
        System.out.print("\n\t|                 |");
        System.out.println("\n\t|  " + board[4] + "  |  " + board[5] + "  |  " + board[6] + "  |");
        System.out.print("\t|_________________|\n");
        System.out.print("\t|                 |");
        System.out.print("\n\t|  " + board[7] + "  |  " + board[8] + "  |  " + board[9] + "  |\n");
        System.out.print("\t|_________________|");
    }

    public void choose(int turn){

 if (turn == 0)  {

            System.out.println("\nChoose a number from the board = ");
            Scanner in = new Scanner(System.in);
            number = in.next().charAt(0);
            

            
if (number == board[1]) 
{
    board[1] = 'O';  
    displayboard();    
}
else if (number ==  board[2])
{
    board[2] = 'O';
    displayboard();
   
}
else if (number ==  board[3])
{
    board[3] = 'O';
    displayboard();
   
}
else if (number ==  board[4])
{
    board[4] = 'O';
    displayboard();
   
}
else if (number == board[5])
{
    board[5] = 'O';
    displayboard();
  
}
else if (number == board[6])
{
    board[6] = 'O';
    displayboard();
    
}
else if (number == board[7])
{
    board[7] = 'O';
    displayboard();
  
}
else if (number == board[8])
{
    board[8] = 'O';
    displayboard();
  
}
else if (number == board[9])
{
    board[9] = 'O';
    displayboard();
   
}
else{
    System.out.print("\n\nThe number you chose was already taken or You chose a number out of range\n");
    while (number < board[1])
    {
        System.out.println("\nChoose a number from the board = ");
        Scanner un = new Scanner(System.in);
        number = un.next().charAt(0);
        
       
        if (number == board[1]) 
        {
        board[1] = 'O';  
        displayboard();  
        break;
        
        }
        else if (number ==  board[2])
        {
        board[2] = 'O';
        displayboard();
        break;
        }
        else if (number ==  board[3])
        {
        board[3] = 'O';
        displayboard();
        break;
        }
        else if (number ==  board[4])
        {
        board[4] = 'O';
        displayboard();
        break;
        }
        else if (number == board[5])
        {
        board[5] = 'O';
        displayboard();
        break; 
        }
        else if (number == board[6])
        {
        board[6] = 'O';
        displayboard();
        break;
        }
        else if (number == board[7])
        {
        board[7] = 'O';
        displayboard();
        break; 
        }
        else if (number == board[8])
        {
        board[8] = 'O';
        displayboard();
        break;
        }
        else if (number == board[9])
        {
        board[9] = 'O';
        displayboard();
        break;
        } 
        } 
    } 
}
else {

    System.out.println("\nChoose a number from the board = ");
    Scanner n = new Scanner(System.in);
    number = n.next().charAt(0);
    
   
    if (number == board[1]) 
    {
    board[1] = 'X';  
    displayboard();  
    
    
    }
    else if (number ==  board[2])
    {
    board[2] = 'X';
    displayboard();
    
    }
    else if (number ==  board[3])
    {
    board[3] = 'X';
    displayboard();
    
    }
    else if (number ==  board[4])
    {
    board[4] = 'X';
    displayboard();
     
    }
    else if (number == board[5])
    {
    board[5] = 'X';
    displayboard();
      
    }
    else if (number == board[6])
    {
    board[6] = 'X';
    displayboard();
    
    }
    else if (number == board[7])
    {
    board[7] = 'X';
    displayboard();
      
    }
    else if (number == board[8])
    {
    board[8] = 'X';
    displayboard();
    
    }
    else if (number == board[9])
    {
    board[9] = 'X';
    displayboard();
     
    }
    else{
    System.out.print("\n\nThe number you chose was already taken or You chose a number out of range\n");

    while (number < board[1]){
        System.out.println("\nChoose a number from the board = ");
        Scanner u = new Scanner(System.in);
        number = u.next().charAt(0);
       
       
        if (number == board[1]) 
        {
        board[1] = 'X';  
        displayboard();  
        break;
        
        }
        else if (number ==  board[2])
        {
        board[2] = 'X';
        displayboard();
        break;
        }
        else if (number ==  board[3])
        {
        board[3] = 'X';
        displayboard();
        break;
        }
        else if (number ==  board[4])
        {
        board[4] = 'X';
        displayboard();
        break;
        }
        else if (number == board[5])
        {
        board[5] = 'X';
        displayboard();
        break; 
        }
        else if (number == board[6])
        {
        board[6] = 'X';
        displayboard();
        break;
        }
        else if (number == board[7])
        {
        board[7] = 'X';
        displayboard();
        break; 
        }
        else if (number == board[8])
        {
        board[8] = 'X';
        displayboard();
        break;
        }
        else if (number == board[9])
        {
        board[9] = 'X';
        displayboard();
        break;
        } 
      }
    }
  }    
 }



 public int win()     
 { 
    
     if (board[1] == board[2] && board[1] == board[3])
     {
        
         if (board[1] == 0)    
         {
             System.out.println("\n\nPlayer O won with row 1 - 2 - 3\n   END OF GAME\n" );
         } 
 
         else {
             System.out.println("\n\nPlayer X won with row 1 - 2 - 3\n   END OF GAME\n");
         } 
          return 1;
     }
     else if (board[4] == board[5] && board[4] == board[6])
     {
         
         if (board[4] == 0) {
             System.out.println("\n\nPlayer O won with row 4 - 5 - 6\n   END OF GAME\n");
         }
         else{
             
             System.out.println("\n\nPlayer X won with row 4 - 5 - 6\n   END OF GAME\n");
         }
         
          return 1; 
     }
     else if (board[7] == board[8] && board[7] == board[9])
     {
         
         if (board[7] == 0) {
             System.out.println("\n\nPlayer O won with row 7 - 8 - 9\n   END OF GAME\n");
             return 1;   
         }
         else{
             System.out.println("\n\nPlayer X won with row 7 - 8 - 9\n   END OF GAME\n" );
             return 1;   
         }
        
         
        
     }
     else if (board[1] == board[4] && board[1] == board[7])
     {
        
         if (board[1] == 0) {
            
             System.out.println("\n\nPlayer O won with column 1 - 4 - 7\n   END OF GAME\n");
         }
         else {
         
             System.out.println("\n\nPlayer X won with column 1 - 4 - 7\n   END OF GAME\n");
         }
        
          return 1;   
     }
     else if (board[2] == board[5] && board[2] == board[8])
     {
         
         if (board[2] == 0) {
         
             System.out.println("\n\nPlayer O won with column 2 - 5 - 8\n   END OF GAME\n");
 
         }
         else {
           
              System.out.println("\n\nPlayer X won with column 2 - 5 - 8\n   END OF GAME\n");
         }
     
         return 1;  
     }
     else if (board[3] == board[6] && board[3] == board[9])
     {
         
         if (board[3] == 'O') {
         System.out.println("\n\nPlayer O won with column 3 - 6 - 9\n   END OF GAME\n");
         }
         else { 
         System.out.println("\n\nPlayer X won with column 3 - 6 - 9\n   END OF GAME\n"); 
         }
             
         
          return 1;
     }
     else if (board[1] == board[5] && board[1] == board[9])
     {
        
         if (board[1] == 0) {
             System.out.println("\n\nPlayer O won with diagonal 1 - 5 - 9\n   END OF GAME\n" );
         }
         else{
             System.out.println("\n\nPlayer X won with diagonal 1 - 5 - 9\n   END OF GAME\n");
         }
       
        return 1;
     }
     else if (board[3] == board[5] && board[3] == board[7])
     {
        
         if (board[3] == 'X') {
             System.out.println("\n\nPlayer X won with row 3 - 5 - 7\n   END OF GAME\n" );
         }
         else{
             System.out.println("\n\nPlayer O won with row 3 - 5 - 7\n   END OF GAME\n" );
         }
             
      
        return 1;
     }  
     else 
     {
      
        return 3;
     }  
     
    

     }
     
    
 }



