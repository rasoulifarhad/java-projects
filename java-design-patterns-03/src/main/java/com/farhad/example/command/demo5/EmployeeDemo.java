package com.farhad.example.command.demo5;

/**
 * Imagine, for example, that we are writing the software that maintains a database of 
 * employees. There are a number of operations that users can apply to that database. 
 * They can add new employees, delete old employees, or change the attributes of existing 
 * employees.
 * 
 * When a user decides to add a new employee, that user must specify all the information 
 * needed to successfully create the employee record.
 * Before acting on that information, the system needs to verify that the information is 
 * syntactically and semantically correct.
 * 
 * The C OMMAND pattern can help with this job.
 * 
 * The command object acts as a repository for the unvalidated data, implements the 
 * validation methods, and implements the methods that finally execute the transaction.
 * 
 * For example, consider Figure 13-5. The AddEmployeeTransaction contains the same data fields 
 * that Employee contains. It also holds a pointer to a PayClassification object. These fields and object are 
 * created from the data that the user specifies when directing the system to add a new 
 * employee. 
 * 
 * The validate method looks over all the data and makes sure it makes sense. It 
 * checks it for syntactic and semantic correctness. It may even check to ensure that the 
 * data in the transaction are consistent with the existing state of the database. For 
 * example, it might ensure that no such employee already exists.
 * 
 * The execute method uses the validated data to update the database. In our simple 
 * example, a new Employee object would be created and loaded with the fields from the 
 * AddEmployeeTransaction object. The PayClassification object would be moved or copied 
 * into the Employee .
 * 
 * Imagine, for example, an application that allows the user to draw geometric shapes on 
 * the screen. A toolbar has buttons that allow the user to draw circles, squares, rectangles,
 * etc. Let’s say that the user clicks on the draw circle button. The system creates a 
 * DrawCircleCommand and then calls do() on that command. The DrawCircleCommand object 
 * tracks the user’s mouse waiting for a click in the drawing window. On receiving that 
 * click, it sets the click point as the center of the circle and proceeds to draw an 
 * animated circle at that center with a radius that tracks the current mouse position. 
 * When the user clicks again, the DrawCircleCommand stops animating the circle and adds 
 * the appropriate circle object to the list of shapes currently displayed on the canvas.
 * 
 * It also stores the ID of the new circle in some private variable of its own. Then it 
 * returns from the do() method. The sys- tem then pushes the expended DrawCirlceCommand 
 * on the stack of completed commands.
 * 
 * Later, the user clicks the undo button on the toolbar. The system pops the completed 
 * commands stack and calls undo() on the resulting Command object. on receiving the undo() 
 * message, the DrawCircleCommand object deletes the circle matching the saved ID from 
 * the list of objects currently displayed on the canvas.
 */
public class EmployeeDemo {
    
}
