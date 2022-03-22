## 1. SessionFactory

- Reads the hibernate config file
- Creates Session objects
- Heavy-weight object
- Only create once in your application 

<br>
<hr>


## 2. Session

- Wraps a JDBC connection
- Main object used to save/retrieve objects
- Short-lived object
- Retrieved from SessionFactory

<br>
<hr>

## 3. Primary Key

- Uniquely identifies each row in a table
- Must be a unique value
- Cannot contain NULL values

<br>
<hr>

## 4. ID Generation Strategies
1. GenerationType.AUTO -- Pick an appropriate strategy for the particular DB
2. GenerationType.IDENTITY -- Assign primary keys using DB identity column
3. GenerationType.SEQUENCE -- Assign primary keys using a database sequence
4. GenerationType.TABLE -- Assign primary keys using an underlying DB table to ensure uniqueness

<br>
<hr>

## 5. Primary Key and Foreign Key
- Primary key: identify a unique row in a table
- Foreign key: Link tables together, a field in one table that refers to primary key in another table

<br>
<hr>

## 6. Cascade
- Apply the same operation to related entities
- CASCADE DELETE
- CASCADE SAVE
- *Cascade delete depends on the use case, especially in many to many relationships

<br>
<hr>

## 7. Fetch Types: Eager vs Lazy Loading
- Eager will retrieve everything
- Lazy will retrieve on request

<br>
<hr>

