package hrms.hrmsProject.core.utilities.business;

import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;

public class BusinessRole {
	public static Result Run(Result... logics) {
		for(Result logic:logics) {
			if (!logic.isSuccess()) {
				return logic;
			}
		}
		return new SuccessResult();
	}
}
