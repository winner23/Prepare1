package Models;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by winner on 16.06.2017.
 */
public class FileAccessModel {
    private static File fileIn, fileOut;
    private Charset windowsCharset;
    private List<Map<String,String>> accModels;

    public static String testFile(String fileName){
        fileName = fileName.trim();
        File testFile = new File(fileName);
        String parent = testFile.getAbsolutePath();
        boolean exist = testFile.exists();

        return "File: " + parent + " ; and this file " +
                (exist ? "exist, size: " + testFile.length() + " bytes" : "not exist");
    }

    public FileAccessModel(String fileNameIn){
        fileNameIn = fileNameIn.trim();
        String fileNameOut = "out.csv";
        if(fileIn==null){
            fileIn = new File(fileNameIn);
        }
        if(fileOut==null){
            fileOut = new File(fileNameOut);
        }
        if(!fileIn.exists()){
            throw new RuntimeException("File not found");
        }
        if(fileOut.exists()){
            renameUp(fileNameOut);
        }
        this.windowsCharset = Charset.forName("windows-1251");
        initData();
    }

    public FileAccessModel(String fileNameIn, String fileNameOut){
        fileNameIn = fileNameIn.trim();
        fileNameOut = fileNameOut.trim();
        if(fileIn==null){
            fileIn = new File(fileNameIn);
        }
        if(fileOut==null){
            fileOut = new File(fileNameOut);
        }

        if(!fileIn.exists()){
            throw new RuntimeException("File not found");
        }
        if(fileOut.exists()){
            renameUp(fileNameOut);
        }
        this.windowsCharset = Charset.forName("windows-1251");
        initData();
    }


    public void initData(){
        List<String> headers = getHeaders();
        List<Map<String,String>> data = new ArrayList<>();
        String lineStr;
        BufferedReader br = null;


        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileIn),windowsCharset));
            try {
                br.readLine();
                while((lineStr = br.readLine())!=null){
                    List<String> lineList = line2List(lineStr);
                    if(lineList.size()<4) continue;
                    Map<String,String> lineMap = new HashMap<>();
                    lineMap = zipMap(headers, lineList);
                    data.add(lineMap);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        accModels = data;

    }

    public List<String> getHeaders(){

        String headerStr = "";
        BufferedReader br=null;
        try {
             br = new BufferedReader(new InputStreamReader(new FileInputStream(fileIn),windowsCharset));
            try {
                headerStr = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return line2List(headerStr);
    }


    private Map<String,String> zipMap(List<String> headers, List<String> values){
        Map<String,String> result = new HashMap<>();
        for(int i=0;i<values.size();i++){
            result.put(headers.get(i),values.get(i));
        }
        return result;
    }

    private List<String> line2List(String line){
        String [] arrLine = line.replace("\"","").split(",");
        List<String> res = Arrays.asList(arrLine);
        return res;
    }

    // Rename to new name with _1 in the end of filename
    private int renameUp(String fileName) {
        fileName =fileName + "_1";
        File f = new File(fileName);

        if(f.exists()){
            renameUp(fileName);
        } else {
            f.renameTo(new File(fileName));
        }
        return 0;
    }

    public static File getFileIn() {
        return fileIn;
    }

    public static void setFileIn(File fileIn) {
        FileAccessModel.fileIn = fileIn;
    }

    public static File getFileOut() {
        return fileOut;
    }

    public static void setFileOut(File fileOut) {
        FileAccessModel.fileOut = fileOut;
    }

    public List<Map<String, String>> getAccModels() {
        return accModels;
    }

}
