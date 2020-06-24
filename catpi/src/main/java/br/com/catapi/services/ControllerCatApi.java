package br.com.catapi.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mapstruct.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.catapi.bean.CategoriaRetornoBean;
import br.com.catapi.bean.GatoRetornoBean;
import br.com.catapi.bean.RacaGatoBean;
import br.com.catapi.business.CatApiBusiness;
import br.com.catapi.exception.BusinessException;
import br.com.catapi.exception.TechnicalException;




/**
 * Controller responsável por gerenciar as requisições para API Rest 
 * 
 * */
@RestController
@RequestMapping("/servicos")
public class ControllerCatApi {

	private static final String ERRO_EXCEPTION = "ERRO EXCEPTION";


	@Autowired
	private LogService log;
	
	
	private CatApiBusiness catApiBusiness = new CatApiBusiness();
	

	/**
	 * <p> Metodo get responsavél por retornar todas as raças
	 * <a href="http://localhost:8080/listarracas/">Listar Raças</a>
	 * </p>
	 * @param ()
	 * @return List<RacaGatoBean>
	 * @since 1.0
	 * @throws UnautorizedException | ErroException
	 */
	@GetMapping("listarracas/")
	public List<RacaGatoBean> consultaListaRacas(@RequestHeader(value = "Accept") String acceptHeader,@RequestHeader(value = "Authorization") String authorizationHeader,@Context HttpServletRequest request){
		
		List<RacaGatoBean> listaRacas = null;
		
		try {
		
			log.gravarLog(request.getRequestURL().toString(), this.getClass().getSimpleName(), LogService.INFO);
			
			
			if (!catApiBusiness.validarLogin(authorizationHeader)) {
				
				log.gravarLog(new UnautorizedException().getMessage(), this.getClass().getSimpleName(), LogService.ERROR);
				
				throw new UnautorizedException();
			}

			listaRacas = catApiBusiness.listarRacas();

		
		} catch (BusinessException | TechnicalException e) {
			
			log.gravarLog(ERRO_EXCEPTION, this.getClass().getSimpleName(), LogService.ERROR,e);

			throw new ErroException();

		}
		

		log.gravarLog(listaRacas, this.getClass().getSimpleName(), LogService.INFO);
		return listaRacas;

	}

	
	
	
	/**
	 * <p> Metodo get responsavél por listar todas categorias
	 * <a href="http://localhost:8080/listarracas/">Listar Raças</a>
	 * </p>
	 * @param ()
	 * @return List<RacaGatoBean>
	 * @since 1.0
	 * @throws UnautorizedException | ErroException
	 */
	@GetMapping("listarcategoria/")
	public List<CategoriaRetornoBean> listarCategoria(@RequestHeader(value = "Accept") String acceptHeader,@RequestHeader(value = "Authorization") String authorizationHeader,@Context HttpServletRequest request){
		
		List<CategoriaRetornoBean> listaCategoria = null;
		
		try {
			
			log.gravarLog(request.getRequestURL().toString(), this.getClass().getSimpleName(), LogService.INFO);
			
			
			if (!catApiBusiness.validarLogin(authorizationHeader)) {
				
				log.gravarLog(new UnautorizedException().getMessage(), this.getClass().getSimpleName(), LogService.ERROR);
				
				throw new UnautorizedException();
			}
			
			listaCategoria = catApiBusiness.listarTodasCategorias();
			
			
		} catch (BusinessException | TechnicalException e) {
			
			log.gravarLog(ERRO_EXCEPTION, this.getClass().getSimpleName(), LogService.ERROR,e);
			
			throw new ErroException();
			
		}
		
		
		log.gravarLog(listaCategoria, this.getClass().getSimpleName(), LogService.INFO);
		return listaCategoria;
		
	}
	
	
	
	
	
	
	
	/**
	 * <p> Metodo get responsavél por listar informações da Raça por Id
	 * <a href="http://localhost:8080/listarinformacaoraca/bslo">Lista Por Id</a>
	 * </p>
	 * @param Sring
	 * @return List<RacaGatoBean>
	 * @since 1.0
	 * @throws UnautorizedException | ErroException 
	 */
	@GetMapping("listarinformacaoraca/{idExterno}")
	public List<RacaGatoBean> listarInfoPorRaca(@PathVariable("idExterno") String  idExterno,  @RequestHeader(value = "Accept") String acceptHeader,@RequestHeader(value = "Authorization") String authorizationHeader,@Context HttpServletRequest request){
		
		List<RacaGatoBean>  listaGatos;
		
			log.gravarLog(request.getRequestURL().toString(), this.getClass().getSimpleName(), LogService.INFO);

		try {
			if (!catApiBusiness.validarLogin(authorizationHeader)) {
				
				log.gravarLog(new UnautorizedException().getMessage(), this.getClass().getSimpleName(), LogService.ERROR);
				
				throw new UnautorizedException();
			}
			
		  listaGatos =	catApiBusiness.listarInformacaoPorRaca(idExterno);
			
		} catch (BusinessException | TechnicalException e) {

			log.gravarLog(ERRO_EXCEPTION, this.getClass().getSimpleName(), LogService.ERROR);
			throw new ErroException();
		
		
		}
		
		log.gravarLog(listaGatos, this.getClass().getSimpleName(), LogService.INFO);
		return listaGatos;
		
	}
	
	/**
	 * <p> Metodo get responsavél por listar informações da Raça por Temperamento
	 * <a href="http://localhost:8080/listarinformacaotemperamento/Easy Going/">Listar Por Temperamento </a>
	 * </p>
	 * @param Sring
	 * @return List<RacaGatoBean>
	 * @since 1.0
	 * @throws UnautorizedException | ErroException
	 */
	@GetMapping("listarinformacaotemperamento/{temperamento}")		
	public List<RacaGatoBean> listarInfoTemperamento(@PathVariable("temperamento") String  temperamento,  @RequestHeader(value = "Accept") String acceptHeader,@RequestHeader(value = "Authorization") String authorizationHeader,@Context HttpServletRequest request)
			{
		
			List<RacaGatoBean> listaGatos;
			log.gravarLog(request.getRequestURL().toString(), this.getClass().getSimpleName(), LogService.INFO);

			
		try {
			if (!catApiBusiness.validarLogin(authorizationHeader)) {
				
				log.gravarLog(new UnautorizedException().getMessage(), this.getClass().getSimpleName(), LogService.ERROR);
				throw new UnautorizedException();
			}
		
		 listaGatos = 	catApiBusiness.listarInformacaoPorTemperamento(temperamento);
			
		} catch (BusinessException | TechnicalException e) {

			log.gravarLog(ERRO_EXCEPTION, this.getClass().getSimpleName(), LogService.ERROR,e);
			throw new ErroException();
		}
		
		log.gravarLog(listaGatos, this.getClass().getSimpleName(), LogService.INFO);
		return listaGatos;
		
	}
	
	/**
	 * <p> Metodo get responsavél por listar informações da Raça por Origem
	 * <a href="http://localhost:8080/listarinformacaoorigem/Easy Going/">Listar Por Origem </a>
	 * </p>
	 * @param Sring
	 * @return List<RacaGatoBean>
	 * @since 1.0
	 * @throws UnautorizedException | ErroException
	 * 
	 */
	@GetMapping("listarinformacaoorigem/{origem}")	
	public List<RacaGatoBean> listarInfoOrigem(@PathVariable("origem") String  origem,  @RequestHeader(value = "Accept") String acceptHeader,@RequestHeader(value = "Authorization") String authorizationHeader,@Context HttpServletRequest request){
		
		log.gravarLog(request.getRequestURL().toString(), this.getClass().getSimpleName(), LogService.INFO);
		List<RacaGatoBean> racaOrigem;
		
		try {
			if (!catApiBusiness.validarLogin(authorizationHeader)) {
				
				log.gravarLog(new UnautorizedException().getMessage(), this.getClass().getSimpleName(), LogService.ERROR);
				
				throw new UnautorizedException();
			}

		 racaOrigem =	catApiBusiness.listarInformacaoPorOrigem(origem);
		} catch (BusinessException | TechnicalException e) {

			log.gravarLog(ERRO_EXCEPTION, this.getClass().getSimpleName(), LogService.ERROR,e);
			throw new ErroException();
		}
		
		log.gravarLog(racaOrigem, this.getClass().getSimpleName(), LogService.INFO);
		return racaOrigem;
		
	}
	
	/**
	 * <p> Metodo get responsavél por Gravar Imagem para todas Racas disponiveis
	 * <a href="http://localhost:8080/gravarimagemtodasracas/1/">Gravar Imagem todas Raca  </a>
	 * </p>
	 * @param Sring
	 * @return List<RacaGatoBean>
	 * @since 1.0
	 * @throws UnautorizedException | ErroException
	 * 
	 */
	@GetMapping("gravarimagemtodasracas/{quantidade}")	
	public List<GatoRetornoBean> gravarImagemTodasRacas(@PathVariable("quantidade") Long  quantidade,  @RequestHeader(value = "Accept") String acceptHeader,@RequestHeader(value = "Authorization") String authorizationHeader,@Context HttpServletRequest request){
		
		log.gravarLog(request.getRequestURL().toString(), this.getClass().getSimpleName(), LogService.INFO);
		List<GatoRetornoBean> listaImagemPorRaca;
		
		try {
			if (!catApiBusiness.validarLogin(authorizationHeader)) {
				
				log.gravarLog(new UnautorizedException().getMessage(), this.getClass().getSimpleName(), LogService.ERROR);
				
				throw new UnautorizedException();
			}

			listaImagemPorRaca =	catApiBusiness.gravarImagemPorRaca(quantidade);
		} catch (BusinessException | TechnicalException e) {

			log.gravarLog(ERRO_EXCEPTION, this.getClass().getSimpleName(), LogService.ERROR,e);
			throw new ErroException();
		}
		
		log.gravarLog(listaImagemPorRaca, this.getClass().getSimpleName(), LogService.INFO);
		return listaImagemPorRaca;
		
	}
	
	/**
	 * <p> Metodo get responsavel por categoria salver a imagem
	 * <a href="http://localhost:8080/gravarimagemtodasracas/1/">Gravar Imagem todas Raca  </a>
	 * </p>
	 * @param Sring
	 * @return List<RacaGatoBean>
	 * @since 1.0
	 * @throws UnautorizedException | ErroException
	 * 
	 */
	@GetMapping("gravarimagemcategoria/{categoria}/{quantidade}")	
	public List<GatoRetornoBean> gravarImagemCategoria(@PathVariable("categoria") String  categoria,@PathVariable("quantidade") Long  quantidade,  @RequestHeader(value = "Accept") String acceptHeader,@RequestHeader(value = "Authorization") String authorizationHeader,@Context HttpServletRequest request){
		
		log.gravarLog(request.getRequestURL().toString(), this.getClass().getSimpleName(), LogService.INFO);
		List<GatoRetornoBean> listaImagemPorRaca;
		
		try {
			if (!catApiBusiness.validarLogin(authorizationHeader)) {
				
				log.gravarLog(new UnautorizedException().getMessage(), this.getClass().getSimpleName(), LogService.ERROR);
				
				throw new UnautorizedException();
			}
			
			listaImagemPorRaca =	catApiBusiness.gravarImagemCategoria(categoria,quantidade);
		} catch (BusinessException | TechnicalException e) {
			
			log.gravarLog(ERRO_EXCEPTION, this.getClass().getSimpleName(), LogService.ERROR,e);
			throw new ErroException();
		}
		
		log.gravarLog(listaImagemPorRaca, this.getClass().getSimpleName(), LogService.INFO);
		return listaImagemPorRaca;
		
	}
	
	
	@GetMapping("/teste")	
	public String teste(){
		
		return "TESTE";
	}

	/**
	 * <p> Classe UnautorizedException USUARIO NÃO ENCONTRADO/SEM PERMISSÃO DE ACESSO
	 * </p>
	 * @since 1.0
	 */
	@ResponseStatus(value = org.springframework.http.HttpStatus.UNAUTHORIZED, reason = "USUARIO NÃO ENCONTRADO/SEM PERMISSÃO DE ACESSO")
	private class UnautorizedException extends RuntimeException {
		private static final long serialVersionUID = -4208520953479458754L;
	}

	/**
	 * <p> Classe ErroException PROBLEMA NA EXECUÇÃO
	 * </p>
	 * @since 1.0
	 */
	@ResponseStatus(value = org.springframework.http.HttpStatus.BAD_GATEWAY, reason = "PROBLEMA NA EXECUÇÃO")
	private class ErroException extends RuntimeException {
		private static final long serialVersionUID = 3809818210346794027L;
	}

}