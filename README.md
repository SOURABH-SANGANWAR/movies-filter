# Movies API.

This is an API service using ElasticSearch and Mongodb in java spring-boot application.
This is based on dataset: **https://www.kaggle.com/datasets/rounakbanik/the-movies-dataset**.

# Getting Started

## Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/#build-image)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#data.nosql.mongodb)
* [Spring Data Elasticsearch (Access+Driver)](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#data.nosql.elasticsearch)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#web)

## Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)


## Project Properties
Add application.properties in src/main/java/resources with following content.
### MongoDB configuration
spring.data.mongodb.uri= <mongodb://{username}:{password}@localhost:{port}/{dbname}>
mongodb_movie_cluster_name = (MONGO_DB MOVIES CLUSTER)\
mongodb_actor_cluster_name = (MONGO_DB ACTORS CLUSTER)\
mongodb_cast_cluster_name = (MONGO_DB CAST CLUSTER)
### Elasticsearch configuration
spring.elasticsearch.cluster-nodes=(host)<br>
spring.elasticsearch.cluster-name=(cluster-name)
elastic_movie_index_name = (ELASTICSEARCH MOVIES INDEX)\
elastic_actor_index_name = (ELASTICSEARCH ACTOR INDEX)\
elastic_cast_index_name = (ELASTICSEARCH CAST INDEX)


## Current Configuration:
### MongoDb: 
### ElasticSearch : 
##### docker.elastic.co/elasticsearch/elasticsearch:8.8.0
##### Make movie_id and actor_id as keyword or enable fielddata as true. Edit code in ElasticsearchQuery accordingly.
##### Currently, movie_id is key_word and actor_id is set as fielddata = true according to code.
## APIRoutes

Following are List of APIRoutes defined and example body/ response:
<ol>
<li> 
<details>
<summary>
/actors['POST']:
</summary>
<ul>
<li>
   Creates new actors
</li>
<li>
   ExampleBody:
     {<br>
    &nbsp;&nbsp;&nbsp;&nbsp; "id":31,<br>
    &nbsp;&nbsp;&nbsp;&nbsp; "gender":2,<br>
    &nbsp;&nbsp;&nbsp;&nbsp; "name":"Tom Hanks",<br>
    &nbsp;&nbsp;&nbsp;&nbsp; "profile_path":"\/pQFoyx7rp09CJTAb932F2g8Nlho.jpg"<br>
    }
</li>
<li>
   Status Codes: Success: 201, Error: 400
</li>
</ul>
</details>
</li>
<li>
<details>
<summary>
/actors/create-multiple['POST']:
</summary>
<ul>
<li>
  Creates multiple actors by passing list
 </li>
<li>
  Example Body:
    [<br>
      &nbsp;&nbsp;&nbsp;&nbsp;{<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "id":31,<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "gender":2,<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name":"Tom Hanks",<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "profile_path":"\/pQFoyx7rp09CJTAb932F2g8Nlho.jpg"<br>
      &nbsp;&nbsp;&nbsp;&nbsp;},<br>
      &nbsp;&nbsp;&nbsp;&nbsp;{<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "id":31,<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "gender":2,<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name":"Tom Hanks",<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "profile_path":"\/pQFoyx7rp09CJTAb932F2g8Nlho.jpg"<br>
      &nbsp;&nbsp;&nbsp;&nbsp;}<br>
    ]
</li>
<li>
  Status Codes: Success: 201, Error: 400
</li>
</ul>
</details>
</li>
<li>
<details>
<summary>/actors/mongodb['GET']:</summary>
<ul>
<li>Fetch data from mongodb. Get all actors</li>
<li>Example Response:<br>
    [<br>
      &nbsp;&nbsp;&nbsp;&nbsp;{<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": "862",<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"gender": 2,<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"name": "George C. Scott",<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"profile_path": "/mINHwB258stf5M4AZcpzXK1GRjW.jpg"<br>
      &nbsp;&nbsp;&nbsp;&nbsp;},<br>
      &nbsp;&nbsp;&nbsp;&nbsp;{<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": "31",<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"gender": 2,<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"name": "Tom Hanks",<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"profile_path": "/pQFoyx7rp09CJTAb932F2g8Nlho.jpg"<br>
      &nbsp;&nbsp;&nbsp;&nbsp;}<br>
    ]
</li>
<li>Status Codes: Success: 200, Error: 400</li>
</ul>
</details>
</li>


<li>
<details>
<summary> /actors/mongodb/(id)   ['GET']:</summary>
<ul>
<li>Fetches an actor</li>
<li>Example Response:<br>
      &nbsp;&nbsp;&nbsp;&nbsp;{<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": "862",<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"gender": 2,<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"name": "George C. Scott",<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"profile_path": "/mINHwB258stf5M4AZcpzXK1GRjW.jpg"<br>
      &nbsp;&nbsp;&nbsp;&nbsp;}
</li>
<li>Status Codes: Success: 200, Error: 400</li>
</ul>
</details>
</li>




<li>
<details>
<summary>/actors/es/{text} ['GET']:</summary>
<ul>
<li>Fetch data from elasticsearch. Get all actors with name contains text given.</li>
<li>Example Request: /actors/es/Tom </li>
<li>Example Response:<br>
    [<br>
      &nbsp;&nbsp;&nbsp;&nbsp;{<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": "862",<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"gender": 2,<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"name": "Roger Tom",<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"profile_path": "/mINHwB258stf5M4AZcpzXK1GRjW.jpg"<br>
      &nbsp;&nbsp;&nbsp;&nbsp;},<br>
      &nbsp;&nbsp;&nbsp;&nbsp;{<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": "31",<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"gender": 2,<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"name": "Tom Hanks",<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"profile_path": "/pQFoyx7rp09CJTAb932F2g8Nlho.jpg"<br>
      &nbsp;&nbsp;&nbsp;&nbsp;}<br>
    ]
</li>
<li>Status Codes: Success: 200, Error: 400</li>
</ul>
</details>
</li>



<li>
<details>
<summary>/movies/es/{text} ['GET']:</summary>
<ul>
<li>Fetch data from elasticsearch. Get all movies with title contains text given.</li>
<li>Example Request: /moves/es/Toy </li>
<li>Example Response:<br>
    [<br>
      &nbsp;&nbsp;&nbsp;&nbsp;{<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": "862",<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"gender": 2,<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"name": "Roger Tom",<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"profile_path": "/mINHwB258stf5M4AZcpzXK1GRjW.jpg"<br>
      &nbsp;&nbsp;&nbsp;&nbsp;},<br>
      &nbsp;&nbsp;&nbsp;&nbsp;{<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": "31",<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"gender": 2,<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"name": "Tom Hanks",<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"profile_path": "/pQFoyx7rp09CJTAb932F2g8Nlho.jpg"<br>
      &nbsp;&nbsp;&nbsp;&nbsp;}<br>
    ]
</li>
<li>Status Codes: Success: 200, Error: 400</li>
</ul>
</details>
</li>



<li>
<details>
<summary> /cast/actors/common   ['GET']:</summary>
<ul>
<li>Takes list of actor Ids and returns movies which are common between these actors.</li>
<li>Returns lists of lists. Each list contains casts of same movie for each actor.</li>
<li>Example Body: ["actor_id1", "actor_id2", ...]</li>
<li>Example Response:<br>
[
    <br>&nbsp;&nbsp;&nbsp;&nbsp;[
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"character": "char1",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"actor_id": "1",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"movie_id": "1",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"actor_name": "actor1"
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"character": "char1",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"actor_id": "2",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"movie_id": "1",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"actor_name": "actor2"
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}
    <br>&nbsp;&nbsp;&nbsp;&nbsp;],
    <br>&nbsp;&nbsp;&nbsp;&nbsp;[
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"character": "char1",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"actor_id": "1",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"movie_id": "2",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"actor_name": "actor1"
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"character": "char1",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"actor_id": "2",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"movie_id": "2",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"actor_name": "actor2"
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}
    <br>&nbsp;&nbsp;&nbsp;&nbsp;]
    <br>]

</li>
<li>Status Codes: Success: 200, Error: 400</li>
</ul>
</details>
</li>






<li>
<details>
<summary> /cast/movies/common   ['GET']:</summary>
<ul>
<li>Takes list of movie Ids and returns casts which are common between these movies.</li>
<li>Returns lists of lists. Each list contains casts of same actor for each moive.</li>
<li>Example Body: ["movie_id1", "movie_id2", ...]</li>
<li>Example Response:<br>
[
    <br>&nbsp;&nbsp;&nbsp;&nbsp;[
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"character": "char1",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"actor_id": "1",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"movie_id": "1",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"actor_name": "actor1"
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"character": "char1",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"actor_id": "1",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"movie_id": "2",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"actor_name": "actor1"
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}
    <br>&nbsp;&nbsp;&nbsp;&nbsp;],
    <br>&nbsp;&nbsp;&nbsp;&nbsp;[
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"character": "char1",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"actor_id": "2",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"movie_id": "1",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"actor_name": "actor2"
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"character": "char1",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"actor_id": "2",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"movie_id": "2",
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"actor_name": "actor2"
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}
    <br>&nbsp;&nbsp;&nbsp;&nbsp;]
    <br>]

</li>
<li>Status Codes: Success: 200, Error: 400</li>
</ul>
</details>
</li>

</ol>