package OOPs;


class pen{
        String color;
        String tip;
        public void setColor(String color) {
            this.color = color;
        }
        public void setTip(String tip) {
            this.tip = tip;
        }
    }
    class student{
        String name;
        int age;
        int marks;
        public void calculatePer(){
            if(marks>=90 && marks<=100){
                System.out.println("Grade A");
            }
            else if(marks>=80 && marks<90){
                System.out.println("Grade B");
            }
            else if(marks>=70 && marks<80){
                System.out.println("Grade C");
            }
            else if(marks>=60 && marks<70){
                System.out.println("Grade D");
            }

        }
        public void setName(String name) {
            this.name = name;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public void setMarks(int marks) {
            this.marks = marks;
        }

    }
public class object {
    public static void main(String[] args) {

        pen p=new pen();
        p.setColor("red");
        p.setTip("gel");
        System.out.println(p.color);
        System.out.println(p.tip);

        student s1=new student();
        s1.setName("Anjali");
        s1.setAge(20);
        s1.setMarks(100);
        s1.calculatePer();
        System.out.println(s1.name);
        System.out.println(s1.age);
        System.out.println(s1.marks);
    }
    
}
