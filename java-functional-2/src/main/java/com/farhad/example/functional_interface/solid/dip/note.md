Let’s look at some code that extracts headings from a hypothetical
markup language where each heading is designated by being suf‐
fixed with a colon ( : ). Our method is going to extract the headings
from a file by reading the file, looking at each of the lines in turn,
filtering out the headings, and then closing the file. We shall also
wrap any Exception related to the file I/O into a friendly domain
exception called a HeadingLookupException .