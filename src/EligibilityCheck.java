public class EligibilityCheck {
    public boolean isButtonEligible(int emptyIndex, int buttonClickedIndex, int squareValue) {
        boolean isEmptyInRightCol = (emptyIndex+1) % squareValue == 0;
        boolean isEmptyInLeftCol = emptyIndex % squareValue == 0;
        boolean isClickedAboveOrBelow = Math.abs(buttonClickedIndex - emptyIndex) == squareValue;
        boolean isClickedToLeft = emptyIndex - buttonClickedIndex == 1;
        boolean isClickedToRight = buttonClickedIndex - emptyIndex == 1;

        if (isEmptyInRightCol && (isClickedAboveOrBelow || isClickedToLeft)) {
            return true;
        } else if (isEmptyInLeftCol && (isClickedAboveOrBelow || isClickedToRight)) {
            return true;
        } else return ((!isEmptyInRightCol && !isEmptyInLeftCol)
                && (isClickedAboveOrBelow || isClickedToLeft || isClickedToRight));
    }
}
