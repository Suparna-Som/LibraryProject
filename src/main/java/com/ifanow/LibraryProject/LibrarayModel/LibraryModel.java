package com.ifanow.LibraryProject.LibrarayModel;

import org.springframework.stereotype.Component;
@Component
public class LibraryModel {
    public int studentId,numberOfBook;
    public String studentName,bookName,issueDate,returnDate,librarian;



    public LibraryModel() {

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getNumberOfBook() {
        return numberOfBook;
    }

    public void setNumberOfBook(int numberOfBook) {
        this.numberOfBook = numberOfBook;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getLibrarian() {
        return librarian;
    }

    public void setLibrarian(String librarian) {
        this.librarian = librarian;
    }

    public LibraryModel(int studentId, int numberOfBook, String studentName, String bookName, String issueDate, String returnDate, String librarian) {
        this.studentId = studentId;
        this.numberOfBook = numberOfBook;
        this.studentName = studentName;
        this.bookName = bookName;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.librarian = librarian;
    }



}
