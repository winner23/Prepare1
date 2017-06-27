package Models;

import java.io.*;

import java.util.List;

/**
 * Created by winner on 26.06.2017.
 */
public class ImportFile {
    private DataSet dataSet;
    private File file;

    public ImportFile(DataSet dataSet, File file){
        this.dataSet = dataSet;
        this.file = file;
    }

    public void getHeaders(){
        BufferedReader bufferedReader;
        try{
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
