package com.spo.controller;

import com.spo.model.CleanerRequest;
import com.spo.model.CleanerResponse;
import com.spo.service.CleanerService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.Valid;
import java.util.List;

@RestController
@EnableSwagger2
public class CleanerApi {

	private final CleanerService cleanerService;

	@Autowired
	public CleanerApi(CleanerService cleanerService) {
		this.cleanerService = cleanerService;
	}

	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successful", response = CleanerResponse.class),
		@ApiResponse(code = 400, message = "Provided request is incorrect")
	})
	@PostMapping("/")
	public List<CleanerResponse> countOptimalNumber(@RequestBody @Valid CleanerRequest input){
		return cleanerService.calculate(input);
	}
}

