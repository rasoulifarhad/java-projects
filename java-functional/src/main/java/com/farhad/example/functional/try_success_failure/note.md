See https://github.com/gtrefs/try/tree/master

See https://github.com/gtrefs/fpworkshop/tree/master

The `Try` type represents a computation that may fail. If the computation is successful it returns the value wrapped in a `Try.Success` otherwise the `java.lang.Exception` wrapped in a `Try.Failure`.

In order to use `Try` you need to call the `Try.apply(FailableSupplier)` method providing a lambda with the same signature used for a common `java.util.function.Supplier`. Indeed `FailableSupplier` is just a `java.util.function.Supplier` with a `throws Exception` added to its `get` method.