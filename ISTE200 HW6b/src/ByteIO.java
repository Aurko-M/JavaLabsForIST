import java.util.*;
import java.io.*;

public class ByteIO
{
   public static void main (String []args)
   {
      try
      {
         FileInputStream fileInputSTRM = new FileInputStream("ClassList.dat");
         BufferedInputStream bufferedInputSTRM = new BufferedInputStream(fileInputSTRM);
         DataInputStream dataInputSTRM = new DataInputStream(bufferedInputSTRM);

         while(dataInputSTRM.available() > 0)
         {
            String Name = dataInputSTRM.readUTF();
            int ID = dataInputSTRM.readInt();
            double grade1 = dataInputSTRM.readDouble();
            double grade2 = dataInputSTRM.readDouble();
            double grade3 = dataInputSTRM.readDouble();
            double grade4 = dataInputSTRM.readDouble();
            
            double avg = (grade1 + grade2 + grade3 + grade4) / 4;
            
            System.out.printf("%1$-20s %2$-5d %3$-4.1f %4$-4.1f %5$-4.1f %6$-4.1f %7$-5.1f %n", Name, ID, grade1, grade2, grade3, grade4, avg);
         }
         
         fileInputSTRM.close();
         bufferedInputSTRM.close();
         dataInputSTRM.close();
      }catch(IOException e)
      {
         System.out.println("Error: \n" );
         e.printStackTrace();
      }
   }
   
   
   
}