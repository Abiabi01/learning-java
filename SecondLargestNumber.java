import java.util.Arrays;
import java.util.Scanner;
public class SecondLargestNumber {

    public static void findSecondLargestNum(int[] arr){
        int secondLargestNum = Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int num : arr){
            if(num > largest){
                secondLargestNum = largest;
                largest = num;

            }else if (num != largest && num > secondLargestNum){
                secondLargestNum = num;
            } 
        }
        if(secondLargestNum == Integer.MIN_VALUE){
           System.out.print("No Second largest found");
        }else{
           System.out.println("secondLargestNum: "+ secondLargestNum);

        }
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int[] inputVal = new int[4];

        for(int i=0;i<inputVal.length;i++){
            while (true) {
                System.out.println("Enter number "+(i + 1)+" :");
                if(sc.hasNextInt()){
                    inputVal[i] = sc.nextInt();
                    break;
                } else {
                    System.out.println("Enter a valid number");
                    sc.next();
                }
                
            }
        }
        System.out.println("Numbers: " + Arrays.toString(inputVal));
        findSecondLargestNum(inputVal);

    }
}
