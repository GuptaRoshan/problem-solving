
# Recursion Patterns and Designs

### 1. Direct Recursion or Linear Recursion
- A function calls itself once with a subset of the original input.
  > **subset of the original input** in the context of linear recursion means that each recursive call to the function works with a part of the data that is derived from the original input, typically a smaller or reduced version of it.

```java
  public class Factorial {
      // Recursive function to calculate factorial
      public static int factorial(int n) {
          // Base case: factorial of 0 or 1 is 1
          if (n == 0 || n == 1) {
              return 1;
          }
          // Recursive case: n! = n * (n-1)!
          return n * factorial(n - 1);
      }
  
      public static void main(String[] args) {
          int number = 5;
          int result = factorial(number);
          System.out.println("Factorial of " + number + " is " + result);
      }
  }
```

```java
  factorial(5)
  |
  5 * factorial(4)
  |    |
  |    4 * factorial(3)
  |        |
  |        3 * factorial(2)
  |            |
  |            2 * factorial(1)
  |                |
  |                1 (base case)
  |
  120 (result)
```

### 2. Tail Recursion
- A special kind of recursion where the recursive call is the last operation in the function. This allows for optimizations by the compiler or interpreter, making the recursion more efficient in terms of memory usage.
- Only one stack frame is created.

```java
  public class TailRecursiveFactorial {
  
      public static int factorial(int n) {
          return factorialHelper(n, 1);
      }
  
      // Helper function to handle tail recursion
      private static int factorialHelper(int n, int accumulator) {
          if (n == 0 || n == 1) {
              return accumulator;
          }
          return factorialHelper(n - 1, n * accumulator);
      }
  
      public static void main(String[] args) {
          int number = 5;
          int result = factorial(number);
          System.out.println("Factorial of " + number + " is " + result);
      }
  }
```

```java
  factorialHelper(5, 1)
    |
    factorialHelper(4, 5)    // 5 * 1
      |
      factorialHelper(3, 20)  // 4 * 5
        |
        factorialHelper(2, 60) // 3 * 20
          |
          factorialHelper(1, 120) // 2 * 60
            |
            factorialHelper(0, 120) // 1 * 120 (base case, return 120)
```




### 3. Tree Recursion
- A type of recursion where a function makes multiple recursive calls. This creates a branching effect, like the branches of a tree.

```
 Problem Definition:

 Given a set of integers and a target sum, determine if there exists a subset whose sum is equal to the target sum.

 Recursive Strategy:

 For each element, we have two choices:
 Include the element in the subset.
 Exclude the element from the subset.     
```

```java
  public class SubsetSum {

      public static boolean isSubsetSum(int[] set, int n, int sum) {
          // Base cases
          if (sum == 0) {
              return true;
          }
          if (n == 0) {
              return false;
          }
  
          // If last element is greater than sum, ignore it
          if (set[n - 1] > sum) {
              return isSubsetSum(set, n - 1, sum);
          }
  
          // Check if sum can be obtained by:
          // 1. Including the last element
          // 2. Excluding the last element
          return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);
      }
  
      public static void main(String[] args) {
          int[] set = {3, 34, 4, 12, 5, 2};
          int sum = 9;
          int n = set.length;
          if (isSubsetSum(set, n, sum)) {
              System.out.println("Found a subset with given sum");
          } else {
              System.out.println("No subset with given sum");
          }
      }
  }
```

```java
isSubsetSum(set, 6, 9)
├── isSubsetSum(set, 5, 9)         // Exclude set[5] (2)
│   ├── isSubsetSum(set, 4, 9)     // Exclude set[4] (5)
│   │   ├── isSubsetSum(set, 3, 9) // Exclude set[3] (12)
│   │   │   ├── isSubsetSum(set, 2, 9) // Exclude set[2] (4)
│   │   │   │   ├── isSubsetSum(set, 1, 9) // Exclude set[1] (34)
│   │   │   │   │   ├── isSubsetSum(set, 0, 9) // Base case, return false
│   │   │   │   │   └── isSubsetSum(set, 0, 5) // Include set[1] (34) => Base case, return false
│   │   │   │   └── isSubsetSum(set, 1, 5) // Include set[2] (4)
│   │   │   │       ├── isSubsetSum(set, 0, 5) // Exclude set[1] (34) => Base case, return false
│   │   │   │       └── isSubsetSum(set, 0, 1) // Include set[1] (34) => Base case, return false
│   │   │   └── isSubsetSum(set, 2, 5) // Include set[3] (12)
│   │   │       ├── isSubsetSum(set, 1, 5) // Exclude set[1] (34) => Base case, return false
│   │   │       └── isSubsetSum(set, 1, 1) // Include set[1] (34) => Base case, return false
│   │   └── isSubsetSum(set, 3, 4) // Include set[4] (5)
│   │       ├── isSubsetSum(set, 2, 4) // Exclude set[2] (4)
│   │       │   ├── isSubsetSum(set, 1, 4) // Exclude set[1] (34) => Base case, return false
│   │       │   └── isSubsetSum(set, 1, 0) // Include set[1] (34) => Base case, return true
│   │       └── isSubsetSum(set, 2, 0) // Include set[2] (4) => Base case, return true
│   └── isSubsetSum(set, 4, 7) // Include set[5] (2)
│       ├── isSubsetSum(set, 3, 7) // Exclude set[3] (12)
│       │   ├── isSubsetSum(set, 2, 7) // Exclude set[2] (4)
│       │   │   ├── isSubsetSum(set, 1, 7) // Exclude set[1] (34) => Base case, return false
│       │   │   └── isSubsetSum(set, 1, 3) // Include set[1] (34) => Base case, return false
│       │   └── isSubsetSum(set, 2, 3) // Include set[2] (4)
│       │       ├── isSubsetSum(set, 1, 3) // Exclude set[1] (34) => Base case, return false
│       │       └── isSubsetSum(set, 1, -1) // Include set[1] (34) => Base case, return false
│       └── isSubsetSum(set, 3, 2) // Include set[3] (12)
│           ├── isSubsetSum(set, 2, 2) // Exclude set[2] (4)
│           │   ├── isSubsetSum(set, 1, 2) // Exclude set[1] (34) => Base case, return false
│           │   └── isSubsetSum(set, 1, -2) // Include set[1] (34) => Base case, return false
│           └── isSubsetSum(set, 2, 0) // Include set[2] (4) => Base case, return true
└── isSubsetSum(set, 5, 7) // Include set[5] (2)
    ├── isSubsetSum(set, 4, 7) // Exclude set[4] (5)
    │   ├── isSubsetSum(set, 3, 7) // Exclude set[3] (12)
    │   │   ├── isSubsetSum(set, 2, 7) // Exclude set[2] (4)
    │   │   │   ├── isSubsetSum(set, 1, 7) // Exclude set[1] (34) => Base case, return false
    │   │   │   └── isSubsetSum(set, 1, 3) // Include set[1] (34) => Base case, return false
    │   │   └── isSubsetSum(set, 2, 3) // Include set[2] (4)
    │   │       ├── isSubsetSum(set, 1, 3) // Exclude set[1] (34) => Base case, return false
    │   │       └── isSubsetSum(set, 1, -1) // Include set[1] (34) => Base case, return false
    │   └── isSubsetSum(set, 3, 2) // Include set[3] (12)
    │       ├── isSubsetSum(set, 2, 2) // Exclude set[2] (4)
    │       │   ├── isSubsetSum(set, 1, 2) // Exclude set[1] (34) => Base case, return false
    │       │   └── isSubsetSum(set, 1, -2) // Include set[1] (34) => Base case, return false
    │       └── isSubsetSum(set, 2, 0) // Include set[2] (4) => Base case, return true
    └── isSubsetSum(set, 4, 5) // Include set[4] (5)
        ├── isSubsetSum(set, 3, 5) // Exclude set[3] (12)
        │   ├── isSubsetSum(set, 2, 5) // Exclude set[2] (4)
        │   │   ├── isSubsetSum(set, 1, 5) // Exclude set[1] (34) => Base case, return false
        │   │   └── isSubsetSum(set, 1, 1) // Include set[1] (34) => Base case, return false
        │   └── isSubsetSum(set, 2, 1) // Include set[2] (4)
        │       ├── isSubsetSum(set, 1, 1) // Exclude set[1] (34) => Base case, return false
        │       └── isSubsetSum(set, 1, -3) // Include set[1] (34) => Base case, return false
        └── isSubsetSum(set, 3, 0) // Include set[3] (12) => Base case, return true
```

### 4. Divide and Conquer
- The divide and conquer pattern is a powerful algorithmic technique where a problem is divided into smaller subproblems that are solved recursively.

``` 
  Problem Defination:

  Finding the Maximum Number in an Array
  
  Recursive Strategy:
  
  Divide: Split the array into two halves.
  Conquer: Recursively find the maximum number in each half.
  Combine: Compare the maximums found in the two halves to determine the overall maximum.
```

```java
  public class DivideAndConquerExample {
  
      // Function to find the maximum number in an array using divide and conquer
      public static int findMax(int[] arr, int left, int right) {
          // Base case: when the array contains only one element
          if (left == right) {
              return arr[left];
          }
  
          // Divide the array into two halves
          int mid = (left + right) / 2;
  
          // Recursively find the maximum in each half
          int maxLeft = findMax(arr, left, mid);
          int maxRight = findMax(arr, mid + 1, right);
  
          // Combine the results to get the overall maximum
          return Math.max(maxLeft, maxRight);
      }
  
      public static void main(String[] args) {
          int[] arr = { 3, 7, 2, 8, 1, 9, 4, 5 };
          int max = findMax(arr, 0, arr.length - 1);
          System.out.println("Maximum number in the array: " + max);
      }
  }
```

```java
  findMax(arr, 0, 7)
  ├── findMax(arr, 0, 3)
  │   ├── findMax(arr, 0, 1)
  │   │   ├── 3
  │   │   └── 7
  │   └── findMax(arr, 2, 3)
  │       ├── 2
  │       └── 8
  └── findMax(arr, 4, 7)
      ├── findMax(arr, 4, 5)
      │   ├── 1
      │   └── 9
      └── findMax(arr, 6, 7)
          ├── 4
          └── 5
```

### 5. Backtracking
- Explore all potential solutions and backtrack when a solution fails.
    - Example: Solving puzzles like Sudoku, N-Queens problem.

### 6. Dynamic Programming (with Recursion)
- Recursion combined with memoization to avoid redundant calculations.
    - Example: Fibonacci sequence with memoization, Knapsack problem.

### 7. Mutual Recursion
- Mutual recursion refers to a situation where two or more functions call each other in a recursive manner. A classic example involves checking whether a number is even or odd using mutual recursion.

```java
  public class EvenOddMutualRecursion {
      
      // Function to check if a number is even
      public static boolean isEven(int n) {
          if (n == 0)
              return true;
          else
              return isOdd(n - 1);
      }
      
      // Function to check if a number is odd
      public static boolean isOdd(int n) {
          if (n == 0)
              return false;
          else
              return isEven(n - 1);
      }
      
      public static void main(String[] args) {
          int num = 5;
          
          System.out.println(num + " is even? " + isEven(num));
          System.out.println(num + " is odd? " + isOdd(num));
      }
  }
```

```java
               isEven(5)
             /          \
     isOdd(4)          false
     /     \
  true  isEven(4)
         /         \
    isOdd(3)       true
    /     \
  true  isEven(3)
         /         \
    isOdd(2)       false
    /     \
  true  isEven(2)
         /         \
    isOdd(1)       true
    /     \
  true  isEven(1)
         /         \
    isOdd(0)       false
    /     \
  false  isEven(0)
                \
             true (base case)

```


### 8. Generative Recursion
- Generative recursion involves generating and solving new subproblems based on the current state, often used in scenarios like generating permutations.

```java
 public class Permutations {
 
     public static List<List<Integer>> generatePermutations(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
         List<Integer> current = new ArrayList<>();
         boolean[] used = new boolean[nums.length];
         generate(nums, used, current, result);
         return result;
     }
     
     private static void generate(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
         if (current.size() == nums.length) {
             result.add(new ArrayList<>(current));
             return;
         }
         
         for (int i = 0; i < nums.length; i++) {
             if (!used[i]) {
                 used[i] = true;
                 current.add(nums[i]);
                 generate(nums, used, current, result);
                 current.remove(current.size() - 1);
                 used[i] = false;
             }
         }
     }
 
       public static void main(String[] args) {
          int[] nums = {1, 2, 3};
          generatePermutations(nums);  
      }
 
 }
```

```java
                         [] 
                /        |       \
            [1]         [2]       [3]
          /   \       /   \     /   \
      [1,2] [1,3]  [2,1] [2,3] [3,1] [3,2]
       /       \    /       \   /       \
   [1,2,3]  [1,3,2] [2,1,3] [2,3,1] [3,1,2] [3,2,1]

```


### 9. Indirect Recursion
- A function calls another function, which eventually leads to the original function being called.
    - Example: Function A calls Function B, and Function B calls Function A.

### 10. Nested Recursion
- Nested recursion occurs when a recursive function calls itself with a recursive call as one of its arguments.

```java
 public class SumOfDigitsNestedRecursion {

     public static int sumOfDigits(int n) {
         if (n < 10) {
             return n;  // Base case: Return the single digit number
         } else {
             // Recursive case: Sum the last digit and recursively sum the rest of the digits
             return n % 10 + sumOfDigits(sumOfDigits(n / 10));
         }
     }

     public static void main(String[] args) {
         int n = 456;
         int result = sumOfDigits(n);
         System.out.println("Sum of digits of " + n + " is: " + result);
     }
 }
```

```java
   sumOfDigits(456)
   │
   └── 6 + sumOfDigits(45)
          │
          ├── 5 + sumOfDigits(4)
                 │
                 └── sumOfDigits(4)
```

# Binary Search

- [Binary Search Patterns](<https://leetcode.com/discuss/interview-question/1322500/5-variations-of-Binary-search-(A-Self-Note)>)


# Sorting

### Bucket Sort

```java

// The formula int range = max - min + 1; calculates the total number of distinct values or positions that an array's elements can span

// int[] arr = { -5, 0, 3, 7 };
// int range = max - min + 1; // 7 - (-5) + 1 = 13
//The range of values from -5 to 7 covers 13 distinct positions: -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7.
int range = max - min + 1; 

int numberOfBuckets = 5;
int bucketSize = (int) Math.ceil((double) range / numberOfBuckets); // one bucket how much elements should hold


private static int getBucketIndex(int elem, int min, int bucketSize) {
   
  // Elem - min: This shifts the element value so that min becomes the starting point of the range. For example, 
  // if min is -5, then elem value 0 would be shifted to 5 (i.e., 0 - (-5) = 5).  
  
  // (elem - min) / bucketSize: This divides the normalized value by the bucket size to determine which bucket the element should go into. The result is the index of the bucket.
  return (elem - min) / bucketSize;
}

```


# Bit Manipulation

- ### Bitwise effects on numbers

```java

    /*
    * Left Shift (<<) :
    * The left shift operator (<<) shifts the bits of a number to the left by a specified number of positions.
    * Each bit is shifted to the left by the specified amount, and zeros are added to the right.
    */
    int x = 5; // Binary representation: 000...0000101
    int y = x << 2; // Shift left by 2 positions
    // After shifting left by 2 positions, the binary representation becomes: 000...0010100

    // Multiplication by powers of 2
    /*  5 * 2^2 = 20 **/
    System.out.println(y); // Output: 20

    /*
    * Right Shift (>>):
    * The right shift operator (>>) shifts the bits of a number to the right by a specified number of positions.
    * Each bit is shifted to the right by the specified amount.
    */

    int a = 20; // Binary representation: 000...0010100
    int b = a >> 2; // Shift right by 2 positions
    // After shifting right by 2 positions, the binary representation becomes: 000...0000101

    // Division by powers of 2
    /*  20 / 2^2 = 5 **/
    System.out.println(b); // Output: 5

```

- ### Check if a Number is Even or Odd

```java

// Input Examples:
// isEven(4):
// 4 in binary: 0100
// 4 & 1: 0100 & 0001 = 0000 (result is 0, so 4 is even)

// isEven(7):
// 7 in binary: 0111
// 7 & 1: 0111 & 0001 = 0001 (result is 1, so 7 is odd)

public boolean isEven(int number) {
    return (number & 1) == 0;
}

```

- ### Toggle a Specific Bit

```java

// Input Examples:
// toggleBit(5, 1):
// 5 in binary: 0101
// 1 << 1 (shift left by 1): 0010
// 5 ^ 2: 0101 ^ 0010 = 0111 (result is 7)

// toggleBit(8, 3):
// 8 in binary: 1000
// 1 << 3 (shift left by 3): 1000
// 8 ^ 8: 1000 ^ 1000 = 0000 (result is 0)

public int toggleBit(int number, int bitPosition) {
    return number ^ (1 << bitPosition);
}

```


- ### Set a Specific Bit

```java

// Input Examples:
// setBit(5, 2):
// 5 in binary: 0101
// 1 << 2 (shift left by 2): 0100
// 5 | 4: 0101 | 0100 = 0101 (result is 7)

// setBit(10, 1):
// 10 in binary: 1010
// 1 << 1 (shift left by 1): 0010
// 10 | 2: 1010 | 0010 = 1010 (result is 10)

public int setBit(int number, int bitPosition) {
    return number | (1 << bitPosition);
}

```

- ### clear a Specific Bit

```java

// Input Examples:
// clearBit(7, 1):
// 7 in binary: 0111
// ~(1 << 1) (shift left by 1 and complement): ~0010 = 1101
// 7 & 1101: 0111 & 1101 = 0101 (result is 5)

// clearBit(15, 3):
// 15 in binary: 1111
// ~(1 << 3) (shift left by 3 and complement): ~1000 = 0111
// 15 & 0111: 1111 & 0111 = 0111 (result is 7)

public int clearBit(int number, int bitPosition) {
    return number & ~(1 << bitPosition);
}

```

- ### Count the Number of Set Bits (Hamming Weight)

```java

// Input Examples:
// countSetBits(7):
// 7 in binary: 0111
// Number of 1's: 3

// countSetBits(10):
// 10 in binary: 1010
// Number of 1's: 2

public int clearBit(int number, int bitPosition) {
public int countSetBits(int number) {
    int count = 0;
    while (number != 0) {
        count += (number & 1);
        number >>= 1;
    }
    return count;
}

```

- ### Find the Position of the Rightmost Set Bit

```java

// Input Examples:
// findRightmostSetBit(12):
// 12 in binary: 1100
// -12 in binary (two's complement): 0011 (inverting 1100) + 1 = 0100
// 12 & -12: 1100 & 0100 = 0100 (result is 4)

// findRightmostSetBit(18):
// 18 in binary: 10010
// -18 in binary: 01101 (inverting 10010) + 1 = 01110
// 18 & -18: 10010 & 01110 = 00110 (result is 2)

public int findRightmostSetBit(int number) {
    return number & -number;
}

```

- ### Check if a Number is a Power of Two

```java

// Input Examples:
// isPowerOfTwo(4):
// 4 in binary: 0100
// 4 - 1 = 3 (binary: 0011)
// 4 & 3: 0100 & 0011 = 0000 (result is 0, so 4 is a power of two)

// isPowerOfTwo(6):
// 6 in binary: 0110
// 6 - 1 = 5 (binary: 0101)
// 6 & 5: 0110 & 0101 = 0100 (result is not 0, so 6 is not a power of two)

public boolean isPowerOfTwo(int number) {
    return (number > 0) && ((number & (number - 1)) == 0);
}

```

- ### Swap Two Numbers Without Using a Temporary Variable

```java

// Input Examples:
// arr = [3, 5]; swap(arr, 0, 1);
// Before swap: [3, 5]
// 3 ^ 5 = 6 (0110)
// 5 ^ 6 = 3
// 6 ^ 3 = 5
// After swap: [5, 3]

// arr = [7, 2]; swap(arr, 0, 1);
// Before swap: [7, 2]
// 7 ^ 2 = 5 (0101)
// 2 ^ 5 = 7
// 5 ^ 7 = 2
// After swap: [2, 7]

public void swap(int[] arr, int i, int j) {
    if (i != j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
}

```

- ### Reverse Bits of an Integer

```java

// Input Examples:
// reverseBits(5):
// 5 in binary: 00000101
// Reversed: 10100000 (result is 160)

// reverseBits(15):
// 15 in binary: 00001111
// Reversed: 11110000 (result is 240)

public int reverseBits(int number) {
    int result = 0;
    while (number > 0) {
        result = (result << 1) | (number & 1);
        number >>= 1;
    }
    return result;
}


```


- ### Determine if Two Integers Have Opposite Signs

```java

// Input Examples:
// haveOppositeSigns(5, -3):
// 5 in binary: 00000000000000000000000000000101
// -3 in binary (two's complement): 11111111111111111111111111111101
// 5 ^ -3: 00000000000000000000000000000101 ^ 11111111111111111111111111111101 = 11111111111111111111111111111000 (negative result)
// Result: true (opposite signs)

// haveOppositeSigns(-7, -8):
// -7 in binary: 11111111111111111111111111111001
// -8 in binary: 11111111111111111111111111111000
// -7 ^ -8: 11111111111111111111111111111001 ^ 11111111111111111111111111111000 = 00000000000000000000000000000001 (positive result)
// Result: false (same signs)


public boolean haveOppositeSigns(int a, int b) {
    return (a ^ b) < 0;
}

```
# Map 

- `Use for grouping elements`
- `Use for storing count frequency of elements`
- `Combine map count frequnecy to create a pair<k, v>, combine with priority queue, list etc.`


# Matrix

### Basic Directions (left, right, top, down)

- `{0, 1}` : Represents movement to the right
- `{0, -1}`: Represents movement to the left
- `{1, 0}` : Represents movement downwards
- `{-1, 0}`: Represents movement upwards

### Additional diagonal movements

- `{1, 1}`  : Represents movement diagonally down and to the right
- `{1, -1}` : Represents movement diagonally down and to the left
- `{-1, 1}` : Represents movement diagonally up and to the right
- `{-1, -1}`: Represents movement diagonally up and to the left


### Matrix Conversion

Convert `n * m` matrix to an array : `a[row * m + col] = matrix[row][col]`

```java
    public static int[] matrixToArray(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] array = new int[m * n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                array[row * n + col] = matrix[row][col];
            }
        }
        return array;
    }
```

Convert array to `n * m` matrix : `matrix[x / m][x % m] = a[x]`;

```java
public static int[][] arrayToMatrix(int[] array, int n, int m) {
        int[][] matrix = new int[n][m];

        for (int x = 0; x < array.length; x++) {
            matrix[x / m][x % m] = array[x];
        }
        return matrix;
    }
```

### Grid Number in matrix

 gridNumber = `(row / 3) * 3 + (col / 3)`


 # Permutations

`P(n, r) = (n−r)! / n!`
where n is the total number of items and r is the number of items to choose from the total.

Permutations of 2 letters from ABC:

`P(3, 2) = (3−2)! / 3! = 3×2×1 = 6`

The permutations are: `AB, BA, AC, CA, BC, CB`

# Combinations

`C(n, r) = n! / (r! × (n−r)!)`

Combinations of 2 letters from ABC:

`C(3, 2) = 3! / ( 2! × (3−2)! ) = 3×2×1 / (2×1×1) = 3`

The combinations are: `AB, AC, BC`

