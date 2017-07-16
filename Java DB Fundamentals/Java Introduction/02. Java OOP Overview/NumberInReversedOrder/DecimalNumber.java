package NumberInReversedOrder;

import java.util.List;

public class DecimalNumber {
    private String num;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public DecimalNumber(String num) {
        this.num = String.valueOf(num);
    }

    public String getReversedNumber(){
        String[] numberParts = this.num.split(".");
        String firstPart = new StringBuilder(numberParts[0]).reverse().toString();
        String secondPart = new StringBuilder(numberParts[1]).reverse().toString();
        String result = "";
        if (secondPart.equals(0)){
            result = firstPart;
        } else {
            result = firstPart + "." + secondPart;
        }

        return result;
    }
}
