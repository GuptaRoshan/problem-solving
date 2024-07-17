
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

# Binary Search Patterns

- [Binary Search Patterns](<https://leetcode.com/discuss/interview-question/1322500/5-variations-of-Binary-search-(A-Self-Note)>)

