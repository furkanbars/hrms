package hrms.hrmsProject.core.utilities.dtoConvertor;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtoConvertorManager implements DtoConvertorService{
	private ModelMapper modelMapper;
	
	@Autowired
	public DtoConvertorManager() {
		this.modelMapper=new ModelMapper();
	}
	
    @Override
	public <T> Object dtoClassConvertor(Object source, Class<T> baseClass) {
		return modelMapper.map(source, baseClass);
	}

    @Override
	public <S, T> List<T> dtoConvertor(List<S> s, Class<T> targetClass) {
    	return s.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
    }

}
