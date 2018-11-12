package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static final String SIGN_IN_FXML = "/Ui/SignInWindow.fxml";
	
	public static final String SIGN_UP_FXML = "/Ui/SignUpWindow.fxml";
	
	public static final String OKKHOR_FXML = "/Ui/OkkhorWindow.fxml";
	
	public static final String STYLE_CSS = "/Ui/application.css";
	
	public static final String EMAIL_REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	
	public static final String DATE_FORMAT = "dd.MM.yyyy";
	
	public static final String TIME_FORMAT = "HH:mm:ss";
	
	public static final String LOGGED_IN = "login";
	
	public static final String DEFAULT = "default";
	
	public static final String BANGLE_LETTER = "ৄৠৡৢৣঅআইঈউঊঋএঐওঔকখগঘঙচছজঝঞটঠডঢণতথদধনপফবভমযরলশষসহড়ঢ়য়ৎংঃঁ০১২৩৪৫৬৭৮৯ািীুূৃেৈোৌ্ৗঽঌৰৱ";

	public static final int NUMBER_OF_LATTER = BANGLE_LETTER.length();
	
	public static final int NUMBER_OF_SUGGESTION_ITEM_SHOW = 10;

	public static final String dot1 = "য়";
	
	public static final String dot2 = "ব়";
	
	public static final String dot3 = "ড়";
	
	public static final String dot4 = "ঢ়";
	
	public static final String original1 = "য়";
	
	public static final String original2 = "র";
			
	public static final String original3 = "ড়";
			
	public static final String original4 = "ঢ়";
	
	
	
	
	
	
	
	
	
	
	public static String getDateTime(String format) {
		
		Date date = new Date();
		SimpleDateFormat dft = new SimpleDateFormat (format);
		return dft.format(date);
	}

	
}
