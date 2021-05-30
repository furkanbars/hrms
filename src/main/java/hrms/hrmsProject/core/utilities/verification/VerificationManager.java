package hrms.hrmsProject.core.utilities.verification;

import java.util.UUID;

public class VerificationManager {

	public void sendLink(String email) {
		UUID uuid=UUID.randomUUID();
		String verificationLink="https://hrmsverificationmail/"+uuid.toString();
		System.out.println("Verification link has been sent to " + email );
        System.out.println("Please click on the link to verify your account:  " + verificationLink );
	}

	public static String sendCode() {
		UUID uuid=UUID.randomUUID();
		String code=uuid.toString();
		System.out.println("Your code: "+code);
		return code;
	}

}
