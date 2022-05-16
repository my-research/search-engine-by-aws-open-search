package com.example.indexer;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class IndexThrower {

    @Value("${aws.open-search.master.url}")
    private String OPEN_SEARCH_MASTER_URI;
    private final RestTemplate restTemplate;

    public void putIndexedData() {
        URI uri = URI.create(OPEN_SEARCH_MASTER_URI);

        restTemplate.put(uri, null);
    }
}
