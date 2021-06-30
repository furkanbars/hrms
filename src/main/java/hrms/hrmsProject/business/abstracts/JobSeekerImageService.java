package hrms.hrmsProject.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.CvImage;

public interface JobSeekerImageService {
	Result uploadImage(MultipartFile multipartFile,int cvId);
	DataResult<CvImage> getById(int id);
}
