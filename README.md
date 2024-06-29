# DB Component

DBComponent was a university project that consisted of building a library to allow connecting to a PostgreSQL database through a connection pool.

The component is made up of the following files:

- ConexionBDD: This class performs a general management of the connection to the database. Returns and closes the connection as well as indicating if the connection is busy with methods.
- Pool: This class uses a Java ArrayList to store connections and support high traffic. The connections are added to the pool indicating the DB access credentials found in a .properties file and the query to be executed from those found in the queries.properties file.
- Params: This class manages the types of parameters related to the queries that are made to the database. In this component we only include data of type string.
- Hilos: This class is in charge of overriding the run method of the Thread class with an instance of the DBComponent class and executing a query to the DB.
- DBComponent: This class is the center of the connection component where there are the methods to execute queries, obtain and set connections and indicate values and types of parameters.

This project helped me to understand and practice the following concepts:

- Connection between Java and postgreSQL.
- ArrayList.
- Threads.
- .properties files.
- Management of parameters.
- Connection class and its methods.
- ResultSet and Statement classes.
- Implementation of connection pool.
- Exception handling.

The component can be exported as a .jar file and used in other packages.

> [!NOTE]
> School project for visual programming class at URU.
