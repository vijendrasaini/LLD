package Problems.RentCar.utils.Exceptions;

import Problems.RentCar.utils.Constants;

public class NegativeIntegerException extends RuntimeException {
    public NegativeIntegerException() {
        super(Constants.NEGATIVE_INTEGER_EXCEPTION_MESSAGE);
    }
    
    public NegativeIntegerException(String message) {
        super(message);
    }
}
