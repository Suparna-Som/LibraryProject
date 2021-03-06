package com.ifanow.LibraryProject.LibraryServices;
import com.google.gson.Gson;
import com.ifanow.LibraryProject.LibrarayModel.LibraryModel;
import com.ifanow.LibraryProject.LibraryConnection.LibraryGetConnection;
import com.ifanow.LibraryProject.LibraryDAO.LibraryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryServices {

    @Autowired
    LibraryGetConnection libraryGetConnection = new LibraryGetConnection();
    Connection connection;
    @Autowired
    LibraryDAO libraryDAO;
    @Autowired
    LibraryModel libraryModel = new LibraryModel();
    PreparedStatement stmt;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public int studentId;
    @Autowired
    private Gson gson;

    public int saveLibraryDetails(int studentId, String studentName, String bookName, String issueDate, String returnDate, int numberOfBook, String librarian){
        int show = 0;
        try {

            connection = libraryGetConnection.getconnect();

            PreparedStatement stmt = connection.prepareStatement(libraryDAO.storeLibraryData);
            libraryModel.setStudentId(studentId);
            libraryModel.setStudentName(studentName);
            libraryModel.setBookName(bookName);
            libraryModel.setIssueDate(issueDate);
            libraryModel.setReturnDate(returnDate);
            libraryModel.setNumberOfBook(numberOfBook);
            libraryModel.setLibrarian(librarian);
            stmt.setInt(1,libraryModel.getStudentId());
            stmt.setString(2,libraryModel.getStudentName() );
            stmt.setString(3,libraryModel.getBookName());
            stmt.setString(4,libraryModel.getIssueDate());
            stmt.setString(5,libraryModel.getReturnDate());
            stmt.setInt(6,libraryModel.getNumberOfBook());
            stmt.setString(7,libraryModel.getLibrarian());
            show = stmt.executeUpdate();
            System.out.println("Records inserted successfully");

            connection.close();
            System.out.println("Connection closed");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return show;
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

            libraryModels[length] = new LibraryModel(result.getInt(2),result.getInt(7),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(8));
                libraryModelList.add(libraryModels[length]);

            }

            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libraryModelList;
    }

    public int deleteLibraryDetail(int srNo)
    {
        int rowsAffected=0;
        try {
            connection = libraryGetConnection.getconnect();
            Statement stmt = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement(libraryDAO.deleteLibraryData);
            ps.setInt(1,srNo);
            rowsAffected = ps.executeUpdate();
            System.out.println("Successfully record deleted");
            showAllLibraryDetail();
            connection.close();
            System.out.println("Connection closed");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    public int updateLibraryDetail(int srNo, String bookName){
        int updated_row=0;
        try {
            connection = libraryGetConnection.getconnect();
            Statement stmt = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement(libraryDAO.updateLibraryData);
            ps.setString(1,bookName);
            ps.setInt(2,srNo);
            updated_row = ps.executeUpdate();
            System.out.println("Records Updated Successfully");
            showAllLibraryDetail();
            connection.close();
            System.out.println("Connection closed");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return updated_row;
    }
public int LibraryDetails(){
        int count = 0;
        try{
            connection = libraryGetConnection.getconnect();

            PreparedStatement ps=connection.prepareStatement(libraryDAO.countLibraryData);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("totalLibraryData"));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    return count;
}
}

