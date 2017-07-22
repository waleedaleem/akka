package com.akkademy;

import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * Created by walid on 22/07/2017.
 */
public class Main {

    public static void main(String... args) {
        ActorSystem system = ActorSystem.create("akkademy");
        system.actorOf(Props.create(AkkademyDb.class), "akkademy-db");
    }
}
