package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DatasetController implements Initializable{
	@FXML private TableView<Positive> table;
	@FXML private TableColumn<Positive,String> word;
	@FXML private TableColumn<Positive,String> frequency;
	public ObservableList<Positive> list1 =FXCollections.observableArrayList();
	
	@FXML private TableView<Negative> table1;
	@FXML private TableColumn<Negative,String> word1;
	@FXML private TableColumn<Negative,String> frequency1;
	public ObservableList<Negative> list2 =FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	  String temp;
		try {
        		File fileham = new File("/Users/pallavsaxena/Desktop/Words.txt");
            BufferedReader BF2 = new BufferedReader(new FileReader(fileham));
			while ((temp = BF2.readLine()) != null) {
				String x[]=temp.split("\\s");
				System.out.println(x[0]+" "+x[1]);
				list1.add(new Positive(x[0],x[1]));
			}
			BF2.close();
			word.setCellValueFactory(new PropertyValueFactory<Positive,String>("Word"));
			frequency.setCellValueFactory(new PropertyValueFactory<Positive,String>("Frequency"));
			table.setItems(list1);
			
			File fileham1 = new File("/Users/pallavsaxena/Desktop/Words.txt");
            BF2 = new BufferedReader(new FileReader(fileham1));
			while ((temp = BF2.readLine()) != null) {
				String x[]=temp.split("\\s");
				System.out.println(x[0]+" "+x[1]);
				list2.add(new Negative(x[0],x[1]));
			}
			BF2.close();
			word1.setCellValueFactory(new PropertyValueFactory<Negative,String>("Word"));
			frequency1.setCellValueFactory(new PropertyValueFactory<Negative,String>("Frequency"));
			table1.setItems(list2);
	 } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}