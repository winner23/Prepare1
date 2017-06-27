package Models;

import java.util.*;

public class DataSet{
    private List<String> headers;
    private Map<String,String> record;
    private List<Map<String,String>> dataSet;

    public DataSet(){
        dataSet = new ArrayList<>();
        headers = new ArrayList<>();
        record = new HashMap<>();
    }

    public DataSet(String [] headers){
        this();
        setHeaders(headers);
    }

    public void setHeaders(List<String> headers){
        this.headers = headers;
    }

    public void setHeaders(String [] headers){
        if(headers.length<1){
            throw new RuntimeException("Incorrect headers data!");
        }
        this.headers = Arrays.asList(headers);
    }

    public void addRecord(Map<String,String> record){
        dataSet.add(record);
    }

    public void addDataRecord(int field,String data){
        if(headers==null){
            throw new RuntimeException("Header not defined!");
        }
        String header = headers.get(field);
        record.put(header,data);
    }



}