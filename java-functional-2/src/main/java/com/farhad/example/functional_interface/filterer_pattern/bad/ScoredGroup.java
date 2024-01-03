package com.farhad.example.functional_interface.filterer_pattern.bad;

import java.util.List;
import java.util.function.Predicate;

import com.farhad.example.functional_interface.filterer_pattern.Group;
import com.farhad.example.functional_interface.filterer_pattern.Item;
import com.farhad.example.functional_interface.filterer_pattern.ScoredItem;

// Such interface may look fine, but the problem with this design is that it is not versatile for subtypes of Item and Group:
// As you can see, we overrode filtered, but the parameter type (Predicate<? super Item>) had to remain unchanged. Because of 
// type erasure in Predicate, we cannot overload this method either.

// As a result, we are able to create a filtered ScoredGroup but unable to filter by ScoredItems (which makes filtered method much less useful).
public interface ScoredGroup extends Group {
	@Override
	List<? extends ScoredItem> items();

	@Override
	ScoredGroup filtered(Predicate<? super Item> predicate);
}
