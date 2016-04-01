package array;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class JavaReflectionTest {

	public static void main(String[] args) {

		Class<?> classMatrix;
		Constructor<?> defaultConstructor, mainConstructor;
		Constructor<?>[] constructors;
		Class[] parameterTypes;
		Matrix a, b, c, res;
		Object[] mainArgs = null;
		Method methodAdd, methodSubtract, methodPrint;
		int dim_m, dim_n;
		double[][] elements;
		Field f;

		System.out.println("1. Получение ссылки на класс:");
		System.out.println("-----------------------------------------------------");

		classMatrix = Matrix.class;
		System.out.println("- с использованием статического поля: " + classMatrix);

		try {
			classMatrix = Class.forName("array.Matrix");
		} catch (ClassNotFoundException e) {
			System.out.println("При определении ссылки на класс произошла ошибка: ");

			e.printStackTrace();
		}
		System.out.println("- по полному имени класса: " + classMatrix);

		try {
			classMatrix = Matrix.class.getClassLoader().loadClass("array.Matrix");
		} catch (ClassNotFoundException e) {
			System.out.println("При определении ссылки на класс произошла ошибка: ");

			e.printStackTrace();
		}
		System.out.println("- через ClassLoader: " + classMatrix);
		System.out.println();
		System.out.println("2. Создание экземпляров класса:");
		System.out.println("-----------------------------------------------------");

		constructors = classMatrix.getDeclaredConstructors();

		parameterTypes = new Class[] { int.class, int.class };
		try {
			defaultConstructor = classMatrix.getDeclaredConstructor(parameterTypes);

			a = (Matrix) defaultConstructor.newInstance(3, 3);

			System.out.println("Создали экземпляр матрицы с помощью перегруженного конструктора: ");

		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			System.out.println("При создании экземпляра матрицы с помощью перегруженного конструктора произошла ошибка:");
			e.printStackTrace();
		}
		parameterTypes = new Class[] {};
		try {
			mainConstructor = classMatrix.getDeclaredConstructor(parameterTypes);

			b = (Matrix) mainConstructor.newInstance(mainArgs);
			c = (Matrix) mainConstructor.newInstance(mainArgs);

			System.out.println("Создали экземпляры матриц с помощью умолчательного конструктора: ");
			f = classMatrix.getDeclaredField("dim_m");
			f.setAccessible(true);
			dim_m = (int)f.get(b);
			dim_n = dim_m;
			
			elements = new double[dim_m][dim_n];
			for(int i=0; i< dim_m; i++){
				for(int j=0; j< dim_n; j++){
					elements[i][j] = i*j;
				}
			}
			f = classMatrix.getDeclaredField("elements");
			f.set(b, elements);
			f.set(c, elements);

			methodPrint = classMatrix.getMethod("printMatrix");
			methodPrint.setAccessible(false);
			
			System.out.println("Получили метод печати матриц с помощью рефлексии и сделали его скрытым");
			System.out.println();
			System.out.println("Заполнили созданные матрицы, печатаем:");
			
			methodPrint.invoke(b);
			System.out.println("-----------------------------------------------------");
			
			methodPrint.invoke(c);
			System.out.println("-----------------------------------------------------");

			parameterTypes = new Class[] { array.Matrix.class };
			methodAdd = classMatrix.getMethod("addMatrix", parameterTypes);
			res = (Matrix) methodAdd.invoke(b, c);

			System.out.println("Получили метод сложения матриц с помощью рефлексии, результат сложения: ");
			System.out.println();

			methodPrint.invoke(res);
			methodSubtract = classMatrix.getMethod("subtractMatrix", parameterTypes);

			res = (Matrix) methodSubtract.invoke(b, c);

			System.out.println("Получили метод вычитания матриц с помощью рефлексии, результат вычитания: ");
			System.out.println();

			methodPrint.invoke(res);

		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | NoSuchFieldException e) {
			System.out.println("Во время работы программы произошла ошибка:");
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------------");
		System.out.println("3. Получение всех полей и методов класса:");
		System.out.println("-----------------------------------------------------");
		System.out.println("Поля класса: ");
		System.out.println("-----------------------------------------------------");

		for (Field field : classMatrix.getDeclaredFields()) {
			System.out.println(field.getType().getName() + " " + field.getName());
		}
		System.out.println("-----------------------------------------------------");
		System.out.println("Методы класса: ");
		System.out.println("-----------------------------------------------------");

		for (Method method : classMatrix.getDeclaredMethods()) {
			System.out.print(method.getReturnType().getName() + " " + method.getName() + "; Параметры: ");

			for (Parameter parameter : method.getParameters()) {
				System.out.print(parameter.getType().getName() + " " + parameter.getName() + ";");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------------");
		System.out.println(
				"4. Вызов методов класса с использованием рефлексии - сделали в пункте 2, чтобы не плодить Exceptions");

	}

}
