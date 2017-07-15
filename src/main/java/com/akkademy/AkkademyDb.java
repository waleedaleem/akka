package com.akkademy;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import com.akkademy.messages.VoteRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by walid on 15/07/2017.
 */
public class AkkademyDb extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
    protected final Map<String, Integer> map = new HashMap<>();

    private AkkademyDb() {
        // implement a vote actor receiving (color, score) pairs and returning overall result
        receive(ReceiveBuilder.match(VoteRequest.class, message -> {
                    log.info("Received vote request – key: {} score: {}", message.getKey(), message.getScore());
                    map.put(message.getKey(), (Integer)(message.getScore()));
                }).matchAny(o -> log.info("received unknown message {}", o)).build()
        );
    }
}
