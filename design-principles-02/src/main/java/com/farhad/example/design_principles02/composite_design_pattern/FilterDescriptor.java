package com.farhad.example.design_principles02.composite_design_pattern;

import java.util.List;

// {
// 	logicalOperator:"OR",
// 	filterDescriptors:[
// 		{
//			field: "firstName",
// 			operator: "eq",
//			value: "xxx"	
// 		},
// 		{
//			field: "lastName",
// 			operator: "eq",
//			value: "yyyy"	
// 		}
// 	]
// }
//
// SELECT * FROM user
// WHERE
// 	firstName = "xxx"
//	OR
//  lastName = "yyyy"
public class FilterDescriptor {

	String field;
	String operator; // equals; not equals; greater than; ...
	String value;
	String logicalOperator; // AND; OR
	List<FilterDescriptor> filterDescriptors;

	void filter() {
		filterDescriptors.forEach(FilterDescriptor::filter);
	}

}
