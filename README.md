# Roman-Arabic Calculator on Java

Console application "Calculator". The application reads the arithmetic operations entered by the user from the console and outputs the result of their execution to the console.

## Description:

1. The calculator can perform addition, subtraction, multiplication and division operations with two numbers: a + b, a - b, a * b, a / b. The data is transferred in one line.
2. The calculator can work with both Arabic (1,2,3,4,5…) and Roman (I,II,III,IV,V…) numbers.
3. The calculator accepts numbers from 1 to 10 inclusive, no more. At the output, the numbers are not limited in size and can be any.
4. The calculator can only work with integers.
5. The calculator can only work with Arabic or Roman numerals at the same time, when the user enters a string like 3 + II, the calculator will throw an exception and stop working.
6. When entering Roman numerals, the answer will be displayed in Roman numerals, respectively, when entering Arabic - the answer will be Arabic.
7. When the user enters inappropriate numbers, the application throws an exception and exits.
8. When the user enters a string that does not match one of the above arithmetic operations, the application throws an exception and exits.
9. The result of the division operation is an integer, the remainder is discarded.
10. The result of the calculator with Arabic numbers can be negative numbers and zero. The result of the calculator with Roman numerals can only be positive numbers, if the result of the work is less than one, an exception is thrown.
