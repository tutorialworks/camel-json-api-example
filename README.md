# Camel Sports API (JSON in REST services)

This is a demo that shows how to use Apache Camel on Spring Boot to expose a REST service.

It also shows how to use Camel's _REST binding mode_ to automatically convert Java POJOs to JSON in the response. JSON support is provided by the `camel-jackson-starter` dependency.

For more info, check out the accompanying YouTube video and blog post!

- [Video: Adding JSON to my REST API (YouTube)][youtube]
- [Blog: Create a REST service in Apache Camel (tomd.xyz)][blog]

## To run

    mvn clean spring-boot:run
    
And the service will be accessible at:

    http://localhost:8080/services/go-sports
    
## To test

To test with `curl`:

    curl -H 'Content-Type: application/json' -X POST --data '{ "name": "Sportsball" }' http://localhost:8080/services/go-sports

If you're using another REST testing tool like Insomnia, just make sure it includes the header `Content-Type: application/json` in the request.

## Changing the URL

If you don't like `/services/` and you want to change the root URL used for all Camel servlet endpoints (e.g. REST services) then edit this line in `application.properties`:

    camel.component.servlet.mapping.context-path=/services/*

[youtube]: https://www.youtube.com/watch?v=YpVVXDnZLPo
[blog]: https://tomd.xyz/camel-rest/
