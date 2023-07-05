> A BigDecimal is defined by two values: an arbitrary precision integer and a 32-bit integer scale. The value of the BigDecimal is defined to be unscaledValue*10^{-scale}.  

<br/>

> The precision is the number of digits in the unscaled value. For instance, for the number 123.45, the precision returned is 5.

<br/>

> So, precision indicates the length of the arbitrary precision integer. Here are a few examples of numbers with the same scale, but different precision:

>> 12345 / 100000 = 0.12345 // scale = 5, precision = 5

<br/>

>> 12340 / 100000 = 0.1234 // scale = 4, precision = 4

<br/>

>> 1 / 100000 = 0.00001 // scale = 5, precision = 1

<br/>

> If zero or positive, the scale is the number of digits to the right of the decimal point. If negative, the unscaled value of the number is multiplied by ten to the power of the negation of the scale. For example, a scale of -3 means the unscaled value is multiplied by 1000.

<br/>

> This means that the integer value of the ‘BigDecimal’ is multiplied by 10^{-scale}.

<br/>

> Here are a few examples of the same precision, with different scales:
 
>> 12345 with scale 5 = 0.12345

<br/>

>> 12345 with scale 4 = 1.2345

<br/>

>> 12345 with scale 0 = 12345

<br/>

>> 12345 with scale -1 = 123450 


<br/>

The available rounding modes are many, each having a purpose; see javadocs for details:

- RoundingMode.CEILING: rounds towards positive infinity;
- RoundingMode.FLOOR: rounds negative infinity;
- RoundingMode.UP: rounds away from zero, considering absolute value;
- RoundingMode.DOWN: rounds towards from zero, considering absolute value;
- RoundingMode.HALF_UP: the usual algorithm taught at school;
- RoundingMode.HALF_DOWN: similar to RoundingMode.HALF_UP, but negative infinity;
- RoundingMode.HALF_EVEN: a mix of RoundingMode.HALF_UP and RoundingMode.HALF_DOWN, used to statistically minimize error on repeated operations;
- RoundingMode.UNNECESSARY: default mode, assumes no rounding will be necessary (i.e. potentially leading to overflow).
