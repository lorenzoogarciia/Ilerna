package AccesoDatos.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import uf1.Ej13Calculator;
class CalculatorTest {
	
		Ej13Calculator calc;
		
		@BeforeAll
		static void beforeAll() {
			System.out.println("Run before all tests");
		}
		
		@TestInstance(Lifecycle.PER_CLASS)
		public static class Extension implements BeforeAllCallback,ParameterResolver {

			@Override
			public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
					throws ParameterResolutionException {
				// TODO Auto-generated method stub
				return new Ej13Calculator();
			}

			@Override
			public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
					throws ParameterResolutionException {
				return parameterContext.getParameter().getType() == Ej13Calculator.class;
			}

			@Override
			public void beforeAll(ExtensionContext context) throws Exception {
				System.out.println("Before all tests");
				
			}
			
			
		}
		
	
		@Test
		@DisplayName("Test add method with positive integers")
		void testAddPositive() {
			
			calc = new Ej13Calculator();
			assertEquals(4, calc.add(2, 2), "2 + 2 should equal: 4");
			assertEquals(100, calc.add(50, 50), "50 + 50 should equal: 50");
		}
		
		@Test
		@DisplayName("Test add method with negative integers")
		void testAddNegative() {
			calc = new Ej13Calculator();
			assertEquals(-4, calc.add(-2, -2), "-2 + -2 should equal: -4");
			assertEquals(-100, calc.add(-50, -50), "-50 + -50 should equal: -100");
		}

}
