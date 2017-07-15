package com.akkademy;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import com.akkademy.messages.VoteRequest;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by walid on 15/07/2017.
 */
public class AkkademyDbTest {
    private ActorSystem system = ActorSystem.create();

    @Test
    public void itShouldPlaceKeyValueFromSetMessageIntoMap() {
        TestActorRef<AkkademyDb> actorRef = TestActorRef.create(system, Props.create(AkkademyDb.class));
        actorRef.tell(new VoteRequest("blue", 5), ActorRef.noSender());
        AkkademyDb akkademyDb = actorRef.underlyingActor();
        assertEquals((int) akkademyDb.map.get("blue"), 5);
    }
}
