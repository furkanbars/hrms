package hrms.hrmsProject.business.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrms.hrmsProject.core.helpers.CloudinaryUploadManager;
import hrms.hrmsProject.core.helpers.UploadService;

@Configuration
public class CloudinaryConfig {
	@Value("${cld.access-key}")
	String apiAccessKey;
	
	@Value("${cld.secret-key}")
	String apiSecretKey;
	
	@Bean(name = "cloudinaryUser")
	public Cloudinary cloudinaryUser()  throws Exception{
		return new Cloudinary(ObjectUtils.asMap(
					"cloud_name","dcnqvolg9",
					"api_key",apiAccessKey,
					"api_secret",apiSecretKey
				));
	}
	
	public UploadService cloudinaryService() throws Exception{
		return new CloudinaryUploadManager(cloudinaryUser());
	}
}
