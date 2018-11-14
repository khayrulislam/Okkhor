package Ai;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import DataObject.Word;
import DataObject.WordNode;
import Factory.FactoryClass;
import Utils.Util;

public class WordTrie {

	private WordNode root;
	
	private static WordTrie dt = null;
	
	private WordTrie() {}
	
	public static WordTrie getWordTrieInstance() {
		
		if(dt==null) {
			synchronized (WordTrie.class) {
				if(dt==null) dt = new WordTrie();	
			}
		}
		return dt;
	}
	
	public void builtTrie() {
		int i=0;
		String word;
		createRoot();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("banglaData4.txt")));
			// TODO get data form databa
			while ( (word = br.readLine() )!= null) {
				insertWord(root, new Word(word));
				//i++;
				//System.err.println(i);
			}	
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void createRoot() {
		this.root = new WordNode();
	}

	public ArrayList<Word> getSuggestionList(String prefix) {
		
		WordNode temp = root;
		ArrayList< Word > arrayList = new ArrayList<>();
		
		for(int i=0;i<prefix.length();i++) {
			
			int index = getIndex(prefix.charAt(i));
			if(temp.children[index]==null) return null;
			temp = temp.children[index];
		}
		
		if(!lastNodeCheck(temp))  getList(temp,prefix,arrayList);
		else arrayList.add(new Word(prefix, 0));
		
		Collections.sort(arrayList);
		
		return arrayList;
	}
	
	private void getList(WordNode root, String prefix,ArrayList< Word > arrayList) {
		
		if(root.isTheEnd) {
			// arrayList.add(prefix);
			arrayList.add(new Word(prefix, root.numberOfUse));
		}
			
		if(lastNodeCheck(root)) return;
		
		for(int i=0;i<Util.NUMBER_OF_LATTER;i++) {
			
			if(root.children[i]!=null) {
				char ch = getLetter(i);
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

	
	public void insertFromOutSide(Word word) {
		insertWord(root, word);
	}
	
	
	private void insertWord(WordNode root, Word word) {
		
		WordNode temp = root;
		
		for(int i=0;i<word.getBengaliWord().length();i++) {
			
			int index = getIndex(word.getBengaliWord().charAt(i));
			if(temp.children[index]==null) temp.children[index] = new WordNode();
			temp = temp.children[index];
		}
		temp.isTheEnd = true;
		temp.numberOfUse += word.getCount();
	}

	private int getIndex(char charAt) {
		//System.out.println(charAt+"          "+(int)charAt);
		return FactoryClass.letterIndex.get(charAt);
	}
	
	private char getLetter(int i) {
		return FactoryClass.indexLetter.get(i);
	}
}
