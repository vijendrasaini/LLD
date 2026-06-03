package Problems.RentCar.utils.Exceptions;

import Problems.RentCar.utils.Constants;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException() {
        super(Constants.RESULT_NOT_FOUND_EXCEPTION_MESSAGE);
    }
    
    public RecordNotFoundException(String message) {
        super(message);
    }
}