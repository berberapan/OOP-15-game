public class EligibilityCheck {


    public boolean isButtonEligible(int emptyIndex, int buttonClickedIndex, int squareValue) {
        int aboveBelow = Math.abs(buttonClickedIndex - emptyIndex);
        int toLeft = emptyIndex - buttonClickedIndex;
        int toRight = buttonClickedIndex - emptyIndex;

        if (((emptyIndex+1) % squareValue == 0) && (aboveBelow == squareValue || toLeft == 1)) {
            return true;
        } else if ((emptyIndex % squareValue == 0) && (aboveBelow == squareValue || toRight == 1)) {
            return true;
        } else return (((emptyIndex+1) % squareValue != 0) && (emptyIndex % squareValue != 0))
                && (aboveBelow == squareValue || toLeft == 1 || toRight == 1);
    }
}
