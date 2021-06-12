package hrms.hrmsProject.core.utilities.dtoConvertor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtoConvertorManager implements DtoConvertorService{
	private ModelMapper modelMapper;
	
	@Autowired
	public DtoConvertorManager(ModelMapper modelMapper) {
		this.modelMapper=modelMapper;
	}
	
	@Override
	public <T> Object dtoClassConvertor(Object source, Class<T> baseClass) {
		return modelMapper.map(source, baseClass);
	}

}
