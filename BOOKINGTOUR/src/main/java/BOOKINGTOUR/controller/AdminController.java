package BOOKINGTOUR.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



@Transactional
@Controller
public class AdminController {
	@Autowired
    SessionFactory factory;
	}


