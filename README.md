# planisense_add_data

Used to read from les-arbres.csv and fill the database.

### The database has to already have been setup as such:
* It has a table named *arbres*
* *arbres* has 3 columns:
```id: Integer, arrondissement: varchar, genre: varchar```

### Building the app
```mvn clean package```

### Running the app
The program takes exactly one argument and it is the path to the csv "les-arbres.csv"

It needs an *application.properties* file located in the same place as the jar

**ex:**
```
$ tree
.
|_ application.properties
|_ planisense_add_data-{version}.jar
|_ les-arbres.csv

$ java -jar planisense_add_data-{version}.jar les-arbres.csv
```

### Application.properties
* **database.url** : cf. https://jdbc.postgresql.org/documentation/head/connect.html
* **database.username**
* **database.password**