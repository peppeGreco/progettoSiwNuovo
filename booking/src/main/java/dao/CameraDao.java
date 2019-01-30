package dao;

import model.Camera;

public interface CameraDao {

	public boolean create(Camera camera);
	public boolean update(Camera camera);
	public boolean delete(Long numeroCamera);
	
	
}
