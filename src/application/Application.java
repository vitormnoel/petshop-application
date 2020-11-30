package application;

import java.util.List;
import java.util.Scanner;

import model.Animal;
import model.Appointment;
import model.Client;
import model.Client_Animal;
import model.Clinic;
import model.Products;
import model.Service;
import models.dao.AnimalDao;
import models.dao.AppointmentDao;
import models.dao.ClientDao;
import models.dao.Client_AnimalDao;
import models.dao.ClinicDao;
import models.dao.DaoFactory;
import models.dao.ProductsDao;
import models.dao.ServiceDao;

public class Application {
	
	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		int op = 1;
		
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("======= APLICATIVO =======");
		System.out.println("==========================");
	    System.out.println("==========================\n");
	    
	    do {
	    	
	    	System.out.println("ESCOLHA UMA OPÇÃO:\n[1]CLIENTES\n[2]ANIMAIS\n"
	    			+ "[3]CONSULTAR REGISTROS DE CLIENTES E ANIMAIS\n[4]CONSULTAS\n[5]PRODUTOS\n[6]SERVIÇOS\n[7]CLINICAS\n[0]SAIR");
	    	op = ler.nextInt();
	    	
	    	switch(op) {
	    		case 1: clients();
	    			break;
	    		case 2: animals();
	    			break;
	    		case 3: clients_animals();
	    			break;
	    		case 4: appointment();
	    			break;
	    		case 5: products();
	    			break;
	    		case 6: services();
	    			break;
	    		case 7: clinic();
	    			break;
	    		case 0: System.out.println("\n\n\n\n\nATÉ MAIS...");
	    			break;
	    		default:
	    			System.out.println("\n\n\nOPÇÃO INEXISTENTE\n\\n\\n");
	    	}
	    	
	    }while(op!=0);
	    
	    ler.close();
	}
	
	public static int aux = 1;
	static Scanner ler = new Scanner(System.in);
	
	public static void clients() {
		
		ClientDao clientDao = DaoFactory.createClientDao();
		
		do{
			
			System.out.println("::::::::::::::::::");
			System.out.println("- Qual operação deseja fazer? ");
			System.out.println("[1] Cadastrar cliente \n[2] Alterar cadastro \n"
					+ "[3] Excluir cliente \n[4] Listar cadastrados \n[0] Voltar");
			aux = ler.nextInt();
			
			switch(aux) {
			case 1:
				
				Client client = new Client();
				
				client.registerNewUser();
				clientDao.insert(client);
				
				break;
			case 2:
				System.out.println("Digite um cpf: ");
				int i = ler.nextInt();
				
				client = clientDao.findById(i);
				System.out.println(client);
				ler.nextLine();
				
				System.out.println("Novo endereço: ");
				String a = ler.nextLine();
				
				client.setAdress(a);
				clientDao.update(client);
				
				System.out.println(client);
				break;
			case 3:
				System.out.println("Digite o cpf: ");
				int c = ler.nextInt();
				
				clientDao.deleteById(c);
				
				System.out.println("Excluido!");
				break;
			case 4:
				
				List<Client> list = clientDao.findAll();
				
				System.out.println("Clientes: ");
				for(Client obj : list) {
					System.out.println(obj);
				}
				
				break;
			default: System.out.println("\n\nOpção invalida\n\n");
				break;
			}
			
		}while(aux!=0);
		
    }
	
	public static void animals() {
		
		AnimalDao animalDao = DaoFactory.createAnimalDao();
		
		do {
			System.out.println("::::::::::::::::::");
			System.out.println("- Qual operação deseja fazer? ");
			System.out.println("[1] Cadastrar animal \n[2] Alterar cadastro \n"
					+ "[3] Listar cadastrados \n[0] Voltar");
			aux = ler.nextInt();
			
			switch(aux) {
			case 1:
				
				Animal animal = new Animal();
				
				animal.registerAnimal();
				animalDao.insert(animal);
				
				break;
			case 2:
				System.out.println("Digite o ID: ");
				int i = ler.nextInt();
				
				animal = animalDao.findById(i);
				System.out.println(animal);
				ler.nextLine();
				
				System.out.println("Editar nome: ");
				String a = ler.nextLine();
				
				animal.setName(a);
				animalDao.update(animal);
				
				System.out.println(animal);
				break;
			case 3:
				
				List<Animal> list = animalDao.findAll();
				
				System.out.println("Animais: ");
				for(Animal obj : list) {
					System.out.println(obj);
				}
				
				break;
			default: System.out.println("\n\nOpção invalida\n\n");
				break;
			}
			
		}while(aux!=0);
		
	}
	
	public static void clients_animals() {
		
		Client_AnimalDao caDao = DaoFactory.createCADao();
		
		do {
			System.out.println("::::::::::::::::::");
			System.out.println("- Qual operação deseja fazer? ");
			System.out.println("[1] Lista de Donos e Pets \n[0] Voltar");
			aux = ler.nextInt();
			
			switch(aux) {
			case 1:
				List<Client_Animal> list = caDao.All();
				
				System.out.println("Lista de clientes e seus pets:::\n");
				
				for(Client_Animal obj : list) {
					System.out.println(obj+"\n");
				}
				
				break;
			default: System.out.println("\n\nOpção invalida\n\n");
				break;
			}
			
		}while(aux!=0);
		
	}
	
	public static void appointment() {
		
		AppointmentDao appointmentDao = DaoFactory.createAppointmentDao();
		
		do {
			System.out.println("::::::::::::::::::");
			System.out.println("- Qual operação deseja fazer? ");
			System.out.println("[1] Cadastrar consulta \n[2] Encontrar consulta"
					+ "\n[3] Listar consultas \n[0] Voltar");
			aux = ler.nextInt();
			
			switch(aux) {
			case 1:
				
				Appointment appointment = new Appointment();
				
				appointment.newAppointment();
				appointmentDao.insert(appointment);
				
				break;
			case 2:
				ler.nextLine();
				System.out.println("Digite o Nome: ");
				String n = ler.nextLine();
				
				appointment = appointmentDao.findByAnimalName(n);
				
				System.out.println(appointment+"\n\n");
				break;
			case 3:
				
				List<Appointment> list = appointmentDao.findAll();
				
				System.out.println("Animais: ");
				for(Appointment obj : list) {
					System.out.println(obj);
				}
				
				break;
			default: System.out.println("\n\nOpção invalida\n\n");
				break;
			}
			
		}while(aux!=0);
		
	}
	
	public static void products() {
		
		ProductsDao productsDao = DaoFactory.createProductDao();
		
		do{
			
			System.out.println("::::::::::::::::::");
			System.out.println("- Qual operação deseja fazer? ");
			System.out.println("[1] Cadastrar produto \n[2] Alterar produto \n"
					+ "[3] Excluir produto \n[4] Pesquisar produto \n[5] Listar produtos cadastrados \n[0] Voltar");
			aux = ler.nextInt();
			
			switch(aux) {
			case 1:
				
				Products product = new Products();
				
				product.registerNewProducts();
				productsDao.insert(product);
				
				break;
			case 2:
				System.out.println("Digite o ID do produto: ");
				int i = ler.nextInt();
				
				product = productsDao.findById(i);
				
				System.out.println(product);
				ler.nextLine();
				
				System.out.println("Atualizar nome: ");
				String n = ler.nextLine();
				product.setName(n);
				
				System.out.println("Atualizar quantidade: ");
				int a = ler.nextInt();
				product.setamount(a);
				
				productsDao.update(product);
				ler.nextLine();
				System.out.println(product);
				
				break;
			case 3:
				
				ler.nextLine();
				System.out.println("Digite o nome: ");
				String c = ler.nextLine();
				
				productsDao.deleteByName(c);
				
				System.out.println("Excluido!");
				ler.nextLine();
				
				break;
				
			case 4:
				
				ler.nextLine();
				System.out.println("Pesquisar por: ");
				String name = ler.nextLine();
				
				product = productsDao.findByName(name);
				ler.nextLine();
				
				break;
			case 5:
				
				List<Products> list = productsDao.findAll();
				
				System.out.println("Clientes: ");
				for(Products obj : list) {
					System.out.println("ID: "+obj.getId()+" | Nome: "+obj.getName()+" | Quantidade: "+obj.getamount());
				}
				
				break;
			default: System.out.println("\n\nOpção invalida\n\n");
				break;
			}
			
		}while(aux!=0);
		
	}
	
	public static void services() {
		
		ServiceDao serviceDao = DaoFactory.createServiceDao();
		
		do{
			
			System.out.println("::::::::::::::::::");
			System.out.println("- Qual operação deseja fazer? ");
			System.out.println("[1] Cadastrar serviço \n[2] Alterar serviço \n"
					+ "[3] Excluir serviço \n[4] Pesquisar serviço \n[5] Listar serviços cadastrados \n[0] Voltar");
			aux = ler.nextInt();
			
			switch(aux) {
			case 1:
				
				Service service = new Service();
				
				service.registerNewService();
				serviceDao.insert(service);
				
				break;
				
			case 2:
				System.out.println("Digite o ID do produto: ");
				int i = ler.nextInt();
				
				service = serviceDao.findById(i);
				
				System.out.println(service);
				ler.nextLine();
				
				System.out.println("Atualizar nome: ");
				String n = ler.nextLine();
				service.setName(n);
				
				serviceDao.update(service);

				System.out.println(service);
				
				break;
			case 3:
				
				ler.nextLine();
				System.out.println("Digite o nome: ");
				String c = ler.nextLine();
				
				serviceDao.deleteByName(c);
				
				System.out.println("Excluido!");
				ler.nextLine();
				
				break;
				
			case 4:
				
				ler.nextLine();
				System.out.println("Pesquisar por: ");
				String name = ler.nextLine();
				
				service = serviceDao.findByServiceName(name);
				ler.nextLine();
				
				break;
			case 5:
				
				List<Service> list = serviceDao.findAll();
				
				System.out.println("Clientes: ");
				for(Service obj : list) {
					System.out.println("ID: "+obj.getId()+" | Nome: "+obj.getName()+" | Hora: "+obj.getHour());
				}
				
				break;
			default: System.out.println("\n\nOpção invalida\n\n");
				break;
			}
			
		}while(aux!=0);
		
	}
	
	public static void clinic() {
		
		ClinicDao clinicDao = DaoFactory.createClinicDao();
		
do{
			
			System.out.println("::::::::::::::::::");
			System.out.println("- Qual operação deseja fazer? ");
			System.out.println("[1] Cadastrar clinica \n[2] Alterar dados da clinica \n"
					+ "[3] Excluir clinica \n[4] Listar clinicas cadastradas \n[0] Voltar");
			aux = ler.nextInt();
			
			switch(aux) {
			case 1:
				
				Clinic clinic = new Clinic();
				
				clinic.registerNewClinic();
				clinicDao.insert(clinic);
				
				break;
			case 2:
				System.out.println("Digite um cnpj: ");
				int i = ler.nextInt();
				
				clinic = clinicDao.findByCnpj(i);
				System.out.println(clinic);
				ler.nextLine();
				
				System.out.println("Novo endereço: ");
				String a = ler.nextLine();
				
				clinic.setAdress(a);
				clinicDao.update(clinic);
				
				System.out.println(clinic);
				break;
			case 3:
				System.out.println("Digite o cnpj: ");
				int c = ler.nextInt();
				
				clinicDao.deleteById(c);
				
				System.out.println("Excluido!");
				break;
			case 4:
				
				List<Clinic> list = clinicDao.findAll();
				
				System.out.println("Clientes: ");
				for(Clinic obj : list) {
					System.out.println(obj);
				}
				
				break;
			default: System.out.println("\n\nOpção invalida\n\n");
				break;
			}
			
		}while(aux!=0);
	}
}
