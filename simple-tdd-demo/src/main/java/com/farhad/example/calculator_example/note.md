### Act 2: The Customer’s Site

Johnny: Hi, Jane, how are you?
Jane: Thanks, I’m fine, how about you?
Johnny: Me too, thanks. Benjamin, this is Jane, our customer. Jane, this is Benjamin, we’ll work
together on the task you have for us.
Benjamin: Hi, nice to meet you.
Jane: Hello, nice to meet you too.
Johnny: So, can you tell us a bit about the software you need us to write?
Jane: Sure. Recently, I bought a new smartphone as a replacement for my old one. The thing is,
I am really used to the calculator application that ran on my previous phone and I cannot find a
counterpart for my current device.
Benjamin: Can’t you just use another calculator app? There are probably plenty of them
available to download from the web.
Jane: That’s right. I checked them all and none has exactly the same behavior as the one I have
used for my tax calculations. You see, this app was like a right hand to me and it had some really
nice shortcuts that made my life easier.
Johnny: So you want us to reproduce the application to run on your new device?
Jane: Exactly.
Johnny: Are you aware that apart from the fancy features that you were using we will have to
allocate some effort to implement the basics that all the calculators have?
Jane: Sure, I am OK with that. I got used to my calculator application so much that if I use
something else for more than a few months, I will have to pay a psychotherapist instead of you
guys. Apart from that, writing a calculator app seems like an easy task in my mind, so the cost
isn’t going to be overwhelming, right?
Johnny: I think I get it. Let’s get it going then. We will be implementing the functionality
incrementally, starting with the most essential features. Which feature of the calculator would
you consider the most essential?
Jane: That would be addition of numbers, I guess.
Johnny: Ok, that will be our target for the first iteration. After the iteration, we will deliver this
part of the functionality for you to try out and give us some feedback. However, before we can
even deliver the addition feature, we will have to implement displaying digits on the screen as
you enter them. Is that correct?
Jane: Yes, I need the display stuff to work as well – it’s a prerequisite for other features, so…
Johnny: Ok then, this is a simple functionality, so let me suggest some user stories as I understand
what you already said and you will correct me where I am wrong. Here we go:
1. In order to know that the calculator is turned on, As a tax payer I want to see “0” on the
screen as soon as I turn it on.
2. In order to see what numbers I am currently operating on, As a tax payer, I want the
calculator to display the values I enter
3. In order to calculate the sum of my different incomes, As a tax payer I want the calculator
to enable addition of multiple numbers
What do you think?
Jane: The stories pretty much reflect what I want for the first iteration. I don’t think I have any
corrections to make.
Johnny: Now we’ll take each story and collect some examples of how it should work.
Benjamin: Johnny, don’t you think it is obvious enough to proceed with implementation straight
away?
Johnny: Trust me, Benjamin, if there is one word I fear most in communication, it is “obvious”.
Miscommunication happens most often around things that people consider obvious, simply
because other people do not.
Jane: Ok, I’m in. What do I do?
Johnny: Let’s go through the stories one by one and see if we can find some key examples of
how the features should work. The first story is…

#### In order to know that the calculator is turned on, As a tax payer I want to see “0” on the screen as soon as I turn it on.

Jane: I don’t think there’s much to talk about. If you display “0”, I will be happy. That’s all.
Johnny: Let’s write this example down using a table:

key sequence | Displayed output | Notes
| ---------- | ---------------- | ------- |
N/A | 0 | Initial displayed value

Benjamin: That makes me wonder… what should happen when I press “0” again at this stage?
Johnny: Good catch, that’s what these examples are for – they make our thinking concrete. As
Ken Pugh says¹⁰: “Often the complete understanding of a concept does not occur until someone
tries to use the concept”. Normally, we would put the “pressing zero multiple times” example on
a TODO list and leave it for later, because it’s a part of a different story. However, it looks like
we’re done with the current story, so let’s move straight ahead. The next story is about displaying
entered digits. How about it, Jane?
Jane: Agree.
Johnny: Benjamin?
Benjamin: Yes, go ahead.

In order to see what numbers I am currently operating on, As a
tax payer, I want the calculator to display the values I enter
Johnny: Let’s begin with the case raised by Benjamin. What should happen when I input “0”
multiple times after I only have “0” on the display?
Jane: A single “0” should be displayed, no matter how many times I press “0”.
Johnny: Do you mean this?

key sequence | Displayed output | Notes
| ---------- | ---------------- | ------- |
0,0,0 | 0 | Zero is a special case – it is displayed only once

Jane: That’s right. Other than this, the digits should just show on the screen, like this:

key sequence | Displayed output | Notes
| ---------- | ---------------- | ------- |
1,2,3 | 123 | Entered digits are displayed

Benjamin: How about this:

key sequence | Displayed output | Notes
| ---------- | ---------------- | ------- |
1,2,3,4,5,6,7,1,2,3,4,5,6 | 1234567123456? | Entered digits are displayed?

Jane: Actually, no. My old calculator app has a limit of six digits that I can enter, so it should be:

key sequence | Displayed output | Notes
| ---------- | ---------------- | ------- |
1,2,3,4,5,6,7,1,2,3,4,5,6 | 123456 | Display limited to six digits

Johnny: Another good catch, Benjamin!
Benjamin: I think I’m beginning to understand why you like working with examples!
Johnny: Good. Is there anything else, Jane?
Jane: No, that’s pretty much it. Let’s start working on another story.

#### In order to calculate sum of my different incomes, As a tax payer I want the calculator to enable addition of multiple numbers

Johnny: Is the following scenario the only one we have to support?

key sequence | Displayed output | Notes
| ---------- | ---------------- | ------- |
2,+,3,+,4,= | 9 | Simple addition of numbers

Jane: This scenario is correct, however, there is also a case when I start with “+” without inputting
any number before. This should be treated as adding to zero:

key sequence | Displayed output | Notes
| ---------- | ---------------- | ------- |
+,1,= | 1 | Addition shortcut – treated as 0+1

Benjamin: How about when the output is a number longer than six digits limit? Is it OK that
we truncate it like this?

key sequence | Displayed output | Notes
| ---------- | ---------------- | ------- |
9,9,9,9,9,9,+,9,9,9,9,9,9,= | 199999 | Our display is limited to six digits only

Jane: Sure, I don’t mind. I don’t add such big numbers anyway.
Johnny: There is still one question we missed. Let’s say that I input a number, then press “+”
and then another number without asking for result with “=”. What should I see?
Jane: Every time you press “+”, the calculator should consider entering current number finished
and overwrite it as soon as you press any other digit:


key sequence | Displayed output | Notes
| ---------- | ---------------- | ------- |
2,+,3 | 3 | Digits entered after + operator are treated as digits of a new number, the previous one is stored

Jane: Oh, and just asking for result just after the calculator is turned on should result in “0”.


key sequence | Displayed output | Notes
| ---------- | ---------------- | ------- |
= | 0 | Result key in itself does nothing

Johnny: Let’s sum up our discoveries:

key sequence | Displayed output | Notes
| ---------- | ---------------- | ------- |
N/A | 0 | Initial displayed value
0,0,0 | 0 | Zero is a special case – it is displayed only once
1,2,3 | 123 | Entered digits are displayed
1,2,3,4,5,6,7,1,2,3,4,5,6 | 123456 | Display limited to six digits
2,+,3 | 3 | Digits entered after + operator are treated as digits of a new number, the previous one is stored
= | 0 | Result key in itself does nothing
+,1,= | 1 | Addition shortcut – treated as 0+1
2,+,3,+,4,= | 9 | Simple addition of numbers
9,9,9,9,9,9,+,9,9,9,9,9,9,= | 199999 | Our display is limited to six digits only


Johnny: The limiting of digits displayed looks like a whole new feature, so I suggest we add it
to the backlog and do it in another sprint. In this sprint, we will not handle such situation at all.
How about that, Jane?
Jane: Fine with me. Looks like a lot of work. Nice that we discovered it up-front. For me, the
limiting capability seemed so obvious that I didn’t even think it would be worth mentioning.
Johnny: See? That’s why I don’t like the word “obvious”. Jane, we will get back to you if any
more questions arise. For now, I think we know enough to implement these three stories for you.
Jane: good luck!

### Act 3: Test-Driven Development


