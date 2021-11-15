package interfaces;

import java.util.List;

public interface Obligacion <Cualquiercosa> {
	
	public boolean create(Cualquiercosa c);
	public boolean delete(Object key);
	public boolean update(Cualquiercosa c);
	public Cualquiercosa read(Object key);
	public List<Cualquiercosa> readAll();

}
