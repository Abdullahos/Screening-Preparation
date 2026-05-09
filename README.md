# My general FAANG-style screening preparationg activity.

Now it contains only LC style problems under the src directory organized by pattern/datastructre.

The algorithms used to solve problems in the `/src` directory are:

*   Dynamic Programming (dp)
*   Breadth-First Search (bfs)
*   Depth-First Search (dfs)
*   SQL
*   Tree
*   Trie
*   Graph
*   Queue
*   Stack
*   Arrays
*   Design Patterns
*   Greedy Algorithms
*   Bitwise Operations
*   Prefix Sum
*   Linked List
*   Two-Dimensional Matrix
*   Two Pointers
*   Backtracking
*   Binary Search
*   Sliding Window
*   Kahn's Algorithm
*   Topological Sort
*   String Manipulation
*   Boyer-Moore Voting Algorithm


Dynamic Programming (DP)
What it is

Solve problems by breaking them into overlapping subproblems and storing results to avoid recomputation.

Core patterns
1D DP
2D DP
Knapsack
Interval DP
State machine DP
Famous problems
Climbing Stairs
House Robber
Coin Change
Longest Increasing Subsequence
Edit Distance
Decode Ways
Solution Files:
*   [JumpGame.java](src/dp/JumpGame.java)
*   [JumpGame2.java](src/dp/JumpGame2.java)
*   [JumpGame3.java](src/dp/JumpGame3.java)
*   [JumpGame4.java](src/dp/JumpGame4.java)
*   [coinChanges.java](src/dp/coinChanges.java)
*   [ClimbingStairs.java](src/dp/ClimbingStairs.java)
*   [SpecialTriplet.java](src/dp/SpecialTriplet.java)
*   [countPartitions.java](src/dp/countPartitions.java)
*   [MinCostClimbingStairs.java](src/dp/MinCostClimbingStairs.java)
*   [MinCostToSplitIntoOnes.java](src/dp/MinCostToSplitIntoOnes.java)
*   [_3d/MaxPathScore.java](src/dp/_3d/MaxPathScore.java)

Breadth-First Search (BFS)
What it is

Traverses level by level using a queue.

Used for
Shortest path in unweighted graphs
Level-order traversal
Famous problems
Binary Tree Level Order Traversal
Rotting Oranges
Word Ladder
Solution Files:
*   [PacificAtlantic.java](src/bfs/PacificAtlantic.java)

Depth-First Search (DFS)
What it is

Explore deeply before backtracking.

Used for
Graph traversal
Connected components
Recursive tree problems
Famous problems
Number of Islands
Clone Graph
Course Schedule
Solution Files:
*   [CountingIslands.java](src/dfs/CountingIslands.java)
*   [CanFinishAllCourses.java](src/dfs/CanFinishAllCourses.java)

SQL
What it is

Querying and manipulating relational data.

Key concepts
Joins
Window functions
Aggregation
CTEs
Famous problems
Second Highest Salary
Rank Scores
Department Top Three Salaries
Solution Files:
*   [monthly-transactions.sql](src/sql/monthly-transactions.sql)
*   [average_selling_price.sql](src/sql/average_selling_price.sql)
*   [students_and_examinations.sql](src/sql/students_and_examinations.sql)
*   [product-sales-analysis-iii.sql](src/sql/product-sales-analysis-iii.sql)
*   [percentage_of_user_attends_context.sql](src/sql/percentage_of_user_attends_context.sql)
*   [user-activity-for-the-past-30-days-i.sql](src/sql/user-activity-for-the-past-30-days-i.sql)

Trees
What it is

Hierarchical data structure.

Key concepts
Traversals
BST
Balancing
Recursion
Famous problems
Validate Binary Search Tree
Lowest Common Ancestor
Serialize and Deserialize Binary Tree
Solution Files:
*   [Successor.java](src/tree/Successor.java)
*   [Sysmetric.java](src/tree/Sysmetric.java)
*   [IsBalanced.java](src/tree/IsBalanced.java)
*   [MinimalTree.java](src/tree/MinimalTree.java)
*   [ValidateBST.java](src/tree/ValidateBST.java)
*   [ListOfDepths.java](src/tree/ListOfDepths.java)
*   [CheckBalanced.java](src/tree/CheckBalanced.java)
*   [RightSideView.java](src/tree/RightSideView.java)
*   [LevelOrderTraversal.java](src/tree/LevelOrderTraversal.java)
*   [ValidateBinarySearchTree101.java](src/tree/ValidateBinarySearchTree101.java)
*   [BinaryTreeZigzagLevelOrderTraversal.java](src/tree/BinaryTreeZigzagLevelOrderTraversal.java)

Trie
What it is

Prefix tree for string lookup.

Used for
Autocomplete
Prefix matching
Famous problems
Implement Trie
Word Search II
Solution Files:
*   [Trie.java](src/trie/Trie.java)
*   [LongestDictionaryWord.java](src/trie/LongestDictionaryWord.java)

Graph
What it is

Nodes + edges relationships.

Core concepts
Traversal
Cycle detection
Shortest path
Famous problems
Network Delay Time
Redundant Connection
Solution Files:
*   [CloneGraph.java](src/graph/CloneGraph.java)
*   [ShortestPath.java](src/graph/ShortestPath.java)
*   [ContainsCycle.java](src/graph/ContainsCycle.java)
*   [CourseSchedule.java](src/graph/CourseSchedule.java)
*   [PathWithMaxProb.java](src/graph/PathWithMaxProb.java)
*   [NetworkDelayTime.java](src/graph/NetworkDelayTime.java)
*   [PathWithMinEffort.java](src/graph/PathWithMinEffort.java)
*   [IsEventuallySafeNode.java](src/graph/IsEventuallySafeNode.java)
*   [MinCostConnectPoints.java](src/graph/MinCostConnectPoints.java)
*   [FindRedundantConnection.java](src/graph/FindRedundantConnection.java)
*   [CheapestFlightsWithMinCost.java](src/graph/CheapestFlightsWithMinCost.java)
*   [Nodes_K_Distance_From_Target.java](src/graph/Nodes_K_Distance_From_Target.java)
*   [MST_Kruskal_ALGO_MIN_COMPONENTS_COST.java](src/graph/MST_Kruskal_ALGO_MIN_COMPONENTS_COST.java)
*   [MaxCityWithMinReachableNeighboorAndPathThreshold.java](src/graph/MaxCityWithMinReachableNeighboorAndPathThreshold.java)

Queue
What it is

FIFO structure.

Famous problems
Implement Queue using Stacks
Sliding Window Maximum
Solution Files:
*   [TopKfreqNums.java](src/queue/TopKfreqNums.java)
*   [BringServerDown.java](src/queue/BringServerDown.java)
*   [ArrayGeneratorService.java](src/queue/ArrayGeneratorService.java)
*   [ConstructStringWithRepeatLimit.java](src/queue/ConstructStringWithRepeatLimit.java)

Stack
What it is

LIFO structure.

Famous problems
Valid Parentheses
Daily Temperatures
Largest Rectangle in Histogram
Solution Files:
*   [MyStack.java](src/stack/imp/MyStack.java)
*   [SetOfStacks.java](src/stack/imp/SetOfStacks.java)
*   [SortedStack.java](src/stack/imp/SortedStack.java)
*   [DecodeString.java](src/stack/imp/DecodeString.java)
*   [MinSwapsToMakeStringBracesBalancesd.java](src/stack/imp/MinSwapsToMakeStringBracesBalancesd.java)
*   [ResultingStringAfterRemovingEachAdjChars.java](src/stack/imp/ResultingStringAfterRemovingEachAdjChars.java)

Arrays
What it is

Contiguous memory structure.

Famous problems
Two Sum
Best Time to Buy and Sell Stock
Solution Files:
*   [X.java](src/arrays/X.java)
*   [Sort.java](src/arrays/Sort.java)
*   [Urify.java](src/arrays/Urify.java)
*   [HIndex.java](src/arrays/HIndex.java)
*   [TwoSum.java](src/arrays/TwoSum.java)
*   [MinSwaps.java](src/arrays/MinSwaps.java)
*   [PrimeGame.java](src/arrays/PrimeGame.java)
*   [SignArray.java](src/arrays/SignArray.java)
*   [Tictactoe.java](src/arrays/Tictactoe.java)
*   [GasStation.java](src/arrays/GasStation.java)
*   [SortColors.java](src/arrays/SortColors.java)
*   [Permutation.java](src/arrays/Permutation.java)
*   [RotateArray.java](src/arrays/RotateArray.java)
*   [SpiralOrder.java](src/arrays/SpiralOrder.java)
*   [TotalFruits.java](src/arrays/TotalFruits.java)
*   [ZeroSumGame.java](src/arrays/ZeroSumGame.java)
*   [AnyPrimeFreq.java](src/arrays/AnyPrimeFreq.java)
*   [GenGenerator.java](src/arrays/GenGenerator.java)
*   [GroupAnagram.java](src/arrays/GroupAnagram.java)
*   [Mult2Numbers.java](src/arrays/Mult2Numbers.java)
*   [RemoveElement.java](src/arrays/RemoveElement.java)
*   [ThreeSumMulti.java](src/arrays/ThreeSumMulti.java)
*   [MaxSubArraySum.java](src/arrays/MaxSubArraySum.java)
*   [MergeIntervals.java](src/arrays/MergeIntervals.java)
*   [MinCuttingCost.java](src/arrays/MinCuttingCost.java)
*   [RomanToInteger.java](src/arrays/RomanToInteger.java)
*   [Search2dMatrix.java](src/arrays/Search2dMatrix.java)
*   [ThreeClosetSum.java](src/arrays/ThreeClosetSum.java)
*   [MajorityElement.java](src/arrays/MajorityElement.java)
*   [MergeCharacters.java](src/arrays/MergeCharacters.java)
*   [OptimizingQuery.java](src/arrays/OptimizingQuery.java)
*   [SpecialTriplets.java](src/arrays/SpecialTriplets.java)
*   [XorAfterQueries.java](src/arrays/XorAfterQueries.java)
*   [MaxSumOfTriplets.java](src/arrays/MaxSumOfTriplets.java)
*   [RemoveDuplicate2.java](src/arrays/RemoveDuplicate2.java)
*   [RemoveDuplicates.java](src/arrays/RemoveDuplicates.java)
*   [KokoEatingBananas.java](src/arrays/KokoEatingBananas.java)
*   [MergeSortedArrays.java](src/arrays/MergeSortedArrays.java)
*   [MostVisitedSector.java](src/arrays/MostVisitedSector.java)
*   [sortArrayByKFlips.java](src/arrays/sortArrayByKFlips.java)
*   [MinMovesToAllEqual.java](src/arrays/MinMovesToAllEqual.java)
*   [PasswordVariations.java](src/arrays/PasswordVariations.java)
*   [Permutating2Arrays.java](src/arrays/Permutating2Arrays.java)
*   [ArrayOfDoubledPairs.java](src/arrays/ArrayOfDoubledPairs.java)
*   [K_MessedSortedArray.java](src/arrays/K_MessedSortedArray.java)
*   [MinSumAfterDeletions.java](src/arrays/MinSumAfterDeletions.java)
*   [LongestConsecutiveSeq.java](src/arrays/LongestConsecutiveSeq.java)
*   [MinNumberOfDaysToRead.java](src/arrays/MinNumberOfDaysToRead.java)
*   [PalindromePermutation.java](src/arrays/PalindromePermutation.java)
*   [SmallestBalancedIndex.java](src/arrays/SmallestBalancedIndex.java)
*   [ContainerWithMostWater.java](src/arrays/ContainerWithMostWater.java)
*   [CountMajoritySubarrays.java](src/arrays/CountMajoritySubarrays.java)
*   [MaximumNumberOfBallons.java](src/arrays/MaximumNumberOfBallons.java)
*   [RecoverInverseCoinChange.java](src/arrays/RecoverInverseCoinChange.java)
*   [BestTimeToBuyAndSellStock.java](src/arrays/BestTimeToBuyAndSellStock.java)
*   [BestTimeToBuyAndSellStocks.java](src/arrays/BestTimeToBuyAndSellStocks.java)
*   [ProductOfArrayExceptItSelf.java](src/arrays/ProductOfArrayExceptItSelf.java)
*   [ConstructStringWithRepeatLimit.java](src/arrays/ConstructStringWithRepeatLimit.java)
*   [NumericaToAlphabeticallMapping.java](src/arrays/NumericaToAlphabeticallMapping.java)
*   [FindOppositePositivesHavingPairs.java](src/arrays/FindOppositePositivesHavingPairs.java)
*   [RemoveDigitFromNumberToMaximizeResult.java](src/arrays/RemoveDigitFromNumberToMaximizeResult.java)
*   [BestTimeToBuyAndSellStocksWithStrategy.java](src/arrays/BestTimeToBuyAndSellStocksWithStrategy.java)

Design Patterns
What it is

Reusable software design solutions.

Must know
Singleton
Factory
Strategy
Observer
Decorator
Famous implementation exercises
Parking lot design
Notification system
Solution Files:
*   [LRUCache.java](src/design/LRUCache.java)
*   [LoggerRateLimiter.java](src/design/LoggerRateLimiter.java)

Greedy Algorithms
What it is

Choose best local decision.

Famous problems
Jump Game
Gas Station
Solution Files:
*   [MinSubArrayLen.java](src/greedy/MinSubArrayLen.java)
*   [LexicographicallyLargestStringPossibleByAtMostkRearragments.java](src/greedy/LexicographicallyLargestStringPossibleByAtMostkRearragments.java)
*   [LexicographicallyLargestStringPossibleByAtMostkReplacements.java](src/greedy/LexicographicallyLargestStringPossibleByAtMostkReplacements.java)

Bitwise Operations
What it is

Manipulate bits directly.

Famous problems
Single Number
Counting Bits
Solution Files:
*   [IsUniqueString.java](src/bitwise/IsUniqueString.java)

Prefix Sum
What it is

Precompute cumulative sums.

Famous problems
Subarray Sum Equals K
Range Sum Query
Solution Files:
*   [MinFlips.java](src/prefixsum/MinFlips.java)
*   [Solution.java](src/prefixsum/Solution.java)

Linked List
What it is

Node-based linear structure.

Famous problems
Reverse Linked List
Merge Two Sorted Lists
Linked List Cycle
Solution Files:
*   [Sum.java](src/linkedlist/Sum.java)
*   [KthToEnd.java](src/linkedlist/KthToEnd.java)
*   [Partition.java](src/linkedlist/Partition.java)
*   [Palindrome.java](src/linkedlist/Palindrome.java)
*   [Intersection.java](src/linkedlist/Intersection.java)
*   [RemoveDuplicates.java](src/linkedlist/RemoveDuplicates.java)

Matrix
What it is

2D grid problems.

Famous problems
Set Matrix Zeroes
Spiral Matrix
Solution Files:
*   [MinStepsToCleanLitters.java](src/twodmatrix/MinStepsToCleanLitters.java)
*   [MinDistictDiffInSubMatrix.java](src/twodmatrix/MinDistictDiffInSubMatrix.java)

Two Pointers
What it is

Use two indices moving strategically.

Famous problems
Container With Most Water
3Sum
Solution Files:
*   [MinCostToBuyAllBooks.java](src/twopointers/MinCostToBuyAllBooks.java)

Backtracking
What it is

Try → recurse → undo.

Famous problems
Permutations
N-Queens
Solution Files:
*   [Efficencey.java](src/backtracking/Efficencey.java)
*   [CanMakeEqual.java](src/backtracking/CanMakeEqual.java)
*   [Permutation1.java](src/backtracking/Permutation1.java)
*   [MinAndMaxMedian.java](src/backtracking/MinAndMaxMedian.java)
*   [MaxSumOfTriplets.java](src/backtracking/MaxSumOfTriplets.java)
*   [CountPermutations.java](src/backtracking/CountPermutations.java)
*   [CanPartitionEqualSum.java](src/backtracking/CanPartitionEqualSum.java)

Binary Search
What it is

Search sorted search space.

Famous problems
Search in Rotated Sorted Array
Koko Eating Bananas
Solution Files:
*   [MergeSortedArrays.java](src/binarysearch/MergeSortedArrays.java)
*   [SearchInRotatedSortedArray.java](src/binarysearch/SearchInRotatedSortedArray.java)
*   [FindMinInRotatedSortedArray.java](src/binarysearch/FindMinInRotatedSortedArray.java)
*   [SearchInRotatedSortedArray2.java](src/binarysearch/SearchInRotatedSortedArray2.java)

Sliding Window
What it is

Maintain dynamic subarray/window.

Famous problems
Longest Substring Without Repeating Characters
Minimum Window Substring
Solution Files:
*   [IsPermutate.java](src/slidingwindow/IsPermutate.java)
*   [TotalFruits.java](src/slidingwindow/TotalFruits.java)
*   [BoxesAndLoader.java](src/slidingwindow/BoxesAndLoader.java)
*   [A_MinSubArrayLen.java](src/slidingwindow/A_MinSubArrayLen.java)
*   [SubArrayProdLessThanK.java](src/slidingwindow/SubArrayProdLessThanK.java)
*   [B_CharacterReplacement.java](src/slidingwindow/B_CharacterReplacement.java)
*   [LengthOfLongestSubstring.java](src/slidingwindow/LengthOfLongestSubstring.java)
*   [LongestRepeatingCharacterReplacements.java](src/slidingwindow/LongestRepeatingCharacterReplacements.java)
*   [MaxSubArraySumOfDistinctCharactersAndKLength.java](src/slidingwindow/MaxSubArraySumOfDistinctCharactersAndKLength.java)
*   [LongestSubstringWithAtMostKDistinctCharacters.java](src/slidingwindow/LongestSubstringWithAtMostKDistinctCharacters.java)
*   [LengthOfTheLongestSubstringWithNoMoreThanKConsecutiveSameLetters.java](src/slidingwindow/LengthOfTheLongestSubstringWithNoMoreThanKConsecutiveSameLetters.java)

Kahn’s Algorithm
What it is

BFS-based topological sort.

Famous problems
Course Schedule II
Solution Files:
*   [CourseScheduler.java](src/kahnsalgorithm/CourseScheduler.java)

Topological SortPrefix Sum
What it is

Linear ordering of DAG nodes.

Famous problems
Alien Dictionary
Solution Files:
*   [CanFinishCourse2.java](src/topologicalsort/CanFinishCourse2.java)

String Manipulation
What it is

Transform/search/process strings.

Famous problems
Longest Common Prefix
Group Anagrams
Solution Files:
*   [OneWay.java](src/stringmanipulation/OneWay.java)
*   [IsAddable.java](src/stringmanipulation/IsAddable.java)
*   [Compression.java](src/stringmanipulation/Compression.java)
*   [AlmostPalindromic.java](src/stringmanipulation/AlmostPalindromic.java)
*   [MinDeletionsToBalance.java](src/stringmanipulation/MinDeletionsToBalance.java)
*   [LongestPalindromicSubstring.java](src/stringmanipulation/LongestPalindromicSubstring.java)

Boyer-Moore Voting Algorithm
What it is

Find majority element in O(n), O(1) space.

Famous problems
Majority Element
Majority Element II
Solution Files:
*   [SolII.java](src/BoyerMooreVotingAlgorithm/SolII.java)
*   [Solution.java](src/BoyerMooreVotingAlgorithm/Solution.java)
