/*
 * Complete the function below.
 *//*


static String[] checkIP(String[] ip) {
        String[] results = new String[ip.length];

        for(int i = 0; i < ip.length; i++){
        results[i] = validIPAddress(ip[i]);
        }
        return results;
        }

public static String validIPAddress(String IP) {

        if(IP == null || IP.equalsIgnoreCase(""))
        return "Neither";

        String[] v4 = IP.split("\\.", -1);
        String[] v6 = IP.split(":", -1);

        if(v4.length != 4 && v6.length != 8)
        return "Neither";

        if(v4.length == 4){
        for(String s : v4){
        if((s.startsWith("0") && s.length() > 1) || s.startsWith("-"))
        return "Neither";
        boolean isNum = true;
        int no = 0;

        try{
        no = Integer.parseInt(s);
        }catch(Exception e){
        isNum = false;
        }
        if(!isNum || no < 0 || no > 255){
        return "Neither";
        }
        }

        return "IPv4";
        }

        if(v6.length == 8){
        for(String s : v6){
        if(s.length() > 4 || s.startsWith("-")){
        return "Neither";
        }
        boolean isNum = true;
        long no = 0;

        try{
        no = Long.parseLong(s,16);
        }catch(Exception e){
        isNum = false;
        }
        if(!isNum || no < 0){
        return "Neither";
        }
        }
        return "IPv6";
        }
        return "Neither";
        }

*/
