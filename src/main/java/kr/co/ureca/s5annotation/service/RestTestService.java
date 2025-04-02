package kr.co.ureca.s5annotation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ureca.dto.EmpDTO;
import kr.co.ureca.entity.Emp;
import kr.co.ureca.s5annotation.repository.EmpRepository;

@Service
public class RestTestService {

	@Autowired
	private EmpRepository repository;

	public EmpDTO findById(Long id) {
		Optional<Emp> opEmp = repository.findById(id);
		Emp emp = opEmp.get();
		EmpDTO dto = new EmpDTO();
		dto.setId( emp.getId() );
		dto.setEmpno( emp.getEmpno() );
		dto.setEname( emp.getEname() );
		dto.setJob( emp.getJob() );
		dto.setMgr( emp.getMgr() );
		dto.setHiredate( emp.getHiredate() );
		dto.setSal( emp.getSal() );
		dto.setComm( emp.getComm() );
		dto.setDeptno( emp.getDeptno() );
		return dto;
	}

} // class





