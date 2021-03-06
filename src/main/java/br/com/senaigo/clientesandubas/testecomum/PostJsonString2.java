package br.com.senaigo.clientesandubas.testecomum;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.senaigo.clientesandubas.model.ClassificacaoMercadoria;

public class PostJsonString2 {

	public static void main(String[] args) {

		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/classificacaomercadoria");

		// Data send to web service.
		ClassificacaoMercadoria objeto = new ClassificacaoMercadoria(new Long(8), "teste nome", "Teste descricao");

		ClientResponse response = webResource.type("application/json").put(ClientResponse.class, objeto);

		if (response.getStatus() != 200) {
			System.out.println("Failed : HTTP error code : " + response.getStatus());

			String error = response.getEntity(String.class);
			System.out.println("Error: " + error);
			return;
		}

		System.out.println("Output from Server .... \n");

		String output = response.getEntity(String.class);

		System.out.println(output);

	}

}