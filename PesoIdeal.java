import javax.swing.*;
public class PesoIdeal {
	public static void main(String[] args)
	{
		int edad, hombre = 1, mujer = 0, actividad;
		double peso, pesoGrosso, pesoIdealHombre = 0, pesoIdealMujer = 0, altura, imc = 0, grasaCorporalHombre = 0, grasaCorporalMujer = 0, escogerActividad, caloriasHombre, caloriasMujer;
		char genero;
		String nombre, clasifPeso;

		nombre = obtenerNombre();

		altura = obtenerAltura();

		peso = obtenerPeso();

		edad = obtenerEdad();		

		pesoGrosso = obtenerPesoGrosso(altura);

		genero = obtenerGenero();

		imc = obtenerImc(peso, altura);

		grasaCorporalHombre = obtenerGrasaCorporalHombre(imc, edad, hombre);

		grasaCorporalMujer = obtenerGrasaCorporalMujer(imc, edad, mujer);

		clasifPeso = obtenerClasifPeso(imc);

		actividad = obtenerActividadFisica(); 

		escogerActividad = determinarEscogenciaDeActividad(actividad);

		System.out.println();
		System.out.println("Su nombre es: " + nombre);
		System.out.println("Su indice corporal es: " + imc);

		if(genero == 'm' || genero == 'M')
		{
			pesoIdealHombre = obtenerPesoIdealHombre(pesoGrosso);
			caloriasHombre = obtenerCaloriasHombre(pesoIdealHombre, altura, edad, escogerActividad);
			hombre = 1;
			System.out.println("Su peso ideal es: " + pesoIdealHombre + " kg");
			System.out.println("Su grasa corporal es de: " + grasaCorporalHombre);
			System.out.println("Las calorias que debe consumir son: " + caloriasHombre);
		}
		else if(genero == 'f' || genero == 'F')
		{
			pesoIdealMujer = obtenerPesoIdealMujer(pesoGrosso);
			caloriasMujer = obtenerCaloriasMujer(pesoIdealMujer, altura, edad, escogerActividad);
			mujer = 0;
			System.out.println("Su peso ideal es: " + pesoIdealMujer + " kg");
			System.out.println("Su grasa corporal es de: " + grasaCorporalMujer);
			System.out.println("Las calorias que debe consumir son: " + caloriasMujer);
		}

		System.out.println("Su clasificacion es: " + clasifPeso);
	}

	static String obtenerNombre()
	{
		String nombre;

		nombre = JOptionPane.showInputDialog("Ingrese su nombre");

		return nombre;
	}

	static double obtenerAltura()
	{
		double altura;
		String inputUser;

		inputUser = JOptionPane.showInputDialog("Ingrese su altura en Mts");
		altura = Double.parseDouble(inputUser);

		return altura;
	}

	static double obtenerPesoGrosso(double paltura)
	{
		double peso;

		paltura = paltura * 100;

		peso = paltura - 100;

		return peso;
	}

	static char obtenerGenero()
	{
		String inputUser;
		char genero;

		inputUser = JOptionPane.showInputDialog("Digite 'M' o 'm' para Masculino\nDigite 'F' o 'f' para Femenino");
		genero = inputUser.charAt(0);

		return genero;
	}

	static double obtenerPesoIdealHombre(double pGrosso)
	{
		double peso;

		peso = pGrosso - ((pGrosso - 52) * 0.2);

		return peso;
	}

	static double obtenerPesoIdealMujer(double pGrosso)
	{
		double peso;

		peso = pGrosso - ((pGrosso - 52) * 0.4);

		return peso;
	}

	static double obtenerPeso()
	{
		double peso;
		String inputUser;

		inputUser = JOptionPane.showInputDialog("Ingrese su peso en Kg");
		peso = Double.parseDouble(inputUser);

		return peso;
	}

	static int obtenerEdad()
	{
		int edad;
		String inputUser;

		inputUser = JOptionPane.showInputDialog("Ingrese su edad");
		edad = Integer.parseInt(inputUser);

		return edad;
	}

	static double obtenerImc(double ppeso, double paltura)
	{
		double imc;

		imc = ppeso / (paltura * paltura);//aqui esta el problema

		return imc;
	}

	static double obtenerGrasaCorporalHombre(double pimc, int pedad, int phombre)
	{
		double grasaCorporal;

		grasaCorporal = (1.2 * pimc) + (0.23 * pedad) - (10.8 * phombre) - 5.4;

		return grasaCorporal;
	}

	static double obtenerGrasaCorporalMujer(double pimc, int pedad, int pmujer)
	{
		double grasaCorporal;

		grasaCorporal = (1.2 * pimc) + (0.23 * pedad) - (10.8 * pmujer) - 5.4;

		return grasaCorporal;
	}

	static String obtenerClasifPeso(double pimc)
	{
		String resultado;

		if(pimc < 18)
		{
			resultado = "Peso Bajo";
		}
		else if(pimc >= 18 && pimc <= 24.9)
		{
			resultado = "Peso Normal";
		}
		else if(pimc >= 25 && pimc <= 26.9)
		{
			resultado = "Sobrepeso";
		}
		else if(pimc >= 27 && pimc <= 29.9)
		{
			resultado = "Obesidad";
		}
		else if(pimc >= 30 && pimc <= 39.9)
		{
			resultado = "Obesidad grado 2";
		}else{
			resultado = "Obesidad Morbida";
		}
		return resultado;
	}

	static int obtenerActividadFisica()
	{
		int actividad;
		String inputUser;

		do{
			inputUser = JOptionPane.showInputDialog("Digite su actividad fisica\n1) Sedentario\n2) Ligera\n3) Moderada\n4) Intensa\n5) Extremadamente Alta");
			actividad = Integer.parseInt(inputUser);
		}while(actividad < 1 || actividad > 5);

		return actividad;
	}

	static double determinarEscogenciaDeActividad(int pactividad)
	{
		double resultado = 0;

		switch(pactividad)
		{
			case 1:
			resultado = 1.2;
			break;

			case 2:
			resultado = 1.375;
			break;

			case 3: 
			resultado = 1.55;
			break;

			case 4:
			resultado = 1.725;
			break;

			case 5: 
			resultado = 1.9;
			break;
		}

		return resultado;
	}

	static double obtenerCaloriasHombre(double ppesoIdealHombre, double paltura, int pedad, double pescogerActividad)
	{
		double resultado;
		paltura = paltura * 100;

		resultado = (66 + (13.7 * ppesoIdealHombre)) + (5 * paltura) - (6.8 * pedad) * pescogerActividad;

		return resultado;
	}

	static double obtenerCaloriasMujer(double ppesoIdealMujer, double paltura, int pedad, double pescogerActividad)
	{
		double resultado;
		paltura = paltura * 100;

		resultado = (655 + (9.6 * ppesoIdealMujer)) + (1.8 * paltura) - (4.7 * pedad) * pescogerActividad;

		return resultado;
	}
}