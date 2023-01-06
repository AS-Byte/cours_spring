package tn.esprit._3cinfo.nomdulivrable.crons;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.esprit._3cinfo.nomdulivrable.Services.IContratService;

@Slf4j
@Component //pour que il puisse gérer les instances et l'injection de dépendances
public class Checkcontrats {
    @Autowired
    IContratService icsi;

@Scheduled(cron = "10 * * * * *")
void verifcontrats(){
    String message= icsi.retrieveAndUpdateStatusContrat();
    log.warn(message);
    }

}
