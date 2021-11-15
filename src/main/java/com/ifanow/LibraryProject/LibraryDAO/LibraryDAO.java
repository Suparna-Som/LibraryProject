package com.ifanow.LibraryProject.LibraryDAO;

import org.springframework.stereotype.Component;

@Component
public class LibraryDAO {
    public final String getAllLibraryData = "Select * from Library";
    public final String storeLibraryData = "insert into Library(studentId,studentName,bookName,issueDate,returnDate,numberOfBook,librarian) values(?,?,?,?,?,?,?)";
    public final String updateLibraryData = "Update Library set status = ? where order_id =?";
    public final String deleteLibraryData  = "DELETE FROM Library  WHERE order_id=?";
}
