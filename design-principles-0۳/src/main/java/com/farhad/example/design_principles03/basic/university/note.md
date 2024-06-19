A course exists in the school catalog, with a name, course id, brief description and number of credits.

A department selects from the catalog a number of courses to offer every semester.

A section is a course offered in a certain semester, held in a certain place on certain days at certain times.

Where do we create an instance of Section? One possibility is to do this in Course. et us assume that we add a new method named createSection in Course, which accepts the semester, the place, days, and time as parameters and returns an instance of a new Section object for the course.

Suppose we need to create a list of all students in our university. Let us say that we should be able to add a student, remove a student, and print all students in the list.