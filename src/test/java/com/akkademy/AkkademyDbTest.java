package com.akkademy;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import com.akkademy.messages.VoteRequest;
import org.junit.Test;
import scala.concurrent.Future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static akka.pattern.Patterns.ask;
import static junit.framework.TestCase.assertEquals;
import static scala.compat.java8.FutureConverters.toJava;

/**
 * Created by walid on 15/07/2017.
 */
public class AkkademyDbTest {
    private ActorSystem system = ActorSystem.create();

    @Test
    public void itShouldPlaceKeyValueFromSetMessageIntoMap() {
        TestActorRef<AkkademyDb> actorRef = TestActorRef.create(system, Props.create(AkkademyDb.class));
        actorRef.tell(new VoteRequest("blue", 5), ActorRef.noSender());
        actorRef.tell(new VoteRequest("red", 1), ActorRef.noSender());
        actorRef.tell(new VoteRequest("blue", 3), ActorRef.noSender());
        AkkademyDb akkademyDb = actorRef.underlyingActor();
        assertEquals((int) akkademyDb.map.get("blue"), 8);
    }

    ActorRef actorRef = system.actorOf(Props.create(AkkademyDb.class));

    @Test
    public void shouldReplyToPingWithPong() throws Exception {
        final CompletionStage<String> cs = askPong("Ping");
        final CompletableFuture<String> jFuture = (CompletableFuture<String>) cs;
        assert (jFuture.get(1000, TimeUnit.MILLISECONDS).equals("Pong"));
    }

    @Test(expected = ExecutionException.class)
    public void shouldReplyToUnknownMessageWithFailure() throws Exception {
        final CompletionStage<String> cs = askPong("Unknown");
        final CompletableFuture<String> jFuture = (CompletableFuture<String>) cs;
        jFuture.get(1000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void printToConsole() throws Exception {
        askPong("Ping").
                // consume the return value x
                thenAccept(x -> System.out.println("replied with: " + x));
        // sleep to not miss on the asynchronous response and make sure the println runs.
        Thread.sleep(100);
    }

    public CompletionStage<String> askPong(String message) {
        Future sFuture = ask(actorRef, message, 1000);
        CompletionStage<String> cs = toJava(sFuture);
        return cs;
    }
}
