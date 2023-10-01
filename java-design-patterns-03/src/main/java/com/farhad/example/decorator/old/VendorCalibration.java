package com.farhad.example.decorator.old;

// after sometime there was additional requirement where we needed to apply additional 
// calibration based on the techtype,policytype and device type also. Initially we thought 
// of creating a one class for each combination of vendor and property type but then we 
// realized that it would create too many classes and also there was a high possibility 
// that there will be additional properties would be added to the list which would cause 
// in creating many more classes.
// So here we considered using decorator pattern so that we can dynamically add 
// functionality into objects.
public abstract class VendorCalibration {
    abstract double calibrate(double rawData);
}
