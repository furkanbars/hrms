package hrms.hrmsProject.core.adapters.concretes;

import org.springframework.stereotype.Service;

import hrms.hrmsProject.core.adapters.abstracts.MernisCheckService;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements MernisCheckService{

	//@Override
	//public boolean validate(String identityNumber, String firstName, String lastName,LocalDate date) {
	//	return true;
	//}
	
	@Override
	public boolean validate(String identityNumber, String firstName, String lastName,String date) {
		KPSPublicSoapProxy kpsPublic;
		try {
			kpsPublic=new KPSPublicSoapProxy();
			boolean result=kpsPublic.TCKimlikNoDogrula(Long.parseLong(identityNumber) ,firstName.toUpperCase(), lastName.toUpperCase(),
					Integer.parseInt(date));
			return result;
		} catch (Exception exception) {
			return false;
		}
	}

}
