package com.syntax.groupProject17;
//Create Registration Class in which you would have
//        variables as email, userName and password that
//        have an access scope only within its own class. After
//        creating an object of the class user should be able to
//        call methods and in each method separately pass
//        values to set users email, username and password.
//        Requirements:
//        A.Valid email consider to be only yahoo
//        B.Valid userName and password cannot be empty and
//        should be of length larger than 6 characters. Also
//        valid password cannot contain userName
public class Task4 {
    public static void main(String[] args) {
        Registration r = new Registration();

            r.setEmail("asd@yahoo.com");
            r.setUserName("1236781111");
            r.setPassword("1236781111");

            System.out.println("Email: " + r.getEmail());  //extra test code(not required on task explanation)
            System.out.println("Username: " + r.getUserName()); //extra test code(not required on task explanation)
            System.out.println("Password: " + r.getPassword()); //extra test code(not required on task explanation)

    }
}

class Registration{
    private String email;
    private String userName;
    private String password;

    public void setEmail(String email) {
        if(email.contains("yahoo")){
            this.email = email;
        }
        else{
            System.out.println("Please enter a yahoo email");
        }
    }

    public void setUserName(String userName) {
        if(!userName.isEmpty() && userName.length()>6){
            this.userName = userName;
        }
        else{
            System.out.println("Username cannot be empty or less than 6 characters");
        }
    }

    public void setPassword(String password) {
        if(password.isEmpty()){
            System.out.println("Password cannot be empty");


        }else if (password.length()<=6) {
            System.out.println("Password should be more than 6 characters");

        }
        else if(password.contains(userName)) {
            System.out.println("Password cannot contain username");
        }
        else{
            this.password = password;

        }

    }

    //extra test code(not required on task explanation)
    public String getEmail() {
        return email;
    }

    //extra test code(not required on task explanation)
    public String getUserName() {
        return userName;
    }

    //extra test code(not required on task explanation)
    public String getPassword() {
        return password;
    }
}
