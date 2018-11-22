import com.Library.*;

import java.util.Scanner;

public class Test {
    public static void main(String args[]){
        Book books[];
        int q;//用于swtich
        Scanner sc1=new Scanner(System.in);
        Scanner sc2=new Scanner(System.in);
        System.out.println("请输入书籍总数");
        int size=sc1.nextInt();
        Library l1=new Library(size);
        books=new Book[l1.getSize()];
        for (int i=0;i<l1.getSize();i++){
            //将新new的booki对象加入数组中；
            books[i]=new Book(getAbook(i+1));
        }
        l1.setBooks(books);
        //String s=l1.toString();
        System.out.println(l1);
        System.out.println("*****查找：1\t增加：2\t删除：3\t修改：4\t退出：0******");
        q=sc1.nextInt();
        while(q!=0) {

            switch (q) {
                case 1:
                        System.out.println("输入需要查找的书号");
                        String id = sc2.nextLine();
                        if (l1.find(id) < 0) {
                            System.out.println("不存在");
                        } else {
                            System.out.println("存在");
                        }
                    break;
                case 2:
                    Book abook=getAbook(size+1);
                    if (l1.add(abook)){
                        System.out.println("增加成功");
                    }else{
                        System.out.println("增加失败");
                    }
                    System.out.println(l1);
                    break;
                case 3:
                    System.out.println("输入需要删除的书号");
                    String id1 = sc2.nextLine();
                    if (l1.del(id1)) {
                        System.out.println("删除成功");
                    } else {
                        System.out.println("不存在该书");
                    }
                    System.out.println(l1);
                    break;
                case 4:
                    Book bbook=getAbook(size+1);
                    System.out.println("输入需要修改的书号");
                    String id2 = sc2.nextLine();
                    if(l1.change(id2,bbook)){
                        System.out.println("修改成功");
                    }else {
                        System.out.println("修改失败");
                    }
                    System.out.println(l1);
            }
            System.out.println("***** 查找：1 *****增加：2***** 删除：3 ***** 修改：4 ***** 退出：0 ******");
            q=sc1.nextInt();
        }
    }
    public static Book getAbook(int i){
        Scanner sc1=new Scanner(System.in);
        Book booki;
        System.out.println("输入书的信息");
        System.out.print("书籍编号：");
        String id=sc1.nextLine();
        System.out.print("书名：");
        String bookname=sc1.nextLine();
        System.out.print("作者：");
        String author=sc1.nextLine();
        booki=new Book(id,bookname,author);
        return booki;

    }
}
