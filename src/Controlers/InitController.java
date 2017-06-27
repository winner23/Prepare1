package Controlers;

import Models.FileAccessModel;
import Views.ViewData;

import java.util.*;

public class InitController {

    private FileAccessModel fileAccessModel;
    private ViewData viewData;

    List<Map<String,String>> contacts;

    public InitController(FileAccessModel fileAccessModel, ViewData viewData) {
        this.fileAccessModel = fileAccessModel;
        this.viewData = viewData;
        contacts = fileAccessModel.getAccModels();

    }




    public void findAll(String str) {
        List<String> headers =fileAccessModel.getHeaders();
        for(Map<String,String> record:contacts){
            Set<String> fields = record.keySet();
            for(String key:fields){
                String val = record.get(key);
                if(val.contains(str)){
                    System.out.println(record.get(headers.get(3))+" "+record.get(headers.get(1))+" "+record.get(headers.get(2)));
                }


            }
        }

    }
}
