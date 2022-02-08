package exercise1Class;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import exercise1Enum.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private double baseSalary;
	
	private Department department;
	//como o trabalhador tem v�rios contratos, dever� ser criada uma lista 
	private List<HourContract> contracts = new ArrayList <>();
	
	public Worker () {
		
	}
	//quando se tem uma composi��o "tem muitos", que no caso � uma lista, n�o se inclui no construtor, iniciando a lista vazia
	public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WorkerLevel getLevel() {
		return level;
	}
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<HourContract> getContracts() {
		return contracts;
	}
	//o m�todo set foi retirado, pois apenas o m�todo add e remove poder�o acessar a quantidade de contratos
	
	//m�todo para adicionar um contrato associado ao trabalhador 
	public void addContract (HourContract contract) {
		contracts.add(contract);
	}
	//m�todo para remover um contrato associado ao trabalhador 
	public void removeContract (HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income (int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c: contracts) {
			cal.setTime(c.getDate());//definindo a data do contrato como a data do calend�rio
			int c_year =  cal.get(Calendar.YEAR);  //para receber o valor do ano do contrato c
			int c_month =  1 + cal.get(Calendar.MONTH) ;   // para receber o valor do m�s do contrato c
			//se o ano informado como par�metro for igual ao ano que estou procurando
			//se o m�s informado como par�metro for igual ao m�s que estou procurando
			//ent�o o valor do contrato ser� somado		
			if (year ==c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
	return sum;
	
	}
	
}
