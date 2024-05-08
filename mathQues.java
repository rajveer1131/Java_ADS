import java.util.Arrays;
import java.util.Scanner;

public class mathQues {





//    static int hcf(int a,int b){
//        if(b%a==0)return b;
//        return hcf(b%a,a);
//
//    }

//    static int hcf(int a,int b){
//        if(a==0)return b;
//        if(b==0)return a;
//        if(a>b) {
//            if (a % b == 0) return b;
//            return hcf(a % b, b);
//        }
//        if(b%a==0)return a;
//
//        return hcf(a,b%a);
//    }


//    public void hcf(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter -1 to exit");
//
//        int a=sc.nextInt();
//
//        while(a!=-1){
//
//            int b=sc.nextInt();
//            System.out.println(a+" "+b+" hcf is: "+hcf(a,b));
//            a=sc.nextInt();
//        }
//        sc.close();
//    }




    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean []arr = new boolean[n+1];
        Arrays.fill(arr,true);


        for(int i=2;i<=(int)Math.sqrt(n);i++){
            for(int j=i+i;j<n+1 ;j+=i){

                    arr[j]=false;

            }
        }

        for(int i=2;i<n+1;i++){
            System.out.print(arr[i]?i+" " :"");
        }





        System.out.println("Done.");
    }
}
