package Ai;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import DataObject.WordNode;
import Utils.Util;

public class WordTrie {

	private WordNode root;
	
	private static WordTrie dt = null;
	
	private WordTrie() {}
	
	public static WordTrie getDateBaseInstance() {
		
		if(dt==null) {
			synchronized (WordTrie.class) {
				if(dt==null) dt = new WordTrie();	
			}
		}
		return dt;
	}
	
	public void builtTrie() {
		
		String word;
		createRoot();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("data.txt")));
			while ( (word = br.readLine() )!= null) 
				insertWord(root, word);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
		
		if(!lastNodeCheck(temp))  getList(temp,prefix,arrayList);
		else arrayList.add(prefix);
		
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
