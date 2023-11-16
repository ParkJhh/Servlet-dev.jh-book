package com.example.jspbook;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private Long id;
    private String name;
    private String author;
    private Long isbn;
    private LocalDate publishedDate;

    public Book(Long id, String name, String author, Long isbn, LocalDate publishedDate) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, isbn);
    }

    @Override
    public boolean equals(Object obj) {
        Book b = (Book) obj;
        if(obj instanceof Book) {
            if (this.name.equals(b.name) && this.author.equals(b.author) && this.isbn.equals(b.isbn)) {
                return true;
            }
        }
    return false;
    }

    public String toString() {
        String toStr = "";
        toStr += "[도서 id :" + this.id +  ", 도서명 :" + this.name + ", 도서 저자 :" + this.author + ", 도서 isbn :" + this.isbn + ", 도서 출판일 :" + this.publishedDate;
        if (this instanceof EBook) {
            toStr += ", 파일 크기(e북 타입) :" + ((EBook)this).getFileSize() + "mb";
        } else if(this instanceof AudioBook){
            toStr += ", 파일 크기(audio북 타입) :" + ((AudioBook)this).getFileSize() + "mb, 언어 :" +
                    ((AudioBook)this).getLanguage() + ", 재생 시간 :" +((AudioBook)this).getPlayTime() + "초";
        }
        toStr += "]";
        return toStr;
        }
}


