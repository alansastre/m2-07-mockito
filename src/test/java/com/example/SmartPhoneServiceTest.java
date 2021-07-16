package com.example;




import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.dao.SmartPhoneDAO;
import com.example.demo.domain.SmartPhone;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CPU;
import com.example.demo.domain.pieces.Camera;
import com.example.demo.domain.pieces.RAM;
import com.example.demo.service.SmartPhoneService;
import com.example.demo.service.SmartPhoneServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SmartPhoneServiceTest {

	// dependencia
	@Mock // anotacion indica que es un mock
	SmartPhoneDAO mock;
	// mas dependencias en caso de que fueran necesarias
	// @Mock // anotacion indica que es un mock
	//CalculatorService calculatorService;
	
	// dependiente - SUT - Class under test
	@InjectMocks // inyectar los mocks dependencia dentro de la clase 
	SmartPhoneServiceImpl smartphoneService;
	
	
	

	private List<SmartPhone> demoData(){

		SmartPhone phone1 = new SmartPhone(1L, "One plus 9", 
				new RAM(1L, "DDR4", 8),
				new Battery(1L, 4500.0),
				new CPU(1L, 4),
				true,
				new Camera(1L, "front camera", 12.5));
		
		SmartPhone phone2 = new SmartPhone(2L, "IPhone X", 
				new RAM(2L, "DDR3", 4),
				new Battery(2L, 3500.0),
				new CPU(2L, 2),
				true,
				new Camera(2L, "front camera", 8.5));
		
		SmartPhone phone3 = new SmartPhone(3L, "Samsung Galaxy 54", 
				new RAM(3L, "DDR5", 32),
				new Battery(3L, 9500.0),
				new CPU(3L, 16),
				true,
				new Camera(3L, "back camera", 58.5));
		
		return Arrays.asList(phone1, phone2, phone3);
	}
	
	@Test
	@DisplayName("Método count para obtener número de smartphones en db")
	void testCount() {
		
		// 1. configurar mocks, llamadas y retornos ficticios
		when(mock.count()).thenReturn(10);
		
		// 2. ejecutar el metodo a testear
		Integer result = smartphoneService.count();
		
		// 3. verificar 
		verify(mock, times(2)).count();
		assertEquals(10, result);
		
	}
	
	class SearchTest{
		
	}
	@Test
	@DisplayName("Método findall para recuperar todos los smartphones")
	void testFindAll() {
		

		// 1. configurar mock
		List<SmartPhone> phones = this.demoData();
		
		when(mock.findAll()).thenReturn(phones);
		
		// 2. ejecutar metodo
		List<SmartPhone> results = smartphoneService.findAll();
		
		// 3. verificar
		verify(mock).findAll();
		verify(mock, times(1)).findAll();
		assertEquals(3, results.size());
		
	}
	
	@Test
	@DisplayName("Método findOne 1L")
	void testFindOne1L() throws Exception {
		
		SmartPhone phone = new SmartPhone();
		phone.setId(1L);
		
		when(mock.findOne(1L)).thenReturn(phone);
		
		// ejecutar
		SmartPhone result = smartphoneService.findOne(1L);
		
		// verificar
		verify(mock).findOne(1L);
		assertEquals(1L, result.getId());
	}
	
	@Test
	@DisplayName("Método findOne Any")
	void testFindOneAny() throws Exception {
		
		SmartPhone phone = new SmartPhone();
		phone.setId(1L);
		
		when(mock.findOne(anyLong())).thenReturn(phone);
		
		// ejecutar
		SmartPhone result1 = smartphoneService.findOne(1L);
		SmartPhone result2 = smartphoneService.findOne(2L);
		SmartPhone result3 = smartphoneService.findOne(3L);
		
		
		// verificar
		verify(mock, times(1)).findOne(1L);
		verify(mock, times(1)).findOne(2L);
		verify(mock, times(1)).findOne(3L);
		verify(mock, times(3)).findOne(anyLong());
		verify(mock, never()).findOne(4L);

		

	}
	
	
	
	
	
	
}
