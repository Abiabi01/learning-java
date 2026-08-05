import java.util.Scanner;
public class Student {

    String name;
    int mark;
    public Student(String name, int mark){
        this.name = name;
        this.mark = mark;
    }

    public void display(){
        System.out.println("name : " + name + " : " + mark);
    }
    public boolean isPass(){
        if(mark >= 35){
            return true;
        }else{
            return false;
        }
    }
   
    public char getGrade(){
        switch (mark/10) {
            case 9:
                return 'A';
            case 8, 7:
                return 'B';
            case 6, 5:
                return 'C';
            case 4, 3:
                return 'D'; 
            default:
                return 'F';
        }   
    }

    public boolean hasDistiction(){
        return mark >= 75;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[3];

        for(int i = 0;i<students.length;i++){
            String name;
            int mark;
            while (true) {
                System.out.println("Enter Student" + (i + 1) + "name: ");
                name = sc.next();
                System.out.println("Enter Student" + (i + 1) + "mark: ");
                mark = sc.nextInt();
                if(mark > 0 && mark <= 100){
                    break;
                }else{
                    System.out.println("Invalid marks! Enter a value between 0 and 100.");
                }
            }
            students[i] = new Student(name,mark);

        }
         int count = 0;
         Student highest = students[0];
         int distiction = 0;
         int total = 0 ;
         int fail = 0;
        for(int i = 0;i< students.length;i++){
        students[i].display();
        char grade = students[i].getGrade();
        System.out.println("Grade: "+ grade);
        count = students[i].isPass() ? count + 1 : count;
        fail = students[i].isPass() ? fail : fail + 1;        
        if(students[i].mark > highest.mark){
            highest = students[i];
        }
        if(students[i].hasDistiction()){
            distiction++;
        }    
        total += students[i].mark;
    }
    double avg = (double) total / students.length;
    System.out.println("Total students pass: "+ count);
    System.out.println("Higest mark: " +highest.name + " " + highest.mark);
    System.out.println("Distiction count: "+ distiction);
    System.out.println("Class Average: "+ avg);
    System.out.print("failed students: " + fail);


    } 
    
        

}
