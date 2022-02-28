package data;

import utilities.Xls_Reader;

public class DataFile {
	
Xls_Reader d = new Xls_Reader("C:\\testing\\NikulTest.xlsx");
	//Login
    public String wrongEmail= d.getCellData("Data1", "Username", 2);
    public String emailwithspecialchar=d.getCellData("Data1", "userName", 4);
    public String wrongpassword= d.getCellData("Data1", "Password", 2);
    public String globalErr= d.getCellData("Data1", "Global Error", 2);
    public String emptyEmailErr=d.getCellData("Data1", "Email Error", 4);
    public String emptypasswordErr= d.getCellData("Data1", "Password Error", 3);
    public String emailwithspecialcharErr= d.getCellData("Data1", "Email Error", 5);

}
