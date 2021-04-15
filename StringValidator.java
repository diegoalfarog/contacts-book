/**
 * contacts book
 * autor Diego Alfaro
 * github diegoalfarog
 * @version 0.1
 * date: 4/15/2021
 */

import java.util.regex.*;
public class StringValidator {

  public static boolean valitateLength(String password, int minlength, int maxlength) {
    if (password.length() < minlength && password.length() > maxlength) {
      return false;
    }
    return true;
  }

  public static boolean valitateLength(String password, int minlength) {
    if (password.length() < minlength) {
      return false;
    }
    return true;
  }

  public static boolean valitateHasNumbers(String password){
    for (int i = 0; i < password.length(); i++) {
      if (Character.isDigit(password.charAt(i))) {
        return true;
      }
    }
    return false;
  }

  public static boolean valitateHasUpperCaseLetter(String password) {
    for (int i = 0; i < password.length(); i++) {
      if (Character.isLetter(password.charAt(i)) && Character.isUpperCase(password.charAt(i))) {
        return true;
      }
    }
    return false;
  }

  public static boolean valitateHasLowerCaseLetter(String password) {
    for (int i = 0; i < password.length(); i++) {
      if (Character.isLetter(password.charAt(i)) && Character.isLowerCase(password.charAt(i))) {
        return true;
      }
    }
    return false;
  }

  public static boolean valitateHasSimbol(String password) {
    for (int i = 0; i < password.length(); i++) {
      if (!Character.isDigit(password.charAt(i)) && !Character.isLetter(password.charAt(i))) {
        return true;
      }
    }
    return false;
  }

  public static boolean valitatePassword(String password) throws ValidationError {
    if (!valitateHasNumbers(password)) {
      throw new ValidationError("The password must have at least one number.");
    }
    if (!valitateHasLowerCaseLetter(password)) {
      throw new ValidationError("The password must have at least one lowercase letter.");
    }
    if (!valitateHasSimbol(password)) {
      throw new ValidationError("The password must have at least one simbol.");
    }
    if (!valitateHasUpperCaseLetter(password)) {
      throw new ValidationError("The password must have at least one uppercase letter.");
    }
    return true;
  }

  public static boolean valitatePassword(String password, int minlength, int maxlength) throws ValidationError {
    if (!valitateLength(password, minlength, maxlength)) {
      throw new ValidationError("The password must be longer than "+ minlength +" and less than " + maxlength + " characters.");
    }
    return valitatePassword(password);
  }

  public static boolean valitatePassword(String password, int minlength) throws ValidationError {
    if (!valitateLength(password, minlength)) {
      throw new ValidationError("The password must be longer than "+ minlength +" characters.");
    }
    return valitatePassword(password);
  }

  public static boolean valitateIfOnlyHaveLettersAndNumbers(String string)  {
    boolean OnlyHaveLettersAndNumbers = false;
    for (int i = 0; i < string.length(); i++) {
      if (Character.isDigit(string.charAt(i)) || Character.isLetter(string.charAt(i))) {
        OnlyHaveLettersAndNumbers = true;
      }else{
        OnlyHaveLettersAndNumbers = false;
      }
    }
    return OnlyHaveLettersAndNumbers;
  }

  public static boolean valitateIfOnlyHaveLetters(String string)  {
    boolean OnlyHaveLetters = false;
    for (int i = 0; i < string.length(); i++) {
      if (Character.isLetter(string.charAt(i))) {
        OnlyHaveLetters = true;
      }else{
        OnlyHaveLetters = false;
      }
    }
    return OnlyHaveLetters;
  }

  public static boolean valitateIfOnlyHaveNumbers(String string)  {
    boolean OnlyHaveNumbers = false;
    for (int i = 0; i < string.length(); i++) {
      if (Character.isDigit(string.charAt(i))) {
        OnlyHaveNumbers = true;
      }else{
        OnlyHaveNumbers = false;
      }
    }
    return OnlyHaveNumbers;
  }


  public static boolean valitateIfIsAEmail(String string) {
    Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
    Matcher mat = pattern.matcher(string);
    return mat.matches();
  }

}