package com.demo;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.repository.IComplianceRepository;
import com.demo.entities.Compliance;
import com.demo.service.IComplianceServiceImpl;

@ExtendWith(MockitoExtension.class)
class IComplianceServiceTest {
@Mock
	private IComplianceRepository repository;
@InjectMocks
	private IComplianceServiceImpl compService;

	@Test
	void getAllRLTest() {
	
	List<Compliance> list = new ArrayList<Compliance>();
	Compliance comp = new Compliance(1,"regulation","completed","2021-08-12",1,2,"good");

	list.add(comp);
	
	
	when(repository.findAll()).thenReturn(list);
	List<Compliance> compList = compService.getAllRL();
	assertEquals(1,compList.size());
	}
	@Test
	void getAllRL2Test() {
		List<Compliance> list = new ArrayList<Compliance>();
		Compliance comp = new Compliance(1,"regulation","completed","2021-08-12",1,2,"good");

		list.add(comp);
		
		when(repository.findByUserId(1)).thenReturn(list);
		List<Compliance> compList = compService.getAllRL(1);
		assertEquals(1,compList.size());
		
	}

	
	
	
/*@Test
void saveComplianceTest(Compliance co) {
	Compliance co = new Compliance(1,"regulation","completed","2021-08-12",1,2,"good");
	when(repository.save(co)).thenReturn(co);
	Compliance savedcomp = compService.createRL(co);
	assertThat(savedcomp).isNotNull();
	assertEquals("regulation", savedcomp.getRlType());
	
}*/


}
