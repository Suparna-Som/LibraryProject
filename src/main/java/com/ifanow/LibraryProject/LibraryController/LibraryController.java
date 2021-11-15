package com.ifanow.LibraryProject.LibraryController;

import com.ifanow.LibraryProject.LibrarayModel.LibraryModel;
import com.ifanow.LibraryProject.LibraryServices.LibraryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    LibraryServices libraryServices;
    List<LibraryModel> libraryDataList = new ArrayList<>();
    @PostMapping("/saveLibraryDetail")
    public LibraryModel saveOrderDetails(@RequestBody LibraryModel libraryModel){
       LibraryModel storeLibraryDetail = libraryServices.saveOrderDetails(libraryModel);
        return storeLibraryDetail;

    }

    @GetMapping("/showLibraryDetails")
    public List showLibrayDetail()
    {
        LibraryModel[] libraryModels = new LibraryModel[100];
        List<LibraryModel> showdetail = libraryServices.showAllLibraryDetail();
        return showdetail;
    }

}
