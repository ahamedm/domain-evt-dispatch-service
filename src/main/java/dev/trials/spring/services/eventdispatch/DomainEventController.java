package dev.trials.spring.services.eventdispatch;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domain")
public class DomainEventController {

	@Autowired 
    ApiMetadata meta;

	@GetMapping("/index")
	public ApiMetadata index(){
		return meta;
	}


	@PostMapping("/event")
	public ResponseEntity<String> newEvent(@RequestBody @Valid DomainEvtResource event){
		/* @TODO Validations & Dispatch Event to Backend*/
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(HttpStatus.ACCEPTED.toString());
	}
}