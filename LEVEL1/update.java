package LEVEL1;

public class update {
    public static void updateMarks(int[] marks ){
        for(int i=0;i<marks.length;i++){
            marks[i]=marks[i]+1;
        }
    }

    public static void main(String[] args) {

        int marks[]={88,98,90};

        updateMarks(marks);

        for(int i=0; i<marks.length;i++){
            System.out.println(marks[i]+" ");
        }
        

    }
    
}
