package com.project.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.MemberDTO;
import com.project.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberMapper mapper;
	
	@Autowired
	public MemberServiceImpl(MemberMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public int memberInsert(MemberDTO dto) {
		return mapper.memberInsert(dto);
	}

	@Override
	public boolean memberLogin(MemberDTO dto, HttpServletRequest request) {
		String memName = mapper.memberLogin(dto);
		HttpSession session = request.getSession();
		
		if(memName != null) {
			session.setAttribute("memName", memName);
			return true;
		} else {
			return false;			
		}
	}

	@Override
	public MemberDTO memberFind(int memNo, HttpServletRequest request) {
		MemberDTO mDto = mapper.memberFind(memNo);
		HttpSession session = request.getSession();
		
		if(mDto != null) {
			session.setAttribute("mDto", mDto);
			System.out.println("memberSvcImpl : memberFind 완료");
			return mDto;
		}else {
			System.out.println("memberSvcImpl : memberFind 실패");
		}
		
		return null;
	}

	@Override
	public MemberDTO get(int memNo){
		return mapper.memberFind(memNo);
	}
	
}
