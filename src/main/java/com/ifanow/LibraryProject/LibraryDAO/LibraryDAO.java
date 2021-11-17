package com.ifanow.LibraryProject.LibraryDAO;

import org.springframework.stereotype.Component;

@Component
public class LibraryDAO {
    public final String getAllLibraryData = "Select * from library";
    public final String storeLibraryData = "insert into library(studentId,studentName,bookName,issueDate,returnDate,numberOfBook,librarian) values(?,?,?,?,?,?,?)";
    public final String updateLibraryData = "Update library set bookName = ? where srNo =?";
    public  final String deleteLibraryData  = "DELETE FROM library  WHERE srNo= ? ";
    public final String countLibraryData = "SELECT COUNT(*) AS totalLibraryData FROM library";
}
