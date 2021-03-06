import java.util.Scanner;

public class Registration extends Launcher {
    private String Name;
    private String UserName;
    private String Password;
    private String EMail;
    private Boolean VIPStatus;
    private String Package;

    public Registration() {
        this.Name = getName();
        this.UserName = getUserName();
        this.Password = getPassword();
        this.EMail = getEMail();
        this.VIPStatus = getVIPStatus();
        this.Package = getPackage();
    }

    public Boolean RegistrationForm() { //Forma eggrafis xristi
        Payment payment = new Payment();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type your Name => "); //Eisagwgi onomatos
        String Name = scanner.nextLine();
        setName(Name);

        System.out.print("Type your UserName => "); //Eisagwgi username
        String UserName = scanner.nextLine();
        setUserName(UserName);

        System.out.print("Type your Password => "); //Eisagwgi kwdikou
        String Password = scanner.nextLine();
        setPassword(Password);

        System.out.print("Type your E-Mail => "); //Eisagwgi Email
        String EMail = scanner.nextLine();
        setEMail(EMail);

        System.out.print("If you want to become a VIP type true or false => "); //Epilogi true h false gia na ginete VIP h oxi
        Boolean VIPStatus = scanner.nextBoolean();
        setVIPStatus(VIPStatus);

        if (VIPStatus == true) { //An epilegei true
            System.out.println("Choose VIP Package"); //Epilekste VIP paketo
            System.out.println("1. 3 months 30 euros");
            System.out.println("2. 6 months 50 euros");
            System.out.println("3. 12 months 80 euros");
            System.out.println("Type exit to leave without upgrading to VIP"); //Grapste exit h EXIT gia na vgeite xwris na ginete VIP
            String Package = scanner.nextLine();
            setPackage(Package); // Grapste 1,2 h 3 gia poio paketo epithimeite
            while (scanner.hasNext()) {
                Package = scanner.nextLine();
                setPackage(Package);
                if (Package.equals("1"))
                    break;
                if (Package.equals("2"))
                    break;
                if (Package.equals("3"))
                    break;
                if (Package.equals("exit") || Package.equals("EXIT"))
                    break;
            }
            if (Package.equals("1")) {
                payment.SetPayment(30.0); //To paketo 1 kostizei 30 euro
                System.out.println("The Total Amount is " + payment.GetPayment() + " euros"); //Ypologizei to poso plirwmis
                System.out.println("Choose Payment Method"); //Dialekste tropo plirwmis
                System.out.println("A or a for Cash"); //Grapste A h a gia karta
                System.out.println("B or b for Card"); //Grapste B h b gia metrita
            } else if (Package.equals("2")) {
                payment.SetPayment(50.0);
                System.out.println("The Total Amount is " + payment.GetPayment() + " euros");
                System.out.println("Choose Payment Method");
                System.out.println("A or a for Cash");
                System.out.println("B or b for Card");
            } else if (Package.equals("3")) {
                payment.SetPayment(80.0);
                System.out.println("The Total Amount is " + payment.GetPayment() + " euros");
                System.out.println("Choose Payment Method");
                System.out.println("A or a for Cash");
                System.out.println("B or b for Card");
            } else if (Package.equals("exit") || Package.equals("EXIT")) {
                setVIPStatus(false); //Bazei false to vipstatus dioti thelei na vgei xwris na ginei VIP
                System.out.println("Upgrade to VIP failed.");
            } else {
                System.out.println("Choose 1, 2 or 3. If you want to leave without upgrading to VIP type exit");
            }
            while (scanner.hasNext()) {
                if (Package.equals("exit") || Package.equals("EXIT")) {
                    break;
                }
                String Method = scanner.nextLine();
                payment.SetPayMethod(Method);
                if (Method.equals("a") || Method.equals("A")) {
                    System.out.println("You chose Cash");
                    System.out.println("Registration Successful");
                    System.out.println("We will accept your payment on your first visit!");
                    System.out.println("Your Name is: " + getName() + ", your UserName is: " + getUserName() + ", your Password is: " + getPassword() + ", your EMail is: " + getEMail() + " and your VIP Status is " + getVIPStatus());
                    return true;
                } else if (Method.equals("b") || Method.equals("B")) {
                    System.out.println("You chose Card");
                    break;
                } else {
                    System.out.println("Try again. Choose A or a for Cash and B or b for Card");
                }
            }
            if (payment.GetPayMethod().equals("b") || payment.GetPayMethod().equals("B")) { //An epilexthike karta
                System.out.println("Please insert your Card Info"); //Balte ta stoixeia tis kartas sas
                System.out.println("Please insert your Card Number"); //Eisagete ton arithmo tis kartas sas
                String CardNumbers = scanner.nextLine();
                System.out.println("Please insert your name as it appears on your card"); //Eisagete to onoma opw fainetai stin karta sas
                String CardName = scanner.nextLine();
                System.out.println("Please insert your Card Expiration Date"); //Eisagete tin imerominia liksis tis kartas sas
                String CardDate = scanner.nextLine();
                System.out.println("Please insert the 3 digit CVV number from the rear of your card"); //Eisagete to tripsifio CVV poy vrisketai sto pisw meros tis kartas sas
                String CVV = scanner.nextLine();
                payment.SetCardInfo(CardNumbers, CardName, CardDate, CVV);
                System.out.println("Registration Successful");
                System.out.println("Your Name is: " + getName() + ", your UserName is: " + getUserName() + ", your Password is: " + getPassword() + ", your EMail is: " + getEMail() + " and your VIP Status is " + getVIPStatus());
                return true;
            }
        }
        System.out.println("Registration Successful"); //Epituxhs eggrafi
        System.out.println("Your Name is: " + getName() + ", your UserName is: " + getUserName() + ", your Password is: " + getPassword() + ", your EMail is: " + getEMail() + " and your VIP Status is " + getVIPStatus()); //Ektipwsi twn stoixeiwn sas
        return false;
    } //setters & getters
    public String getName() {
        return this.Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getUserName() {
        return this.UserName;
    }
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    public String getPassword() {
        return this.Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
    public String getEMail() {
        return this.EMail;
    }
    public void setEMail(String EMail) {
        this.EMail = EMail;
    }
    public Boolean getVIPStatus() {
        return this.VIPStatus;
    }
    public void setVIPStatus(Boolean VIPStatus) {
        this.VIPStatus = VIPStatus;
    }
    public void setPackage(String Package) {
        this.Package = Package;
    }
    public String getPackage() {
        return this.Package;
    }
}