/*Ler os dados de um trabalhador com N contratos (N fornecido pelo usu�rio). Depois, solicitar
do usu�rio um m�s e mostrar qual foi o sal�rio do funcion�rio nesse m�s
 * 
 * */
package exercise1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import exercise1Class.Department;
import exercise1Class.HourContract;
import exercise1Class.Worker;
import exercise1Enum.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the department name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker (workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department (departmentName));
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Enter contract #" + i + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valorPerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valorPerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Enter the month and yearto calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring (0, 2));//converter a String para inteiro nas duas primeiras posi��es
		int year = Integer.parseInt(monthAndYear.substring (3));//converter a partir da terceira posi�ao
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());//acessar o nome do objeto department a partir da classe worker
		System.out.println("Income for " + monthAndYear + ": " +String.format("%.2f%n", worker.income(year, month)));// ir� informar o valor do sal�rio no referido m�s
	
	sc.close();
	}

}
