package Problems.RentCar;

import java.security.InvalidParameterException;

public class SearchBox {
    private String text;
    public void setText(String text) {
        if(text == null) throw new InvalidParameterException();

        this.text = text.trim();
    }

    public boolean isEmpty() {
        return text == null || text.isEmpty();
    }

    public boolean hasAtLeastCharacters(int n) {
        if(n < 0) throw new InvalidParameterException();

        if( n == 0 ) return true;

        if(isEmpty()) {
            return false;
        }
        
        return text.length() >= n;
    }
}
