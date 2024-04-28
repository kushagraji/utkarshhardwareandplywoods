package com.utkarshhardwareandplywood.springboot.website.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.utkarshhardwareandplywood.springboot.website.models.Login;
import com.utkarshhardwareandplywood.springboot.website.models.User;
import com.utkarshhardwareandplywood.springboot.website.repo.Repo;


@SpringBootApplication
class UserControllerTest {
	
    @Mock
    private Repo repo;
	
	
	public Repo getRepo() {
		return repo;
	}

	public void setRepo(Repo repo) {
		this.repo = repo;
	}

	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	private UserController userController;
	
	

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		 userController = new UserController();
		
	}
	
	@Test
	void showRegistrationPage_Test() {
		
		ModelAndView modelAndView2 = userController.showregisterPage();
		assertEquals("userRegister", modelAndView2.getViewName() );
		
	}
	
//	@Test
//	void registerUser_Test() {
//		User user = new User();
//		user.setId(1);
//		ModelMap model = new ModelMap();
//		ModelAndView modelAndView3 = userController.registerUser( user, model);
//	    when(repo.save(user)).thenReturn(user);
//		assertEquals("userRegister", modelAndView3.getViewName() );
//		assertEquals("your Id is:1", model.get("id"));
//	}
	
	@Test
	void showLoginPage_Test() {
		ModelAndView modelAndView = userController.showLoginPage();
		assertEquals("login" ,modelAndView.getViewName());
	}
	
//	@Test
//	void loginVerification_Test() {
//		User user = new User();
//		ModelAndView model = new ModelAndView();
//		Login login = new Login();
//		login.setId(1);
//		login.setEmail("kushagragupta");
//		userController.loginVerification(login);
//		when(repo.findById(login.getId()).get()).thenReturn(user);
//		if((login.getEmail()).equals(user.getEmail())) {
//		 assertEquals("productPage", userController.loginVerification(login).getViewName());	
//		}else {
//			 assertEquals("Invalid Credential", model.getModel().get("message"));   
//			 assertEquals("login", userController.loginVerification(login).getViewName());	
//		}
	}


