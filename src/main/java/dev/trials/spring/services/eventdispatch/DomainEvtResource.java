package dev.trials.spring.services.eventdispatch;

import java.io.Serializable;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder(toBuilder = true)
public class DomainEvtResource implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -6381458457178751755L;
	@NotNull
	private long timestamp;
	@NotNull
	@Size(min = 4, max = 20)
	private String domain;
	private String subdomain;
	@NotNull
	@Size(min = 4, max = 20)
	private String sourceRef;
	@NotNull
	@Size(min = 4, max = 20)
	private String type;
	private String desc;
	private Map<String,Object> attributes;
}