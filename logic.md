# Loop Constructs

## Nested Loop Comparison Techniques

### Standard comparisons

```java

int[] arr = {-2, 45, 0, 11, -9, 8, 1, 90};
int size = arr.length;

// Inner loop skips the last element (size - 1)
for (int i = 0; i < size - 1; i++) {
    // Skips the last element (size - 1) and ith numbers ((size - 1) - i)
    for (int j = 0; j < (size - 1) - i; j++) {
        if (arr[j] > arr[j + 1]) {
            // Swap elements if needed
        }
    }
}

```


### Bubble Sort Comparison

```java

int[] arr = {-2, 45, 0, 11, -9, 8, 1, 90};
int size = arr.length;

// Inner loop starts from the first element
for (int i = 1; i < size; i++) {
        // Last element is in the correct position, reduce the space by ith times
        for (int j = 1; j < size - i; j++) {
            // Swap elements if needed
           if (arr[j - 1] > arr[j]) { }
     }
 }

```


### Step ahead

```java

int[] arr = {-2, 45, 0, 11, -9, 8, 1, 90};
int size = arr.length;

// Inner loop skips the last element (size - 1)
for (int i = 0; i < size - 1; i++) {
        // Outer loop starts one step ahead of the inner loop
        for (int j = i + 1; j < size; j++) {
        // Perform comparison or other operations
        }
 }


```


### Backward Comparison

```java

int[] arr = {-2, 45, 0, 11, -9, 8, 1, 90};
int size = arr.length;

// Inner loop starts from the first element
for (int i = 1; i < size; i++) {
    // Outer loop runs backward from the previous position of i
    int j = i - 1;
    while (j >= 0) {
        // Perform backward comparison or other operations
        --j;
    }
}

```


### Bucket Sort bucket distributions

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