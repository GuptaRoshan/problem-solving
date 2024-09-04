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