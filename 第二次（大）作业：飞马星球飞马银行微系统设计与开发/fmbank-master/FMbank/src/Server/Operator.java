package Server;

public class Operator {
    // 114abcd sql
    // 格式：flag + number + length(column) + column + sql

    public String get_flag(String s) {
        return s.charAt(0)+"";
    }

    public String get_col(String s) {
        if((s.charAt(0)+"").equals("0")) {
            int st = Integer.parseInt(s.charAt(2)+"");
            return s.substring(3,st+3);
        } else {
            return "";
        }
    }

    public int get_f(String s) {
        if((s.charAt(0)+"").equals("0")) {
            return Integer.parseInt(s.charAt(1)+"");
        } else {
            return -1;
        }
    }

    public String get_sql(String s) {
        if((s.charAt(0)+"").equals("0")) {
            int st = Integer.parseInt(s.charAt(2)+"");
            return s.substring(st+3);
        } else {
            return s.substring(1);
        }
    }
}
