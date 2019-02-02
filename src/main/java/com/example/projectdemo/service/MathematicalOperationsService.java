package com.example.projectdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.example.projectdemo.bean.MathematicalOperations;
import com.example.projectdemo.exception.MathOperationException;

@Service
public class MathematicalOperationsService {
	
	private boolean multiploTres;
	private boolean multiploCinco;
	
	public static String getRequestURI(HttpServletRequest request) {
		return request.getRequestURI();
	}
	
	public MathematicalOperations operation(final int min, final int max) throws MathOperationException {

		MathematicalOperations mathematicalOperations = new MathematicalOperations();

		List<String> list = new ArrayList<String>();

		try {

			if (min < max && isNumeric(min) && isNumeric(max)) {

				for (int x = min; x <= max; x++) {

					if (x % 3 == 0) {
						multiploTres = true;
						mathematicalOperations.setCode(200);
						list.add(Integer.toString(x));
						list.add("Fizz");
						mathematicalOperations.setList(list);
					}

					if (x % 5 == 0) {
						multiploCinco = true;
						mathematicalOperations.setCode(200);
						list.add(Integer.toString(x));
						list.add("Buzz");
						mathematicalOperations.setList(list);
					}

					if ((x % 3 == 0) && (x % 5 == 0)) {
						mathematicalOperations.setCode(200);
						list.add(Integer.toString(x));
						list.add("FizzBuzz");
						mathematicalOperations.setList(list);
					}
					
//					if (!(x % 3 == 0) && !(x % 5 == 0)) {
//						multiploTres = false;
//						multiploCinco = false;
//						mathematicalOperations.setCode(200);
//						list.add(Integer.toString(x));
//						list.add("Not Found FizzBuzz");
//						mathematicalOperations.setList(list);
//					}
					
					
					if(multiploTres) {
						mathematicalOperations.setDescription("Se encontraron multiplos de 3");
					}
					
					if(multiploCinco) {
						mathematicalOperations.setDescription("Se encontraron multiplos de 5");
					}
					
					if(multiploTres && multiploCinco) {
						mathematicalOperations.setDescription("Se encontraron multiplos de 3 y 5");
					}
					
//					if(!multiploTres && !multiploCinco) {
//						mathematicalOperations.setDescription("No se encontraron multiplos de 3 y 5");
//					}
					

				}

			}else {
				throw new MathOperationException("Los parámetros enviados no son correctos.");
			}

		} catch (MathOperationException e) {
			// TODO: handle exception
			throw new MathOperationException("Los parámetros enviados no son correctos.");
		}

		return mathematicalOperations;

	}
	
	
	private static boolean isNumeric(int number){
		try {
			String x = String.valueOf(number);
			Integer.parseInt(x);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	

}