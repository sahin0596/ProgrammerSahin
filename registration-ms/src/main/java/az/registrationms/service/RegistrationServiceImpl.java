package az.registrationms.service;

import az.registrationms.entity.ConfirmationToken;
import az.registrationms.entity.Registration;
import az.registrationms.mailSender.MailSender;
import az.registrationms.repository.RegistrationRepository;
import az.registrationms.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;

    private final TokenRepository tokenRepository;

    private final MailSender mailSender;

    @Override
    public ResponseEntity<?> saveUser(Registration user) {

        if (registrationRepository.existsByUserEmail(user.getUserEmail())) {
            return ResponseEntity.badRequest().body("Error: This Account already exists");
        }
        registrationRepository.save(user);
        ConfirmationToken confirmationToken = new ConfirmationToken();
        tokenRepository.save(confirmationToken);
        String subject = "Complete the registration";
        String text = "Hello " + user.getUserName() + ",Thank you for choosing our company.Please complete the registration by clicking on the link:" +
                "http://localhost:8080/v1/registration/confirm-account?token=" + confirmationToken.getConfirmationToken();
        mailSender.sendEmail(user.getUserEmail(), subject, text);
        System.out.println("Confirmation Token: " + confirmationToken.getConfirmationToken());
        return ResponseEntity.ok("Please complete the registration");
    }

    @Override
    public ResponseEntity<?> confirmUserEmail(String confirmationToken) {

        ConfirmationToken token = tokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
            Registration user = registrationRepository.findByUserEmailIgnoreCase(token.getUserEntity().getUserEmail());
            user.setEnabled(true);
            registrationRepository.save(user);
            return ResponseEntity.ok("You have successfully registered");
        }
        return ResponseEntity.badRequest().body("Registration Failed");
    }
}
