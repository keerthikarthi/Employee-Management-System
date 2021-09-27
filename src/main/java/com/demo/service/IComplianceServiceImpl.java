package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.repository.IComplianceRepository;
import com.demo.entities.Compliance;
import com.demo.entities.StatusReport;

@Service
public class IComplianceServiceImpl implements IComplianceService{
	@Autowired
	private IComplianceRepository repository;

	@Override
	public void createRL(Compliance co) {
		// TODO Auto-generated method stub
		repository.save(co);		
	}

	@Override
	public List<Compliance> getAllRL(int userId) {
		// TODO Auto-generated method stub
		return repository.findByUserId(userId);
	}

	@Override
	public List<Compliance> getAllRL() {
		// TODO Auto-generated method stub
		return (List<Compliance>) repository.findAll();
	}

	@Override
	public void createStatusReport(StatusReport statusreport) {
		// TODO Auto-generated method stub
		 repository.save(statusreport);
	}	

	@Override
	public List<StatusReport> getAllStatusReport(int userId,int compid) {
		// TODO Auto-generated method stub
		return repository.findStatusReportById(userId,compid);
	}
}
	