package service;

import model.Camera;

public interface CameraService {
	
	public boolean create (Camera camera);
	public boolean update(Camera camera);
	public boolean delete(Long numeroCamera);

}