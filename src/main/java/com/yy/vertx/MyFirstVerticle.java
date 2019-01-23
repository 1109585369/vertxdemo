package com.yy.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class MyFirstVerticle extends AbstractVerticle {

    @Override
    public void start(final Future<Void> startFuture) throws Exception {
        vertx
                .createHttpServer()
                .requestHandler(r -> {
                    r.response().end("Hello from my first " +
                            "Vert.x 3 application");
                })
                .listen(8080, result -> {
                    if (result.succeeded()) {
                        startFuture.complete();
                    } else {
                        startFuture.fail(result.cause());
                    }
                });
    }
//
//    public static void main(String[] args) {
//        this.start();this.start();
//    }

}
