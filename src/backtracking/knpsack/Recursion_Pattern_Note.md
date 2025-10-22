## 🧠 Recursion Pattern Note --- `for (int i = start; i < n; i++)`

### 🔍 Overview

In recursive algorithms, the pattern you choose for iterating or
branching greatly affects both **correctness** and **complexity**.\
One common confusion is when to use a `for` loop (e.g.,
`for (int i = start; i < n; i++)`) versus when to make a **direct
include/exclude** recursive call.

This note helps clarify the difference. 👇

------------------------------------------------------------------------

### 🚀 Pattern 1: *Include/Exclude* (No Loop)

**Used for:**\
Problems where you make a **binary decision** at each step --- usually
choosing whether to include or exclude an element.

**Examples:** - 0/1 Knapsack\
- Subset Sum\
- Decision Tree Problems

**Pattern:**

``` java
void solve(int[] arr, int index) {
    if (index == arr.length) return;

    // Include current element
    solve(arr, index + 1);

    // Exclude current element
    solve(arr, index + 1);
}
```

**Explanation:**\
Each recursive level corresponds to a specific element, and you always
move linearly forward (`index + 1`).\
There's **no need for a loop**, since recursion already explores all
possibilities.

------------------------------------------------------------------------

### 🌿 Pattern 2: *Combination/Subset Generation* (With Loop)

**Used for:**\
Problems where you can choose **any element from the remaining range**,
not just the next one.\
You're essentially exploring *all combinations* or *all subsequences*.

**Examples:** - Generating all subsets (power set)\
- Combination Sum\
- N-Queens\
- Permutations (with variations)

**Pattern:**

``` java
void generate(int[] arr, int start, List<Integer> path) {
    result.add(new ArrayList<>(path));

    for (int i = start; i < arr.length; i++) {
        path.add(arr[i]);
        generate(arr, i + 1, path);  // explore with next starting point
        path.remove(path.size() - 1);
    }
}
```

**Explanation:**\
The `for` loop allows you to explore all *future choices* from the
current position.\
Each recursive call starts from `i + 1`, ensuring combinations are built
in order and without duplicates.

------------------------------------------------------------------------

### ⚖️ Summary

  --------------------------------------------------------------------------------
  Pattern                When to Use           Loop?      Example Problem
  ---------------------- --------------------- ---------- ------------------------
  **Include/Exclude**    One decision per      ❌ No      0/1 Knapsack
                         element                          

  **Combination/Subset   Choose any remaining  ✅ Yes     Power Set, Combination
  Generation**           element                          Sum
  --------------------------------------------------------------------------------

------------------------------------------------------------------------

### 💡 Tip

If each recursive step represents *a single element*, skip the loop.\
If each step represents *a choice among remaining elements*, use the
loop.
