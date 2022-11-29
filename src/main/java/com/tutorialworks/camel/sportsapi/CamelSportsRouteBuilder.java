package com.tutorialworks.camel.sportsapi;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CamelSportsRouteBuilder extends RouteBuilder {

    @Autowired
    SportRepository sportRepository;

    @Override
    public void configure() throws Exception {
        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.auto);

        rest()
                .path("/go-sports")

                .get()
                    .to("direct:getSports")

                .post()
                    .type(Sport.class)
                    .outType(SportResponse.class)
                    .to("direct:postSport");


        from("direct:getSports")
                // Get all the sports from the repository
                // Camel will marshal to JSON automatically!
                .bean(sportRepository, "getSports");

        from("direct:postSport")
                    .to("log:mylogger?showAll=true")

                    // An inline processor to generate the response
                    .process(new Processor() {
                        @Override
                        public void process(Exchange exchange) throws Exception {
                            // Get the Body as an (unmarshalled!) Sport POJO
                            Sport sport = exchange.getMessage().getBody(Sport.class);

                            sportRepository.addSport(sport);

                            // Build up the response using our SportResponse class
                            SportResponse response = new SportResponse();
                            response.setMessage("Thanks for submitting "
                                    + sport.getName());

                            // Pop the response back in the body
                            // Camel will marshal to JSON automatically!
                            exchange.getMessage().setBody(response);
                        }
                    });
    }

}
