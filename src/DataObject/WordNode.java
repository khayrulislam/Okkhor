package DataObject;

import Utils.Util;

public class WordNode {

	public WordNode [] children = new WordNode[Util.NUMBER_OF_LATTER];
	public boolean isTheEnd;
	public int numberOfUse;
	
	public WordNode() {
		this.isTheEnd = false;
		this.numberOfUse = 0;
		for(int i=0;i<Util.NUMBER_OF_LATTER;i++) this.children[i]=null;
	}
	
	
}
