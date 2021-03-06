package hrms.hrmsProject.core.helpers;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;

@Service
public class CloudinaryUploadManager implements UploadService{
	private Cloudinary cloudinary;
	
	
    public CloudinaryUploadManager(Cloudinary cloudinary) {
		super();
		this.cloudinary=cloudinary;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<?> uploadImage(MultipartFile file) {
		
		try {
			Map cloudinaryUploader=cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(cloudinaryUploader);
			
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return new ErrorDataResult<Map>();
		
	}

}
