package com.onetwostory;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class AppLifesycleListener {

    private static final Logger log =
            Logger.getLogger(String.format("Application life cycle in %s", AppLifesycleListener.class.getName()));

    public void onStart(@Observes StartupEvent startupEvent) {
        log.info("On application start: onStart");
    }

    public void onStop(@Observes ShutdownEvent shutdownEvent) {
        log.info("On application stop: onStop");
    }
}
