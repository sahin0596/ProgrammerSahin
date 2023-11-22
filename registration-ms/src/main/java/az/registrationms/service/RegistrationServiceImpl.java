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
            return ResponseEntity.badRequest().body("Error: Giriş eləmisən dana nə diriyifsən ?");
        }
        registrationRepository.save(user);
        ConfirmationToken confirmationToken = new ConfirmationToken();
        tokenRepository.save(confirmationToken);
        String subject = "Registrasiyani tamamla qardashim";
        String text = "Salam brat, zehmet olmasa clickle yorma bizi sene zehmet:" +
                "http://localhost:8082/v1/registration/confirm-account?token=" + confirmationToken.getConfirmationToken();
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
            return ResponseEntity.ok("Halaldı sənə kişi adamsan uğurlu oldu");
        }
        return ResponseEntity.badRequest().body("Tfu yüzünə yekə adamsan bir dənə emaili verify eliyəmmədin");
    }
}
