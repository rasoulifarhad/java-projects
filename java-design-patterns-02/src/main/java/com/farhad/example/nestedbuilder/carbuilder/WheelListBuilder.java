package com.farhad.example.nestedbuilder.carbuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WheelListBuilder {
	
		private List<Wheel> wheels;

		private WheelListBuilder() {

		}

		public static WheelListBuilder newBuilder() {
			return new WheelListBuilder();
		}
	

		public WheelListBuilder withNewList() {
			wheels = new ArrayList<>();
			return this;
		}

		public WheelListBuilder withList(List<Wheel> wheels) {
			this.wheels = wheels;
			return this;
		}

		// we want : 
		//
		// List<Wheel> wheels = wheelListBuilder
    	// 		.addWheel().withType(1).withSize(2).withColour(2).addWheelToList()
        // 		.addWheel().withType(1).withSize(2).withColour(2).addWheelToList()
        //	    .addWheel().withType(1).withSize(2).withColour(2).addWheelToList()
        //	    .addWheel().withType(1).withSize(2).withColour(2).addWheelToList()
        //	    .build();
		//
		// As soon as the method addWheel() is called, a new instance of the class WheelBuilder should be returned.
		// The method addWheelToList() creates the instance of the class Wheel and adds it to the list. 
		// To achieve it, one has to modify both Builders involved. 
		// On the side of the WheelBuilder, the method addWheelToList() is added. 
		// This method adds the instance of the class Wheel to the WheelListBuilder and returns the instance of the class WheelListBuilder.
		// On the side of the class WheelListBuilder, only the method addWheel() is added.

		public Wheel.Builder addWheel() {
			Wheel.Builder builder = Wheel.newBuilder();
			builder.withWheelListBuilder(this);
			return builder;
		}
		
		public WheelListBuilder addWheel(Wheel wheel) {
			Objects.requireNonNull(wheels);
			// this.wheels = this.wheels == null ? withNewList().wheels : this.wheels;
			this.wheels.add(wheel);
			return this;
		}

		public List<Wheel> build() {
			if (this.wheels.size() != 4 ){
				throw new IllegalStateException("Wheel number must be 4: " + wheels.size());
			}
			return wheels; 
		}

}
