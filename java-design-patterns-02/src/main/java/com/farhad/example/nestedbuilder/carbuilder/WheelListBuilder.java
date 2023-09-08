package com.farhad.example.nestedbuilder.carbuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WheelListBuilder {
	
		private List<Wheel> wheels;

		private WheelListBuilder() {

		}

		public static WheelListBuilder newWheelListBuilder() {
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
