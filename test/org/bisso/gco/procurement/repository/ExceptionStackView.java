package org.bisso.gco.procurement.repository;

import java.sql.SQLException;

import org.bisso.commons.repository.exception.ConnetionFailureException;
import org.bisso.commons.repository.exception.InfrastructureException;


public class ExceptionStackView {

	public static void main(String[] args) {
		System.out.println("init main ");
		method1();
		System.out.println("end main ");
	}

	
	public static void method1(){
		System.out.println("init method1 ");
		try {
			method2();
		} catch (ConnetionFailureException | InfrastructureException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end method1 ");
	}

	public static void method2()  throws ConnetionFailureException{
		System.out.println("init method2 ");
		method3();
		System.out.println("end method2 ");
	}
	
	public static void method3()  throws ConnetionFailureException {
		System.out.println("init method3 ");
		method4();
		System.out.println("end method3 ");
	}
	
	public static void method4() throws ConnetionFailureException {
		System.out.println("init method4 ");
		try {
			method5();
		} catch (SQLException e) {
			System.out.println(e + "\n\n\n\n\n");
			e.printStackTrace();
			System.out.println("\n\n\n=================================\n\n");
			throw new ConnetionFailureException("Oia não foi nao .. ",e);
		}
		System.out.println("end method4 ");	
	
	}

	public static void method5() throws SQLException {
		
		System.out.println("init method5 ");
		
		String nome = null;
		
		if ( nome == null) {
			throw new SQLException("Caraca Maluco o nome eh null");
		}
		
		
		System.out.println("end method5 ");
	
	}

}
