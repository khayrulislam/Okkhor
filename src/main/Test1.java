package main;

import com.sun.javafx.sg.prism.NGRectangle;

import dataAnalyzer.Counter;
import dataAnalyzer.N_Gram;
import dataAnalyzer.WordAnalyzer;
import normalizer.Normalizer;
import utilities.Utilities;

public class Test1 {

	public static void main(String[] args) {
		
		//new Normalizer().normalize();
		//normalizer.normalize();
		//new WordAnalyzer().test();
		//new Counter().wordTest();
		//new N_Gram().test2();
		//Utilities.READ_WRITE.appendInFile("ap.txt", "ok");
	
		//Utilities.GRAM_CONVERTER.convertAndWrite("a b c d e f g h");
		
		//new N_Gram().test2();
		
		Utilities.FACADE.process();
		
		
		//for(String str: Utilities.GRAM_FILENAME)
		//	System.out.println(str);
		
	}
}
