package com.ifanow.LibraryProject.LibraryController;

import com.google.gson.Gson;
import com.ifanow.LibraryProject.LibrarayModel.LibraryModel;
import com.ifanow.LibraryProject.LibraryServices.LibraryServices;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {
    @Autowired
    LibraryServices libraryServices;
    List<LibraryModel> libraryDataList = new ArrayList<>();


    @PostMapping("/storeLibraryDetails")
    public int saveLibraryDetails(@RequestParam int studentId, @RequestParam String studentName, @RequestParam String bookName, @RequestParam String issueDate, @RequestParam String returnDate, @RequestParam int numberOfBook, @RequestParam String librarian){
    int storeLibraryDetail=0;
    storeLibraryDetail = libraryServices.saveLibraryDetails(studentId,studentName,bookName,issueDate,returnDate,numberOfBook,librarian);
        return storeLibraryDetail;
    }

    @GetMapping("/showLibraryDetails")
    public String showLibrayDetails()
    {
        Gson libraryModeljson=new Gson();
        String libraryjsonObj =libraryModeljson.toJson(libraryServices.showAllLibraryDetail());
        System.out.println(libraryjsonObj);
        return libraryjsonObj;
    }

    @PutMapping("/updateLibraryDetails")
    public int updateLibraryDetails(@RequestParam int srNo,@RequestParam String bookName){
    int updatedRow = 0;
    updatedRow = libraryServices.updateLibraryDetail(srNo,bookName);
    return updatedRow;
    }

    @DeleteMapping("/deleteLibraryDetails")
    public int deleteLibraryDetail(@RequestParam int srNo) throws IOException {
        //int studentId=3;
        int deletedRow=0;
        deletedRow=libraryServices.deleteLibraryDetail(srNo);
        return deletedRow;
    }
    @GetMapping("/totalLibraryDetails")
    public int totalLibrrayDetail(){
        int count = 0;
        count = libraryServices.LibraryDetails();
        return count;
    }
}
