package 智仁库.第3次作业;
import java.util.Scanner;
 interface  Xiti{
    void Xitiku();
}
class Gaoshu implements Xiti{
     public Gaoshu(){
         this.Xitiku();
     }
     public void Xitiku(){
         System.out.println("打印高数");
     }
}
class Yingyu implements Xiti{
    public Yingyu(){
        this.Xitiku();
    }
    public void Xitiku(){
        System.out.println("打印英语");
    }
}
class Xiandai implements Xiti{
    public Xiandai(){
        this.Xitiku();
    }
    public void Xitiku(){
        System.out.println("打印现代");
    }
}
class XitiFactory{
     public Xiti makeXiti(String Xititype){
         if(Xititype.equalsIgnoreCase("高数")){
             return new Gaoshu();
         }else if(Xititype.equalsIgnoreCase("英语")){
             return new Yingyu();
         }else if(Xititype.equalsIgnoreCase("现代")){
             return new Xiandai();
         }
         return null;
     }

}

public class factory {
     public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         String a=sc.nextLine();
         XitiFactory xitiFactory=new XitiFactory();
         Xiti yy=xitiFactory.makeXiti(a);

     }
}
