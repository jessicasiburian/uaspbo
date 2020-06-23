/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ITD
 */
public class Login {
    String tfusername;
    String tfpass;
    String xusername;
    String xpassword;

    Login(String xusername, String xpassword) throws IOException {
        ambildata();
        this.xusername = xusername;
        this.xpassword = xpassword;
    }


    public String getUsername() {
        return tfusername;
    }

    public void setUsername(String username) {
        this.tfusername = username;
    }

    public String getPassword() {
        return tfpass;
    }

    public void setPassword(String password) {
        this.tfpass = password;
    }

    public String getXusername() {
        return xusername;
    }

    public void setXusername(String xusername) {
        this.xusername = xusername;
    }

    public String getXpassword() {
        return xpassword;
    }

    public void setXpassword(String xpassword) {
        this.xpassword = xpassword;
    }

    

    private void ambildata() throws FileNotFoundException, IOException{
        FileInputStream input = new FileInputStream("./src/Admin/user.txt");
        byte[] byten = new byte[1100];
        input.read(byten);
        String converString = new String(byten).trim();
        String[] data = converString.split(";");
        tfusername = data[0];
        tfpass = data[1];
    }
    
    public boolean login(){
        if(tfusername.equals(xusername) && tfpass.equals(xpassword)){
            
            return true;
        }
        else{
            return false;
        }
    }
    
}
