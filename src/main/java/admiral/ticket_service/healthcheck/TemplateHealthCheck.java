package admiral.ticket_service.healthcheck;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {

	private final String template;
	
	public TemplateHealthCheck(String template) {
		this.template = template;
	}



	@Override
	protected Result check() throws Exception {
		final String saying = String.format(template, "HELLO");
		
		if(!saying.contains("TEST")){
			return Result.unhealthy("template does not include the name");
		}
		
		return Result.healthy();
	}

}
