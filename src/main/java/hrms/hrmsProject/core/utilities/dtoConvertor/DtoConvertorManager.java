package hrms.hrmsProject.core.utilities.dtoConvertor;

import org.modelmapper.ModelMapper;

//@Service
public class DtoConvertorManager{
	private ModelMapper modelMapper;
	
	public DtoConvertorManager(ModelMapper modelMapper) {
		this.modelMapper=modelMapper;
	}
	
//@Override
	public <T> Object dtoClassConvertor(Object source, Class<T> baseClass) {
		return modelMapper.map(source, baseClass);
	}

}
