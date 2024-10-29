package com.bpjstk.JSReport.services.networks;

import com.bpjstk.JSReport.models.PostDataBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@Service
public class NetworkService {
    private final WebClient webClient;

    @Autowired
    public NetworkService(WebClient webClient) {
        this.webClient = webClient;
    }

    public CompletableFuture<byte[]> post(PostDataBuilder data) {
        return this.webClient
                .post()
                .body(Mono.just(data), PostDataBuilder.class)
                .retrieve()
                .bodyToMono(byte[].class)
                .toFuture();
    }
}
