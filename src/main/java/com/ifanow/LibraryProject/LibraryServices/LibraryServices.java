package com.ifanow.LibraryProject.LibraryServices;

import com.ifanow.LibraryProject.LibrarayModel.LibraryModel;
import com.ifanow.LibraryProject.LibraryConnection.LibraryGetConnection;
import com.ifanow.LibraryProject.LibraryDAO.LibraryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryServices {
    @Autowired
    LibraryGetConnection libraryGetConnection = new LibraryGetConnection();
    Connection connection;
    @Autowired
    LibraryDAO libraryDAO;
    PreparedStatement stmt;


    public LibraryModel saveOrderDetails(LibraryModel libraryModel){

        try {

            connection = libraryGetConnection.getconnect();

            PreparedStatement stmt = connection.prepareStatement(libraryDAO.storeLibraryData);
            stmt.setInt(1,libraryModel.getStudentId());
            stmt.setString(2,libraryModel.getStudentName() );
            stmt.setString(3,libraryModel.getBookName());
            stmt.setString(4,libraryModel.getIssueDate());
            stmt.setString(5,libraryModel.getReturnDate());
            stmt.setInt(6,libraryModel.getNumberOfBook());
            stmt.setString(7,libraryModel.getLibrarian());


            stmt.executeUpdate();
            System.out.println("Records inserted successfully");
            connection.close();
            System.out.println("Connection closed");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return libraryModel;
    }
    public List showAllLibraryDetail() {
        int length=0;
        LibraryModel[] libraryModels = new LibraryModel[100];
        List<LibraryModel> libraryModelList = new ArrayList<>();
        try {
            connection = libraryGetConnection.getconnect();

            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(libraryDAO.getAllLibraryData);

            while (result.next()) {
                System.out.println(result.getInt("studentId") + " " + result.getString("studentName") + " " + result.getString("bookName") + " " + result.getString("issueDate") + " " + result.getString("returnDate") + " " + result.getInt("numberOfBook") + " " + result.getString("librarian"));
            libraryModels[length] = new LibraryModel(result.getInt(1),result.getInt(6),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(7));
                libraryModelList.add(libraryModels[length]);

            }
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libraryModelList;
    }
}
