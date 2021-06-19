package hrms.hrmsProject.core.helpers;

import org.springframework.web.multipart.MultipartFile;

import hrms.hrmsProject.core.utilities.Results.DataResult;

public interface UploadService {
	DataResult<?> uploadImage(MultipartFile file);
}
