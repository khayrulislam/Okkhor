package Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Utils.Util;

public class RegularExpressionCheck {

	public boolean isValidEmail(String email) {
		
		Pattern p = Pattern.compile(Util.EMAIL_REGEX);
		Matcher m = p.matcher(email);	
		return m.matches();
	}
	
	
}
