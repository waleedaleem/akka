package com.akkademy;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Status;
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
        //respond Ping with Pong back to sender
        receive(ReceiveBuilder
                .matchEquals("Ping", s -> sender().tell(s + "Pong", ActorRef.noSender()))
                .matchEquals("PingPingPong", s -> sender().tell(s + "Pong", ActorRef.noSender()))
                .match(VoteRequest.class, message -> {
                    log.info("Received vote request – key: {} score: {}", message.getKey(), message.getScore());
                    map.merge(message.getKey(), (Integer) (message.getScore()), Integer::sum);
                    log.info("Overall vote results are: {} score: {}", message.getKey(), map.get(message.getKey()));
                })
                .matchAny(o -> {
                    log.info("received unknown message {}", o);
                    //respond back to sender
                    sender().tell(new Status.Failure(new Exception("unknown message")), self());
                })
                .build()
        );
    }
}
