package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Testing {
	int totalHamMails=1;
	int totalSpamMails=1;
	HashMap<String,Integer> spam=new HashMap<String,Integer>();
	HashMap<String,Integer> ham=new HashMap<String,Integer>();
	public void getList() {
	    	String temp;
		try {
             File filespam = new File("/Users/pallavsaxena/Desktop/Words.txt");
             BufferedReader BF1 = new BufferedReader(new FileReader(filespam));
             System.out.println("Inserting .....");
             while ((temp = BF1.readLine()) != null) {
                 String words[]=temp.split("\\s");
                 spam.put(words[0],Integer.parseInt(words[1]));
             }
             BF1.close();
             
             File fileham = new File("/Users/pallavsaxena/Desktop/Words.txt");
             BufferedReader BF2 = new BufferedReader(new FileReader(fileham));
             System.out.println("Inserting .....");
             while ((temp = BF2.readLine()) != null) {
                 String words[]=temp.split("\\s");
                 ham.put(words[0],Integer.parseInt(words[1]));
             }
             BF2.close();
            }
         catch (IOException e) {
             e.printStackTrace();
         }
	}
	public String getProbability(String s) {
		double hprobability;
		double sprobability;
		int x=0,y=0;
		double hamP=1;
		double spamP=1;
		double cat1=(double)totalHamMails/(double)(totalHamMails+totalSpamMails);
		double cat2=(double)totalSpamMails/(double)(totalHamMails+totalSpamMails);
		String[] temp=s.split("\\s");
		for(int i=0;i<temp.length;i++) {
			if(ham.get(temp[i])!=null) {
				x=ham.get(temp[i]);
			}
			else {
				x=0;
			}
			if(spam.get(temp[i])!=null) {
				y=spam.get(temp[i]);
			}
			else {
				y=0;
			}
			System.out.println("x:"+x+" "+"y:"+y);
			double total=x+y;
			hprobability=x/totalHamMails;
			sprobability=y/totalSpamMails;
			System.out.println("total:"+total);
			System.out.println(hprobability+" "+sprobability);
			double wHProbability=(0.5+(hprobability*total))/(1+total);
			double wSProbability=(0.5+(sprobability*total))/(1+total);
			System.out.println("HP:"+wHProbability+" "+"SP:"+wSProbability);
			hamP=hamP*wHProbability;
			spamP=spamP*wSProbability;
		}
		System.out.println(totalHamMails+"  "+totalSpamMails);
		System.out.println("cat1:"+cat1+" "+"cat2:"+cat2);
		System.out.println(hamP*cat1+"   "+spamP*cat2);
		
		return Double.toString(hamP*cat1)+" "+Double.toString(spamP*cat2);
	}
}
