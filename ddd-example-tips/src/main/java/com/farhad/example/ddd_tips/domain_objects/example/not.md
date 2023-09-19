The employee management context needs some, but not all, information about users from the identity management context. There is a REST endpoint for this and the data is serialized into JSON.

Inside the identity management context, a `User` is represented like this:

```java
public class User extends AggregateRoot<UserId> {
    private String userName;
    private String firstName;
    private String lastName;
    private Instant validFrom;
    private Instant validTo;
    private boolean disabled;
    private Instant nextPasswordChange;
    private List<Password> passwordHistory;

    // Getters, setters and business logic omitted
}

```

Inside the employee management context, we only need the user ID and name. The user will be uniquely identified by the ID but the name is shown in the UI. 

We obviously cannot change any user information so the user information is immutable. 