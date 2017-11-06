package application;


import javafx.beans.property.SimpleStringProperty;

public class Positive {
	private final SimpleStringProperty word;
	private final SimpleStringProperty frequency;
	
	public Positive(String word,String frequency) {
		super();
		this.word=new SimpleStringProperty(word);
		this.frequency=new SimpleStringProperty(frequency);
	}
	public String getWord() {
		return word.get();
	}
	public String getFrequency() {
		return frequency.get();
	}
}
