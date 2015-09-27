package PopUpMenuExample;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Divide {
    
    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        boolean continueLoop = true;
        
        do
        {
            try
            {
                System.out.println("Toogoo oruul");
                int hurtver = sc.nextInt();
        
                System.out.println("toogoo oruul");
                int huvaari = sc.nextInt();
                
                int result = huvaah(hurtver, huvaari);
                System.out.println("\nResult: "+ result);
                continueLoop = false;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Buruu utga.");
                sc.nextInt();
                System.out.println("too oruulah yostoi");
                        
            }
            catch(ArithmeticException e)
            {
                System.out.println("0 d huvaagdahgu");
            }
            
        }
        while (continueLoop);
    }
    
    private static int huvaah(int hurtver, int huvaari)
    {
        return hurtver/huvaari;
    }
}
