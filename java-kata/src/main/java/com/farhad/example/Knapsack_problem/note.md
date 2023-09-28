See https://en.wikipedia.org/wiki/Knapsack_problem#0-1_knapsack_problem
See https://www.rosettacode.org/wiki/Knapsack_problem/0-1#Java
See https://pysaumont.github.io/2016/06/11/Folding-the-Universe-part-I.html

## Knapsack problem

The knapsack problem is the following problem in combinatorial optimization:

    Given a set of items, each with a weight and a value, determine which items to include in the collection so that the total weight is less than or equal to a given limit and the total value is as large as possible.

A tourist wants to make a good trip at the weekend with his friends.

They will go to the mountains to see the wonders of nature, so he needs to pack well for the trip.

He has a good knapsack for carrying things, but knows that he can carry a maximum of only 4kg in it,   and it will have to last the whole day.

He creates a list of what he wants to bring for the trip but the total weight of all items is too much.

He then decides to add columns to his initial list detailing their weights and a numerical value representing how important the item is for the trip.  

Here is the list: 

Table of potential knapsack items 
| item | weight (dag) | value
| ---- | -------- | ------ | 
map | 9 | 150 
compass | 13 | 35
water | 153 | 200
sandwich | 50 | 160
glucose | 15 | 60
tin | 68 | 45
banana | 27 | 60
apple | 39 | 40
cheese | 23 | 30
beer | 52 | 10
suntan cream | 11 | 70
camera | 32 | 30
T-shirt | 24 | 15
trousers | 48 | 10
umbrella | 73 | 40
waterproof trousers | 42 | 70
waterproof overclothes | 43 | 75
note-case | 22 | 80
sunglasses | 7 | 20
towel | 18 | 	12
socks | 4 | 50
book | 30 | 10
knapsack | ≤400 dag | ? 

The tourist can choose to take any combination of items from the list, but only one of each item is available.

He may not cut or diminish the items, so he can only take whole units of any item. 

### Task

Show which items the tourist can carry in his knapsack so that their total weight does not exceed 400 dag [4 kg],   and their total value is maximized.

[dag = decagram = 10 grams] 