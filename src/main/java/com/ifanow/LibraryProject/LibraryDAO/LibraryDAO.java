package com.ifanow.LibraryProject.LibraryDAO;

import org.springframework.stereotype.Component;

@Component
public class LibraryDAO {
    public final String getAllLibraryData = "Select * from Library";
    public final String storeLibraryData = "insert into Library(studentId,studentName,bookName,issueDate,returnDate,numberOfBook,librarian) values(?,?,?,?,?,?,?)";
    public final String updateLibraryData = "Update Library set bookName = ? where studentId =?";
    public  final String deleteLibraryData  = "DELETE FROM Library  WHERE studentId= ? ";
    public final String countLibraryData = "SELECT COUNT(*) AS totalLibraryData FROM Library";
}
