package DataObject;

public class Word implements Comparable<Word>{

	private String bengaliWord;
	private int count;
	
	
	public Word(String input) {
		modifyInput(input);
	}
	
	public Word(String bengaliWord, int count) {
		this.bengaliWord = bengaliWord;
		this.count = count;	
	}
	
	private void modifyInput(String input) {
		String [] array = input.split(" ");
		this.bengaliWord = array[0];
		this.count = Integer.parseInt(array[1]);
	}

	public String getBengaliWord() {
		return bengaliWord;
	}
	public int getCount() {
		return count;
	}


	@Override
	public int compareTo(Word o) {
		// TODO Auto-generated method stub
		return o.count-this.count;
	}
	
}
