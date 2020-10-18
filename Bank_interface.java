class bank_account{
    String name;
    int acc_no;
    String acc_type;
    int balance;
    int depo,wid;
    bank_account(String name,int acc_no,String acc_type,int balance,int depo,int wid){
        this.name=name;
        this.acc_no=acc_no;
        this.acc_type=acc_type;
        this.balance=balance;
        this.depo=depo; 
        this.wid=wid;
    }
    int deposit(){
        balance+=depo;
        System.out.println("Balance updated after depositing...");
        return balance;
    }
    int withdraw(){
        if(balance-wid<0){
            System.out.println("Not enought balance");
            return -1;
        }
        else{
            balance-=wid;
            System.out.println("Balance Updated after withdrawing...");
        }
        return balance;
    }
    void check_balance(){
        System.out.println("Name:"+this.name);
        System.out.println("Remaining Balance:"+balance);
    }
    void exit(){
        System.out.println("Exiting the app...");
    }
    
}
class bank{
    public static void main(String args[]){
        bank_account b = new bank_account("Harshit",2809, "Saving",300000,5000,40000);
        bank_account b1 =new bank_account("Grover",2064,"Savings",100000,20000,40000);
        b.withdraw();
        b.check_balance();
        b.deposit();
        b.check_balance();
        b.exit();
        System.out.println("------------------Info of next client--------------------------------");
        b1.withdraw();
        b1.check_balance();
        b1.deposit();
        b1.check_balance();
        b1.exit();
    }
}

