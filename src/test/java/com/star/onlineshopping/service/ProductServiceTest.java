package com.star.onlineshopping.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.star.onlineshopping.dto.ProductsDto;
import com.star.onlineshopping.entity.Products;
import com.star.onlineshopping.entity.User;
import com.star.onlineshopping.exception.ProductException;
import com.star.onlineshopping.exception.UserException;
import com.star.onlineshopping.respository.ProductsRepository;
import com.star.onlineshopping.respository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceTest {
	@InjectMocks
	ProductsServiceImpl productsServiceImpl;
	
	@Mock
	ProductsRepository productRepository;
	@Mock
	UserRepository userRepository;
	User user=new User();
	User normalUser=new User();
	Products product=new Products();
	Products normalProduct=new Products();
	List<Products> productList=new ArrayList<Products>();
	ProductsDto productDto=new ProductsDto();
	List<ProductsDto> productDtoList=new ArrayList<ProductsDto>();

	@Before
	public void init()
	{
	user.setId(1L);
	user.setName("prateek");
	user.setPassword("pal");

	user.setPhoneNumber("1234");
	user.setEmail("pal@gmail.com");
	user.setUserType("priority");
	
	normalUser.setId(2L);
	normalUser.setName("prateek");
	normalUser.setPassword("pal");

	normalUser.setPhoneNumber("1234");
	normalUser.setEmail("lol@gmail.com");
	normalUser.setUserType("normal");
	
	product.setId(1L);
	product.setDescription("football");
	product.setName("football");
	product.setPrice(2000.23);
	product.setProductCode("A123");
	product.setType("priority");
	
	normalProduct.setId(2L);
	normalProduct.setDescription("cricket");
	normalProduct.setName("bat");
	normalProduct.setPrice(2000.23);
	normalProduct.setProductCode("B123");
	normalProduct.setType("normal");
	productList.add(product);
	productList.add(normalProduct);
	
	productDto.setDescription("football");
	productDto.setName("football");
	productDto.setPrice(2000.23);
	productDto.setProductCode("A123");
	productDto.setType("priority");
	
	productDtoList.add(productDto);
	
	}
	
	@Test
	public void getPriorityProductTest() throws UserException, ProductException
	{
		Mockito.when(userRepository.findByEmail("pal@gmail.com")).thenReturn(java.util.Optional.of(user));
		Mockito.when(productRepository.findAll()).thenReturn(productList);
		List<ProductsDto> l=productsServiceImpl.getProductByEmail("pal@gmail.com");
		assertEquals(2, l.size());
	}
	
	
	@Test
	public void getNormalProductTest() throws UserException, ProductException
	{
		Mockito.when(userRepository.findByEmail("lol@gmail.com")).thenReturn(java.util.Optional.of(normalUser));
		Mockito.when(productRepository.findByType(normalUser.getUserType())).thenReturn(productList);
		List<ProductsDto> l=productsServiceImpl.getProductByEmail("lol@gmail.com");
		assertEquals(2, l.size());
	}
	
	@Test(expected = UserException.class)
	public void invalidUserTest() throws UserException, ProductException
	{
		User user=new User();
		user.setId(1L);
		Mockito.when(userRepository.findByEmail("lol@gmail.com")).thenReturn(java.util.Optional.of(user));
		List<ProductsDto> l=productsServiceImpl.getProductByEmail("lola@gmail.com");
		
	}
	@Test(expected = ProductException.class)
	public void noRecordFoundTest() throws UserException, ProductException
	{
		List<Products> productList=new ArrayList<Products>();
		Mockito.when(userRepository.findByEmail("pal@gmail.com")).thenReturn(java.util.Optional.of(user));
		Mockito.when(productRepository.findAll()).thenReturn(productList);
		List<ProductsDto> l=productsServiceImpl.getProductByEmail("pal@gmail.com");
		
		
	}
	
	
	
	@Test(expected = ProductException.class)
	public void noRecordFoundForNormalTest() throws UserException, ProductException
	{
		List<Products> productList=new ArrayList<Products>();
		Mockito.when(userRepository.findByEmail("lol@gmail.com")).thenReturn(java.util.Optional.of(normalUser));
		Mockito.when(productRepository.findByType(normalUser.getUserType())).thenReturn(productList);
		List<ProductsDto> l=productsServiceImpl.getProductByEmail("lol@gmail.com");
		
		
	}
	
	
	

}
