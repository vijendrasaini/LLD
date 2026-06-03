package Problems.RentCar.utils.Exceptions;

import Problems.RentCar.utils.Constants;

public class RecordNotFoundExecption extends RuntimeException {
    public RecordNotFoundExecption() {
        super(Constants.RESULT_NOT_FOUND_EXCEPTION_MESSAGE);
    }
    
    public RecordNotFoundExecption(String message) {
        super(message);
    }
}