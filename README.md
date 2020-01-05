# json_reader_bordea

This program parallely reads json file with spark and outputs parsed 
objects to the command line. As a template was used 
`MrPowers/spark-sbt.g8` project. You can get it with the following command:
```console
$ sbt new MrPowers/spark-sbt.g8
```

### How to install

First install [sbt](https://www.scala-sbt.org/download.html) and download 
[Spark](https://spark.apache.org/downloads.html) (version 2.4.x, scala 2.11). 
You will also need to download the 
[json file](https://storage.googleapis.com/otus_sample_data/winemag-data.json.tgz) 
with objects.
Then clone the repository:
```console
$ git clone git@github.com:sbordya/json_reader_bordea.git
```
Navigate to the project folder and prepare a jar file with dependencies
(you will be able to see it under the path 
`<path_to_project>/target/scala-2.11/json_reader_bordea-assembly-0.0.1.jar`):
```console
$ sbt assembly
```
Now you are ready to run the program:
```console
$ <path_to_spark>/bin/spark-submit --master local[*] --class com.example.JsonReader <path_to_project>/target/scala-2.11/json_reader_bordea-assembly-0.0.1.jar <path_to_json_file>
```

If you want to see the graph of dependencies, you can run:
```console
$ sbt dependencyBrowseGraph
```
### Project Goals

This program was created during the 
[data engineer](https://otus.ru/lessons/data-engineer/?int_source=courses_catalog&int_term=data-science) 
course on [otus.ru](https://otus.ru/). 