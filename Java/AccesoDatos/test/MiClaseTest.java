package AccesoDatos.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uf1.Ej12MiClaseJUnit;

class MiClaseTest {

	@Test
	void testNumero_Mayor() {
		System.out.println("numero_mayor");
		int a = 0;
		int b = 0;
		int c = 0;
		
		Ej12MiClaseJUnit instance = new Ej12MiClaseJUnit();
		int expResult = 0;
		int result = instance.numero_mayor(a, b, c);
		assertEquals(expResult, result);
	}

}
