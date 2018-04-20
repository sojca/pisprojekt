package org.pis.core;

import org.pis.entity.Employee;
import org.pis.services.EmployeeService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.text.Normalizer;
import java.util.List;

@Stateless
public class EmployeeUtils {

    @EJB
    private EmployeeService employeeService;

    private Employee createLogin(Employee empl){

        String surnameNorm = Normalizer.normalize(empl.getSurname().toLowerCase(), Normalizer.Form.NFD);
        surnameNorm = surnameNorm.replaceAll("[^\\p{ASCII}]", "");

        List<Employee> lastUsedUserName = employeeService.getLastUsedUsername(surnameNorm);

        if (lastUsedUserName.size() > 0 && lastUsedUserName.get(0) != null ){
            String sequence = lastUsedUserName.get(0).getLogin().substring(surnameNorm.length());
            if(sequence.length() == 0){
                surnameNorm += Integer.toString(1);
            }
            try {
                int seq = Integer.parseInt(sequence);
                surnameNorm += Integer.toString(seq+1);
            }
            catch (NumberFormatException e){

            }
        }

        empl.setLogin(surnameNorm);

        return empl;
    }

    private Employee createPassword(Employee employee){
        String password = Hash("test");
        employee.setPassword(password);
        return employee;
    }

    public Employee createCredentials(Employee employee){
        this.createLogin(employee);
        this.createPassword(employee);

        return employee;
    }

    public String Hash(String stringToHash){
        return stringToHash;
    }
}
