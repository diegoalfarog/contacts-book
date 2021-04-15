/**
 * contacts book
 * autor Diego Alfaro
 * github diegoalfarog
 * @version 0.1
 * date: 4/15/2021
 */

public class ValidationError extends Exception {
  private static final long serialVersionUID = 1L;
  public ValidationError(String errorMessage) {
    super(errorMessage);
  }
}