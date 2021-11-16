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
public class LibraryController {
    @Autowired
    LibraryServices libraryServices;
    List<LibraryModel> libraryDataList = new ArrayList<>();
    @PostMapping("/saveLibraryDetails")
    public LibraryModel saveOrderDetails(@RequestBody LibraryModel libraryModel){
       LibraryModel storeLibraryDetail = libraryServices.saveOrderDetails(libraryModel);
        return storeLibraryDetail;

    }

    @GetMapping("/showLibraryDetails")
    public String showLibrayDetail()
    {
        Gson libraryModeljson=new Gson();
        String libraryjsonObj =libraryModeljson.toJson(libraryServices.showAllLibraryDetail());
        System.out.println(libraryjsonObj);
        return libraryjsonObj;
    }

    @PutMapping("/updateLibraryDetails")
    public int updateLibraryDetail(){
     int studentId = 5;
     String bookName = "JAVA";
    int updatedRow = 0;
    updatedRow = libraryServices.updateLibraryDetail(studentId,bookName);
    return updatedRow;
    }

    @DeleteMapping("/deleteLibraryDetails")
    public int deleteLibraryDetail() throws IOException {
        int studentId=3;
        int deletedRow=0;
        deletedRow=libraryServices.deleteLibraryDetail(studentId);
        return deletedRow;
    }
    @GetMapping("/totalLibraryDetails")
    public void totalLibrrayDetail(){
        libraryServices.LibraryDetails();
    }
}
