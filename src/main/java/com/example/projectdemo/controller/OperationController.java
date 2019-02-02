package com.example.projectdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectdemo.bean.MathematicalOperations;
import com.example.projectdemo.exception.MathOperationException;
import com.example.projectdemo.service.MathematicalOperationsService;

@RestController()
public class OperationController {

	@Autowired
	private MathematicalOperationsService mathematicalOperationsService;

	@GetMapping(value = "/fizzbuzz/{min}/{max}")
	public MathematicalOperations getResult(@PathVariable("min") int min, @PathVariable("max") int max)
			throws MathOperationException, Exception, NumberFormatException {

		MathematicalOperations mathematicalOperations = new MathematicalOperations();
		try {
			mathematicalOperations = mathematicalOperationsService.operation(min, max);
		} catch (MathOperationException e) {
			// TODO: handle exception
			throw new MathOperationException("Los parámetros enviados son incorrectos.");
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception();
		}
		return mathematicalOperations;

	}

}