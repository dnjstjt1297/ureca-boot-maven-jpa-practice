package kr.co.ureca.s5getpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.ureca.entity.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {

	public Emp findByEmpno(Integer empno);

} // interface
