package com.Library;

public class Library {
    private int size;
    static int maxsize=100;
    private Book books[];
/************构造方法***********/
    public Library(){

    }
    public Library(int size){
        this.size=size;
        books=new Book[maxsize];
    }
    public void setSize(int size) {
        if (size>maxsize){
            System.out.println("overflow");
             return;
        }
        this.size = size;
    }
    public int getSize() {
        return size;
    }

    public static void setMaxsize(int maxsize) {
        Library.maxsize = maxsize;
    }

    public static int getMaxsize() {
        return maxsize;
    }


    public void setBooks(Book ...books) {
        //因为此时数组下标从零开始，所以在for循环中如果i=1的话，books【0】没有被复制，导致空指针异常；
        for (int i=0;i<size;i++){
            this.books[i]=new Book(books[i]);
        }
        this.size=books.length;
    }

    public Book[] getBooks() {
        return books;
    }
    @Override
    //此处重写了object类中的tostring方法，返回值和参数列表需完全相同
    public String toString() {
        String s;
        s="容量"+size+"\n";
        s=s+"书籍编号"+"\t"+"书名"+"\t"+"作者"+"\t"+"\n\n";
        for (int i=0;i<size;i++){
        s=s+books[i].getNumber()+"\t"+books[i].getBookname()+"\t"+books[i].getAuthor()+"\n";
        }
        return s;
    }
    //查找方法0
    public int find(String id){
        for(int i=0;i<size;i++) {
            if (books[i].getNumber().equals(id))
                return i;
        }
            return -1;
    }
    //删除方法
    public boolean del(String id){
        int flag=find(id);
        if (flag==-1){
            return false;
        }
        for (int i=flag+1;i<size;i++){
            books[i-1]=books[i];
        }
        size--;
              return true;
    }
    //插入方法
    public boolean add(Book abook){
        if (size==maxsize)return false;
        if (find(abook.getNumber())>=0)return false;
        this.books[size]=new Book(new String(abook.getNumber()),new String(abook.getBookname()),new String(abook.getAuthor()));//此处调用book类中带参的构造方法
        size++;
        return true;
    }
    //修改方法
    public boolean change(String id,Book abook){
        int flag=find(id);
        if (flag==-1){
            return false;
        } else {
            this.books[flag]=new Book(new String(abook.getNumber()),new String(abook.getBookname()),new String(abook.getAuthor()));
            return true;
        }
    }

}
