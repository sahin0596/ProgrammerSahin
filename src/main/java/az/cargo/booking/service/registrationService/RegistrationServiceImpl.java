package az.cargo.booking.service.registrationService;

import az.cargo.booking.registration.ConfirmationToken;
import az.cargo.booking.registration.Registration;
import az.cargo.booking.repository.RegistrationRepository;
import az.cargo.booking.repository.TokenRepository;
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
            return ResponseEntity.badRequest().body("Error: Bu hesab mövcuddur");
        }
        registrationRepository.save(user);
        ConfirmationToken confirmationToken = new ConfirmationToken();
        tokenRepository.save(confirmationToken);
        String subject = "Registration continued";
        String text = "Hello click you button" +
                "http://localhost:8080/v1/registration/confirm-account?token=" + confirmationToken.getConfirmationToken();
        mailSender.sendEmail(user.getUserEmail(), subject, text);
        System.out.println("Confirmation Token: " + confirmationToken.getConfirmationToken());
        return ResponseEntity.ok("Təsdiqlə brat emailivi sənin də işin getsin bizim də");
    }
    @Override
    public ResponseEntity<?> confirmUserEmail(String confirmationToken) {

        ConfirmationToken token = tokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
            Registration user = registrationRepository.findByUserEmailIgnoreCase(token.getUserEntity().getUserEmail());
            user.setEnabled(true);
            registrationRepository.save(user);
            return ResponseEntity.ok("Complete successfully");
        }
        return ResponseEntity.badRequest().body("Error:");
    }
}