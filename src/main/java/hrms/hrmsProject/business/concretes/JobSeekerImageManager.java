package hrms.hrmsProject.business.concretes;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.hrmsProject.business.abstracts.CvService;
import hrms.hrmsProject.business.abstracts.JobSeekerImageService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.helpers.UploadService;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.JobSeekerImageDao;
import hrms.hrmsProject.entities.concretes.CvImage;
import lombok.var;

@Service
public class JobSeekerImageManager implements JobSeekerImageService{
	
	private UploadService uploadService;
	private CvService cvService;
	private JobSeekerImageDao imageDao;
	
	@Autowired
	public JobSeekerImageManager(UploadService uploadService,CvService cvService,JobSeekerImageDao imageDao) {
		this.uploadService=uploadService;
		this.cvService=cvService;
		this.imageDao=imageDao;
	}

	@Override
	public Result uploadImage(MultipartFile multipartFile, int cvId) {
		
		Map<String, String> uploader =(Map<String, String>) uploadService.uploadImage(multipartFile).getData();
		String imageUrl=uploader.get("url");
		
		var existCv = this.cvService.getById(cvId).getData();
		
		if (existCv == null) {
			return new ErrorResult(ProjectMessages.notFoundCv);
		}
		
		var existImage = this.imageDao.getByCv_id(cvId);
		
		if (existImage!=null) {
			existImage.setImageUrl(imageUrl);
			existImage.setUpdatedDate(java.sql.Date.valueOf(LocalDate.now()));
		}
		else {
			CvImage cvImage = new CvImage(imageUrl,cvId);
		}
		return new SuccessResult(ProjectMessages.addedImage);
	}

	@Override
	public DataResult<CvImage> getById(int id) {
		CvImage result = this.imageDao.getOne(id);
		if (result!=null) {
			return new SuccessDataResult<CvImage>(result);
		}
		return new ErrorDataResult<CvImage>(ProjectMessages.errorResultMessage);
	}

}
