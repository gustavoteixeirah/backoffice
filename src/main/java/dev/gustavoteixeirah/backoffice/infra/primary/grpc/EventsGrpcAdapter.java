package dev.gustavoteixeirah.backoffice.infra.primary.grpc;

import dev.gustavoteixeirah.backoffice.EventActionType;
import dev.gustavoteixeirah.backoffice.EventProto;
import dev.gustavoteixeirah.backoffice.EventsServiceGrpc;
import dev.gustavoteixeirah.backoffice.ListEventsRequest;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

import java.util.UUID;

@GrpcService
public class EventsGrpcAdapter extends EventsServiceGrpc.EventsServiceImplBase {

    @Override
    public void listEvents(ListEventsRequest request, StreamObserver<ListEventsRequest.Response> responseObserver) {
        EventProto eventProto = EventProto.newBuilder()
                .setEventId(UUID.randomUUID().toString())
                .setActionType(EventActionType.CREATED)
                .build();
        ListEventsRequest.Response response = ListEventsRequest.Response.newBuilder()
                .addEvents(eventProto)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
