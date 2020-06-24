package br.com.catapi.services;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


import br.com.catpi.dao.ControleLog;
@Repository
public interface LogRepository extends ElasticsearchRepository<ControleLog, String> {
 
    org.springframework.data.domain.Page<ControleLog> findByLogEntrada(String name,  org.springframework.data.domain.Pageable pageable);
 
    @Query("{\"bool\": {\"must\": [{\"match\": {\"logEntrada\": \"?0\"}}]}}")
    org.springframework.data.domain.Page<ControleLog> queryPorParametroEntreda(String name, org.springframework.data.domain.Pageable pageable);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"dataRegistroLogEntrada\": \"?0\"}}]}}")
    org.springframework.data.domain.Page<ControleLog> queryPorData(String name, org.springframework.data.domain.Pageable pageable);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"authorsName\": \"?0\"}}]}}")
    org.springframework.data.domain.Page<ControleLog> queryPorDataClasse(String name, org.springframework.data.domain.Pageable pageable);
    
    @Query("{\"bool\": {\"must\": [{\"match\": {\"tipo\": \"?0\"}}]}}")
    org.springframework.data.domain.Page<ControleLog> queryPorTipoErro(String name, org.springframework.data.domain.Pageable pageable);
    

}