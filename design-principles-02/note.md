Mokito : See https://javadoc.io/static/org.mockito/mockito-core/5.6.0/org/mockito/Mockito.html

See https://github.com/iluwatar/java-design-patterns
See https://github.com/test-driven-development/fpinjava/tree/master/fpinjava-parent
See https://github.com/thombergs/buckpal/tree/master'
See https://github.com/VaughnVernon/IDDD_Samples
See https://github.com/test-driven-development/video-store/tree/master
See https://github.com/AxonIQ/food-ordering-demo/tree/master
See https://github.com/test-driven-development/design-patterns-in-java/tree/master
See https://github.com/mploed/ddd-with-spring

See https://resources.unity.com/games/level-up-your-code-with-game-programming-patterns?ungated=true

See https://dl.acm.org/doi/fullHtml/10.1145/3489449.3489972
See https://github.com/jstevenperry/IBM-Developer/tree/master
See https://github.com/Alvence/NextGen_POS_demo/tree/master
See https://github.com/Alvence/monopoly_demo
See https://github.com/oop-study/awesome-design-patterns
See https://github.com/asimihsan/stockstalk/tree/master
See https://github.com/miguelemos/ddd-domain-driven-design/tree/master
See https://nilamkhairnarblog.files.wordpress.com/2018/11/assig6.pdf
See https://www.it.uu.se/edu/course/homepage/asd/ht14/Lecture%204.pdf

See https://www.slideshare.net/GunasundariSelvaraj/unit-1-251313061
See https://www.slideshare.net/GunasundariSelvaraj/unit-2-251313063
See https://www.slideshare.net/GunasundariSelvaraj/unit-4-251313071
See https://www.slideshare.net/guna287176/unit-i-251298918
See https://www.slideshare.net/guna287176/unit-3-251298919

See https://medium.com/@in10se/mastering-grasp-design-principles-for-better-software-design-a21b5ec29e89
See https://www.thoughtworks.com/insights/blog/agile-project-management/domain-modeling-what-you-need-to-know-before-coding
See https://github.com/Jmgiacone/Pokemon/tree/master
See https://github.com/sarahdahippo-zz/pokemon-battle/tree/master
See https://martinfowler.com/articles/domain-oriented-observability.html
See https://codeburst.io/rule-your-domain-model-d4beae6806c

See https://www.designgurus.io/course-play/grokking-the-object-oriented-design-interview/doc/637d2288eeb90d2166ac95be
See https://github.com/gopalbala/parkinglot
See https://dotnettutorials.net/lesson/abstraction-in-java/
See https://dotnettutorials.net/lesson/abstract-classes-and-abstract-methods-in-java/
See https://dotnettutorials.net/lesson/inheritance-in-java/
See https://dotnettutorials.net/course/java-design-patterns/
See https://dotnettutorials.net/lesson/interface-in-java/
See https://dotnettutorials.net/lesson/association-composition-and-aggregation-in-java/

### parking lot

> Parking lot has multiple floors, multiple entry and exit points.

<br/>

> Entry is recorded at entry point and payment is done at the time of exit.

<br/>

> Parking lot contains Multiple floors.

<br/>

>Parking floor containts multiple parking slots which are of different types.

<br/>


1. HANDICAPPED
2. CAR
3. LARGE
4. MOTORBIKE
5. ELECTRIC
6. EBIKE

> Parking is on first come first served basis.

<br/>

> Time is recorded at the time of issuing the ticket in entry panel.

<br/>

> Time is recorded at the exit panel and charges are calculated at that point of time.

<br/>

> User should be able to pay for the ticket.

<br/>

> Admin should be able to add floor to the lot.

<br/>

> Admin shoul be able to add parking slots to the floor.

<br/>

> Admin should be able to remove a slot.

<br/>

> Admin should be able to add etrance and exit panels.

<br/>

> User should not be issued a ticket if the slot is not available.

<br/>

> As the user is allocated a slot the inventory of the slots gets reduced.

<br/>

> Add user leaves the parking the inventory get updated.

<br/>

```
Admin Case 1 - should be able to add parking floor case
Admin Case 2 - should be able to add parking floor case
Admin Case 3 - should be able to add entrance panel
Admin Case 4 - should be able to add exit panel
Admin case 5 - should be able to add car parking spot
Admin case 6 - should be able to add bike parking spot
Admin case 7 - should be able to add car parking spot

#User Test cases Test case 1 - check for availability of parking lot - TRUE
Test case 2 - check for availability of parking lot - FALSE
Test case 3 - check for availability of parking lot - FALSE
TEST case 4 - Check if full
Test case 5 - get parking spot
Test case 6 - should not be able to get spot
Test case 7 - Entrance Panel - 1
Test case - 8 - Should be able to get parking ticket
Test case - 9 - Should be able to get parking ticket
Test case 10 - Should not be able to get ticket
Test case 11 - Should be able to get ticket
Test case 12 - vacate parking spot
Test case 13 - park on vacated spot
Test case 14 - park when spot is not available
Test cast 15 - vacate car
Test case 16 - Now should be able to park car
Test case 17 - Should be able to vacate parked vehicle
Test case 18 - check for slots count
Test case 19 - Payment
Test case 20 - vacate motorbike spot
```