package application;

import java.util.HashMap;

public class createSingleWordFile {
	static  HashMap<String,Integer> singleWord(String temp[]){
        HashMap<String,Integer> x=new HashMap<String,Integer>();
        for(int i=0;i<temp.length;i++){
            x.put(temp[i],1);
        }
        return x;
    }
}
