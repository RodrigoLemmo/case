package br.com.catapi.services;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import br.com.catapi.exception.BusinessException;
import br.com.catapi.util.ConfiguracaoAPI;
import br.com.catapi.util.ConfiguracaoElasticData;

@Configuration
@EnableElasticsearchRepositories(basePackages = "br.com.catapi.elasticsearch.repositorio")
@ComponentScan(basePackages = { "br.com.catapi.services" })
public class ConfigElastic {
	

	@Bean
    public RestHighLevelClient client() throws BusinessException {
		ConfiguracaoElasticData configuracaoElasticData = new ConfiguracaoElasticData(ConfiguracaoAPI.CONF_PROPRIEDADES_ELASTICSPRING);
        ClientConfiguration clientConfiguration= ClientConfiguration.builder().connectedTo(configuracaoElasticData.getServidorUrl())
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
 
    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws BusinessException {
        return new ElasticsearchRestTemplate(client());
    }
}