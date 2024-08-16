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
   
         public static boolean hasSubsetSum(int[] nums, int target) {
            return hasSubsetSum(nums, target, 0);
         }
   
         private static boolean hasSubsetSum(int[] nums, int target, int index) {
            // Base case: if the target sum is 0, we have found a subset
            if (target == 0) {
               return true;
            }
            // Base case: if we have checked all elements
            if (index == nums.length) {
               return false;
            }
            // Recursive case: include the current element or exclude it
            boolean isSubsetSumExits = hasSubsetSum(nums, target - nums[index], index + 1) || hasSubsetSum(nums, target, index + 1);
            return isSubsetSumExits;
         }
   
         public static void main(String[] args) {
            int[] nums = {3, 34, 4, 12, 5, 2};
            int target = 9;
            boolean result = hasSubsetSum(nums, target);
            System.out.println("Subset with sum " + target + " exists? " + result);
         }
   }
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

# Map Usage in LeetCode Problems

1. **Frequency Counting**

   - Approach: Count occurrences of elements
   - Examples:
     - Valid Anagram
     - Top K Frequent Elements
   - Usage: `Map<element, frequency>`

2. **Two Sum and Variants**

   - Approach: Store complement values
   - Examples:
     - Two Sum
     - 3Sum
     - 4Sum
   - Usage: `Map<complement, index>`

3. **Caching/Memoization**

   - Approach: Store computed results
   - Examples:
     - Fibonacci Number
     - LRU Cache
   - Usage: `Map<input, computedResult>`

4. **String Manipulation**

   - Approach: Character mapping or counting
   - Examples:
     - Isomorphic Strings
     - Group Anagrams
   - Usage: `Map<char, char> or Map<string, list>`

5. **Graph Representation**

   - Approach: Adjacency list
   - Examples:
     - Clone Graph
     - Course Schedule
   - Usage: `Map<node, List<neighbors>>`

6. **Prefix Sum**

   - Approach: Store cumulative sum
   - Examples:
     - Subarray Sum Equals K
     - Continuous Subarray Sum
   - Usage: `Map<prefixSum, count> or Map<prefixSum, index>`

7. **Design Problems**

   - Approach: Implement data structure
   - Examples:
     - Design HashMap
     - Implement Trie (Prefix Tree)
   - Usage: `Map as core data structure`

8. **Longest Substring/Subarray**

   - Approach: Track last seen index
   - Examples:
     - Longest Substring Without Repeating Characters
     - Longest Consecutive Sequence
   - Usage: `Map<char/num, lastSeenIndex>`

9. **Array Transformation**

   - Approach: Map old to new values
   - Examples:
     - Find and Replace Pattern
     - Word Pattern
   - Usage: `Map<oldValue, newValue>`

10. **Intersection and Union**

    - Approach: Track common elements
    - Examples:
      - Intersection of Two Arrays
      - Union of Two Arrays
    - Usage: `Map<element, occurrence>`

11. **Time-Based Data Structures**

    - Approach: Store values with timestamps
    - Examples:
      - Time Based Key-Value Store
    - Usage: `Map<key, List<{timestamp, value}>>`

12. **Sliding Window**

    - Approach: Track window contents
    - Examples:
      - Longest Substring with At Most K Distinct Characters
    - Usage: `Map<char, frequency>`

13. **Path Sum Problems**

    - Approach: Store path sums
    - Examples:
      - Path Sum III
    - Usage: `Map<prefixSum, count>`

14. **Parentheses Problems**

    - Approach: Match opening and closing
    - Examples:
      - Valid Parentheses
    - Usage: `Map<closingParen, openingParen>`

15. **Bit Manipulation**
    - Approach: Store bit patterns
    - Examples:
      - Repeated DNA Sequences
    - Usage: `Map<bitPattern, count>`



# Deque Usage

1. **Implementing Both Stack and Queue Operations**
   
   - As a Stack: You can use methods like addFirst() and removeFirst() to add and remove elements from the front, mimicking stack behavior.
   - As a Queue: You can use methods like addLast() and removeFirst() to enqueue and dequeue elements, mimicking queue behavior.

3. **Sliding Window Problems**
   
    - Deque is particularly useful in algorithms that require a sliding window over a sequence of data. For example, in finding the maximum or minimum in a sliding window over an array, a Deque can efficiently maintain the window's elements, allowing constant-time access to the window's maximum or minimum.

5. **Palindrome Checking**
   
   - You can use a Deque to check if a string is a palindrome. By pushing characters onto the Deque and then popping from both ends, you can compare characters from the front and back to determine if they are the same.

7. **Undo and Redo Operations**
   - In applications with undo and redo functionalities, a Deque can store the history of actions. The front of the Deque can store actions for undo, while the back can store actions for redo.

8. **Expression Parsing**
   
   - In parsing expressions, especially for balancing parentheses or evaluating postfix expressions, a Deque can be used to temporarily hold operands and operators.

10. **BFS (Breadth-First Search) and DFS (Depth-First Search)**
    
    - In graph traversal algorithms, a Deque can be used to manage the frontier. For BFS, you can use it as a queue, and for DFS, you can use it as a stack.

11. **Handling a Fixed Number of Recent Elements**
    
    - When you need to maintain a fixed number of recent elements, a Deque can be used to implement a circular buffer. By adding elements to the back and removing elements from the front, you can keep the buffer up to date with the most recent data.

13. **Job Scheduling**
 
    - In systems that require scheduling tasks or jobs, a Deque can help manage tasks that can be added and removed from either end, providing flexibility in task management.


# Two-Pointer Techniques

1. **Merge Two Sorted Arrays**

   - First pointer: `0th index of first array`
   - Second pointer: `0th index of second array`
   - Movement: Compare elements, place smaller in result, move corresponding pointer

2. **Two Sum (Sorted Array)**

   - First pointer: `0th index (left)`
   - Second pointer: `Last index (right)`
   - Movement: Move left if sum too small, right if sum too large

3. **Reverse Array/String**

   - First pointer: `0th index (left)`
   - Second pointer: `Last index (right)`
   - Movement: Swap elements, move left pointer right and right pointer left

4. **Remove Duplicates from Sorted Array**

   - First pointer: `0th index (unique elements)`
   - Second pointer: `1st index (iterator)`
   - Movement: Second pointer moves, first only when new unique element found

5. **Container With Most Water**

   - First pointer: `0th index (left)`
   - Second pointer: `Last index (right)`
   - Movement: Move the pointer with shorter height inward

6. **3Sum**

   - First pointer: `Fixed, iterates through array`
   - Second and Third: `Two-sum on remaining elements (like #2)`

7. **Sliding Window**

   - First pointer: `Start of window`
   - Second pointer: `End of window`
   - Movement: `Expand/contract window based on condition`

8. **Palindrome Check**

   - First pointer: `0th index (left)`
   - Second pointer: `Last index (right)`
   - Movement: Move towards center, comparing characters

9. **Linked List Cycle Detection**

   - First pointer: `Slow (moves one step)`
   - Second pointer: `Fast (moves two steps)`
   - Movement: If cycle exists, they'll meet

10. **Dutch National Flag**
    - First pointer: `0th index (left, for 0s)`
    - Second pointer: `0th index (iterator)`
    - Third pointer: `Last index (right, for 2s)`
    - Movement: Swap elements based on value, adjust pointers

# Sliding Window Techniques

- [Sliding Window](https://leetcode.com/discuss/interview-question/3722472/mastering-sliding-window-technique-a-comprehensive-guide)

1. **Fixed-size window:**

   - Slide a window of fixed size across the array/string
   - Useful for problems where the subarray/substring size is given
   - Example: `Finding the maximum sum subarray of a fixed size`

   **How it works:**

   - Initialize the window sum with the first k elements
   - Slide the window by one position at a time:
     - Add the next element to the sum
     - Subtract the first element of the previous window
   - Keep track of the maximum sum encountered

2. **Variable-size window:**

   - Use two pointers (start and end) to define the window
   - Expand or contract the window based on certain conditions
   - Useful for problems where you need to find a subarray/substring that satisfies certain criteria
   - Example: `Finding the longest substring without repeating characters`

   **How it works:**

   - Start with both pointers at the beginning
   - Expand the window (move end pointer) until a condition is violated
   - Contract the window (move start pointer) until the condition is satisfied again
   - Update the result if necessary
   - Repeat until the end pointer reaches the end of the array/string

3. **Window with Auxiliary Data Structure:**

   - Use a hash map or set to keep track of elements in the current window
   - Useful for problems involving unique elements or frequency counts
   - Example: `Finding the longest substring with at most K distinct characters`

   **How it works:**

   - Use a hash map to store character frequencies
   - Expand the window and update the hash map
   - If the number of distinct characters exceeds K, contract the window
   - Update the hash map as you contract
   - Keep track of the longest valid substring

4. **Sliding Window with a Counter:**

   - Maintain a counter for a specific condition
   - Update the counter as you slide the window
   - Useful for problems involving counting or finding occurrences
   - Example: `Finding the number of subarrays with K different integers`

   **How it works:**

   - Use a counter to keep track of a specific condition (e.g., number of unique elements)
   - Expand the window and update the counter
   - If the condition is met, update the result
   - Contract the window if necessary and update the counter
   - Continue this process until the end of the array/string is reached

#### LeetCode Problems

1. **Fixed Window Size:**

   - LeetCode 643: Maximum Average Subarray I
   - LeetCode 1343: Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold

2. **Variable Window Size:**

   - LeetCode 3: Longest Substring Without Repeating Characters
   - LeetCode 76: Minimum Window Substring
   - LeetCode 209: Minimum Size Subarray Sum
   - LeetCode 424: Longest Repeating Character Replacement

3. **Window with Auxiliary Data Structure:**

   - LeetCode 159: Longest Substring with At Most Two Distinct Characters
   - LeetCode 340: Longest Substring with At Most K Distinct Characters
   - LeetCode 438: Find All Anagrams in a String

4. **Sliding Window with a Counter:**
   - LeetCode 239: Sliding Window Maximum
   - LeetCode 567: Permutation in String
   - LeetCode 1004: Max Consecutive Ones III

# Stack Techniques

1. **Monotonic Stack**

   - A stack that maintains elements in a strictly increasing or decreasing order
   - Used for problems involving finding the next greater/smaller element or calculating spans

   **How it works:**

   - Iterate through the elements
   - For each element, pop elements from the stack that violate the monotonic property
   - Push the current element onto the stack
   - The elements remaining in the stack after processing all elements often represent the solution

2. **Paired Brackets Matching**

   - Used for validating or processing strings with paired brackets or parentheses

   **How it works:**

   - Push opening brackets onto the stack
   - When encountering a closing bracket, check if it matches the top of the stack
   - If it matches, pop the top element; if not, the string is invalid
   - After processing all characters, the stack should be empty for a valid string

3. **Expression Evaluation**

   - Used for evaluating arithmetic expressions, especially those in Reverse Polish Notation (RPN)

   **How it works:**

   - For RPN: Push operands onto the stack
   - When an operator is encountered, pop the required number of operands, apply the operator, and push the result back
   - The final result is the top of the stack after processing all tokens

4. **Backtracking with Stack**

   - Used for problems that require exploring paths or combinations with the ability to backtrack

   **How it works:**

   - Push states or choices onto the stack as you explore
   - When backtracking, pop the stack to return to the previous state
   - Continue until all possibilities are explored

5. **Stack for Tree Traversal**

   - Used for implementing iterative versions of tree traversal algorithms

   **How it works:**

   - Push nodes onto the stack as you traverse
   - Pop nodes to process them
   - The order of pushing and processing determines the type of traversal (in-order, pre-order, post-order)

# Binary Search Techniques

1. **Basic Binary Search**

   **Technique**

   Search a sorted array by repeatedly dividing the search interval in half.

   **How it works**

   - [Binary Search Patterns](<https://leetcode.com/discuss/interview-question/1322500/5-variations-of-Binary-search-(A-Self-Note)>)

   **Common Applications**

   - Searching in sorted arrays
   - Implementing lower_bound and upper_bound

2. **Binary Search on Answer**

   **Technique**
   Use binary search to find an answer that satisfies certain conditions.

   **How it works**

   - Define a range where the answer must lie
   - Use binary search to narrow down the correct answer
   - Check if the mid value satisfies the problem conditions

   **Common Applications**

   - Minimizing maximum or maximizing minimum problems
   - Finding the Kth element in sorted arrays

3. **Binary Search on Floating Point Numbers**

   **Technique**
   Apply binary search to a continuous range of real numbers.

   **How it works**

   - Define a precision (epsilon)
   - Continue binary search until the range is smaller than the precision

   **Common Applications**

   - Finding square roots
   - Optimization problems with continuous domains

4. **Binary Search in Rotated Sorted Array**

   **Technique**
   Modify binary search to work on a sorted array that has been rotated.

   **How it works**

   - Find the pivot point where rotation occurs
   - Perform binary search on the appropriate half of the array

   **Common Applications**

   - Searching in rotated sorted arrays
   - Finding minimum in rotated sorted array

5. **Binary Search on Monotonic Functions**

   **Technique**
   Apply binary search to find roots or extrema of monotonic functions.

   **How it works**

   - Define the function and its monotonic property
   - Use binary search to narrow down the point where the function changes sign or reaches extremum

   **Common Applications**

   - Finding peaks in bitonic arrays
   - Optimization problems

6. **Multi-dimensional Binary Search**

   **Technique**
   Apply binary search on multiple dimensions or parameters simultaneously.

   **How it works**

   - Perform binary search on one dimension
   - For each step, solve a subproblem in other dimensions

   **Common Applications**

   - Median of two sorted arrays
   - Searching in sorted 2D matrices

7. **Binary Search with Prefix Sums**

   **Technique**
   Combine binary search with prefix sum array for range queries.

   **How it works**

   - Precompute prefix sum array
   - Use binary search to find appropriate ranges in the prefix sum array

   **Common Applications**

   - Finding subarrays with sum closest to a target
   - Optimizing subarray-related problems

### General Approach to Binary Search Problems

1. **Identify if binary search is applicable:**

   - Look for sorted data or monotonic properties
   - Consider if the problem involves finding a specific value or optimizing some condition

2. **Define the search space:**

   - Determine the range where the answer must lie
   - For arrays, this is typically the index range
   - For "search on answer" problems, define reasonable lower and upper bounds

3. **Implement the basic binary search structure:**

   - Choose between recursive and iterative implementations
   - Be careful with integer overflow when calculating mid point

4. **Define the condition to check at each step:**

   - This is crucial for "search on answer" problems
   - Ensure the condition correctly divides the search space

5. **Handle edge cases:**
   - Empty arrays
   - Single-element arrays
   - Target values at the boundaries of the search space

# Linked List Techniques

1. **Two-Pointer Technique**

   - Uses two pointers moving at different speeds or starting at different positions
   - Useful for detecting cycles, finding middle elements, or identifying intersections

   **How it works:**

   - Initialize two pointers, often called "slow" and "fast"
   - Move the pointers through the list at different rates
   - The relative position or meeting point of the pointers provides the solution

2. **Dummy Node**

   - Uses a dummy node as the head of the list to simplify edge cases
   - Particularly useful in problems involving list manipulation or merging

   **How it works:**

   - Create a dummy node and set it as the head of the new list
   - Perform operations on the list, starting from the dummy node
   - Return the next node of the dummy node as the head of the resulting list

3. **Reverse Linked List**

   - A fundamental operation used in many linked list problems
   - Can be done iteratively or recursively

   **How it works:**

   - _Iterative:_ Use three pointers (prev, current, next) to reverse links as you traverse
   - _Recursive:_ Recursively reverse the rest of the list and fix the head

4. **Merge Lists**

   - Combines two or more sorted linked lists into a single sorted list
   - Often used as a subproblem in more complex list manipulations

   **How it works:**

   - Compare the heads of the lists
   - Choose the smaller head and move it to the result list
   - Repeat until all lists are exhausted

5. **Fast and Slow Pointers**

   - A specific application of the two-pointer technique
   - Used for finding the middle of the list, detecting cycles, or finding the nth node from the end

   **How it works:**

   - Initialize two pointers, with the fast pointer moving twice as fast as the slow pointer
   - When the fast pointer reaches the end, the slow pointer will be at the middle

6. **Sentinel Node**

   - Similar to the dummy node, used to simplify edge cases
   - Particularly useful in problems involving deletion or insertion

   **How it works:**

   - Create a sentinel node and link it to the head of the list
   - Perform operations on the list, treating the sentinel as the start
   - Remove the sentinel node at the end if necessary


# Tree Techniques

```
       1
     /   \
    2     3
   / \   / \
  4   5 6   7
  
```

## Traditional Traversals

### Inorder Traversal

- **Order**: `Visit left subtree → Node → Right subtree`
- **Output**: 4 2 5 1 6 3 7

### Preorder Traversal

- **Order**: `Visit node → Left subtree → Right subtree`
- **Output**: 1 2 4 5 3 6 7

### Postorder Traversal

- **Order**: `Visit left subtree → Right subtree → Node`
- **Output**: 4 5 2 6 7 3 1

### Level Order Traversal

- **Order**: `Visit nodes level by level from root to leaves`
- **Output**: 1 2 3 4 5 6 7

## Reversed Traversals

### Reversed Inorder Traversal

- **Order**: `Visit right subtree → Node → Left subtree`
- **Output**: 7 3 6 1 5 2 4

### Reversed Preorder Traversal

- **Order**: `Visit node → Right subtree → Left subtree`
- **Output**: 1 3 7 6 2 5 4

### Reversed Postorder Traversal

- **Order**: `Visit right subtree → Left subtree → Node`
- **Output**: 7 6 3 5 4 2 1

### Reversed Level Order Traversal

- **Order**: `Visit nodes level by level from leaves to root, left to right at each level`
- **Output**: 4 5 6 7 2 3 1



### Tree Problem Categories

1. **Tree Traversal**
   - **Preorder Traversal**: Visit the root, then left subtree, then right subtree.
   - **Inorder Traversal**: Visit the left subtree, then root, then right subtree.
   - **Postorder Traversal**: Visit the left subtree, then right subtree, then root.
   - **Level Order Traversal**: Visit nodes level by level from top to bottom.

2. **Binary Search Tree (BST) Problems**
   - **Insertion and Deletion**: Adding or removing nodes while maintaining the BST property.
   - **Searching**: Finding a specific value or node.
   - **Validation**: Checking if a tree is a valid BST.
   - **Finding the Lowest Common Ancestor (LCA)**: Finding the common ancestor of two nodes in a BST.
   - **Converting Sorted Array to BST**: Creating a balanced BST from a sorted array.

3. **Binary Tree Properties**
   - **Height and Depth**: Calculating the height or depth of the tree.
   - **Diameter**: Finding the longest path between any two nodes.
   - **Symmetry**: Checking if a tree is symmetric (mirror image of itself).
   - **Balanced Tree**: Checking if the tree is height-balanced.

4. **Tree Construction**
   - **Constructing from Traversal Orders**: Building a tree from preorder and inorder, or postorder and inorder traversals.
   - **Constructing from Serialization**: Reconstructing a tree from a serialized format (like in a string).

5. **Tree Algorithms**
   - **Depth-First Search (DFS)**: Using recursion or stack-based approach.
   - **Breadth-First Search (BFS)**: Using queue-based approach.
   - **Lowest Common Ancestor (LCA)**: Finding the LCA in different types of trees (BST, general trees).

6. **Tree Modifications**
   - **Flattening**: Converting a binary tree to a linked list.
   - **Invert/Reverse**: Flipping the tree upside down.
   - **Merge Trees**: Combining two trees into one.

7. **Special Trees**
   - **N-ary Trees**: Handling trees where each node can have more than two children.
   - **Trie (Prefix Tree)**: Insertion, search, and deletion operations.

8. **Advanced Tree Problems**
   - **Segment Tree**: For range queries and updates.
   - **Fenwick Tree (Binary Indexed Tree)**: For cumulative frequency tables.
   - **Suffix Tree and Suffix Array**: For string processing problems.


# Heap and Priority Queue Techniques

1. **Basic Heap Operations**

   **Concept**

   A heap is a specialized tree-based data structure that satisfies the heap property. In a max heap, for any given node, the node's value is greater than or equal to the values of its children. In a min heap, the node's value is less than or equal to the values of its children.

   **Key Operations**

   - Insertion: O(log n)
   - Deletion of top element: O(log n)
   - Peek top element: O(1)
   - Heapify (building a heap from an array): O(n)

   **How it works**

   - Heaps are typically implemented as arrays, where for any element at index i:
   - Its left child is at index 2i + 1
   - Its right child is at index 2i + 2
   - Its parent is at index (i - 1) / 2
   - When inserting or deleting, the heap property is maintained by "bubbling up" or "sinking down" elements.

2. **K-th Largest/Smallest Element**

   **Technique**

   Use a min heap for K-th largest, or a max heap for K-th smallest.

   **How it works**

   - For K-th largest:

   1. Maintain a min heap of size K.
   2. Iterate through all elements:
      - If heap size < K, add the element.
      - If current element > heap top, remove top and add current element.
   3. The top of the heap is the K-th largest element.

3. **Merge K Sorted Lists/Arrays**

   **Technique**

   Use a min heap to efficiently merge multiple sorted sequences.

   **How it works**

   1. Create a min heap and insert the first element from each list along with its list identifier.
   2. While the heap is not empty:

   - Extract the minimum element (this is the next element in the merged sequence).
   - If the list this element came from is not exhausted, insert its next element into the heap.

   3. Time complexity: O(N log K), where N is the total number of elements and K is the number of lists.

4. **Sliding Window Problems**

   **Technique**
   Use a heap to maintain the maximum or minimum within a sliding window.

   **How it works**

   1. Use a heap to store elements within the current window.
   2. As the window slides:

   - Remove elements that are no longer in the window.
   - Add the new element entering the window.
   - The top of the heap represents the max/min of the current window.

   3. To handle element removal efficiently, you might need to pair each value with its index in the heap.

5. **Top K Frequent Elements**

   **Technique**

   Use a hash map for counting and a heap for selecting top K.

   **How it works**

   1. Use a hash map to count the frequency of each element.
   2. Use a min heap of size K to keep track of the K most frequent elements:
      - If heap size < K, add the element.
      - If current element's frequency > heap top's frequency, remove top and add current element.
   3. The heap will contain the K most frequent elements.
   4. Time complexity: O(N log K), where N is the number of elements.

6. **Median in a Stream of Integers**

   **Technique**

   Use two heaps: a max heap for the lower half and a min heap for the upper half.

   **How it works**

   1. Maintain two heaps:

   - A max heap for the lower half of the numbers.
   - A min heap for the upper half of the numbers.

   2. Balance the heaps so their sizes differ by at most 1.
   3. When a new number comes in:

   - Add to the appropriate heap.
   - Rebalance if necessary by moving the top element from one heap to the other.

   4. The median is either the top of the max heap (if it's larger) or the average of both tops.

7. **Dijkstra's Algorithm (Shortest Path)**

   **Technique**
   Use a min heap (priority queue) to always process the vertex with the smallest known distance.

   **How it works**

   1. Initialize distances to all vertices as infinite, except the start vertex (distance = 0).
   2. Push the start vertex into the min heap.
   3. While the heap is not empty:

   - Extract the vertex with minimum distance.
   - For each neighbor of this vertex:
     - Calculate the distance through the current vertex.
     - If this distance is less than the previously known distance, update it and push the neighbor onto the heap.

   4. Time complexity: O((V + E) log V), where V is the number of vertices and E is the number of edges.


### General Approach to Heap/Priority Queue Problems

1. **Identify if a heap is suitable:**

   - Problems involving finding top K elements, sorting, or maintaining a dynamic set of elements where you frequently need the max/min.

2. **Choose between min heap and max heap:**

   - Min heap for problems where you need to repeatedly find and remove the smallest element.
   - Max heap for problems where you need to repeatedly find and remove the largest element.

3. **Consider using two heaps:**

   - Useful for problems like finding the median in a stream of numbers.

4. **Pair values with additional information:**

   - Often useful to store pairs (value, index) or (value, frequency) in the heap.

5. **Be mindful of time complexity:**

   - Insertion and deletion operations are O(log n), where n is the size of the heap.
   - Building a heap from an array is O(n).

6. **Use with other data structures:**

   - Heaps are often used in combination with hash maps, especially for frequency-based problems.

7. **Custom comparators:**

   - For complex objects, define custom comparison logic to determine heap ordering.

8. **Lazy deletion:**

   - In some cases, it's more efficient to mark elements as deleted rather than removing them immediately.

9. **Space-time trade-off:**

   - Heaps can often provide a good balance between time efficiency and space usage.

10. **Practice and learn patterns:**
    - Many heap problems share similar structures. Recognizing these patterns can speed up problem-solving.

# Backtracking Techniques

1. **Basic Backtracking Structure**

   **How it works:**

   - Start with an initial state or partial solution.
   - Recursively explore possible candidates to build the solution.
   - If a candidate leads to a valid solution, add it to the result.
   - If a candidate doesn't lead to a valid solution, backtrack (undo the last choice) and try the next candidate.
   - Continue this process until all possibilities have been explored.

   The key components are:

   1. A method to check if the current state is a valid solution.
   2. A way to generate candidate choices for the next step.
   3. A mechanism to apply and undo changes to the current state.
   4. A recursive function that ties all these components together.

2. **Pruning in Backtracking**

   **How it works**

   - Before fully exploring a branch, check if it can potentially lead to a valid solution.
   - If the branch cannot possibly lead to a valid solution, skip it entirely.
   - This is typically implemented by adding conditions before the recursive call.
   - Pruning can significantly reduce the number of explored states, improving efficiency.

3. **State Space Tree**

   **How it works**

   - Conceptualize the problem as a tree where:
   - Each node represents a partial solution or state.
   - Edges represent choices or decisions.
   - Leaf nodes are either complete solutions or dead ends.
   - Traverse this tree using depth-first search.
   - Backtracking occurs when you reach a leaf node and need to explore other branches.

4. **Backtracking with Memoization**

   **How it works:**

   - Combine backtracking with dynamic programming techniques.
   - Store the results of subproblems in a data structure (often a hash map).
   - Before solving a subproblem, check if its result is already stored.
   - If found, use the stored result instead of recomputing.
   - This optimization is particularly useful when the same subproblems are encountered multiple times during backtracking.

5. **Iterative Backtracking**

   **How it works:**

   - Instead of using recursion, use a stack to manage the states.
   - Push initial state onto the stack.
   - While the stack is not empty:
   - Pop a state from the stack.
   - If it's a solution, process it.
   - If not, generate new candidate states and push them onto the stack.
   - This approach avoids potential stack overflow issues in deep recursions.
   - It can be more complex to implement but may be necessary for very deep search trees.

### General Approach to Backtracking Problems

1. **Identify the problem structure:**

   - Determine if the problem requires finding all solutions or just one
   - Identify the constraints and validity conditions

2. **Define the state:**

   - Determine what information needs to be maintained in each state
   - Design a suitable data structure to represent the state

3. **Implement the backtracking function:**

   - Define base cases (solution found or dead end)
   - Implement the recursive exploration of possibilities

4. **Optimize with pruning:**

   - Identify conditions that allow early termination of a branch
   - Implement checks to skip invalid paths early

5. **Consider time and space complexity:**

   - Analyze the branching factor and depth of the search tree
   - Look for opportunities to reduce redundant computations

6. **Test with small examples:**

   - Verify the algorithm with simple, known cases
   - Gradually increase complexity to test robustness

7. **Debug systematically:**

   - Use print statements or debuggers to visualize the backtracking process
   - Verify that all valid solutions are being generated and no invalid ones are included

8. **Consider iterative implementation:**

   - If stack overflow is a concern, convert the recursive solution to an iterative one

9. **Optimize for specific problem requirements:**

   - If only one solution is needed, consider adding early termination
   - If counting solutions is sufficient, avoid storing all solutions explicitly

10. **Practice and learn patterns:**
    - Many backtracking problems share similar structures
    - Recognizing these patterns can speed up problem-solving in the future

# Graph Techniques

1. **Graph Representation**

   **Techniques**

   - Adjacency Matrix
   - Adjacency List

   **How it works**

   - Adjacency Matrix: 2D array where matrix[i][j] indicates an edge from i to j
   - Adjacency List: Array of lists where list[i] contains nodes adjacent to node i

   **Common Applications**

   - Dense graphs (Adjacency Matrix)
   - Sparse graphs (Adjacency List)

2. **Depth-First Search (DFS)**

   **Technique**
   Explore as far as possible along each branch before backtracking.

   **How it works**

   - Use recursion to visit all neighbors of a node
   - Keep track of visited nodes to avoid cycles
   - Process each node once

   **Common Applications**

   - Topological sorting
   - Cycle detection
   - Path finding

3. **Breadth-First Search (BFS)**

   **Technique**
   Explore all neighbor nodes at the present depth before moving to nodes at the next depth level.

   **How it works**

   - Use a queue to store nodes at each level
   - Process nodes in the order they were added to the queue
   - Keep track of visited nodes to avoid revisiting

   **Common Applications**

   - Shortest path in unweighted graphs
   - Level-order traversal
   - Finding connected components

4. **Dijkstra's Algorithm**

   **Technique**
   Find the shortest path between nodes in a weighted graph.

   **How it works**

   - Use a priority queue to select the node with the smallest tentative distance
   - Update distances to all adjacent nodes
   - Repeat until all nodes are visited

   **Common Applications**

   - Shortest path problems
   - Network routing protocols

5. **Union-Find (Disjoint Set)**

   **Technique:**
   Efficiently keep track of a partition of a set into disjoint subsets.

   **How it works**

   - Implement `find` and `union` operations
   - Use path compression and union by rank for optimization

   **Common Applications**

   - Kruskal's algorithm for Minimum Spanning Tree
   - Detecting cycles in undirected graphs

6. **Topological Sort**

   **Technique**
   Linear ordering of vertices such that for every directed edge (u, v), vertex u comes before v in the ordering.

   **How it works**

   - Use DFS and stack to store nodes in reverse finishing time
   - Alternatively, use Kahn's algorithm with in-degree tracking

   **Common Applications**

   - Dependency resolution
   - Task scheduling

7. **Strongly Connected Components**

   **Technique**
   Find maximal strongly connected subgraphs.

   **How it works**

   - Kosaraju's algorithm: Perform DFS, reverse graph, perform DFS again
   - Tarjan's algorithm: Single DFS with lowlink values

   **Common Applications**

   - Social network analysis
   - Compiler optimization

8. **Minimum Spanning Tree**

   **Techniques**

   - Kruskal's Algorithm
   - Prim's Algorithm

   **How it works**

   - Kruskal's: Sort edges, add if no cycle formed
   - Prim's: Grow tree from a starting vertex, always adding the cheapest edge

   **Common Applications**

   - Network design
   - Cluster analysis

### General Approach to Graph Problems

1. **Choose appropriate representation:**

   - Adjacency list for sparse graphs
   - Adjacency matrix for dense graphs or when quick edge lookup is needed

2. **Identify the problem type:**

   - Traversal, shortest path, connectivity, etc.
   - This helps in choosing the right algorithm

3. **Consider graph properties:**

   - Directed vs undirected
   - Weighted vs unweighted
   - Cyclic vs acyclic

4. **Implement basic graph operations:**

   - Adding edges, checking for adjacency, etc.

5. **Choose the right algorithm:**

   - DFS for exploring all paths or topological sorting
   - BFS for shortest path in unweighted graphs
   - Dijkstra's for shortest path in weighted graphs

6. **Handle edge cases:**

   - Empty graph
   - Graph with one node
   - Disconnected graphs

7. **Optimize for space and time:**

   - Consider iterative vs recursive implementations
   - Use appropriate data structures (e.g., priority queues for Dijkstra's)

8. **Debug systematically:**

   - Use small, simple graphs to test your algorithm
   - Visualize the graph and algorithm steps

9. **Consider problem-specific optimizations:**

   - Can you preprocess the graph?
   - Are there any special properties you can exploit?

10. **Practice and learn patterns:**
    - Many graph problems share similar structures
    - Recognizing these patterns can speed up problem-solving

# Bit Manipulation

### Bitwise effects on numbers

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

### Check if a Number is Even or Odd

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

### Toggle a Specific Bit

`It means doing NOT operation at a specific bit position(using XOR ^)`

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

### Set a Specific Bit

`It means setting 1 at a specific bit position (using OR | )`


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

### clear a Specific Bit

`It means setting 0 at a specific bit position (using AND and Complement )`

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

### Count the Number of Set Bits (Hamming Weight)

```java

// Input Examples:
// countSetBits(7):
// 7 in binary: 0111
// Number of 1's: 3

// countSetBits(10):
// 10 in binary: 1010
// Number of 1's: 2

public int countSetBits(int number) {
    int count = 0;
    while (number != 0) {
        count += (number & 1);
        number >>= 1;
    }
    return count;
}

```

### Find the Position of the Rightmost Set Bit

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

### Check if a Number is a Power of Two

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

### Swap Two Numbers Without Using a Temporary Variable

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

### Reverse Bits of an Integer

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

### Determine if Two Integers Have Opposite Signs

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

# Matrix

### Basic Directions (left, right, top, down)

- `{0, 1}` : Represents movement to the right
- `{0, -1}`: Represents movement to the left
- `{1, 0}` : Represents movement downwards
- `{-1, 0}`: Represents movement upwards

### Additional diagonal movements

- `{1, 1}` : Represents movement diagonally down and to the right
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

`P(n, r) = (n−r)! / n!` where n is the total number of items and r is the number of items to choose from the total.
Permutations of 2 letters from ABC : `P(3, 2) = (3−2)! / 3! = 3×2×1 = 6`
The permutations are : `AB, BA, AC, CA, BC, CB`

# Combinations

`C(n, r) = n! / (r! × (n−r)!)`
Combinations of 2 letters from ABC : `C(3, 2) = 3! / ( 2! × (3−2)! ) = 3×2×1 / (2×1×1) = 3`
The combinations are : `AB, AC, BC`
