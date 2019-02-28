package com.swagger.Swagger2.controllers;


import com.swagger.Swagger2.Model.Requisition;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.Date;


@RestController
@RequestMapping(path = "/api/Requisition")
@Api(value = "SwaggerApi", produces = MediaType.APPLICATION_JSON_VALUE)
public class RequisitionController {




	@GetMapping("/{id}")
	@ApiOperation("Gets the requisition with unique identity")
	@ApiResponses(value ={@ApiResponse(code = 200, message = "OK", response = Requisition.class) } )
	public Requisition getReq(@PathVariable Long id){
    	return new Requisition(id, new Date());

    }


    @GetMapping("/info")
	@ApiOperation("All info")
	public String getInfo(){
		return " here is the whole info: there are is no info";
	}
}




