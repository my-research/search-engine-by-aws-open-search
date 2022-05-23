package com.example.indexer.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.http.HttpHeaders;

@Configuration
@EnableElasticsearchRepositories
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

    public static final String ACCEPT_HEADER = "Accept";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String COMPATIBLE_HEADER_VALUE = "application/vnd.elasticsearch+json;compatible-with=7";

    @Value("${elasticsearch.url}")
    private String ES_URL;
    @Value("${elasticsearch.username}")
    private String ES_USERNAME;
    @Value("${elasticsearch.password}")
    private String ES_PASSWORD;

    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {

        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(ES_URL)
                .usingSsl()
                .withBasicAuth(ES_USERNAME, ES_PASSWORD)
                .withDefaultHeaders(getCompatibilityHeader())
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

    private HttpHeaders getCompatibilityHeader() {
        HttpHeaders compatibilityHeaders = new HttpHeaders();

        compatibilityHeaders.add(ACCEPT_HEADER, COMPATIBLE_HEADER_VALUE);
        compatibilityHeaders.add(CONTENT_TYPE, COMPATIBLE_HEADER_VALUE);

        return compatibilityHeaders;
    }
}
