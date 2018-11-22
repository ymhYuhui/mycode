package com.Library;

public class Book {
    private String number;
    private String bookname;
    private String author;
    //********构造方法*********
    public Book() {
    }
    //带参数的构造方法，用于初始化一本书
    public Book (String number,String bookname,String author){
        this.number=number;
        this.bookname=bookname;
        this.author=author;
    }
    //用于对书籍数组赋值的构造函数，book（number，bookname，author）
    public Book(Book s){
        this.number=s.number;
        this.bookname=s.bookname;
        this.author=s.author;
    }

    //getter,setter 方法
    public void setNumber(String number) {
        this.number = number;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNumber() {
        return number;
    }

    public String getBookname() {
        return bookname;
    }

    public String getAuthor() {
        return author;
    }
    @Override
    public String toString(){
        return getNumber()+"\t"+getBookname()+"\t"+getAuthor();

    }
    @Override
    public boolean equals(Object s){
        if (this.getClass()!=s.getClass()){
            return false;
        }
        Book b=(Book)s;
        return (this.getNumber().equals(b.getNumber()));
    }
}

