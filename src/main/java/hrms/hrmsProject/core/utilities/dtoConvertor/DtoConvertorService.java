package hrms.hrmsProject.core.utilities.dtoConvertor;

import java.util.List;

public interface DtoConvertorService {
	<S,T> List<T> dtoConvertor(List<S> s,Class<T> targetClass);
	public <T> Object dtoClassConvertor(Object source, Class<T> baseClass);

}
