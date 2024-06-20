We’re a development team for Markup and Gouge, a company that buys antiques on the professional market to sell to clients “with the best possible taste.” Markup and Gouge has been following the industry and now does a lot of its buying on- line, largely from Southabee’s, a venerable auction house that is keen to grow online. The trouble is that our buyers are spending a lot of their time manually checking the state of an auction to decide whether or not to bid, and even missed a couple of attractive items because they could not respond quickly enough.

After intense discussion, the management decides to commission an Auction Sniper, an application that watches online auctions and automatically bids slightly higher whenever the price changes, until it reaches a stop-price or the auction closes. The buyers are keen to have this new application and some of them agree to help us clarify what to build.

we need to agree on some basic terms:

- Item is something that can be identiﬁed and bought.
- Bidder is a person or organization that is interested in buying an item.
- Bid is a statement that a bidder will pay a given price for an item.
- Current price is the current highest bid for the item.
- Stop price is the most a bidder is prepared to pay for an item.
- Auction is a process for managing bids for an item.
- Auction house is an institution that hosts auctions.

It turns out that in the online system there’s an auction for every item, so we decide to use an item’s identiﬁer to refer to its auction.

Sniper application doesn’t have to concern itself with managing any items we’ve bought, since other systems will handle payment and delivery.

We decide to build the Auction Sniper as a Java Swing application. It will run on a desktop and allow the user to bid for multiple items at a time. It will show the identiﬁer, stop price, and the current auction price and status for each item it’s sniping.

Buyers will be able to add new items for sniping through the user interface, and the display values will change in response to events arriving from the auction house.

Communicating with an Auction


The Auction Protocol


The protocol for messages between a bidder and an auction house is simple. Bidders send commands, which can be:

- Join
A bidder joins an auction. The sender of the XMPP message identiﬁes the bidder, and the name of the chat session identiﬁes the item.

- Bid
A bidder sends a bidding price to the auction. 


Auctions send events, which can be:

- Price
An auction reports the currently accepted price. This event also includes the minimum increment that the next bid must be raised by, and the name of bidder who bid this price. The auction will send this event to a bidder when it joins and to all bidders whenever a new bid has been accepted.

- Close
An auction announces that it has closed. The winner of the last price event has won the auction.



The XMPP Messages

Southabee’s On-Line has also sent us details of the formats they use within the
XMPP messages. They’re pretty simple, since they only involve a few names and
values, and are serialized in a single line with key/value pairs. Each line starts
with a version number for the protocol itself. The messages look like this:

SOLVersion: 1.1; Command: JOIN;
SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;
SOLVersion: 1.1; Command: BID; Price: 199;
SOLVersion: 1.1; Event: CLOSE;

Southabee’s On-Line uses login names to identify items for sale, so to bid
for an item with identiﬁer 12793 , a client would start a chat with the “user”
auction-12793 at the Southabee’s server. The server can tell who is bidding from
the identity of the caller, assuming the accounts have been set up beforehand.


After some discussion, we come up with this sequence of features to build:

Single item: join, lose without bidding

This is our starting case where we put together the core infrastructure; it is the subject of Chapter 10.

***Single item: join, bid, and lose***

Add bidding to the basic connectivity.

***Single item: join, bid, and win***

Distinguish who sent the winning bid.

***Show price details***

Start to fill out the user interface.

***Multiple items***

Support bidding for multiple items in the same application.

***Add items through the user interface***

Implement input via the user interface.

***Stop bidding at the stop price***

More intelligence in the Sniper algorithm.
