package com.farhad.example.extensionobjects;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import com.farhad.example.extensionobjects.abstractextensions.CommanderExtension;
import com.farhad.example.extensionobjects.abstractextensions.SergentExtension;
import com.farhad.example.extensionobjects.abstractextensions.SoldierExtension;
import com.farhad.example.extensionobjects.units.CommanderUnit;
import com.farhad.example.extensionobjects.units.SergentUnit;
import com.farhad.example.extensionobjects.units.SoldierUnit;
import com.farhad.example.extensionobjects.units.Unit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
	public static void main(String[] args) {
		
		CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit1");
		SergentUnit sergentUnit = new SergentUnit("SergentUnit1");
		SoldierUnit soldierUnit = new SoldierUnit("SoldierUnit1");

		checkExtensionsForUnit(soldierUnit);
		checkExtensionsForUnit(sergentUnit);
		checkExtensionsForUnit(commanderUnit);
	}

	private static void checkExtensionsForUnit(Unit unit) {
		log.info("{}", unit.getName());
		String name = unit.getName();
		
		Function<String, Runnable> func = (e) -> () -> log.info("{} without {}", name, e);

		String extension = "SoldierExtension";
		Optional.ofNullable( unit.getUnitExtention(extension))
					.map(u -> Optional.of((SoldierExtension)u))
					.ifPresent(
						OptionalConsumer.of(
							SoldierExtension::soldierReady, 
							func.apply(extension)));
			
		extension = "SergentExtension";
		Optional.ofNullable( unit.getUnitExtention(extension))
					.map(u -> Optional.of((SergentExtension)u))
					.ifPresent(
						OptionalConsumer.of(
							SergentExtension::sergentReady, 
							func.apply(extension)));

		extension = "CommanderExtension";
		Optional.ofNullable( unit.getUnitExtention(extension))
					.map(u -> Optional.of((CommanderExtension)u))
					.ifPresent(
						OptionalConsumer.of(
							CommanderExtension::commanderReady, 
							func.apply(extension)));
			
	}

	static  class OptionalConsumer<T> implements Consumer<Optional<T>> {

		private final Consumer<T> consumer;
		private final Runnable runnablel;

		public static <T> OptionalConsumer<T> of(Consumer<T> consumer, Runnable r) {
			return new OptionalConsumer<>(consumer, r);
		}
		public OptionalConsumer(Consumer<T> consumer, Runnable runnable) {
			super();
			this.consumer = consumer;
			this.runnablel = runnable;
		}

		@Override
		public void accept(Optional<T> t) {
			if (t.isPresent()) {
				consumer.accept(t.get());
			} else {
				runnablel.run();
			}
		}

	}
}
