# Using JSON in REST services in Apache Camel

This is a demo that shows how to use Apache Camel on Spring Boot to expose a REST service with JSON payloads.

It shows how to use Camel's _REST binding mode_ to automatically convert POJOs (Plain Old Java Objects) into JSON in the response. In Camel, JSON support is provided by the `camel-jackson-starter` dependency.

For more info, check out the accompanying YouTube video and blog post!

- [Video: Adding JSON to my REST API (YouTube)][youtube] - This example has been slightly modified (some might say improved!) from the YouTube video.
- [Blog: Create a REST service in Apache Camel (tomd.xyz)][blog]

And for more tutorials check out <https://www.tutorialworks.com>.

## To run

You'll need [Apache Maven][maven] installed. Then run:

    mvn clean spring-boot:run
    
And the service will be accessible at:

    http://localhost:8080/services/go-sports
    
## To test

You can use an API testing tool like `curl` to test the GET operation of the service:

```bash
curl http://localhost:8080/services/go-sports
```

Which should return a response like this, showing all the sports in the repository. You can format the output nicely using a tool like [jq][jq]:

```json
[
  {
    "name": "American Football",
    "players": 11,
    "league": "NFL"
  },
  {
    "name": "Basketball",
    "players": 5,
    "league": "NBA"
  },
  {
    "name": "Baseball",
    "players": 9,
    "league": "MLB"
  },
  {
    "name": "Volleyball",
    "players": 6,
    "league": "NVA"
  }
]
```

To add a new Sport to the database with `curl`, send a POST request:

    curl -H 'Content-Type: application/json' -X POST --data '{ "name": "Football", "players": 11, "league": "Premier League" }' http://localhost:8080/services/go-sports

If you're using another REST testing tool like [Insomnia][insomnia], make sure that it includes the header `Content-Type: application/json` in the request.

## Changing the base API URL

If you don't like `/services/` and you want to change the root URL used for all Camel servlet endpoints (which includes REST services like this one) then edit this line in `application.properties`:

    camel.servlet.mapping.context-path=/services/*

## That's it!

That's all there is to it. You can now use the REST service to add and retrieve sports in JSON format.

We're keeping it simple here, using a simple Java object to store the sports. But in real usage you might swap out the `SportRepository` class with a different class to store and retrieve the data from a database.

## License

This project is licensed under the Apache License, Version 2.0. See the [LICENSE][license] file for more info.

[youtube]: https://www.youtube.com/watch?v=YpVVXDnZLPo
[blog]: https://tomd.xyz/camel-rest/
[maven]: https://maven.apache.org/
[jq]: https://stedolan.github.io/jq/
[insomnia]: https://insomnia.rest/
[license]: LICENSE

