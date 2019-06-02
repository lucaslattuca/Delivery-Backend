package ml.work.main.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ObjectController<T> {
	
	public List<T> getAll();
	public T getOne(int id);
	public ResponseEntity save(T t);
	public ResponseEntity updateEntity (T t, int id);
	public ResponseEntity deleteEntity (int id);

}
