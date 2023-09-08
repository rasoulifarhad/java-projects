package com.farhad.example.nestedbuilder.carbuilder;

import lombok.Data;

@Data
public class Wheel {
	private int size;
	private int type;
	private int color;

	private Wheel() {

	}

	private Wheel(Builder builder) {
		setSize(builder.size);
		setType(builder.type);
		setColor(builder.color);
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static Builder newBuilder(Wheel copy) {
		Builder builder = new Builder();
		builder.size = copy.size;
		builder.type = copy.type;
		builder.color = copy.color;
		return builder;
	}

	public static final class Builder {
		private int size;
		private int type;
		private int color;
		private WheelListBuilder wheelListBuilder;

		private Builder() {

		}

		public void withWheelListBuilder(WheelListBuilder wheelListBuilder) {
			this.wheelListBuilder = wheelListBuilder;
		}
		public Builder withSize(int size) {
			this.size = size;
			return this;
		}

		public Builder withType(int type) {
			this.type = type;
			return this;
		}

		public Builder withColor(int color) {
			this.color = color;
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
		public WheelListBuilder addWheelToList() {
			this.wheelListBuilder.addWheel(this.build());
			return wheelListBuilder;
		}
		public Wheel build() {
			return new Wheel(this);
		}

	}
}
