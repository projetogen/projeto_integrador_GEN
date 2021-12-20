package com.projetoIntegrador.EducacaoDeQualidade.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

public class SwaggerConfig {

	@Bean
	public OpenAPI springOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Projeto Integrador")
						.description("Nosso Projeto Integrador")
						.version("v0.0.1")
						.license(new License()
								.name("Generation Brazil")
								.url("https://brazil.generation.org/"))
						.contact(new Contact()
								.name("Projeto Gen")
								.url("https://github.com/projetogen")))
				.externalDocs(new ExternalDocumentation()
						.description("Github Projeto Integrador")
						.url("https://github.com/projetogen/projeto_integrador_GEN"));
	}
	
	private ApiResponse createApiResponse(String message) {
		return new ApiResponse().description(message);
	}
	
	@Bean
	public OpenApiCustomiser customerGlobalResponseStatus() {
		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
				ApiResponses api = operation.getResponses();
				
				api.addApiResponse("200", createApiResponse("Sucesso!"));
				api.addApiResponse("201", createApiResponse("Criado!"));
				api.addApiResponse("204", createApiResponse("Sem conteudo!"));
				api.addApiResponse("400", createApiResponse("Erro de requisição!"));
				api.addApiResponse("401", createApiResponse("Não autorizado!"));
				api.addApiResponse("404", createApiResponse("Não encontrado!"));
				api.addApiResponse("500", createApiResponse("Erro interno do servidor!"));
			}));
		};
	}
}
