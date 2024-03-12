package com.farhad.example.refactoring.call_super.better;

// Here the super-class defines the public method and provides a separate method (often referred to as a 
// hook method) for the subclass to override. The subclass writer now doesn't have to worry his ugly head 
// about calls to super. Furthermore the super-class writer is free to add calls after the subclass method 
// if she wishes.
//
// There are a couple of ways to define the hook method. 
//
// - an empty implementation. This is useful if many subclasses don't need to provide 
// their own additional behavior. 
//
// - if many subclasses have to do the same thing, you can consider a default implementation, which can also be a template method itself to allow for variation within the common scheme.
//
// - If every subclass should provide unique behavior, then you can make the hook method abstract in the super-class.
//
// One of the problems with this is that there's usually no way to indicate that a certain method is a hook 
// method, i.e. that it's the one that the framework writer expects to be overridden. You do see conventions 
// (the handle/doHandle is one common one), but mostly you have to explain how it works. One of the best ways 
// to explain it is with an example. When I'm looking at one of these cases I usually find the best thing to 
// do is look at an existing subclass and see what it does.
public class App {

}
