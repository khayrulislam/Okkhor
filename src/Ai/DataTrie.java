package Ai;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import DataObject.WordNode;
import Utils.Util;

public class DataTrie {

	private WordNode root;
	
	private static DataTrie dt = null;
	
	private DataTrie() {}
	
	public static DataTrie getDateBaseInstance() {
		
		if(dt==null) {
			synchronized (DataTrie.class) {
				if(dt==null) dt = new DataTrie();	
			}
		}
		return dt;
	}
	
	public void builtTrie() {
		
		createRoot();
		
		ArrayList<String>  data = new ArrayList<>();
		
		FileReader fr;
		
		String rr;
		
		try {
			fr = new FileReader(new File("data.txt"));
			BufferedReader br = new BufferedReader(fr);
			while ( (rr = br.readLine() )!= null) {
				//System.out.println(rr.length()); 
				insertWord(root, rr);
				//System.out.println(1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		data.add("hello");
		data.add("dog");
		data.add("hell");
		data.add("cat");
		data.add("hel");
		data.add("help");
		data.add("helps");
		data.add("helping");
		
		
		
		for(int i=0;i<data.size();i++) insertWord(root, data.get(i));
	}
	
	private void createRoot() {
		this.root = new WordNode();
	}

	public ArrayList<String> getSuggestionList(String prefix) {
		
		WordNode temp = root;
		ArrayList< String > arrayList = new ArrayList<>();
		
		for(int i=0;i<prefix.length();i++) {
			
			int index = getIndex(prefix.charAt(i));
			
			if(temp.children[index]==null) return null;
			
			temp = temp.children[index];
		}
		
		
		boolean isLast = lastNodeCheck(temp);
		
		if(!isLast) {
			getList(temp,prefix,arrayList);
		}
		else {
			arrayList.add(prefix);
		}
		
		return arrayList;
	}
	
	private void getList(WordNode root, String prefix,ArrayList< String > arrayList) {
		
		if(root.isTheEnd) 
			arrayList.add(prefix);
		if(lastNodeCheck(root)) return;
		
		for(int i=0;i<Util.NUMBER_OF_LATTER;i++) {
			
			if(root.children[i]!=null) {
				char ch =(char) ((char) 'a'+i);
				getList( root.children[i],  prefix+ch, arrayList);
			}	
		}
		return ;
	}

	private boolean lastNodeCheck(WordNode root) {

		for(int i=0;i<Util.NUMBER_OF_LATTER;i++) 
			if(root.children[i]!=null) return false;
		return true;
	}

	private void insertWord(WordNode root, String word) {
		
		WordNode temp = root;
		
		for(int i=0;i<word.length();i++) {
			
			int index = getIndex(word.charAt(i));
			
			if(temp.children[index]==null) temp.children[index] = new WordNode();
			
			temp = temp.children[index];
		}
		temp.isTheEnd = true;
	}

	private int getIndex(char charAt) {
		return charAt - 'a';
	}
	
	
}
