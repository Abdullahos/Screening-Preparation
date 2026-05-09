package zplayground.serialization;

import java.io.Serial;
import java.io.Serializable;

public class ArbitraryClass implements Serializable {
    private String arbitraryValue; //private field getting serialization as the serialization uses reflection and the reflection لا دين له
    int painInAss = 10;
    @Serial
    private static final long serialVersionUID = 1722536751297988029L;


    public String getArbitraryValue() {
        return arbitraryValue;
    }
    public ArbitraryClass(String arbitraryValue) {
        this.arbitraryValue = arbitraryValue;
    }
}
