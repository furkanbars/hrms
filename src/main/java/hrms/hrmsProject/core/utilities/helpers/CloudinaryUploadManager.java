package hrms.hrmsProject.core.utilities.helpers;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;

public class CloudinaryUploadManager implements UploadService{
	private Cloudinary cloudinary;
	
	@Autowired
    public CloudinaryUploadManager(Cloudinary cloudinary) {
			this.cloudinary=cloudinary;
	}
	
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
