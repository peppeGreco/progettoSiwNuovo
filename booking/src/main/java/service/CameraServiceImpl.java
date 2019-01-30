package service;

import dao.CameraDao;
import dao.persistence.DAOFactory;
import model.Camera;

public class CameraServiceImpl implements CameraService {

	private CameraDao cameraDao;
	
	
	public CameraServiceImpl() {
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		this.cameraDao = factory.getCameraDAO();
		
	}
	
	
	@Override
	public boolean create(Camera camera) {
		return cameraDao.create(camera);
	}


	@Override
	public boolean update(Camera camera) {
		return cameraDao.update(camera);
	}


	@Override
	public boolean delete(Long numeroCamera) {
		return cameraDao.delete(numeroCamera);
	}

}
