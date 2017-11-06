package application;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TrainMachine {
    void prepareHashmap(final File folder){
        HashMap<String,Integer> wordsCount=new HashMap<String, Integer>();
        String temp="",s;
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                prepareHashmap(fileEntry);
            }
            else {
                System.out.println(fileEntry.getName());
                try {
                    File file = new File("/Users/pallavsaxena/Desktop/XYZ/"+fileEntry.getName());
                    BufferedReader BF = new BufferedReader(new FileReader(file));
                    temp="";
                    System.out.println("Inserting .....\n");
                    while ((s = BF.readLine()) != null) {
                        temp=temp+s;
                    }
                    BF.close();
                    String words[]=temp.split("\\s");
                    HashMap<String,Integer> singleWords=createSingleWordFile.singleWord(words);
                    for(@SuppressWarnings("rawtypes") Map.Entry m : singleWords.entrySet()){
                        if(wordsCount.containsKey((String) m.getKey())){
                            int num=wordsCount.get(m.getValue());
                            wordsCount.put((String)m.getKey(),num+1);
                        }
                        else{
                            wordsCount.put((String)m.getKey(),1);
                        }
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        TrainMachine.createFile(wordsCount);
    }
    static void createFile(HashMap<String,Integer> x){
    		try {
            File file=new File("/Users/pallavsaxena/Desktop/words.txt");
            FileWriter fileWriter = new FileWriter(file);
            for(@SuppressWarnings("rawtypes") Map.Entry m:x.entrySet()){
                fileWriter.write((String)m.getKey()+"\t"+m.getValue()+"\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

