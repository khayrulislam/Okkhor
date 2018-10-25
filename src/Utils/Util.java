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

	
	
	
	
	
	
	
	
	
	
	public static String getDateTime(String format) {
		
		Date date = new Date();
		SimpleDateFormat dft = new SimpleDateFormat (format);
		return dft.format(date);
	}

	
}
