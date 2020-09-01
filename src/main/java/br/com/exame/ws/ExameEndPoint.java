package br.com.exame.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.exame.dao.impl.JDBCExameDAO;
import br.com.exame.ws.client.GetExameRequest;
import br.com.exame.ws.client.GetExameResponse;

@Endpoint
public class ExameEndPoint {

	private static final String NAMESPACE_URI = "http://client.ws.exame.com.br";

	private JDBCExameDAO jdbcExameDAO;

	@Autowired
	public ExameEndPoint(JDBCExameDAO jdbcExameDAO) {
		this.jdbcExameDAO = jdbcExameDAO;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getExameRequest")
	@ResponsePayload
	public GetExameResponse getExame(@RequestPayload GetExameRequest request) {
		GetExameResponse response = new GetExameResponse();
		response.setExame(jdbcExameDAO.findExame(Long.valueOf(request.getId())));
		return response;
	}
}
