package models.dao;

import db.DB;
import models.dao.impl.AnimalDaoJDBC;
import models.dao.impl.AppointmentDaoJDBC;
import models.dao.impl.ClientDaoJDBC;
import models.dao.impl.Client_AnimalDaoJDBC;
import models.dao.impl.ClinicDaoJDBC;
import models.dao.impl.ProductsDaoJDBC;
import models.dao.impl.ServiceDaoJDBC;
import models.dao.impl.VetDaoJDBC;

public class DaoFactory {
	
	public static AnimalDao createAnimalDao() {
		return new AnimalDaoJDBC(DB.getConnection());
	}
	
	public static AppointmentDao createAppointmentDao() {
		return new AppointmentDaoJDBC(DB.getConnection());
	}
	
	public static ClientDao createClientDao() {
		return new ClientDaoJDBC(DB.getConnection());
	}
	
	public static ClinicDao createClinicDao() {
		return new ClinicDaoJDBC(DB.getConnection());
	}
	
	public static ProductsDao createProductDao() {
		return new ProductsDaoJDBC(DB.getConnection());
	}
	
	public static ServiceDao createServiceDao() {
		return new ServiceDaoJDBC(DB.getConnection());
	}
	
	public static VetDao createVetDao() {
		return new VetDaoJDBC(DB.getConnection());
	}
	
	public static Client_AnimalDao createCADao() {
		return new Client_AnimalDaoJDBC(DB.getConnection());
	}
}
