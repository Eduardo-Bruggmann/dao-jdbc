package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program1 {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment =====");
		List<Seller> sellers = sellerDao.findByDepartment(new Department(2, null));
		for(Seller s: sellers) {
			System.out.println(s);
		}
		
		System.out.println("\n=== TEST 3: seller findAll =====");
		List<Seller> allSellers = sellerDao.findAll();
		for(Seller s: allSellers) {
			System.out.println(s);
		}
		
		System.out.println("\n=== TEST 4: seller insert =====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 3000, new Department(1, null));
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller update =====");
		seller = sellerDao.findById(1);
		seller.setName("Bruce Wayne");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 6: seller delete =====");
		sellerDao.deleteById(101);
		System.out.println("Deleted completed!");
	}
}
