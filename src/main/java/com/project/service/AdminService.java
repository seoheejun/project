package com.project.service;

import javax.servlet.http.HttpServletRequest;

import com.project.domain.AdminDTO;

public interface AdminService {
	public boolean ad_Login(AdminDTO dto, HttpServletRequest request);
}
