package ua.epicwasa.minibank.sheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ua.epicwasa.minibank.data.entity.Account;
import ua.epicwasa.minibank.data.entity.DepositContract;
import ua.epicwasa.minibank.data.entity.LoanContract;
import ua.epicwasa.minibank.data.repo.AccountRepo;
import ua.epicwasa.minibank.data.repo.DepositRepo;
import ua.epicwasa.minibank.data.repo.LoanRepo;

import java.time.LocalDate;

@Component
public class ScheduledPercentApplier {

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    LoanRepo loanRepo;

    @Autowired
    DepositRepo depositRepo;

//    @Scheduled(fixedRate = 86400000)
//    public void applyDividents(){
//        Iterable<DepositContract> deposits = depositRepo.findAll();
//        for (DepositContract d:deposits) {
//            d.setInitialSum(d.getInitialSum()+d.getInitialSum()*(d.getRate().getRate()/100/12/30));
//            depositRepo.save(d);
//            if(d.getDateOfExpiration().equals(LocalDate.now())){
//                d.getAccount().setAmount(d.getAccount().getAmount()+d.getInitialSum());
//                depositRepo.delete(d);
//            }
//        }
//        Iterable<LoanContract> loans = loanRepo.findAll();
//        for (LoanContract l:loans) {
//            Account account =  l.getAccount();
//           account.setAmount(account.getAmount()-l.getInitialSum()*l.getRate().getRate()/100/12/30);
//
//            accountRepo.save(account);
//        }
//    }

}
