# Postfix-Calculator-Android-App


# User Interface
* The app provides one activity.
* The top four items on the stack will be displayed in text views.
* The number currently being entered will be displayed in a text view.
## The calculator has the following keys:
1. Digits 0 through 9
2. Decimal point
3. Enter
4. Del
5. Addition, subtraction, multiplication, and division
6. Drop

## Operation
* Digit keys and decimal point are used to enter numbers.
* The Del (backspace) removes the most recently entered digit (or decimal point) from the current number.
* Enter pushes the current number onto the stack.
* Drop pops the number from the top of the stack and discards it.
* The addition, subtraction, multiplication, and division keys pop the top two operands from the stack, perform the operation, and push the results back onto the stack.
## Specifications
* The app will retain the contents of the stack when paused.
* Activity is locked to a single orientation.
* The current number may be entered with only one decimal point.
* Application uses an instance of java.util.Deque to hold the stack.


#Note:
> For installation and other instructions read the Readme file inside ReadMe folder. 
