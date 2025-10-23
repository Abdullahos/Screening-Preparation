# 🧠 Dynamic Programming (DP) Design Cheat Sheet

> **Goal:** Turn a brute-force / backtracking idea into an efficient DP
> solution by identifying what matters in each decision.

------------------------------------------------------------------------

## 🚩 Step 1: Define the "Decision Process"

Ask yourself:\
\> "At any point in my recursion, what *choices* do I have?"

**Examples:** - 0/1 Knapsack → take or skip the current item.\
- Partition Equal Subset → include or exclude current number.\
- LIS → pick a number or skip it if it breaks increasing order.\
- Coin Change → use current coin or move to next denomination.

👉 Each choice leads to a smaller subproblem.

------------------------------------------------------------------------

## 🧩 Step 2: Identify the **State**

The *state* defines **where you are** in the decision process.\
It's the minimal set of variables that uniquely represent your progress.

Ask:\
\> "If I froze recursion right now, what information would I need to
resume it later?"

**Common state dimensions:**

  Problem Type                       Typical State Variables
  ---------------------------------- --------------------------
  Subset / Knapsack                  `(index, currentSum)`
  Sequence DP (LIS, Edit Distance)   `(i, j)` (two pointers)
  Grid Problems                      `(row, col)`
  String Problems                    `(index1, index2)`
  Interval DP                        `(start, end)`
  Counting Paths                     `(i, j, remainingSteps)`

💡 **Rule of Thumb:**\
If two recursive calls have the same parameter values and will always
produce the same result, that's what you memoize.

------------------------------------------------------------------------

## 🎯 Step 3: Define the **Transition**

Ask:\
\> "From this state, how do I move to the next one?"

This comes straight from your recursive relation.

**Example -- subset sum:**

``` java
include = dfs(idx + 1, acc + nums[idx])
exclude = dfs(idx + 1, acc)
```

That gives you your transition rule:

    dp[idx][acc] = dp[idx + 1][acc] || dp[idx + 1][acc + nums[idx]]

------------------------------------------------------------------------

## 🧮 Step 4: Base Case

Think:\
\> "When does recursion stop and return a known answer?"

**Examples:** - Reached end of array.\
- Target sum reached.\
- One string fully processed.

Base cases define the *bottom row / column* of your DP table.

------------------------------------------------------------------------

## 🪣 Step 5: Choose DP Type

  -----------------------------------------------------------------------------
  Type              When to Use                  How it Builds
  ----------------- ---------------------------- ------------------------------
  **Top-Down        You already have recursion   Add a cache (`Map` or array)
  (Memoization)**   working                      

  **Bottom-Up       You understand state         Fill dp\[\]\[\] iteratively
  (Tabulation)**    transitions clearly          
  -----------------------------------------------------------------------------

💡 **Tip:**\
Start top-down for intuition → then refactor to bottom-up if needed.

------------------------------------------------------------------------

## 🧠 Step 6: Optimize Space (optional)

Once you've got a correct table:\
- Ask which dimensions really depend on the previous row/state.\
- You can often reduce from `O(n * m)` → `O(m)` by rolling arrays.

**Example:**

``` java
boolean[] dp = new boolean[target + 1];
```

------------------------------------------------------------------------

## 🚀 Quick "DP Checklist"

✅ Define what the function means (e.g., `dfs(i, sum)` → can we reach
`sum` starting at `i`?)\
✅ Find the state variables that fully describe progress.\
✅ Write recurrence relation (transition).\
✅ Set base cases.\
✅ Memoize or tabulate.\
✅ (Optional) Optimize space.

------------------------------------------------------------------------

## ⚡ Bonus: Red Flags of Overengineering DP

❌ Adding unnecessary parameters that can be derived from others.\
❌ Memoizing every variable instead of only the minimal state.\
❌ Storing path information when you only need boolean or count.\
❌ Building 3D DP when 2D suffices.

👉 *If you can explain your recursion in one short sentence, your state
is probably minimal.*
