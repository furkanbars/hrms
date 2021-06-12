package hrms.hrmsProject.core.utilities.dtoConvertor;

public interface DtoConvertorService {
	public <T>Object dtoClassConvertor(Object source, Class<T> baseClass);

}
