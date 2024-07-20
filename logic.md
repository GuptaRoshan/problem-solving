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


