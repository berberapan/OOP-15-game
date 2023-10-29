public class EligibilityCheck {


    public boolean isButtonEligible(int emptyIndex, int buttonClickedIndex, int squareValue) {
        int aboveBelow =  Math.abs(buttonClickedIndex - emptyIndex) % squareValue;
        int toLeft = emptyIndex - buttonClickedIndex;
        int toRight = buttonClickedIndex - emptyIndex;
        //Längst ut till höger
        if ((emptyIndex % squareValue-1 == 0) && (aboveBelow == 0 || toLeft == 1)) {
            return true;
        } else if ((emptyIndex % squareValue == 0) && (aboveBelow == 0 || toRight == 1)) {
            return true;
        } else return (emptyIndex % squareValue - 1 != 0) && (emptyIndex % squareValue != 0)
                && (aboveBelow == 0 || toLeft == 1 || toRight == 1);
    }
}
