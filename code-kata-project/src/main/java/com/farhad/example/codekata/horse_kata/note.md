Note on data size and performance:

    Assume the table data will have no more than 50 000 rows and 100 columns, and will easily fit into available memory space.
    Assume you will filter on a maximum of 100 columns
    Assume you will only sort on one column
    Assume the pagination is for page sizes of anything from 1 to 500 rows.


A request from the front end might look like this:

{
    "Filters": [{"ColumnHeader": "Breed", "Value": "Thoroughbred"}, 
                {"ColumnHeader": "Age", "Value": 2}],
    "Sorting": {"ColumnHeader": "Height", "SortOrder": "Descending"},
    "Pagination": {"FirstRecordInPage": 4, "PageSize": 3}
}

The table data you have in the back end and might look like this: (You should write code that would work with more columns and more rows).

{
    "Headers": ["Breed", "Colour", "Height", "Age", "Shoes"],
    "TableData": [["Thoroughbred", "Bay", 1.60, 3, true],
                  ["Thoroughbred", "Grey", 1.55, 3, true],
                  ["Arabian horse", "Bay", 1.51, 5, true],
                  ["Shetland Pony", "Black", 1.01, 2, false],
                  ["Shire horse", "Black", 1.71, 4, true]]
}

You should return data to the front end in this format:

{
    "Headers": ["Breed", "Colour", "Height", "Age", "Shoes"],
    "TableData": [["Thoroughbred", "Grey", "1.55", "3", "true"],
                  ["Arabian horse", "Bay", "1.51", "5", "true"],
                  ["Shetland Pony", "Black", "1.01", "2", "false"],
                  ["Shire horse", "Black", "1.71", "4", "true"]],
    "TotalRows": 6
}


"TotalRows" refers to the actual number of rows that exist in the back end that match the criteria, it will normally be larger than the number of rows in "TableData". The data should all be presented as strings, and satisfy the filter, sorting and pagination request.