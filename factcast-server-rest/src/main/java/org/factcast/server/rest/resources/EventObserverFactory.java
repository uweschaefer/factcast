package org.factcast.server.rest.resources;

import java.net.URI;
import java.util.function.Supplier;

import org.factcast.core.subscription.Subscription;
import org.glassfish.jersey.media.sse.EventOutput;
import org.springframework.stereotype.Component;

import com.mercateo.common.rest.schemagen.link.LinkFactory;
import com.mercateo.common.rest.schemagen.types.HyperSchemaCreator;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
class EventObserverFactory {

    private final LinkFactory<EventsResource> eventsResourceLinkFactory;

    private final HyperSchemaCreator hyperSchemaCreator;

    EventObserver createFor(EventOutput eventOutput, URI baseURI, Supplier<Subscription> subsup) {
        return new EventObserver(eventOutput, eventsResourceLinkFactory, hyperSchemaCreator,
                baseURI, subsup);
    }
}
