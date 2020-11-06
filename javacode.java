import java.util.*;
class StringCalculator
{
    public int count=0;
    public int Add(String numbers) throws Exception
    {
        GetCalledCount();
        int negative = numbers.indexOf('-');
        
        if(negative>0)
        {
            throw new Exception("negatives not allowed");
        }
        
        
        numbers = numbers.replaceAll("[^0-9]", "");
        
        if (numbers.equals("")) 
            return 0; 
        
        int allNum=Integer.parseInt(numbers);
        int sum=0;
        while(allNum > 0)
        {
            sum+=allNum%10;
            allNum = allNum / 10;
        }
        
        return sum;
        
    }
    
    public void GetCalledCount()
    {
        count++;
    }

    
    public static void main (String[] args) 
    {
        StringCalculator obj= new StringCalculator();
        Scanner sc=new Scanner(System.in);
        String numbers=sc.nextLine();
        
        try
        { 
            System.out.println(obj.Add(numbers));
        } 
        catch(Exception e) 
        { 
            int index = numbers.indexOf('-');
            while (index >= 0) 
            {
                System.out.println(numbers.charAt(index)+""+numbers.charAt(index+1));
                index = numbers.indexOf('-', index + 1);
            }
           
        }
        System.out.println("Total times Add invoked: "+obj.count);
    }
}
